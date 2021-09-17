package com.bitcamp.orl.member.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.orl.member.domain.MemberRequest;
import com.bitcamp.orl.member.domain.NaverLoginBO;
import com.bitcamp.orl.member.service.CheckService;
import com.bitcamp.orl.member.service.LoginService;
import com.bitcamp.orl.member.service.RegService;
import com.github.scribejava.core.model.OAuth2AccessToken;

@Controller
public class NaverLoginController {

    /* NaverLoginBO */
	@Autowired
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;
    
    @Autowired
    private RegService regService;
    @Autowired
    private CheckService chkService;
    @Autowired
    private LoginService longinService;
    
    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }

  
    //referer값을 쿠키에 저장해놓고  -> 사용완료하면 쿠키 만료시키는 처리
    //네이버 로그인 처리 메서드 : 네이버 로그인 성공 시 callback 호출 메소드
    @RequestMapping(value = "/member/naverCallback", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(
    		Model model, 
    		@RequestParam String code, 
    		@RequestParam String state, 
    		HttpSession session, 
    		HttpServletRequest request, 
    		MemberRequest memberRequest)
            throws IOException, 
            ParseException, 
            MessagingException {
 
        int result = 0;
        System.out.println("여기는 callback");
        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
 
        // 로그인 사용자 정보를 읽어온다.
        apiResult = naverLoginBO.getUserProfile(oauthToken);
        System.out.println(naverLoginBO.getUserProfile(oauthToken).toString());
        model.addAttribute("result", apiResult);
        System.out.println("result" + apiResult);
        
        //DB와 세션에 넣기
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject;
		try {
			jsonObject = (JSONObject)jsonParser.parse(naverLoginBO.getUserProfile(oauthToken).toString());
			JSONObject response = (JSONObject)jsonObject.get("response");
			
			System.out.println("이것은" + jsonObject.get("response"));
			System.out.println("아이디는" + (String)response.get("id"));
			
			memberRequest.setMemberId((String)response.get("id"));
			memberRequest.setMemberPw("0000"); //DB에서 Not null로 처리했기에 임의로 준 값
			memberRequest.setMemberName((String) response.get("name"));
			memberRequest.setMemberEmail((String) response.get("email"));
			memberRequest.setMemberNickname((String) response.get("nickname")); //닉네임 수정!!
			memberRequest.setYear((String) response.get("birthyear"));
			String month=((String) response.get("birthday")).substring(0,2);
			String date=((String) response.get("birthday")).substring(3);
			memberRequest.setMonth(month);
			memberRequest.setDate(date);
			
			System.out.println(month);
			System.out.println(date);
			
			System.out.println("멤버아이디는 " + memberRequest.getMemberId());
		
			// 등록된 아이디 없으면 DB에 등록하기
			if((chkService.idCheck((String)response.get("id"))).equals("Y")) {
				result =  regService.reg(memberRequest);
			}
			model.addAttribute("result",result);
			
			
			
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//로그인처리
		boolean loginChk=longinService.naverLogin(request, memberRequest.getMemberId(), memberRequest.getMemberPw());
		model.addAttribute("loginChk", loginChk);
		
		return "member/login";
        
    }

}
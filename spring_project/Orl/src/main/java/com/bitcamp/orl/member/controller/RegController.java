package com.bitcamp.orl.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.orl.member.domain.MemberRequest;
import com.bitcamp.orl.member.domain.NaverLoginBO;
import com.bitcamp.orl.member.service.RegService;

@Controller
@RequestMapping("/member/reg")
public class RegController {
	
	
	  /* NaverLoginBO */
	@Autowired
    private NaverLoginBO naverLoginBO;
	@Autowired
	private RegService regService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String regForm(Model model, HttpSession session) {
		
		   /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        
        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
        //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
        System.out.println("네이버:" + naverAuthUrl);
        
        //네이버 
        model.addAttribute("url", naverAuthUrl);

        /* 생성한 인증 URL을 View로 전달 */
		
		return "member/regForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String reg(MemberRequest memberRequest, Model model) {
		int result = regService.reg(memberRequest);
		model.addAttribute("result",result);
		
		return "member/reg";
	}
	
	
}

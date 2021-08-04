package com.bitcamp.firstSpring.member.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/login")
public class LoginController {

	// @RequestMapping("/member/loginform")
	//@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm(@RequestParam("page") int page) {
		System.out.println(page+1);
		return "member/loginForm"; // /WEB-INF/views/member/loginForm.jsp
	}

	//  /member/login/member/login
	//@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			
			@RequestParam("id") String id, @RequestParam("pw") String pw
			
			) {
				
		System.out.println(id + " : " + pw);
		
		return "member/login"; // /WEB-INF/views/member/login.jsp
	}

}







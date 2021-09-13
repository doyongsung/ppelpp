package com.bitcamp.orl.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.orl.member.service.LoginService;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	
	@Autowired
	private LoginService loginservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(
			@RequestHeader(value="referer", required = false) String redirectUri,
			Model model
			) {
		model.addAttribute("redirectUri", redirectUri);
		return "member/loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			HttpServletRequest request, 
			HttpServletResponse response,
			Model model,
			@RequestParam("memberId") String memberId,
			@RequestParam("memberPw") String memberPw,
			@RequestParam(value="reid", required = false) String reid,
			@RequestParam(value = "redirectUri", required = false) String redirectUri
			) {
		boolean loginChk = loginservice.login(request, response, memberId, memberPw, reid);
		model.addAttribute("loginChk", loginChk);
		
		String view = "member/login";
		
		if(loginservice.chkURI(redirectUri) && loginChk) {
			redirectUri = redirectUri.substring(request.getContextPath().length());
			view = "redirect:"+redirectUri;
	}
		return view;
	}
}

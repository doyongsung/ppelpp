package com.bitcamp.orl.member.controller;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.orl.member.service.ForgotPwService;

@Controller
@RequestMapping("/member/forgotPw")
public class ForgotPwController {
	
	@Autowired
	private ForgotPwService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getForgotPw() {
		return "member/forgotPw";
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String getFindPw(HttpServletRequest request, Model model,
			@RequestParam("memberId") String memberId,
			@RequestParam("memberName") String memberName,
			@RequestParam("memberEmail") String memberEmail) {
		
		String findPw= service.FindPw(request,memberId, memberName, memberEmail);
		
		try {
			service.mailSender(findPw, memberEmail);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			findPw = null;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			findPw = null;

		}
		
		model.addAttribute("findPw",findPw);



		return "member/findPw";
	}
	


}

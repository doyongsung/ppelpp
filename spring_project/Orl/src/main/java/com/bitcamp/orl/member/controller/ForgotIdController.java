package com.bitcamp.orl.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.orl.member.service.ForgotIdService;

@Controller
@RequestMapping("/member/forgotId")
public class ForgotIdController {
	
	@Autowired
	private ForgotIdService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getForgotId() {
		
		return "member/forgotId";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String getFindId(HttpServletRequest request, Model model,
								@RequestParam("memberName") String memberName,
								@RequestParam("memberEmail") String memberEmail) {
		
		String findId= service.FindId(request, memberName, memberEmail);
		
		model.addAttribute("findId",findId);
		
		
		return "member/forgotIdView";
	}
}

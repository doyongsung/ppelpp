package com.bitcamp.orl.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.orl.member.domain.MemberRequest;
import com.bitcamp.orl.member.service.RegService;

@Controller
@RequestMapping("/member/reg")
public class RegController {

	@Autowired
	private RegService regservice;

	@RequestMapping(method = RequestMethod.GET)
	public String regForm() {
		return "member/regForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String reg(
			MemberRequest memberRequest, 
			Model model) {
		int result = regservice.reg(memberRequest);
		model.addAttribute("result", result);
		return "member/reg";
	}

}

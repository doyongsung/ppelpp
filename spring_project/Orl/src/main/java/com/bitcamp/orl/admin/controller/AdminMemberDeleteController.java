package com.bitcamp.orl.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.admin.service.AdminMemberService;

@Controller
public class AdminMemberDeleteController {

	@Autowired
	private AdminMemberService service;
	
	@RequestMapping("/admin/member/delete")
	public String MemberDelete(HttpServletRequest request, Model model) {
		
		model.addAttribute("idx",request.getParameter("memberIdx"));
		int memberIdx= Integer.parseInt(request.getParameter("memberIdx"));
		int result =service.deleteMember(memberIdx);
		model.addAttribute("result",result);
		
		return "admin/admin_memberDelete";
	}
	
}

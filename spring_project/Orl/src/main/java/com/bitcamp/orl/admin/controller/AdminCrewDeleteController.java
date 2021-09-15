package com.bitcamp.orl.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.admin.service.AdminCrewService;

@Controller
public class AdminCrewDeleteController {

	
	@Autowired
	private AdminCrewService service;
	
	@RequestMapping("admin/crew/delete")
	public String CrewDelete(HttpServletRequest request, Model model) {
		
		model.addAttribute("idx",request.getParameter("crewIdx"));
		int crewIdx=Integer.parseInt(request.getParameter("crewIdx"));
		int result = service.deleteCrew(crewIdx);
		model.addAttribute("result", result);
		return "admin/admin_crewDelete";
	}
}

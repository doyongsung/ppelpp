package com.bitcamp.orl.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.service.CrewListViewService;

@Controller
public class AdminCrewController {

	@Autowired
	private CrewListViewService service;
	
	@RequestMapping("/admin/crew")
	public String CrewList(HttpServletRequest request, Model model) {
		
		List<Crew> crewList = null;
		
		crewList=service.getCrewListAdmin();
		
		model.addAttribute("crewList",crewList);
		
		return "admin/admin_crew";
	}
	
}

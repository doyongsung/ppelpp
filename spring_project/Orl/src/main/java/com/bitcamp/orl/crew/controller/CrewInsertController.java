package com.bitcamp.orl.crew.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.orl.crew.domain.CrewRequest;
import com.bitcamp.orl.crew.service.CrewRegService;

@Controller
@RequestMapping("/crew/insert")
public class CrewInsertController {
	
	@Autowired
	private CrewRegService regService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String insert() {
		return "crew/insert";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String reg(
			CrewRequest crewRequest,
			HttpServletRequest request,
			Model model
			) {
		
		int result = regService.reg(crewRequest,request);
		
		model.addAttribute("result", result);
		
		return "crew/insert";
	}
}

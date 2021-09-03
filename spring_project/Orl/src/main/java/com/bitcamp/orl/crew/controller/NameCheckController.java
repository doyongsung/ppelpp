package com.bitcamp.orl.crew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.orl.crew.service.NameCheckService;

@Controller
public class NameCheckController {
	
	@Autowired
	private NameCheckService checkService;

	@RequestMapping(value="crew/nameCheck", method =  RequestMethod.POST)
	public String idCheck(
			@RequestParam("crewName") String crewName,
			Model model
			) {
		
		model.addAttribute("result",checkService.nameCheck(crewName));
		
		return "crew/nameCheck";
	}
	
	
}

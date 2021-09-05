package com.bitcamp.orl.crew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.service.CrewNameCheckService;

@RestController
public class CrewNameCheckController {
	
	@Autowired
	private CrewNameCheckService service;
	
	@RequestMapping("/crew/nameCheck")
	public String crewNameCheck(
			@RequestParam("crewName") String crewName,
			Model model
			) {
		return service.crewNameCheck(crewName);
	}
}
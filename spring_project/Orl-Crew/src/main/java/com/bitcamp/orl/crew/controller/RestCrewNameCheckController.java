package com.bitcamp.orl.crew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.service.CrewNameCheckService;

@RestController
public class RestCrewNameCheckController {
	
	@Autowired
	private CrewNameCheckService service;
	
	//이름 유효성 중복 check
	@RequestMapping("/crew/nameCheck")
	@CrossOrigin
	public String crewNameCheck(
			@RequestParam("crewName") String crewName,
			Model model
			) {
		return service.crewNameCheck(crewName);
	}
}

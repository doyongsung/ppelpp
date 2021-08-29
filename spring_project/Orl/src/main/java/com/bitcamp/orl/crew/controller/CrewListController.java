package com.bitcamp.orl.crew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrewListController {
	
	@RequestMapping("/crew/list")
	public String list() {
		return "crew/list";
	}

}

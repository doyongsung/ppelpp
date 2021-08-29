package com.bitcamp.orl.crew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrewInsertController {
	
	@RequestMapping("/crew/insert")
	public String insert() {
		return "crew/insert";
	}

}

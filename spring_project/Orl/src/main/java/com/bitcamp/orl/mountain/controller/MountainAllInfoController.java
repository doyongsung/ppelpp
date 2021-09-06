package com.bitcamp.orl.mountain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MountainAllInfoController {
	
	@RequestMapping("/mountain/mountainAllInfo")
	public String getMountainAll() {
		return "mountain/mountain_all";
	}
	
}

package com.bitcamp.orl.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {

	@RequestMapping("/main/main")
	public String main() {
		return "main/main";
	}
}

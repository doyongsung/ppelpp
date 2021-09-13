package com.bitcamp.orl.mountain.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MountainAllInfoController {
	
	// 전국 지도 보여주는 컨트롤러
	@RequestMapping("/mountain/mountainAllInfo")
	public String getMountainAll() {
		return "mountain/mountain_all";
	}
	
}

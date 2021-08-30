package com.bitcamp.orl.crew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrewManageController {
	
	@RequestMapping("/crew/edit")
	public String getCrewEdit() {
		return "crew/edit";
	}
	
	@RequestMapping("/crew/memberManage")
	public String getCrewMemberMng() {
		return "crew/memberManage";
	}
	
	@RequestMapping("/crew/remove")
	public String getCrewRemove() {
		return "crew/remove";
	}
	
}

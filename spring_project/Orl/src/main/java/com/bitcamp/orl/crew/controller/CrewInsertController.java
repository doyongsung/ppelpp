package com.bitcamp.orl.crew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/crew/insert")
public class CrewInsertController {

	//크루 생성 페이지 view 주는 method
	@RequestMapping(method = RequestMethod.GET)
	public String insert() {
		return "crew/insertForm";
	}
	
}
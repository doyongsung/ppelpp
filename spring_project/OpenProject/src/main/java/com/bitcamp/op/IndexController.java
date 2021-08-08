package com.bitcamp.op;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
	//void로만 만들어도 index.jsp 를 찾아감
	@RequestMapping("/index")
	public void index() {
	}
	
	@RequestMapping("/")
	public String index1() {
		System.out.println("/ 진입");
		return "redirect:/index";
	}
	
}
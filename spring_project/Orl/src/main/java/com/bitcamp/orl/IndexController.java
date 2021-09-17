package com.bitcamp.orl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String getIndexPage() {
		return "redirect:/main";
	}

	@RequestMapping("/index")
	public void getIndex() {
	}

	@RequestMapping("/main")
	public String main() {
		return "index";
	}
}
package com.bitcamp.orl.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/logout")
public class AdminLogoutController {

	@RequestMapping(method = RequestMethod.GET)
	public String logout() {
		return "admin/logout";
	}

}

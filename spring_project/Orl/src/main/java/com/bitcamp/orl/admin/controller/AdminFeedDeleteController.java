package com.bitcamp.orl.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.admin.service.AdminCrewService;
import com.bitcamp.orl.admin.service.AdminFeedService;
import com.bitcamp.orl.feed.service.FeedManageService;

@Controller
public class AdminFeedDeleteController {

	
	@Autowired
	private AdminFeedService service;
	
	@RequestMapping("admin/feed/delete")
	public String CrewDelete(HttpServletRequest request, Model model) {
		
		model.addAttribute("idx",request.getParameter("boardIdx"));
		int boardIdx=Integer.parseInt(request.getParameter("boardIdx"));
		int result = service.getDeleteFeed(boardIdx);
		model.addAttribute("result", result);
		return "admin/admin_feedDelete";
	}
}

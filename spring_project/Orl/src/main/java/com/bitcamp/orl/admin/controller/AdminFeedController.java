package com.bitcamp.orl.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.admin.service.AdminFeedService;
import com.bitcamp.orl.feed.domain.FeedView;

@Controller
public class AdminFeedController {

	@Autowired
	private AdminFeedService feedservice;
	
	@RequestMapping("/admin/feed")
	public String FeedList(HttpServletRequest request, Model model) {
		
		// 전체 피드 리스트 (최신순)
		List<FeedView> feedList=null;
		feedList=feedservice.selectAllFeed();
		
		model.addAttribute("feedList",feedList);
		
		
		return "admin/admin_feed";
	}
	
}

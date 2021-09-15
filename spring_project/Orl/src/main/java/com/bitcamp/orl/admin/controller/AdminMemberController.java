package com.bitcamp.orl.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.admin.service.AdminFeedService;
import com.bitcamp.orl.admin.service.AdminMemberService;
import com.bitcamp.orl.feed.domain.FeedView;
import com.bitcamp.orl.member.domain.Member;

@Controller
public class AdminMemberController {

	@Autowired
	private AdminMemberService memberservice;
	
	@Autowired
	private AdminFeedService feedService;
	
	
	@RequestMapping("/admin/member")
	public String MemberList(HttpServletRequest request, Model model) {
		
		List<Member> list= null;		
		List<FeedView> feedList=null;
		
		list = memberservice.getMemberList();
		feedList=feedService.selectAllFeed();
		
		model.addAttribute("memberList",list);
		model.addAttribute("feedList",feedList);
		
		return "admin/admin_member";
	}
	
}

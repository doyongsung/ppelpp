package com.bitcamp.orl.crew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.service.GetMemberInfoService;
import com.bitcamp.orl.member.domain.Member;

@RestController
public class RestGetMemberInfoController {
	
	@Autowired
	private GetMemberInfoService service;
	
	@RequestMapping("/crew/getMemberInfo")
	@CrossOrigin
	public Member getMemberInfo(
			@RequestParam("memberIdx")int memberIdx
			) {
		Member member = null;
		if(memberIdx != 0) {
			member = service.getMemberInfo(memberIdx);
		}
		return member;
	}
}

package com.bitcamp.orl.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MypageController {
	
	@RequestMapping("/member/mypage")
	public String getMypage() {
		return "member/mypage_edit";
	}
	
	@RequestMapping("/member/mypage_pw_change")
	public String getMypagePwChange() {
		return "member/mypage_pw_change";
	}
}

package com.bitcamp.op.member.dao;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class MemberDao {

	public void login() {
		System.out.println("로그인 합니다.");
	}

}

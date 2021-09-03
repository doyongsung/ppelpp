package com.bitcamp.op.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberRegRequest;
import com.bitcamp.op.member.domain.RegRequest;
import com.bitcamp.op.member.service.MemberRegService;
import com.bitcamp.op.member.service.MemberRestService;

//@Controller
@RestController
public class MemberRestController {

	@Autowired
	private MemberRestService restService;

	@Autowired
	private MemberRegService regService;

	@RequestMapping("/members/{id}")
	@CrossOrigin
	public Member getMember(@PathVariable("id") int idx) {
		Member member = restService.getMember(idx);
		System.out.println(member);
		return member;
	}

	@GetMapping("/members")
	@CrossOrigin
	public List<Member> getMembers() {
		return restService.getMembers();
	}

	@GetMapping("/members1")
	public Map<Integer, Member> getMembers1() {

		return restService.getMembers1();
	}

	@PostMapping("/members/reg1")
	@CrossOrigin
	public String regMember1(RegRequest regRequest, HttpServletRequest request) {
		System.out.println(regRequest);
		return Integer.toString(regService.memberReg(regRequest, request));
	}

	@PostMapping("/members/reg2")
	@CrossOrigin
	public String regMember2(@RequestBody RegRequest regRequest, HttpServletRequest request) {
		System.out.println(regRequest);
		return Integer.toString(regService.memberReg(regRequest, request));
	}

}

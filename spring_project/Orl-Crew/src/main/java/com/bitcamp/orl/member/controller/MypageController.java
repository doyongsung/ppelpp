package com.bitcamp.orl.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.orl.member.domain.Member;
import com.bitcamp.orl.member.domain.MemberDto;
import com.bitcamp.orl.member.domain.MemberEditRequest;
import com.bitcamp.orl.member.service.MypageService;

@Controller
public class MypageController {

   @Autowired
   private MypageService service;

   @RequestMapping(value = "/member/mypage", method = RequestMethod.GET)
   public String getMypage(HttpServletRequest request, Model model) {
      MemberDto memberVo = (MemberDto) request.getSession().getAttribute("memberVo");
      Member member = service.getMemberSelectByIdx(memberVo.getMemberIdx());
      model.addAttribute("member", member);
      return "member/mypage/mypage";
   }

   @RequestMapping(value = "/member/mypage", method = RequestMethod.POST)
   public String postMypage(HttpServletRequest request, MemberEditRequest memberEditRequest, Model model) {
      MemberDto memberVo = (MemberDto) request.getSession().getAttribute("memberVo");
      System.out.println(memberVo);
      Member member = service.getMemberSelectByIdx(memberVo.getMemberIdx());
      int result = service.editMember(request, member, memberEditRequest);
      model.addAttribute("result", result);
      return "member/mypage/update";
   }
   
   @RequestMapping(value="/member/mypage/pwchange", method=RequestMethod.GET)
   public String getPwChangePage(HttpServletRequest request, Model model) {
	  MemberDto memberVo = (MemberDto) request.getSession().getAttribute("memberVo");
      Member member = service.getMemberSelectByIdx(memberVo.getMemberIdx());
      model.addAttribute("member", member);
      return "member/mypage/mypagePwChange";
   }
   
   @RequestMapping(value="/member/mypage/pwchange", method=RequestMethod.POST)
   public String getPwChange(HttpServletRequest request, Model model) {
	   MemberDto memberVo = (MemberDto) request.getSession().getAttribute("memberVo");
	   Member member = service.getMemberSelectByIdx(memberVo.getMemberIdx());

	   String oldPw=request.getParameter("pw");
	   String newPw=request.getParameter("newpw");
	   String newPw2=request.getParameter("newpw2");
	   int result = service.editPw(oldPw,newPw,newPw2,member);
	   
      model.addAttribute("result", result);
      return "member/mypage/changePw";
   }
   
   
}
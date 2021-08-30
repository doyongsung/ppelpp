package com.bitcamp.orl.crew.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.crew.domain.CrewComment;
import com.bitcamp.orl.crew.domain.CrewCommentInfo;
import com.bitcamp.orl.crew.domain.CrewInfo;
import com.bitcamp.orl.crew.service.CrewDetailService;
import com.bitcamp.orl.member.domain.Member;

public class CrewDetailController {
	
	@Autowired
	CrewDetailService service;
	
	@RequestMapping("/crew/detail/{crewIdx}")
	public String getCrewDetail(
			@PathVariable("crewIdx")int crewIdx,
			HttpSession session,
			Model model
			) {
		CrewInfo crewinfo = service.getCrew(crewIdx).crewToCrewInfo();
		Member member = (Member)session.getAttribute("member");
		
		crewinfo.setCrewMemberNum(service.getCrewMemberNum(crewIdx));
		crewinfo.setCrewCommentNum(service.getCrewCommentNum(crewIdx));
		if(member != null) {
			crewinfo.setReg(service.getIsCrewMember(member.getMemberIdx(), crewIdx));
		}
		model.addAttribute("crew", crewinfo);
		
		List<CrewComment> list = service.getCrewComment(crewIdx);
		if(list != null) {
			for(int i = 0 ; i < list.size() ; i++) {
				CrewCommentInfo info = list.get(i).CommentToInfo();
				Member commentMember = service.getCommentMember(list.get(i).getMemberIdx());
				info.setMemberNickName(commentMember.getMemberNickname());
				info.setMemberProfile(commentMember.getMemberProfile());
			}
		}
		model.addAttribute("commentList", list);
		
		return "crew/detail";
	}
	
}

package com.bitcamp.orl.crew.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.orl.crew.domain.CrewCommentCriteria;
import com.bitcamp.orl.crew.domain.CrewInfo;
import com.bitcamp.orl.crew.service.CrewDetailService;

@Controller
public class CrewDetailController {
	
	@Autowired
	private CrewDetailService service;
	
	//Crew Detail Page view 값을 주는 controller
	@RequestMapping("/crew/detail")
	public String getCrewDetail(
			@RequestParam("crewIdx")int crewIdx,
			@RequestParam(value="currentPageNum", required = false, defaultValue = "1")int currentPageNum,
			HttpServletRequest request,
			Model model
			) {
		CrewInfo crewinfo = service.getCrewInfo(request.getSession(), crewIdx);
		CrewCommentCriteria cri = new CrewCommentCriteria(crewIdx, currentPageNum);
		
		model.addAttribute("crew", crewinfo);
		model.addAttribute("cri", cri);
		
		return "crew/detail";
	}
	
}
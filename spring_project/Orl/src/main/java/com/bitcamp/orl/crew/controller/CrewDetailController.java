package com.bitcamp.orl.crew.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.crew.domain.CrewCommentCriteria;
import com.bitcamp.orl.crew.domain.CrewInfo;
import com.bitcamp.orl.crew.service.CrewDetailService;

@Controller
@RequestMapping("/crew/detail")
public class CrewDetailController {
	
	@Autowired
	CrewDetailService service;
	
	@RequestMapping("/{crewIdx}&{currentPageNum}")
	public String getCrewDetail(
			@PathVariable("crewIdx")int crewIdx,
			@PathVariable("currentPageNum")int currentPageNum,
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
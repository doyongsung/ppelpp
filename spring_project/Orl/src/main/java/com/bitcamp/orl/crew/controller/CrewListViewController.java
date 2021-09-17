package com.bitcamp.orl.crew.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.service.CrewListViewService;

@Controller
public class CrewListViewController {
	
	@Autowired
	CrewListViewService service;
	
	//Crew List view 주는 Controller
	@RequestMapping("/crew/list")
	public String getCrewList(
			HttpServletRequest request,
			Model model,
			@RequestParam(value="searchType", required = false)String searchType,
			@RequestParam(value="keyword", required = false)String keyword,
			@RequestParam(value="page", required = false, defaultValue = "1")int page
			) {
		
		//내 크루 리스트 처리
		List<Crew> myCrewList = null;
		myCrewList = service.getMyCrewList(request);
		
		model.addAttribute("myCrewList", myCrewList);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		model.addAttribute("page", page);
		
		return "crew/list";
	}
	
}

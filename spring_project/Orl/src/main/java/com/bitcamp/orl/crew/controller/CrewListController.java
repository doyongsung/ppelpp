package com.bitcamp.orl.crew.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.crew.service.CrewListViewService;


@Controller
@RequestMapping("/crew/list")
public class CrewListController{
	
	@Autowired
	CrewListViewService service;
	

	
	@RequestMapping(method = RequestMethod.GET)
	public String getCrewList(
			HttpServletRequest request,
			Model model,
			@ModelAttribute("searchType")
			SearchType searchType
			) {
		
		System.out.println(searchType);
		
		//크루 검색		
		List<Crew> list = null;
		if(searchType.getKeyword() !=null && searchType.getKeyword().trim().length() > 0) {
			list= service.getCrewListAll(searchType);
		} else {
			list = service.getCrewListAll();
		}
		model.addAttribute("crewList",list);
	
		//내 크루 리스트 처리//
		List<Crew> myCrewList = null;
		myCrewList = service.getMyCrewList(request);
		model.addAttribute("myCrewList", myCrewList);
		
		//전체 크루 리스트 처리//
		List<Crew> crewListAll = null;
		crewListAll = service.getCrewListAll();
		model.addAttribute("crewListAll", crewListAll);
		
		return "crew/list";
	}
	
}
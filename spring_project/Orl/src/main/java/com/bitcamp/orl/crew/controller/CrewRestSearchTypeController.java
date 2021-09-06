package com.bitcamp.orl.crew.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.crew.service.CrewRestService;


@Controller
@RestController
public class CrewRestSearchTypeController{
	
	@Autowired
	CrewRestService restService;
	
	@GetMapping("/crew/searchTypeRest")
	@CrossOrigin
	public List<Crew> getCrewList(
			HttpServletRequest request,
			Model model,
			@ModelAttribute("searchType")
			SearchType searchType
			) {
		
		System.out.println(searchType);
		
		//크루 검색		
		List<Crew> list = null;
		if(searchType.getKeyword() !=null && searchType.getKeyword().trim().length() > 0) {
			list= restService.getSortingName(searchType);
		} else {
			list = restService.getSortingName();
		}
		System.out.println(list);
		model.addAttribute("crewList",list);
	
		/*
		 * //내 크루 리스트 처리// List<Crew> myCrewList = null; myCrewList =
		 * restService.getSortingName(request); model.addAttribute("myCrewList",
		 * myCrewList);
		 */
		
		//전체 크루 리스트 처리//
		List<Crew> crewListAll = null;
		crewListAll = restService.getSortingName();
		model.addAttribute("crewListAll", crewListAll);
		
		return list;
	}
	
}
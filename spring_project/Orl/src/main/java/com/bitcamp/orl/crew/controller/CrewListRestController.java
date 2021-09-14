package com.bitcamp.orl.crew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.crew.service.CrewListViewService;

@RestController
public class CrewListRestController {

	@Autowired
	CrewListViewService service;
	
	@RequestMapping("/crew/searchList")
	@CrossOrigin
	public List<Crew> getCrewList(
			@RequestParam(value="searchType", required = false)String searchType,
			@RequestParam(value="keyword", required = false)String keyword
			){
		
		SearchType st = new SearchType(searchType, keyword);
		List<Crew> allCrewList = service.getCrewListAll(st);
		if(st.getKeyword() !=null && st.getKeyword().trim().length() > 0) {
			allCrewList= service.getCrewListAll(st);
		} else {
			allCrewList = service.getCrewListAll();
		}
		return allCrewList;
	}
}


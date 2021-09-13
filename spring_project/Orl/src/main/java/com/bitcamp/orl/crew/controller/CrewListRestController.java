package com.bitcamp.orl.crew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.service.CrewRestService;

@RestController
public class CrewListRestController {
	
	@Autowired
	private CrewRestService restService;
	
	@GetMapping("/crew/crewName")
	@CrossOrigin
	public List<Crew> getSortingName(){
		return restService.getSortingName();
	}
	/*
	 * @GetMapping("/crew/searchList")
	 * 
	 * @CrossOrigin public List<Crew> getCrewSearchList(
	 * 
	 * @RequestParam("SearchType")String SearchType,
	 * 
	 * @RequestParam("keyword")String keyword, Model model ){
	 * model.addAttribute("SearchType",SearchType);
	 * model.addAttribute("keyword",keyword);
	 * 
	 * List<Crew> list = null; list =
	 * restService.getSearchingList(SearchType,keyword); return list;
	 * 
	 * }
	 */

}

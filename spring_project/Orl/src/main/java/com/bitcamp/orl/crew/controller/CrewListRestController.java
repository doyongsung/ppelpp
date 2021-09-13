package com.bitcamp.orl.crew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.crew.service.CrewRestService;

@RestController
public class CrewListRestController {
	
	@Autowired
	private CrewRestService restService;
	
	@GetMapping("/crew/crewName")
	@CrossOrigin
	public List<Crew> getSortingName(SearchType searchType){
		return restService.getSortingName(searchType);
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
	
	@GetMapping("/crew/searchList")
	@CrossOrigin
	public List<Crew> getCrewSearchList(
			@ModelAttribute("searchType")SearchType searchType,
			Model model
			){
		//크루 검색기능 더해서 전체 크루 리스트 처리		
		List<Crew> list = null;
		if(searchType.getKeyword() !=null && searchType.getKeyword().trim().length() > 0) {
			list= restService.getSearchList(searchType);
		} else {
			list = restService.getSortingName();
		}
		model.addAttribute("crewList", list);
		
		return list;
	
	}
}

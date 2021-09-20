package com.bitcamp.orl.crew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewInfo;
import com.bitcamp.orl.crew.domain.CrewInsertRequest;
import com.bitcamp.orl.crew.service.CrewDetailService;
import com.bitcamp.orl.crew.service.CrewInsertService;

@RestController
public class RestCrewCreateController {
	
	@Autowired
	private CrewInsertService insertService;
	
	@Autowired
	private CrewDetailService detailService;
	
	@RequestMapping("/crew/createCrew")
	@CrossOrigin
	public CrewInfo createCrew(CrewInsertRequest crewRequest) {
		
		Crew crew = insertService.insert(crewRequest);
		CrewInfo crewinfo = null;
		
		if(crew != null) {
			crewinfo = detailService.getCrewInfo(crew.getMemberIdx(), crew.getCrewIdx());
		}
		
		return crewinfo;
	}
}

package com.bitcamp.orl.crew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.service.CrewRestService;

@Controller
@RestController
public class CrewRestController {

	@Autowired
	private CrewRestService restService;
	
	@GetMapping("/crew/crewName")
	@CrossOrigin
	public List<Crew> getSortingName(String crewName){
		return restService.getSortingName(crewName);
	}
}

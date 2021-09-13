package com.bitcamp.orl.crew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.domain.CrewMemberList;
import com.bitcamp.orl.crew.service.CrewMemberListService;

@RestController
public class CrewMemberListRestController {
	
	@Autowired
	CrewMemberListService service;
	
	@GetMapping("fdf")
	@CrossOrigin
	public List<CrewMemberList> crewMemberList(
			@RequestParam("crewIdx")int crewIdx
			){
		List<CrewMemberList> list = null;
		list = service.getCrewMemberList(crewIdx);
		return list;
	}
}

package com.bitcamp.orl.crew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.domain.CrewMemberList;
import com.bitcamp.orl.crew.service.CrewMemberMngService;

@RestController
public class RestCrewMemberMngController {
	
	@Autowired
	CrewMemberMngService service;
	
	@GetMapping("/crew/getCrewMemberList")
	@CrossOrigin
	public List<CrewMemberList> crewMemberList(
			@RequestParam("crewIdx")int crewIdx
			){
		List<CrewMemberList> list = null;
		list = service.getCrewMemberList(crewIdx);
		return list;
	}
	
	@GetMapping("/crew/deleteCrewMemberFromList")
	@CrossOrigin
	public int deleteFromCrewMemberList(
			@RequestParam("memberIdx")int memberIdx,
			@RequestParam("crewIdx")int crewIdx
			) {
		int resultCnt = 0;
		resultCnt = service.deleteCrewMemberFromList(memberIdx, crewIdx);
		return resultCnt;
	}
	
	@GetMapping("/crew/joinToCrewMemberList")
	@CrossOrigin
	public int joinToCrewMemberList(
			@RequestParam("memberIdx")int memberIdx,
			@RequestParam("crewIdx")int crewIdx) {
		int resultCnt = 0;
		resultCnt = service.crewReg(memberIdx, crewIdx);
		return resultCnt;
	}
	
}

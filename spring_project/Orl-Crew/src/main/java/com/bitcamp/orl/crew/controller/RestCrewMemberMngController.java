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
	
	//크루원 관리에서 해당 크루원 리스트를 가져오기 위한 method
	@GetMapping("/crew/getCrewMemberList")
	@CrossOrigin
	public List<CrewMemberList> crewMemberList(
			@RequestParam("crewIdx")int crewIdx
			){
		
		List<CrewMemberList> list = null;
		list = service.getCrewMemberList(crewIdx);
		return list;
	}
	
	//크루원 추방 method
	@GetMapping("/crew/deleteCrewMemberFromList")
	@CrossOrigin
	public int deleteFromCrewMemberList(
			@RequestParam("memberIdx")int memberIdx,
			@RequestParam("crewIdx")int crewIdx
			) {
		
		int resultCnt = 0;
		
		//크루원 추방
		resultCnt = service.deleteCrewMemberFromList(memberIdx, crewIdx);
		return resultCnt;
	}
	
	//크루 가입 method
	@GetMapping("/crew/joinToCrewMemberList")
	@CrossOrigin
	public int joinToCrewMemberList(
			@RequestParam("memberIdx")int memberIdx,
			@RequestParam("crewIdx")int crewIdx) {
		
		int resultCnt = 0;
		
		//가입
		resultCnt = service.crewReg(memberIdx, crewIdx);
		return resultCnt;
	}
	
}

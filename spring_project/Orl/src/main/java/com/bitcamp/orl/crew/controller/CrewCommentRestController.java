package com.bitcamp.orl.crew.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.domain.CrewCommentCriteria;
import com.bitcamp.orl.crew.domain.CrewCommentPagingDTO;
import com.bitcamp.orl.crew.domain.CrewCommentRequest;
import com.bitcamp.orl.crew.service.CrewCommentService;
@RestController
public class CrewCommentRestController {
	
	@Autowired
	CrewCommentService commentService;
	
	@RequestMapping("/crew/getCommentInfo")
	@CrossOrigin
	public CrewCommentPagingDTO getCommentList(
			HttpServletRequest request,
			@RequestParam("crewIdx")int crewIdx,
			@RequestParam(value="currentPageNum", defaultValue = "0")int currentPageNum
			){
		
		if(currentPageNum == 0) {
			currentPageNum = 1;
		}
		
		CrewCommentCriteria cir = new CrewCommentCriteria(crewIdx, currentPageNum);
		CrewCommentPagingDTO dto = commentService.getCrewComment(cir);
		
		return dto;
	}
	
	@RequestMapping("/crew/commentInsert")
	@CrossOrigin
	public String insertComment(
			CrewCommentRequest request,
			HttpSession session
			) {
		return Integer.toString(commentService.insertCrewComment(request.getCrewComment(), session, request.getCrewIdx()));
	}
}
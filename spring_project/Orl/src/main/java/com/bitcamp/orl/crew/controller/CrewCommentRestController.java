package com.bitcamp.orl.crew.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.domain.CrewCommentInfo;
import com.bitcamp.orl.crew.domain.CrewCommentRequest;
import com.bitcamp.orl.crew.service.CrewCommentService;
@RestController
public class CrewCommentRestController {
	
	@Autowired
	CrewCommentService commentService;
	
	@RequestMapping("/crew/getCommentInfo")
	@CrossOrigin
	public List<CrewCommentInfo> getCommentList(
			HttpServletRequest request,
			@RequestParam("crewIdx")int crewIdx
			){
		List<CrewCommentInfo> list = commentService.getCrewComment(crewIdx);
		
		return list;
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
package com.bitcamp.orl.crew.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.domain.CrewCommentCriteria;
import com.bitcamp.orl.crew.domain.CrewCommentInfo;
import com.bitcamp.orl.crew.domain.CrewCommentPagingDTO;
import com.bitcamp.orl.crew.domain.CrewCommentRequest;
import com.bitcamp.orl.crew.service.CrewCommentService;

@RestController
public class CrewCommentRestController {
	
	@Autowired
	CrewCommentService commentService;
	
	@RequestMapping("/crew/getCommentInfoList")
	@CrossOrigin
	public CrewCommentPagingDTO getCommentList(
			HttpServletRequest request,
			@RequestParam("crewIdx")int crewIdx,
			@RequestParam(value="currentPageNum", required = false, defaultValue = "1")int currentPageNum
			){
		
		CrewCommentCriteria cir = new CrewCommentCriteria(crewIdx, currentPageNum);
		CrewCommentPagingDTO dto = commentService.getCrewComment(cir);
		
		return dto;
	}
	
	@RequestMapping("/crew/getCommentInfo")
	@CrossOrigin
	public CrewCommentInfo getCrewComment(
			@RequestParam("crewCommentIdx")int crewCommentIdx
			) {
		return commentService.getCrewCommentInfo(crewCommentIdx);
	}
	
	@RequestMapping("/crew/commentInsert")
	@CrossOrigin
	public String insertComment(
			CrewCommentRequest request,
			HttpSession session
			) {
		return Integer.toString(commentService.insertCrewComment(request.getCrewComment(), session, request.getCrewIdx()));
	}
	
	@RequestMapping("crew/commentDelete")
	@CrossOrigin
	public String deleteMyComment(
			@RequestParam("crewCommentIdx")int crewCommentIdx
			) {
		return Integer.toString(commentService.deleteCrewComment(crewCommentIdx));
	}
	
	@RequestMapping("crew/commentUpdate")
	@CrossOrigin
	public String updateComment(
			@RequestParam("crewComment")String crewComment,
			@RequestParam("crewCommentIdx")int crewCommentIdx
			) {
		return Integer.toString(commentService.updateCrewComment(crewComment, crewCommentIdx));
	}
}

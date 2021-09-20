package com.bitcamp.orl.crew.controller;

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
public class RestCrewCommentController {
	
	@Autowired
	CrewCommentService commentService;
	
	//crew Detail Page에서 comment를 list로 받아오는 method
	@RequestMapping("/crew/getCommentInfoList")
	@CrossOrigin
	public CrewCommentPagingDTO getCommentList(
			@RequestParam("crewIdx")int crewIdx,
			@RequestParam(value="currentPageNum", required = false, defaultValue = "1")int currentPageNum
			){
		
		if(currentPageNum == 0) {
			currentPageNum = 1;
		}
		CrewCommentCriteria cir = new CrewCommentCriteria(crewIdx, currentPageNum);
		CrewCommentPagingDTO dto = commentService.getCrewComment(cir);
		
		return dto;
	}
	
	//crew Detail Page에서 한 댓글 정보를 확인할 때 member정보까지 가져오기 위해서 작성한 method
	@RequestMapping("/crew/getCommentInfo")
	@CrossOrigin
	public CrewCommentInfo getCrewComment(
			@RequestParam("crewCommentIdx")int crewCommentIdx
			) {
		return commentService.getCrewCommentInfo(crewCommentIdx);
	}
	
	//crew Detail Page에서 댓글 입력 method
	@RequestMapping("/crew/commentInsert")
	@CrossOrigin
	public String insertComment(
			CrewCommentRequest request
			) {
		return Integer.toString(commentService.insertCrewComment(request.getCrewIdx(), request.getCrewComment(), request.getMemberIdx()));
	}
	
	//crew Detail Page에서 댓글 삭제 method
	@RequestMapping("crew/commentDelete")
	@CrossOrigin
	public String deleteMyComment(
			@RequestParam("crewCommentIdx")int crewCommentIdx
			) {
		return Integer.toString(commentService.deleteCrewComment(crewCommentIdx));
	}
	
	//crew Detail Page에서 댓글 수정 method
	@RequestMapping("crew/commentUpdate")
	@CrossOrigin
	public String updateComment(
			@RequestParam("crewComment")String crewComment,
			@RequestParam("crewCommentIdx")int crewCommentIdx
			) {
		return Integer.toString(commentService.updateCrewComment(crewComment, crewCommentIdx));
	}
}

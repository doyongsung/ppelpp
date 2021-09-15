package com.bitcamp.orl.feed.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.feed.domain.FeedComment;
import com.bitcamp.orl.feed.domain.NewFeedList;
import com.bitcamp.orl.feed.service.FeedCommentingService;
import com.bitcamp.orl.feed.service.FeedManageService;
import com.bitcamp.orl.member.domain.MemberDto;

@RestController
public class FeedRestController {
	
	//0915 우리 언니 추가
	
	@Autowired
	FeedManageService manageService;
	
	@Autowired
	FeedCommentingService commentingService;
	
	//피드 삭제
	@RequestMapping("/feed/feedview/deletefeed/{memberIdx}&{boardIdx}")
	public int deleteFeed(
		@PathVariable("memberIdx") int memberIdx,
		@PathVariable("boardIdx") int boardIdx,
		HttpServletRequest request
		) {
		
		int result = 0;

		int myIdx = ((MemberDto) request.getSession().getAttribute("memberVo")).getMemberIdx();

		if(memberIdx == myIdx) {
			result = manageService.deleteFeed(memberIdx, boardIdx);	//1 or 0
			System.out.println("삭제 피드 : " + boardIdx);
		} else {
			//피드 작성자가 아니므로 삭제 불가
			System.out.println("피드 작성자 불일치 (feed creator Idx : " + memberIdx + " )");
		}
		
		return result;
	}	
	
	//피드 댓글 삭제
	@RequestMapping("/feed/feedview/deletecomment/{boardCommentIdx}&{boardIdx}")
	public List<FeedComment> deleteComment(
			@PathVariable("boardCommentIdx") int boardCommentIdx,
			@PathVariable("boardIdx") int boardIdx,
			HttpServletRequest request
			) {
		
		manageService.deleteComment(boardCommentIdx);
		
		System.err.println("삭제 댓글 : " + boardCommentIdx);
		List<FeedComment> feedComment = manageService.selectFeedComment(boardIdx);
		
		return feedComment;
	}
	
	//피드 리스트 (최신순)
	@RequestMapping("/feed/feedmain/selectNewFeed")
	public List<NewFeedList> newFeedList (HttpServletRequest request){
		
		List<NewFeedList> feedlist = manageService.selectNewFeed();
		System.out.println("rest controller =>" + feedlist);
		
		return feedlist;
	}
	
	//댓글 리스트
	@GetMapping("/feed/feedview/selectcomment")
	public List<FeedComment> selectComments(HttpServletRequest request) {
		
		int boardIdx = Integer.parseInt(request.getParameter("boardIdx"));
		
		List<FeedComment> feedComment = manageService.selectFeedComment(boardIdx);
		System.out.println("rest controller => "+feedComment);
		
		return feedComment;
		
	}

	
	
}

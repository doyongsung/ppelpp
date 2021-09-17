package com.bitcamp.orl.feed.controller;

import java.util.*;

import javax.servlet.http.*;

import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.bitcamp.orl.feed.domain.*;
import com.bitcamp.orl.feed.service.*;
import com.bitcamp.orl.member.domain.*;

@Controller
public class FeedViewController {

	// 피드 상세보기 페이지

	@Autowired
	private FeedViewService viewService;

	@Autowired
	private FeedCommentingService commentingService;

	@RequestMapping("/feed/feedview/{memberIdx}&{boardIdx}")
	public String getFeedView(
			@PathVariable("memberIdx") int memberIdx,
			@PathVariable("boardIdx") int boardIdx,
			HttpServletRequest request,
			Model model) {

		// 피드 상세보기
		FeedView feedview = viewService.getFeedView(boardIdx);

		// session에 있는 나의 memberIdx 필요
		int myIdx = ((MemberDto) request.getSession().getAttribute("memberVo")).getMemberIdx();
		// 하트 상태
		int likeStatus = viewService.getLikeStatus(myIdx, boardIdx);
		int totalLikeCount = viewService.getTotalLikeCount(boardIdx);
		
		// 모델에 저장
		model.addAttribute("selectFeedView", viewService.getFeedView(boardIdx));
		model.addAttribute("totalLikeCount", totalLikeCount);
		model.addAttribute("likeStatus", likeStatus);
		model.addAttribute("boardMemberIdx", memberIdx);

		return "/feed/feedview";

	}

	@RequestMapping(value="/feed/feedview/{memberIdx}&{boardIdx}", method = RequestMethod.POST)
	public String postFeedView(
			@PathVariable("memberIdx") int memberIdx,
			@PathVariable("boardIdx") int boardIdx,
			FeedCommentRequest commentRequest,
			HttpServletRequest request,
			Model model) {

		//피드 상세보기
		FeedView feedview = viewService.getFeedView(boardIdx); //모델에 저장
		
		// 댓글 작성 insert
		commentingService.insertComment(commentRequest, request);
		
		// session에 있는 나의 memberIdx 필요
		int myIdx = ((MemberDto) request.getSession().getAttribute("memberVo")).getMemberIdx();
		// 하트 상태
		int likeStatus = viewService.getLikeStatus(myIdx, boardIdx); //모델에 저장
		int totalLikeCount = viewService.getTotalLikeCount(boardIdx); //모델에 저장
		
		// 모델에 저장
		model.addAttribute("selectFeedView", viewService.getFeedView(boardIdx));
		model.addAttribute("boardCommentIdx", commentRequest.getBoardCommentIdx());
		model.addAttribute("comment", commentRequest.getComment());
		model.addAttribute("boardIdx", commentRequest.getBoardIdx());
		model.addAttribute("memberIdx", commentRequest.getMemberIdx());
		model.addAttribute("likeStatus", likeStatus);
		model.addAttribute("totalLikeCount", totalLikeCount);
		model.addAttribute("boardMemberIdx", memberIdx);

		return "redirect:/feed/feedview/"+memberIdx+"&"+boardIdx;
	}

	// 피드 수정
	@RequestMapping(value = "/feed/feedview/editfeed/{memberIdx}&{boardIdx}", method = RequestMethod.POST)
	public String postEditFeed(
			@PathVariable("boardIdx") int boardIdx,
			FeedEdit feedEdit,
			HttpServletRequest request,
			Model model) {

		int result = viewService.editFeed(boardIdx, feedEdit, request);

		model.addAttribute("boardDiscription", feedEdit.getBoardDiscription());
		model.addAttribute("hashtag", feedEdit.getHashtag());
		model.addAttribute("tag", feedEdit.getTag());

		return "/feed/feedview";
		
	}

	
	
}

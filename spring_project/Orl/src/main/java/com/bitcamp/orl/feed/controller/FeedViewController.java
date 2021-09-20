package com.bitcamp.orl.feed.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.orl.feed.domain.FeedCommentRequest;
import com.bitcamp.orl.feed.domain.FeedEdit;
import com.bitcamp.orl.feed.service.FeedCommentingService;
import com.bitcamp.orl.feed.service.FeedViewService;
import com.bitcamp.orl.member.domain.MemberDto;

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
		
		/*
		// 피드 상세보기
		FeedView feedview = viewService.getFeedView(boardIdx);
		*/
		
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
//		model.addAttribute("member",member); //추가 (09.16.우리)

		return "/feed/feedview";

	}

	@RequestMapping(value="/feed/feedview/{memberIdx}&{boardIdx}", method = RequestMethod.POST)
	public String postFeedView(
			@PathVariable("memberIdx") int memberIdx,
			@PathVariable("boardIdx") int boardIdx,
			FeedCommentRequest commentRequest,
			HttpServletRequest request,
			Model model) {
		
		// 댓글 작성 insert
		commentingService.insertComment(commentRequest, request);

		return "redirect:/feed/feedview/"+memberIdx+"&"+boardIdx;
	}

	// 피드 수정
	@RequestMapping(value = "/feed/feedview/editfeed/{memberIdx}&{boardIdx}", method = RequestMethod.POST)
	public String postEditFeed(
			@PathVariable("boardIdx") int boardIdx,
			FeedEdit feedEdit,
			HttpServletRequest request,
			Model model) {
		
		// 추가 (09.16.우리)
		//피드 상세보기
		/*
		FeedView feedview = viewService.getFeedView(boardIdx); //모델에 저장
		*/

		viewService.editFeed(boardIdx, feedEdit, request);

		model.addAttribute("boardDiscription", feedEdit.getBoardDiscription());
		model.addAttribute("hashtag", feedEdit.getHashtag());
		model.addAttribute("tag", feedEdit.getTag());
		model.addAttribute("selectFeedView", viewService.getFeedView(boardIdx));	// 추가 (09.16.우리)

		return "/feed/feedview";
		
	}

	
	
}
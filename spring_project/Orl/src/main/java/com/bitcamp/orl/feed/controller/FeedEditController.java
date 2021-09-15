package com.bitcamp.orl.feed.controller;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.bitcamp.orl.feed.domain.*;
import com.bitcamp.orl.feed.service.*;
import com.bitcamp.orl.member.domain.*;

@Controller
@RequestMapping("/feed/feededit/{memberIdx}&{boardIdx}")
public class FeedEditController {
	
	//0915 추가
	//피드 수정 페이지 

	@Autowired
	private FeedViewService viewService;

	@RequestMapping(method = RequestMethod.GET)
	public String getFeedEdit(
			@PathVariable("memberIdx") int memberIdx,
			@PathVariable("boardIdx") int boardIdx,
			HttpServletRequest request, Model model) {

		// 피드 상세
		FeedView feedview = viewService.getFeedView(boardIdx);
		model.addAttribute("selectFeedView", viewService.getFeedView(boardIdx));
		System.out.println("feedview controller => " + feedview);

		// session에 있는 나의 memberIdx 필요
		MemberDto memberVo = (MemberDto) request.getSession().getAttribute("memberVo");
		int myIdx = memberVo.getMemberIdx();
		// 1. 첫 요청에 하트의 결과를 보여줘야한다. 내가 이 게시물을 좋아요 하는지 안 하는지!
		int likeStatus = viewService.getLikeStatus(myIdx, boardIdx);
		// 모델에 저장
		model.addAttribute("likeStatus", likeStatus);

		return "/feed/feedEdit";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String postFeedEdit(
			@PathVariable("boardIdx") int boardIdx,
			@PathVariable("memberIdx") int memberIdx,
			FeedEdit feedEdit,
			HttpServletRequest request,
			Model model
			) {

		// 피드 상세보기
		FeedView feedview = viewService.getFeedView(boardIdx);
		model.addAttribute("selectFeedView", viewService.getFeedView(boardIdx));
		System.out.println("feedview controller => " + feedview);
		
		// 피드 수정
		int result = viewService.editFeed(boardIdx, feedEdit, request);
		
		model.addAttribute("boardDiscription", feedEdit.getBoardDiscription());
		model.addAttribute("hashtag", feedEdit.getHashtag());
		model.addAttribute("tag", feedEdit.getTag());
		
		return "/feed/feedview";

	}

}

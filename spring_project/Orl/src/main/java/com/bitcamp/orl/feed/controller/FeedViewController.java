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
import com.bitcamp.orl.feed.domain.FeedView;
import com.bitcamp.orl.feed.service.FeedCommentService;
import com.bitcamp.orl.feed.service.FeedCommentingService;
import com.bitcamp.orl.feed.service.FeedViewService;
import com.bitcamp.orl.member.domain.MemberDto;

@Controller
@RequestMapping("/feed/feedview/{memberIdx}&{boardIdx}")
public class FeedViewController {

	// 피드 상세보기 컨트롤러

	@Autowired
	private FeedViewService viewService;

	@Autowired
	private FeedCommentService commentService;

	@Autowired
	private FeedCommentingService commentingService;


	// 피드 상세보기 처음 요청
	@RequestMapping(method = RequestMethod.GET)
	public String getFeedView(
			@PathVariable("memberIdx") int memberIdx,
			@PathVariable("boardIdx") int boardIdx,
			HttpServletRequest request,
			Model model
			) {

		// 피드 상세보기
		//		FeedView feedview = viewService.getFeedView(boardIdx);
		//		model.addAttribute("selectFeedView", viewService.getFeedView(boardIdx));
		//		System.out.println(feedview);

		// 1) 피드 상세 0915 우리언니
		FeedView feedview = viewService.getFeedView(boardIdx);

		System.out.println("feedview controller => "+feedview);

		// session에 있는 나의 memberIdx 필요
		int myIdx = ((MemberDto) request.getSession().getAttribute("memberVo")).getMemberIdx();

		//2) 첫 요청에 하트의 결과를  보여줘야한다. 내가 이 게시물을 좋아요 하는지 안 하는지!
		int likeStatus = viewService.getLikeStatus(myIdx,boardIdx);

		// 3)  첫 요청에 좋아요 갯수를 보여준다.
		int totalLikeCount = viewService.getTotalLikeCount(boardIdx);


		// 모델에 저장
		model.addAttribute("selectFeedView", viewService.getFeedView(boardIdx));
		model.addAttribute("likeStatus",likeStatus);
		model.addAttribute("totalLikeCount",totalLikeCount);




		return "/feed/feedview";
	}

	// 댓글 작성용 ( 0915 추가)--> 작성을 하고 나면 다시 로드
	@RequestMapping(method = RequestMethod.POST)
	public String postFeedView(
			@PathVariable("boardIdx") int boardIdx,
			@PathVariable("memberIdx") int memberIdx,
			//			FeedEdit feedEdit,
			FeedCommentRequest commentRequest,
			HttpServletRequest request,
			Model model
			) {

		// 피드 상세보기
		FeedView feedview = viewService.getFeedView(boardIdx);
		System.out.println("feedview controller => "+feedview);

		//댓글 작성 insert
		commentingService.insertComment(commentRequest, request);

		// 추가
		// session에 있는 나의 memberIdx 필요
		int myIdx = ((MemberDto) request.getSession().getAttribute("memberVo")).getMemberIdx();


		// 하트 상태
		int likeStatus = viewService.getLikeStatus(myIdx,boardIdx);

		// 하트 상태
		int totalLikeCount = viewService.getTotalLikeCount(boardIdx);

		//모델에 저장
		model.addAttribute("selectFeedView", viewService.getFeedView(boardIdx));
		model.addAttribute("boardCommentIdx", commentRequest.getBoardCommentIdx());
		model.addAttribute("comment", commentRequest.getComment());
		model.addAttribute("boardIdx", commentRequest.getBoardIdx());
		model.addAttribute("memberIdx", commentRequest.getMemberIdx());
		model.addAttribute("likeStatus",likeStatus);
		model.addAttribute("totalLikeCount",totalLikeCount);

		return "/feed/feedview";
	}


	// 피드 수정하기 0915
	@RequestMapping(value = "/feed/feedview/editfeed/{memberIdx}&{boardIdx}", method = RequestMethod.POST)
	public String postEditFeed(
			@PathVariable("boardIdx") int boardIdx,
			FeedEdit feedEdit,
			HttpServletRequest request,
			Model model
			) {

		int result = viewService.editFeed(boardIdx, feedEdit, request);

		model.addAttribute("boardDiscription", feedEdit.getBoardDiscription());
		model.addAttribute("hashtag", feedEdit.getHashtag());
		model.addAttribute("tag", feedEdit.getTag());

		return "/feed/feedview";
	}
}

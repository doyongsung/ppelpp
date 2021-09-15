package com.bitcamp.orl.feed.controller;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.bitcamp.orl.feed.domain.*;
import com.bitcamp.orl.feed.service.*;

@Controller
@RequestMapping("/feed/feedmain")
public class FeedMainController {

	@Autowired
	private CreateFeedService createService;

	@Autowired
	private FeedListService listservice;

//	@RequestMapping(method = RequestMethod.GET)
//	public String getCreateFeedForm(Model model) {
//
//		// 피드 기본 정렬  ajax
//		List<NewFeedList> newFeedList = listservice.selectNewFeed();
//		model.addAttribute("selectNewFeed", listservice.selectNewFeed());
//
//		// 피드 인기순 정렬 ajax 안하고
//		List<NewFeedList> feedOrderByLike = listservice.selectFeedOrderByLike();
//		model.addAttribute("feedOrderByLike",feedOrderByLike);
//
//
//		return "feed/feedmain";
//	}
	
	// 0915 수정 피드 눌렀을 때 첫 요청
	@RequestMapping(method = RequestMethod.GET)
	public String getFeedMain(Model model) {
		
		// 피드 인기순 정렬 ajax 안하고
		List<NewFeedList> feedOrderByLike = listservice.selectFeedOrderByLike();
		model.addAttribute("feedOrderByLike",feedOrderByLike);
		
		return "feed/feedmain";
	}	

//	@RequestMapping(method = RequestMethod.POST)
//	public String upload(FeedCreateRequest feedrequest, Model model, HttpServletRequest request)
//			throws IllegalStateException, IOException {
//
//		// 피드 기본 정렬
//		List<NewFeedList> newFeedList = listservice.selectNewFeed();
//		model.addAttribute("selectNewFeed", listservice.selectNewFeed());
//		// 비동기통신으로 수정해야함
//
//		// Form input data
//		model.addAttribute("boardPhoto", feedrequest.getBoardPhoto());
//		model.addAttribute("boardDiscription", feedrequest.getBoardDiscription());
//		model.addAttribute("hashtag", feedrequest.getHashtag());
//		model.addAttribute("tag", feedrequest.getTag());
//		// data insert
//		createService.insert(feedrequest, request);
//
//		return "feed/feedmain";
//	}
	
	// 피드올리기 
	@RequestMapping(method = RequestMethod.POST)
	public String postFeedMain(
			FeedCreateRequest feedrequest, 
			HttpServletRequest request,
			Model model)
			throws IllegalStateException, IOException {
		
		
		// 피드 인기순 정렬 ajax 안하고
		List<NewFeedList> feedOrderByLike = listservice.selectFeedOrderByLike();
		model.addAttribute("feedOrderByLike",feedOrderByLike);
		
		//피드 작성
		model.addAttribute("boardPhoto", feedrequest.getBoardPhoto());
		model.addAttribute("boardDiscription", feedrequest.getBoardDiscription());
		model.addAttribute("hashtag", feedrequest.getHashtag());
		model.addAttribute("tag", feedrequest.getTag());
		
		createService.insert(feedrequest, request);

		return "feed/feedmain";
	}

}
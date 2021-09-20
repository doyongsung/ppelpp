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
import com.bitcamp.orl.member.domain.*;

@Controller
@RequestMapping("/feed/feedmain")
public class FeedMainController {
	
	//피드 메인 페이지

	@Autowired
	private CreateFeedService createService;
	
	@Autowired
	private FeedListService listService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getFeedMain(
			Model model,
			HttpServletRequest request) {
		
		// 피드 인기순 정렬 ajax 안하고
	    List<NewFeedList> feedOrderByLike = listService.selectFeedOrderByLike();
	    
	    //추가 (09.16.우리)
	    Member member = listService.getMember(request);
	    System.out.println("member : "+ member);
	    
	    //모델에 저장
	    model.addAttribute("member", member);	//추가 (09.16.우리)
	    model.addAttribute("feedOrderByLike",feedOrderByLike);
		
		return "feed/feedmain";
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public String postFeedMain(
			FeedCreateRequest feedrequest, 
			HttpServletRequest request,
			Model model)
			throws IllegalStateException, IOException {
		
		//삭제 (09.17.우리)
//		// 피드 인기순 정렬 ajax 안하고
//	    List<NewFeedList> feedOrderByLike = listService.selectFeedOrderByLike();
//	    model.addAttribute("feedOrderByLike",feedOrderByLike);
//		
//		//피드 작성
//		model.addAttribute("boardPhoto", feedrequest.getBoardPhoto());
//		model.addAttribute("boardDiscription", feedrequest.getBoardDiscription());
//		model.addAttribute("hashtag", feedrequest.getHashtag());
//		model.addAttribute("tag", feedrequest.getTag());
		
		createService.insert(feedrequest, request);
	    
		return "redirect:/feed/feedmain";
	}

	
	
}
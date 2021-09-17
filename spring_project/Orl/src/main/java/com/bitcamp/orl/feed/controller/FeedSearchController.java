package com.bitcamp.orl.feed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.orl.feed.domain.FeedSearchByNickname;
import com.bitcamp.orl.feed.domain.NewFeedList;
import com.bitcamp.orl.feed.service.FeedSearchService;

@Controller
public class FeedSearchController {
	
	@Autowired
	FeedSearchService searchService;
	
	
	@RequestMapping(value="/feed/feedSearch", method=RequestMethod.GET)
	public String getFeedSearch() {
		
		
		return "feed/feedSearch";
	}
	
	@RequestMapping(value="/feed/feedSearch", method=RequestMethod.POST)
	public String getFeedSearch(
			@RequestParam("mySearch") String mySearch,
			Model model
			) {
		
		// 검색 결과를 가져오기
		System.out.println("mySearch : " + mySearch);
		// 닉네임으로 찾기 -> 닉네임, 프로필 사진 가져오기, memberIdx 
		List<FeedSearchByNickname> searchByNickname = searchService.getSearchByNickname(mySearch);
		
		
		// 해시태그로 검색 하면
		// 해당 사진, 닉네임, memberIdx, boardIdx로 가져오기
		
		List<NewFeedList> searchByHashtag = searchService.getSearchByHashtag(mySearch);
		
		
		//모델에 저장
		model.addAttribute("searchByHashtag",searchByHashtag);
		model.addAttribute("searchByNickname",searchByNickname);
		
		
		return "feed/feedSearch";
	}
}

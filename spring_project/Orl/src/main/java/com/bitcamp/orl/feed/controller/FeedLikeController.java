package com.bitcamp.orl.feed.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.feed.service.LikeService;
import com.bitcamp.orl.member.domain.MemberDto;

@RestController
public class FeedLikeController {
	
	@Autowired
	private LikeService likeService;
	
	//비동기통신으로 좋아요 누르고 취소하기 처리
	@PostMapping("/feed/likeButtonClick")
	public int insertLike(
			@RequestParam("boardIdx") int boardIdx,
			@RequestParam("likeChange") int likeChange,
			HttpServletRequest request
			) {
		
		// 세션에 있는 나의 idx
		int myIdx =((MemberDto)request.getSession().getAttribute("memberVo")).getMemberIdx();
		
		int likeResult =0;
		
		if(likeChange==1) {
			
			likeResult = likeService.insertLike(myIdx,boardIdx);
			
		}else {
			
			likeResult = likeService.deleteLike(myIdx,boardIdx);
		}
		return likeResult;
	}
	
	
	
	
}

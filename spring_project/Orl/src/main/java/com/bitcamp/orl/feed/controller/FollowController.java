package com.bitcamp.orl.feed.controller;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.bitcamp.orl.feed.domain.*;
import com.bitcamp.orl.feed.service.*;
import com.bitcamp.orl.member.domain.*;

@RestController
public class FollowController {
	// 비동기 통신 처리

	@Autowired
	FollowService followService;

	@RequestMapping("/feed/followerList/{memberIdx}")
	public List<FollowList> getFollowerList(@PathVariable("memberIdx") int memberIdx, Model model) {

		// 팔로잉 리스트 가져오기
		List<FollowList> followerList = followService.getFollowerList(memberIdx);
		System.out.println(followerList); // 확인!

		return followerList;
	}

	// 팔로잉 리스트 출력: 내 피드 이던 남 피드 이던 memberIdx로 팔로잉 리스트 찾기
	@RequestMapping("/feed/followingList/{memberIdx}")
	public List<FollowList> getFollowingList(@PathVariable("memberIdx") int memberIdx, Model model) {

		// 팔로잉 리스트 가져오기
		List<FollowList> followingList = followService.getFollowingList(memberIdx);
		System.out.println(followingList);

		// 비동기 통신의 결과 데이터 json
		return followingList;
	}

	// 팔로우 시작하기 혹은 그만하기 버튼 클릭
	@PostMapping("/feed/followButtonClick")
	public int startFollow(@RequestParam("memberIdx") int yourIdx, @RequestParam("followStatus") int followStatus,
			HttpServletRequest request) {
		// 반환하는 결과 데이터
		int followResult = 0;

		// session에 저장된 myIdx 가져오기
		int myIdx = ((Member) request.getSession().getAttribute("member")).getMemberIdx();

		if (followStatus == -1) {
			// -1: 팔로우 그만하기를 눌렀다. -->delete
			followResult = followService.followCancle(myIdx, yourIdx);
			// 결과 성공이면 1
		} else {
			// 1: 팔로우 시작하기를 눌렀다. -->insert
			followResult = followService.followStart(myIdx, yourIdx);
		}

		// 결과 json
		return followResult;
	}

}
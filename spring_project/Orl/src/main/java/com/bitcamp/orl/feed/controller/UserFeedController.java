package com.bitcamp.orl.feed.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.service.CrewListViewService;
import com.bitcamp.orl.feed.domain.FeedGallery;
import com.bitcamp.orl.feed.domain.FeedLikeGallery;
import com.bitcamp.orl.feed.service.FeedGalleryService;
import com.bitcamp.orl.feed.service.UserFeedService;
import com.bitcamp.orl.member.domain.Member;

@Controller
public class UserFeedController {

	@Autowired
	UserFeedService feedService;

	@Autowired
	FeedGalleryService galleryService;

	@Autowired
	CrewListViewService crewListService;

	// 가장 첫번째 요청: 피드 보여주기 (세션에 저장된 idx 필요)
	// 1. 사용자 닉네임 --해결
	// 2. 게시물 개수 --해결
	// 3. 팔로워 수, 팔로잉 수 -- 해결
	// 4. 내가 가입한 크루
	// 5. 내가 올린 사진 피드 전체
//	@RequestMapping("/feed/userFeed")
//	public String getUserFeed(
//			HttpServletRequest request,
//			Model model
//			) {
//
//		// 1.로그인 세션에 저장된 member객체 가져오기
//		Member member = (Member) request.getSession().getAttribute("member");
//
//		// 로그인 세션에 저장된 member객체에서 idx 뽑아서
//		// follow table에서 idx에 해당하는 팔로워와 팔로잉 수 구해서 가져오기 -> 전달
//		
//		// 팔로워 수 구하기
//		int followerCount = feedService.getFollowerCount(member.getMemberIdx());
//
//		//팔로잉 수 구하기
//		int followingCount = feedService.getFollowingCount(member.getMemberIdx());
//
//		// 게시물 수 구하기
//		int feedCount = feedService.getFeedCount(member.getMemberIdx());
//
//
//		//member 객체 전달
//		model.addAttribute("member",member);
//		model.addAttribute("followerCount",followerCount);
//		model.addAttribute("followingCount",followingCount);
//		model.addAttribute("feedCount",feedCount);
//
//		return "feed/userFeed";
//	}

	// 피드 이동하면 보여주기(내피드 보기랑 남피드 보기 한 요청으로 처리)
	@RequestMapping("/feed/userFeed/{memberIdx}")
	public String getUserFeed(HttpServletRequest request, @PathVariable("memberIdx") int memberIdx, Model model) {
		System.out.println("요청 받음");

		// 세션에 저장된 나의 memberIdx
		int myIdx = ((Member) request.getSession().getAttribute("member")).getMemberIdx();

		// memberIdx에 해당하는 member객체 가져오기
		// 내가 내 피드로 들어가면 member = 나
		// 내가 남 피드로 들어가면 member = 남
		Member member = feedService.getOneMember(memberIdx);

		// 1) 팔로워 수 구하기
		int followerCount = feedService.getFollowerCount(memberIdx);

		// 2) 팔로잉 수 구하기
		int followingCount = feedService.getFollowingCount(memberIdx);

		// 3) 게시물 수 구하기
		int feedCount = feedService.getFeedCount(memberIdx);

		// 4 )팔로우 관계 --> 팔로우 시작하기, 팔로우 그만하기 버튼
		// 팔로우 하고 있으면 1 아니면 0
		int followRelation = feedService.getfollowRelation(myIdx, memberIdx);
		// System.out.println(followRelation);

		// 5) 사진 갤러리 기본 정렬 보여주기
		List<FeedGallery> feedGallery = galleryService.getFeedGallery(memberIdx);

		// 6) 사진 갤러리 좋아요 정렬 보여주기
		List<FeedLikeGallery> feedLikeGallery = galleryService.getFeedLikeGallery(memberIdx);

		// 7) 내가 가입한 크루 보여주기
		//List<Crew> myCrewList = crewListService.getMyCrewList(memberIdx);

		// model에 객체 전달
		model.addAttribute("member", member);
		model.addAttribute("followerCount", followerCount);
		model.addAttribute("followingCount", followingCount);
		model.addAttribute("feedCount", feedCount);
		model.addAttribute("followRelation", followRelation);
		model.addAttribute("feedGallery", feedGallery);
		model.addAttribute("feedLikeGallery", feedLikeGallery);
		//model.addAttribute("myCrewList", myCrewList);

		return "feed/userFeed";
	}

	// 피드올리기
//	@RequestMapping("/feed/createFeed")
//	public String getCreateFeed() {
//		return "feed/createFeed";
//	}
//
//	//피드상세보기
//	@RequestMapping("/feed/feedview")
//	public String gerFeedView() {
//		return "feed/feedview";
//	}

}
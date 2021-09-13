package com.bitcamp.orl.feed.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.feed.dao.FeedDao;
import com.bitcamp.orl.feed.domain.Follow;
import com.bitcamp.orl.feed.domain.FollowList;
import com.bitcamp.orl.member.domain.Member;

@Service
public class UserFeedService {
	
	private FeedDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	// 팔로워 수 가져오기 (08.30)
	public int getFollowerCount(int memberIdx) {
		int followerCount = 0;
		
		dao = template.getMapper(FeedDao.class);
		followerCount = dao.selectFollowerCount(memberIdx);
		
		return followerCount;
	}
	
	//팔로워 리스트 가져오기
//	public List<FollowList> getFollowerList(int memberIdx) {
//		List<FollowList> followerList = new ArrayList<>();
//		
//		dao = template.getMapper(FeedDao.class);
//		followerList = dao.selectFollowerList(memberIdx);
//		
//		return followerList;
//	}
	
	
	// 팔로잉 수 가져오기(08.30)
	public int getFollowingCount(int memberIdx){
		
		int followingCount = 0;
		
		dao=template.getMapper(FeedDao.class);
		followingCount = dao.selectFollowingCount(memberIdx);
		
		return followingCount;
		
	}

	//팔로잉 리스트 가져오기(08.31)
//	public List<FollowList> getFollowingList(int memberIdx) {
//		List<FollowList> followingList = new ArrayList<>();
//		
//		dao = template.getMapper(FeedDao.class);
//		followingList = dao.selectFollowingList(memberIdx);
//		
//		
//		return followingList;
//	}
	
	
	// 게시물 수 가져오기 (08.31)
	public int getFeedCount(int memberIdx) {
		
		int feedCount = 0;
		
		dao = template.getMapper(FeedDao.class);
		feedCount = dao.selectFeedCount(memberIdx);
		
		
		return feedCount;
	}
	
	// memberIdx로 member객체 가져오기(남피드 이동할 때 전달할 객체)
	public Member getOneMember(int memberIdx) {
		Member member = null;
		
		dao = template.getMapper(FeedDao.class);
		member = dao.selectOneMember(memberIdx);
		
		//System.out.println(member); 확인 완료
		return member;
	}
	
	
	//09.01 추가
	//myIdx와 yourIdx로 내가 남을 팔로우 하는 상태인지 확인한다 ->팔로우하기, 팔로우 끊기 버튼 보여주기!
	public int getfollowRelation(int myIdx, int yourIdx) {
		int followRelationResult = 1;
		
		dao=template.getMapper(FeedDao.class);
		//반환 결과는 1또는 0
		followRelationResult = dao.selectFollowRelation(myIdx,yourIdx);
		
		return followRelationResult;
	}

	
	
	
	
}
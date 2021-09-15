package com.bitcamp.orl.feed.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.feed.dao.FeedDao;
import com.bitcamp.orl.feed.domain.FollowList;

@Service
public class FollowService {
	
	
	// 비동기 통신으로 팔루우, 팔로잉 리스트 가져오기
	// 비동기 통신으로 팔로우 시작하기, 팔로우 그만하기 
	
	
	private FeedDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	// 1) 팔로잉 리스트 가져오기(08.31)
	public List<FollowList> getFollowingList(int memberIdx) {
		List<FollowList> followingList = new ArrayList<>();
		
		dao = template.getMapper(FeedDao.class);
		followingList = dao.selectFollowingList(memberIdx);
		
		
		return followingList;
	}
	
	// 2) 팔로워 리스트 가져오기(08.31)
	public List<FollowList> getFollowerList(int memberIdx) {
		List<FollowList> followerList = new ArrayList<>();
		
		dao = template.getMapper(FeedDao.class);
		followerList = dao.selectFollowerList(memberIdx);
		
		return followerList;
	}
	
	
	// 3) 팔로우 시작하기 -->insert (09.01)
	public int followStart(int myIdx, int yourIdx) {
		//팔로우 시작하기 결과
		int followResult = 0;
		
		dao = template.getMapper(FeedDao.class);
		followResult = dao.insertFollowMember(myIdx,yourIdx);
		
		return followResult;
	}
	
	// 4) 팔로우 그만하기 -->delete (09.01)
	public int followCancle(int myIdx, int yourIdx) {
		int followResult =0;
		
		
		dao =template.getMapper(FeedDao.class);
		followResult =dao.deleteFollowMember(myIdx, yourIdx);
		
		return followResult;
	}
	
	
}

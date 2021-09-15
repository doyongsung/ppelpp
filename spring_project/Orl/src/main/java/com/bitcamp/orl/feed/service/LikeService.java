package com.bitcamp.orl.feed.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.feed.dao.FeedDao;

@Service
public class LikeService {
	// 비동기 통신으로 좋아요 버튼 누르기, 취소하기 처리하기
	
	private FeedDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	// 1) 좋아요 누르기 -->insert
	public int insertLike(int memberIdx, int boardIdx) {
		
		int likeResult =0;
		
		dao = template.getMapper(FeedDao.class);
		likeResult = dao.insertLike(memberIdx,boardIdx);
		
		
		return likeResult;
		
	}

	// 2) 좋아요 취소하기 --> delete
	public int deleteLike(int memberIdx,int boardIdx) {
		
		int likeResult = 0;
		
		dao =template.getMapper(FeedDao.class);
		likeResult =dao.deleteLike(memberIdx,boardIdx);
		
		return likeResult;
	}
	
}

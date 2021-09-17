package com.bitcamp.orl.feed.service;

import javax.servlet.http.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.bitcamp.orl.feed.dao.*;
import com.bitcamp.orl.feed.domain.*;

@Service
public class FeedViewService {

	private FeedDao dao;

	@Autowired
	private SqlSessionTemplate template;

	// 피드 상세보기
	public FeedView getFeedView(int boardIdx) {

		FeedView feedview = null;

		dao = template.getMapper(FeedDao.class);
		feedview = dao.selectFeedView(boardIdx);

		return feedview;
	}

	// 피드 수정
	public int editFeed(
			int boardIdx,
			FeedEdit feedEdit,
			HttpServletRequest request) {

		int result = 0;

		dao = template.getMapper(FeedDao.class);
		result = dao.editFeed(
				feedEdit.getBoardDiscription(),
				feedEdit.getHashtag(),
				feedEdit.getTag(),
				boardIdx);

		return result;

	}

	// 3) 좋아요 상태인지 아닌지 확인 (세라 추가)
	public int getLikeStatus(int myIdx, int boardIdx) {
		
		int likeStatus = 0;

		dao = template.getMapper(FeedDao.class);
		likeStatus = dao.selectLikeStatus(myIdx, boardIdx);

		return likeStatus;
	}

	// 4) 좋아요 갯수 가져오기 (세라 추가)
	public int getTotalLikeCount(int boardIdx) {

		int totalLikeCount = 0;

		dao = template.getMapper(FeedDao.class);
		totalLikeCount = dao.selectTotalLikeCount(boardIdx);

		return totalLikeCount;
	}

}

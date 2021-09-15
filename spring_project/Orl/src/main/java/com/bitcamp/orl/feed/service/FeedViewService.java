package com.bitcamp.orl.feed.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.feed.dao.FeedDao;
import com.bitcamp.orl.feed.domain.FeedEdit;
import com.bitcamp.orl.feed.domain.FeedView;

@Service
public class FeedViewService {

	// 피드 상세 보기 가져오기
	// 좋아요 갯수와 좋아요 누른 상태인지


	private FeedDao dao;

	@Autowired
	SqlSessionTemplate template;

	// 1) 피드 상세보기 했을 때의 정보 가져오기 (우리언니)
	public FeedView getFeedView(int boardIdx) {

		FeedView feedview = null;

		dao = template.getMapper(FeedDao.class);
		feedview = dao.selectFeedView(boardIdx);

		System.out.println("feed view load");

		return feedview;

	}

	// 2) 피드 수정 (0915 추가)
	public int editFeed(
			int boardIdx,
			FeedEdit feedEdit,
			HttpServletRequest request
			) {

		int result = 0;

		dao = template.getMapper(FeedDao.class);

		result = dao.editFeed(
				feedEdit.getBoardDiscription(),
				feedEdit.getHashtag(),
				feedEdit.getTag(),
				boardIdx
				);

		return result;

	}


	// 3)  좋아요 상태인지 아닌지 확인 (세라 추가)
	public int getLikeStatus(int myIdx, int boardIdx) {
		int likeStatus =0;

		dao = template.getMapper(FeedDao.class);
		likeStatus = dao.selectLikeStatus(myIdx,boardIdx);


		return likeStatus;
	}

	// 4)  좋아요 갯수 가져오기 (세라 추가)
	public int getTotalLikeCount(int boardIdx) {

		int totalLikeCount = 0;

		dao = template.getMapper(FeedDao.class);
		totalLikeCount = dao.selectTotalLikeCount(boardIdx);

		return totalLikeCount;
	}

}

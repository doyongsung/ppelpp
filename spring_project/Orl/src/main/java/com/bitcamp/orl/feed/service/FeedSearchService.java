package com.bitcamp.orl.feed.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.feed.dao.FeedDao;
import com.bitcamp.orl.feed.domain.FeedSearchByNickname;
import com.bitcamp.orl.feed.domain.NewFeedList;

@Service
public class FeedSearchService {
	
	// 피드에서 검색했을 때

	private FeedDao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	
	//1) 해시태그로 검색
	public List<NewFeedList> getSearchByHashtag(String hashtag) {
		
		List<NewFeedList> searchByHashtag = null;
		
		
		dao =template.getMapper(FeedDao.class);
		searchByHashtag = dao.selectByHashtag(hashtag);
		
		return searchByHashtag;
	}

	//2) 닉네임으로 검색
	public List<FeedSearchByNickname> getSearchByNickname(String nickname) {
		
		List<FeedSearchByNickname> searchByNickname = null;
		
		dao =template.getMapper(FeedDao.class);
		searchByNickname = dao.selectByNickname(nickname);
		
		
		return searchByNickname;
	}
	
	
}

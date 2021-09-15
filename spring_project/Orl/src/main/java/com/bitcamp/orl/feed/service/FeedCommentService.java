package com.bitcamp.orl.feed.service;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.bitcamp.orl.feed.dao.*;
import com.bitcamp.orl.feed.domain.*;

@Service
public class FeedCommentService {
	
	FeedDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	//피드 댓글보기 (최신순)
	public List<FeedComment> getFeedComment(int boardIdx) {
		
		List<FeedComment> feedComments = null;
		
		dao = template.getMapper(FeedDao.class);
		feedComments = dao.selectFeedComment(boardIdx);
		
		
		return feedComments;
		
	}
}

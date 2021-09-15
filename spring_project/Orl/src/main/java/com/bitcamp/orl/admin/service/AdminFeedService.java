package com.bitcamp.orl.admin.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.feed.dao.FeedDao;
import com.bitcamp.orl.feed.domain.FeedView;

@Service
public class AdminFeedService {

		//피드의 Dao
		private FeedDao dao;
		
		@Autowired
		private SqlSessionTemplate template;
		
		//모든 피드 리스트
		public List<FeedView> selectAllFeed(){
			
			return template.getMapper(FeedDao.class).selectAllFeed();
		}
		
		//피드 삭제
		public int getDeleteFeed( int boardIdx) {
			
			int result = 0;		
			
			dao = template.getMapper(FeedDao.class);
			result = dao.deleteFeedByAdmin(boardIdx);
			
			return result;
		}
		
}

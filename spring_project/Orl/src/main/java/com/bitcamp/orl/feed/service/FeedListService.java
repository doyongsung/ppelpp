package com.bitcamp.orl.feed.service;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.bitcamp.orl.feed.dao.*;
import com.bitcamp.orl.feed.domain.*;

@Service
public class FeedListService {
   
   // feedmain 에서 전체 피드랑 인기순 정렬 피드 보여주기
   
   private FeedDao dao;

   @Autowired
   private SqlSessionTemplate template;

   //전체 피드 리스트 (최신순)
   public List<NewFeedList> selectNewFeed() {
      
      List<NewFeedList> newFeedList = null;
      
      dao = template.getMapper(FeedDao.class);
      newFeedList = dao.selectNewFeed();
      
      System.out.println("feed list - new");
      
      return newFeedList;
   }
   
   // 피드 리스트(인기순) 세라 추가
   public List<NewFeedList> selectFeedOrderByLike() {
      
      List<NewFeedList> feedOrderByLike = null;
      
      dao= template.getMapper(FeedDao.class);
      feedOrderByLike = dao.selectFeedOrderByLike();
      
      
      
      return feedOrderByLike;
   }
   
   
}
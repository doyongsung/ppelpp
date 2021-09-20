package com.bitcamp.orl.feed.service;

import java.util.*;

import javax.servlet.http.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.bitcamp.orl.feed.dao.*;
import com.bitcamp.orl.feed.domain.*;
import com.bitcamp.orl.member.domain.*;

@Service
public class FeedListService {

	// feedmain 에서 전체 피드랑 인기순 정렬 피드 보여주기

	private FeedDao dao;

	@Autowired
	private SqlSessionTemplate template;

	// 전체 피드 리스트 (최신순)
	public List<NewFeedList> selectNewFeed() {

		List<NewFeedList> newFeedList = null;

		dao = template.getMapper(FeedDao.class);
		newFeedList = dao.selectNewFeed();

		System.out.println("feed list - new");

		return newFeedList;

	}

	// 멤버 가져오기 (09.16.우리)
	public Member getMember(HttpServletRequest request) {

		dao = template.getMapper(FeedDao.class);

		Member member = null;
		MemberDto dto = (MemberDto) request.getSession().getAttribute("memberVo");

		if (dto != null) {
			member = dao.selectOneMember(dto.getMemberIdx());
		}

		return member;

	}

	// 피드 리스트(인기순) 세라 추가
	public List<NewFeedList> selectFeedOrderByLike() {

		List<NewFeedList> feedOrderByLike = null;

		dao = template.getMapper(FeedDao.class);
		feedOrderByLike = dao.selectFeedOrderByLike();

		return feedOrderByLike;
	}

}
package com.bitcamp.orl.feed.service;

import javax.servlet.http.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.bitcamp.orl.feed.dao.*;
import com.bitcamp.orl.feed.domain.*;
import com.bitcamp.orl.member.domain.*;

@Service
public class FeedCommentingService {

	FeedDao dao;

	@Autowired
	private SqlSessionTemplate template;

	// 피드 댓글 작성
	public int insertComment(FeedCommentRequest commentRequest, HttpServletRequest request) {

		int result = 0;
		
		try {
			
			FeedComment feedComment = commentRequest.toFeedComment();
			
			MemberDto memberVo = (MemberDto)(request.getSession().getAttribute("memberVo"));
			
			if(memberVo != null) {
				feedComment.setMemberIdx(memberVo.getMemberIdx());
			}

			dao = template.getMapper(FeedDao.class);
			result = dao.insertFeedComment(feedComment);
			
			System.out.println(feedComment);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("예외발생");
		}

		return result;

	}

}

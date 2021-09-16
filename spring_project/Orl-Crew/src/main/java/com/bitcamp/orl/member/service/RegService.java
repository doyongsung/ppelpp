package com.bitcamp.orl.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.member.domain.Member;
import com.bitcamp.orl.member.domain.MemberRequest;
import com.bitcamp.orl.member.mapper.Dao;

@Service
public class RegService {
	
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int reg(MemberRequest memberRequest) {
		
		int resultCnt=0;
		
		Member member= new Member();
		
		try {
			member.setMemberId(memberRequest.getMemberId());
	        member.setMemberPw(memberRequest.getMemberPw());
	        member.setMemberName(memberRequest.getMemberName());
	        member.setMemberEmail(memberRequest.getMemberEmail());
	        member.setMemberNickname(memberRequest.getMemberNickname());
			member.setMemberBirth(memberRequest.getMemberBirth());
			
			dao = template.getMapper(Dao.class);
			
			resultCnt=dao.insertMember(member);
			
			
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return resultCnt;
	}
	
	public int regNaver(Member member) {
		
		int resultCnt=0;
		
		dao = template.getMapper(Dao.class);
			
		resultCnt=dao.insertMember(member);
			
		
		return resultCnt;
	}
}

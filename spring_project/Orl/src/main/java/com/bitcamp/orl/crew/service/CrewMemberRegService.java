package com.bitcamp.orl.crew.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.member.domain.MemberDto;

@Service
public class CrewMemberRegService {
	
	Dao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public int reg(HttpServletRequest request, int crewIdx) {
		
		int resultCnt = 0;
		
		dao = template.getMapper(Dao.class);
		
		try {
		MemberDto memberDto = (MemberDto)request.getSession().getAttribute("memberDto");
		int memberIdx = memberDto.getMemberIdx();
		resultCnt = dao.insertCrewReg(memberIdx, crewIdx);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		return resultCnt;
	}
}

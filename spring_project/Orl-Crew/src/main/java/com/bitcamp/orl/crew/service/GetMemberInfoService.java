package com.bitcamp.orl.crew.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.mapper.CrewMapper;
import com.bitcamp.orl.member.domain.Member;

@Service
public class GetMemberInfoService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	public Member getMemberInfo(int memberIdx) {
		return template.getMapper(CrewMapper.class).selectMemberByMemberIdx(memberIdx);
	}
}

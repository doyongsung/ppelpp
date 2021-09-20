package com.bitcamp.orl.crew.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.domain.CrewMemberList;
import com.bitcamp.orl.crew.mapper.CrewMapper;

@Service
public class CrewMemberMngService {
	
	CrewMapper dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	//크루원 리스트 가져오기
	public List<CrewMemberList> getCrewMemberList(
			int crewIdx
			){
		dao = template.getMapper(CrewMapper.class);
		List<CrewMemberList> list = dao.selectCrewMemberList(crewIdx);
		return list;
	}
	
	//크루원 추방
	public int deleteCrewMemberFromList(
			int memberIdx,
			int crewIdx
			) {
		int resultCnt = 0;
		dao = template.getMapper(CrewMapper.class);
		resultCnt = dao.deleteFromCrewMemberList(memberIdx, crewIdx);
		return resultCnt;
	}
	
	//크루 가입
	public int crewReg(
			int memberIdx,
			int crewIdx
			) {
		int resultCnt = 0;
		dao = template.getMapper(CrewMapper.class);
		resultCnt = dao.insertCrewReg(memberIdx, crewIdx);
		return resultCnt;
	}
}

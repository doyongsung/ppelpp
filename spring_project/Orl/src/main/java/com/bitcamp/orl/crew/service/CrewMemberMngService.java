package com.bitcamp.orl.crew.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.CrewMemberList;

@Service
public class CrewMemberMngService {
	
	Dao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public List<CrewMemberList> getCrewMemberList(
			int crewIdx
			){
		dao = template.getMapper(Dao.class);
		List<CrewMemberList> list = dao.selectCrewMemberList(crewIdx);
		return list;
	}
	
	public int deleteCrewMemberFromList(
			int memberIdx,
			int crewIdx
			) {
		int resultCnt = 0;
		dao = template.getMapper(Dao.class);
		resultCnt = dao.deleteFromCrewMemberList(memberIdx, crewIdx);
		return resultCnt;
	}
	
	public int crewReg(
			int memberIdx,
			int crewIdx
			) {
		int resultCnt = 0;
		dao = template.getMapper(Dao.class);
		resultCnt = dao.insertCrewReg(memberIdx, crewIdx);
		return resultCnt;
	}
}

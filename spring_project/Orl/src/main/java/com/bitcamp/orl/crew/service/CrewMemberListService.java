package com.bitcamp.orl.crew.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.CrewMemberList;

@Service
public class CrewMemberListService {
	
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
}

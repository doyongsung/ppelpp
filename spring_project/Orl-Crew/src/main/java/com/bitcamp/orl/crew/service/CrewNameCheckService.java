package com.bitcamp.orl.crew.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.mapper.CrewMapper;

@Service
public class CrewNameCheckService {
	
	private CrewMapper dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public String crewNameCheck(String crewName) {
		
		String result = "Y";
		dao = template.getMapper(CrewMapper.class);
		
		if(dao.selectByCrewName(crewName)>0) {
			result="N";
		}
		return result;
	}
}

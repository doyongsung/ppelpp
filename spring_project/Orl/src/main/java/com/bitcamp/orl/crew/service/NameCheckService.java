package com.bitcamp.orl.crew.service;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;

@Service
public class NameCheckService {

	private Dao dao;
	private final String NAME_SPACE = "com.bitcamp.orl.crew.dao.CrewDaoMapper";
	@Autowired
	private SqlSessionTemplate template;
	
	public int selectByName(String crewName) throws SQLException {
		return template.selectOne(NAME_SPACE+".selectById", crewName);
	}
	
	public String nameCheck(String crewName) {
		
		String result = "Y";
		dao = template.getMapper(Dao.class);
		
		if(dao.selectByName(crewName)>0) {
			result="N";
		}
		
		return result;
	}

}

package com.bitcamp.orl.crew.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;

@Service
public class NameCheckService {

	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public String nameCheck(String id) {
		
		String result = "Y";
		dao = template.getMapper(Dao.class);
		
		if(dao.selectByName(id)>0) {
			result="N";
		}
		return result;
	}

}

package com.bitcamp.orl.admin.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;


@Service
public class AdminCrewService {

		//크루의 Dao
		private Dao dao;
		
		@Autowired
		private SqlSessionTemplate template;
		
		// 크루 삭제
		public int deleteCrew(int crewIdx) {
			return template.getMapper(Dao.class).deleteCrew(crewIdx);
		}
}

package com.bitcamp.orl.crew.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.SearchType;

@Service
public class CrewRestService {
private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public List<Crew> getSortingName(){
		List<Crew> crewList = null;
		dao = template.getMapper(Dao.class);
		crewList = dao.selectAll();
		return crewList;
	}
	  public List<Crew> getCrewListAll(SearchType searchType){
		  return template.getMapper(Dao.class).selectCrewAll(searchType);
    }
	 
	public int getCrewCount() {
		return template.getMapper(Dao.class).CrewCount();
	}
	

}

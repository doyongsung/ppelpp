package com.bitcamp.orl.crew.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.member.domain.Member;
import com.bitcamp.orl.member.domain.MemberDto;

@Service
public class CrewListViewService {

	private Dao dao;

	@Autowired
	private SqlSessionTemplate template;

	public List<Crew> getMyCrewList(
			HttpServletRequest request
			) {

		List<Crew> myCrewList = null;
		MemberDto memberdto = (MemberDto) request.getSession().getAttribute("memberdto");
		if (memberdto != null) {
			int memberIdx = memberdto.getMemberIdx();
			dao = template.getMapper(Dao.class);
			myCrewList = dao.selectMyCrewList(memberIdx);
		}
		return myCrewList;
	}

	public List<Crew> getCrewListAll(int pageStart, int perPageNum) {
		dao = template.getMapper(Dao.class);
		return dao.selectAll(pageStart, perPageNum);
	}

	public List<Crew> getCrewListAll(SearchType searchType){
		dao = template.getMapper(Dao.class);
		return dao.selectCrewAll(searchType);
	}
	
	public int getCrewCount() {
		return template.getMapper(Dao.class).CrewCount();
	}
	
	public int getCrewCountForSearching(SearchType searchType) {
		return template.getMapper(Dao.class).CrewCountForSearching(searchType);
	}
}

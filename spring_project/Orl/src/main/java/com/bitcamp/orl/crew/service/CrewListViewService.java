package com.bitcamp.orl.crew.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.Criteria;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.member.domain.Member;

@Service
public class CrewListViewService {

	private Dao dao;

	@Autowired
	private SqlSessionTemplate template;

	// 크루 리스트 (이름순)
	public List<Crew> getCrewNameInfo(String crewName) {
		List<Crew> crewList = null;
		dao = template.getMapper(Dao.class);
		return crewList;
	}
	
	//오버로딩  09.06 세라
		public List<Crew> getMyCrewList(
				int memberIdx
				){
			
			List<Crew> myCrewList = null;
			dao = template.getMapper(Dao.class);
			myCrewList = dao.selectMyCrewListinFeed(memberIdx);
			
			
			return myCrewList;
		};

	public List<Crew> getMyCrewList(
			HttpServletRequest request
			) {

		List<Crew> myCrewList = null;
		Member member = (Member) request.getSession().getAttribute("member");
		if (member != null) {
			int memberIdx = member.getMemberIdx();
			dao = template.getMapper(Dao.class);
			myCrewList = dao.selectMyCrewList(memberIdx);
		}
		return myCrewList;
	}

	public List<Crew> getMyCrewList(
			HttpServletRequest request, 
			SearchType searchType
			) {

		List<Crew> myCrewList = null;

		Member member = (Member) request.getSession().getAttribute("member");
		if (member != null) {
			int memberIdx = member.getMemberIdx();
			dao = template.getMapper(Dao.class);
			myCrewList = dao.selectMyCrewList(memberIdx, searchType);
		}
		return myCrewList;
	};

	public List<Crew> getCrewListAll() {
		dao = template.getMapper(Dao.class);
		return dao.selectAll();
	}

	public List<Crew> getCrewListAll(SearchType searchType){
		return template.getMapper(Dao.class).selectCrewAll(searchType);
	}
	
	public int getCrewCount() {
		return template.getMapper(Dao.class).CrewCount();
		}
	
	public List<Crew> listCriteria(Criteria cri){
		return template.getMapper(Dao.class).listCriteria(cri);
	}
	



}

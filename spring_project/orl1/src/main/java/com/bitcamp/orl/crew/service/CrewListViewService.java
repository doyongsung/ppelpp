package com.bitcamp.orl.crew.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.member.domain.MemberDto;

@Service
public class CrewListViewService {

	private CrewMapper dao;

	@Autowired
	private SqlSessionTemplate template;

	public List<Crew> getMyCrewList(
			HttpServletRequest request
			) {

		List<Crew> myCrewList = null;
		MemberDto dto = (MemberDto) request.getSession().getAttribute("memberVo");
		if (dto != null) {
			int memberIdx = dto.getMemberIdx();
			dao = template.getMapper(CrewMapper.class);
			myCrewList = dao.selectMyCrewList(memberIdx);
		}
		return myCrewList;
	}

	//오버로딩  09.06 세라
		public List<Crew> getMyCrewList(
				int memberIdx
				){
			
			List<Crew> myCrewList = null;
			dao = template.getMapper(CrewMapper.class);
			myCrewList = dao.selectMyCrewList(memberIdx);
			
			
			return myCrewList;
		};
		
	
	public List<Crew> getCrewListAll(int pageStart, int perPageNum) {
		dao = template.getMapper(CrewMapper.class);
		return dao.selectAll(pageStart, perPageNum);
	}

	public List<Crew> getCrewListAll(SearchType searchType){
		dao = template.getMapper(CrewMapper.class);
		return dao.selectCrewAll(searchType);
	}
	
	public List<Crew> getCrewListAdmin(){
		dao = template.getMapper(CrewMapper.class);
		return dao.selectCrewListByAdmin();
	}
	
	
	public int getCrewCount() {
		return template.getMapper(CrewMapper.class).CrewCount();
	}
	
	public int getCrewCountForSearching(SearchType searchType) {
		return template.getMapper(CrewMapper.class).CrewCountForSearching(searchType);
	}
}

package com.bitcamp.orl.crew.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.crew.mapper.CrewMapper;
import com.bitcamp.orl.member.domain.MemberDto;

@Service
public class CrewListViewService {

	private CrewMapper dao;

	@Autowired
	private SqlSessionTemplate template;

	//내가 가입한 크루 리스트 가져오기
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
	
	//검색하지 않았을 때 크루 리스트 가져오기(페이징 처리)
	public List<Crew> getCrewListAll(int pageStart, int perPageNum) {
		dao = template.getMapper(CrewMapper.class);
		return dao.selectAll(pageStart, perPageNum);
	}

	//검색 결과가 있을 때 크루 리스트 가져오기(페이징 처리)
	public List<Crew> getCrewListAll(SearchType searchType){
		dao = template.getMapper(CrewMapper.class);
		return dao.selectCrewAll(searchType);
	}
	
	//크루 총 개수 계산(검색하지 않았을 때)
	public int getCrewCount() {
		return template.getMapper(CrewMapper.class).CrewCount();
	}
	
	//크루 총 개수 계산(검색했을 때)
	public int getCrewCountForSearching(SearchType searchType) {
		return template.getMapper(CrewMapper.class).CrewCountForSearching(searchType);
	}
}

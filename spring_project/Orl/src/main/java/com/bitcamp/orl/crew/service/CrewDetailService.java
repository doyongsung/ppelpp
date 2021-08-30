package com.bitcamp.orl.crew.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewComment;
import com.bitcamp.orl.member.domain.Member;

@Service
public class CrewDetailService {
	
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public Crew getCrew(int crewIdx) {
		Crew crew = null;
		dao = template.getMapper(Dao.class);
		crew = dao.selectCrew(crewIdx);
		return crew;
	}
	
	public int getCrewMemberNum(int crewIdx) {
		dao = template.getMapper(Dao.class);
		int crewMemberNum = dao.selectCrewMemberNum(crewIdx);
		return crewMemberNum;
	}
	
	public int getCrewCommentNum(int crewIdx) {
		dao = template.getMapper(Dao.class);
		int crewCommentNum = dao.selectCrewCommentNum(crewIdx);
		return crewCommentNum;
	}
	
	public boolean getIsCrewMember(int memberIdx, int crewIdx) {
		boolean chk = false;
		dao = template.getMapper(Dao.class);
		int chkInt = dao.selectCountMemberToRegCrew(memberIdx, crewIdx);
		if(chkInt != 0) {
			chk = true;
		}
		return chk;
	}
	
	public List<CrewComment> getCrewComment(int crewIdx) {
		dao = template.getMapper(Dao.class);
		return dao.selectCrewComment(crewIdx);
	}
	
	public Member getCommentMember(int memberIdx) {
		dao = template.getMapper(Dao.class);
		return dao.selectCommentMember(memberIdx);
	}
}

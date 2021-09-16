package com.bitcamp.orl.crew.service;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewInfo;
import com.bitcamp.orl.member.domain.MemberDto;

@Service
public class CrewDetailService {
	
	private CrewMapper dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public CrewInfo getCrewInfo(
			HttpSession session, 
			int crewIdx
			) {
		
		CrewInfo crewinfo = getCrew(crewIdx).crewToCrewInfo();
		MemberDto dto = (MemberDto)session.getAttribute("memberVo");
		
		crewinfo.setCrewMemberNum(getCrewMemberNum(crewIdx));
		crewinfo.setCrewCommentNum(getCrewCommentNum(crewIdx));
		
		if(dto != null) {
			crewinfo.setIsReg(getIsCrewMember(dto.getMemberIdx(), crewIdx));
		} else {
			crewinfo.setIsReg(false);
		}
		
		return crewinfo;
	}
	
	public Crew getCrew(int crewIdx) {
		dao = template.getMapper(CrewMapper.class);
		Crew crew = dao.selectCrew(crewIdx);
		return crew;
	}
	
	public int getCrewMemberNum(int crewIdx) {
		dao = template.getMapper(CrewMapper.class);
		int crewMemberNum = dao.selectCrewMemberNum(crewIdx);
		return crewMemberNum;
	}
	
	public int getCrewCommentNum(int crewIdx) {
		dao = template.getMapper(CrewMapper.class);
		int crewCommentNum = dao.selectCrewCommentNum(crewIdx);
		return crewCommentNum;
	}
	
	public boolean getIsCrewMember(int memberIdx, int crewIdx) {
		boolean chk = false;
		dao = template.getMapper(CrewMapper.class);
		int chkInt = dao.selectCountMemberToRegCrew(memberIdx, crewIdx);
		if(chkInt != 0) {
			chk = true;
		}
		return chk;
	}
}

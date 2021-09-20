package com.bitcamp.orl.crew.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewInfo;
import com.bitcamp.orl.crew.mapper.CrewMapper;

@Service
public class CrewDetailService {
	
	private CrewMapper dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	//크루 정보가져오기
	public CrewInfo getCrewInfo(
			int memberIdx,
			int crewIdx
			) {
		
		CrewInfo crewinfo = getCrew(crewIdx).crewToCrewInfo();
		crewinfo.setCrewMemberNum(getCrewMemberNum(crewIdx));
		crewinfo.setCrewCommentNum(getCrewCommentNum(crewIdx));
		
		if(memberIdx != 0 ) {
			crewinfo.setReg(getIsCrewMember(memberIdx, crewIdx));
		} else {
			crewinfo.setReg(false);
		}
		
		return crewinfo;
	}
	
	//crewIdx로 한 크루 선택
	public Crew getCrew(int crewIdx) {
		dao = template.getMapper(CrewMapper.class);
		Crew crew = dao.selectCrew(crewIdx);
		return crew;
	}
	
	//해당 크루의 크루원 수 계산
	public int getCrewMemberNum(int crewIdx) {
		dao = template.getMapper(CrewMapper.class);
		int crewMemberNum = dao.selectCrewMemberNum(crewIdx);
		return crewMemberNum;
	}
	
	//해당 크루의 댓글 수 계산
	public int getCrewCommentNum(int crewIdx) {
		dao = template.getMapper(CrewMapper.class);
		int crewCommentNum = dao.selectCrewCommentNum(crewIdx);
		return crewCommentNum;
	}
	
	//접속한사람(세션 값)이 해당 크루의 크루원인지 여부 체크
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

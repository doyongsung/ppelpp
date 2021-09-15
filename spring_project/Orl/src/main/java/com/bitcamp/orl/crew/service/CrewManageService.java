package com.bitcamp.orl.crew.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewInsertRequest;
import com.bitcamp.orl.member.domain.Member;
import com.bitcamp.orl.member.domain.MemberDto;

@Service
public class CrewManageService {
	
	Dao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public boolean isHaveAuth(
			int crewIdx,
			HttpServletRequest request
			) {
		boolean chk = false;
		MemberDto memberVo = (MemberDto)request.getSession().getAttribute("memberVo");
		
		try {
			int nowAuthIdx = memberVo.getMemberIdx();
			int crewAuthIdx = selectCrew(crewIdx).getMemberIdx();
			if(nowAuthIdx == crewAuthIdx) {
				chk = true;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return chk;
	}
	
	public Crew selectCrew(
			int crewIdx
			) {
		dao = template.getMapper(Dao.class);
		Crew crew = dao.selectCrew(crewIdx);
		return crew;
	}
	
	public int updateCrew(
			CrewInsertRequest crewRequest,
			HttpServletRequest request,
			int crewIdx
			) {
		int resultCnt = 0;
		File newFile = null;
		dao = template.getMapper(Dao.class);
		
		CrewInsertService insertservice = new CrewInsertService();
		
		try {
			if (crewRequest.getCrewPhoto() != null && !crewRequest.getCrewPhoto().isEmpty()) {
				newFile = insertservice.saveFile(request, crewRequest.getCrewPhoto());
				resultCnt = dao.updateCrew(
						crewRequest.getCrewName(), 
						newFile.getName(), 
						crewRequest.getCrewDiscription(), 
						crewRequest.getCrewTag(),
						crewIdx);
			} else {
				resultCnt = dao.updateCrewWithoutPhoto(
						crewRequest.getCrewName(), 
						crewRequest.getCrewDiscription(), 
						crewRequest.getCrewTag(),
						crewIdx);
			}
		} catch(Exception e) {
			e.printStackTrace();
			if(newFile != null && newFile.exists()) {
				newFile.delete();
				System.out.println("오류가 발생하여 파일을 삭제했습니다.");
			}
		}
		return resultCnt;
	}
	
	public int deleteCrew(
			int crewIdx,
			String crewName
			) {
		int resultCnt = 0;
		dao = template.getMapper(Dao.class);
		
		Crew crew = selectCrew(crewIdx);
		if(crew.getCrewName().contentEquals(crewName)) {
			resultCnt = dao.deleteCrew(crewIdx);

		}
		return resultCnt;
	}
}

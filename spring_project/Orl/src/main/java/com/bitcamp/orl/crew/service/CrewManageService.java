package com.bitcamp.orl.crew.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewInsertRequest;
import com.bitcamp.orl.member.domain.MemberDto;

@Service
public class CrewManageService {
	
	final String UPLOAD_URI ="/images/crew";
	
	Dao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	//해당 페이지에 접근할 권한이 있는지(크루장인지) 확인하기
	public boolean isHaveAuth(
			int crewIdx,
			HttpServletRequest request
			) {
		boolean chk = false;
		MemberDto dto = (MemberDto)request.getSession().getAttribute("memberVo");
		
		try {
			int nowAuthIdx = dto.getMemberIdx();
			int crewAuthIdx = selectCrew(crewIdx).getMemberIdx();
			if(nowAuthIdx == crewAuthIdx) {
				chk = true;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return chk;
	}
	
	//한 크루 선택
	public Crew selectCrew(
			int crewIdx
			) {
		dao = template.getMapper(Dao.class);
		Crew crew = dao.selectCrew(crewIdx);
		return crew;
	}
	
	//크루 수정
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
			//크루 수정 시 파일을 넣었을 때
			if (crewRequest.getCrewPhoto() != null && !crewRequest.getCrewPhoto().isEmpty()) {
				//기존 파일을 선택해서 삭제
				selectThatFile(request, crewIdx).delete();
				//새로운 파일 저장
				newFile = insertservice.saveFile(request, crewRequest.getCrewPhoto());
				//DB에 업데이트
				resultCnt = dao.updateCrew(
						crewRequest.getCrewName(), 
						newFile.getName(), 
						crewRequest.getCrewDiscription(), 
						crewRequest.getCrewTag(),
						crewIdx);
			} else {
				//크루 수정 시 파일을 넣지 않았을 때
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
	
	//크루 삭제
	public int deleteCrew(
			int crewIdx,
			String crewName,
			HttpServletRequest request
			) {
		int resultCnt = 0;
		dao = template.getMapper(Dao.class);
		Crew crew = selectCrew(crewIdx);
		
		//크루이름이 일치할 때 삭제
		if(crew.getCrewName().equals(crewName)) {
			selectThatFile(request, crewIdx).delete();
			resultCnt = dao.deleteCrew(crewIdx);
		}
		return resultCnt;
	}
	
	//크루 idx로 현재 크루 사진 파일 선택
	public File selectThatFile(
			HttpServletRequest request,
			int crewIdx
			) {
		dao = template.getMapper(Dao.class);
		String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		File Dir = new File(path);
		File file = null;
		Crew crew = dao.selectCrew(crewIdx);
		try {
			String crewPhoto = crew.getCrewPhoto();
			file = new File(Dir, crewPhoto);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return file;
	}
}

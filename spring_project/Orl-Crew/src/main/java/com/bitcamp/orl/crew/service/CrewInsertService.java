package com.bitcamp.orl.crew.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewInsertRequest;
import com.bitcamp.orl.crew.mapper.CrewMapper;
import com.bitcamp.orl.member.domain.MemberDto;

@Service
public class CrewInsertService {

	final String UPLOAD_URI ="/images/crew";
	
	private CrewMapper dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public Crew insert(
			CrewInsertRequest crewRequest,
			HttpServletRequest request
			
			) {
		File newFile = null;
		Crew crew = crewRequest.toCrew();
		
		try {
			
			if (crewRequest.getCrewPhoto() != null && !crewRequest.getCrewPhoto().isEmpty()) {
				newFile = saveFile(request,crewRequest.getCrewPhoto());
				crew.setCrewPhoto(newFile.getName());
			}
			
			MemberDto dto = (MemberDto)(request.getSession().getAttribute("memberVo"));
		    
		    if (dto != null) {			
		    	crew.setMemberIdx(dto.getMemberIdx());
		    	crew.setMemberNickName(dto.getMemberNickname());
		    }
		    
			dao = template.getMapper(CrewMapper.class);
			dao.insertCrew(crew);
			dao.insertCrewReg(dto.getMemberIdx(), crew.getCrewIdx());
		
		} catch(Exception e) {
			e.printStackTrace();
			if(newFile != null & newFile.exists()) {
				newFile.delete();
				System.out.println("파일 삭제");
			}
		}
		
		return crew;
	}
	
	public File saveFile(
			HttpServletRequest request, 
			MultipartFile file) {
		
		String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		File newDir = new File(path);
		
		if(!newDir.exists()) {
			newDir.mkdir();
			System.out.println("저장 폴더를 생성했습니다.");
		}
		
		String newFileName = System.currentTimeMillis() + file.getOriginalFilename();
		File newFile = new File(newDir, newFileName);
		
		try {
			file.transferTo(newFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newFile;
	}
	
	public Crew selectCrew(int crewIdx) {
		dao = template.getMapper(CrewMapper.class);
		return dao.selectCrew(crewIdx);
	}
}
package com.bitcamp.orl.crew.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewRequest;
import com.bitcamp.orl.member.domain.Member;

@Service
public class CrewInsertService {

	final String UPLOAD_URI ="/images/crew";
	private final String NAME_SPACE = "com.bitcamp.orl.crew.dao.CrewDaoMapper";
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int reg(
			CrewRequest crewRequest,
			HttpServletRequest request
			
			) {
		int resultCnt = 0;
		
		File newFile = null;
		
		try {
		Crew crew = new Crew();
		crew.setCrewName(crewRequest.getCrewName());
		
		if (crewRequest.getCrewPhoto() != null && !crewRequest.getCrewPhoto().isEmpty()) {
			newFile = saveFile(request,crewRequest.getCrewPhoto());
			crew.setCrewPhoto(newFile.getName());
		}
		
	    crew.setCrewDiscription(crewRequest.getCrewDiscription());
	    crew.setCrewTag(crewRequest.getCrewTag());
	    
	    Member member = (Member)(request.getSession().getAttribute("member"));
	    
	    if (member != null) {			
	    	crew.setMemberIdx(member.getMemberIdx());
	    	crew.setMemberNickName(member.getMemberNickname());
	    }
		dao = template.getMapper(Dao.class);
		resultCnt = dao.insertCrew(crew);
		dao.insertCrewReg(member.getMemberIdx(), crew.getCrewIdx());
		}catch(Exception e) {
			e.printStackTrace();
			if(newFile != null & newFile.exists()) {
				newFile.delete();
				System.out.println("파일 삭제");
			}
		}
		
		return resultCnt;
	}
	
	
	
	private File saveFile(HttpServletRequest request, MultipartFile file) {
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
}

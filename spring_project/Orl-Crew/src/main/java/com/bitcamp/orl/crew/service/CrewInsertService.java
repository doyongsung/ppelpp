package com.bitcamp.orl.crew.service;

import java.io.File;
import java.io.IOException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewInsertRequest;
import com.bitcamp.orl.crew.mapper.CrewMapper;

@Service
public class CrewInsertService {

	private CrewMapper dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	//크루 생성
	public Crew insert(CrewInsertRequest crewRequest) {
		
		File newFile = null;
		Crew crew = crewRequest.toCrew();
		dao = template.getMapper(CrewMapper.class);
		
		//크루 이름이 3글자 이상이 안되면 null 리턴
		if(crewRequest.getCrewName().trim().length()<3) {
			return null;
		}
		
		try {
			if (crewRequest.getCrewPhoto() != null && !crewRequest.getCrewPhoto().isEmpty()) {
				newFile = saveFile(crewRequest.getCrewPhoto());
				crew.setCrewPhoto(newFile.getName());
			}
			
			dao.insertCrew(crew);
			dao.insertCrewReg(crew.getMemberIdx(), crew.getCrewIdx());
		} catch(Exception e) {
			e.printStackTrace();
			if(newFile != null & newFile.exists()) {
				newFile.delete();
				System.out.println("파일 삭제");
			}
		}
		return crew;
	}
	
	//파일 저장 method
	public File saveFile(MultipartFile file) {
		
		String path = "C:\\Users\\user\\Documents\\GitHub\\java205\\Spring_project\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Orl\\images\\crew";
		File newDir = new File(path);
		
		if(!newDir.exists()) {
			newDir.mkdir();
			System.out.println("저장 폴더를 생성했습니다.");
		}
		System.out.println(newDir);
		
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
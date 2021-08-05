package com.bitcamp.firstSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.firstSpring.dao.Dao;


// 자동 bean 등록
@Service
public class FileUploadService {
	
	@Autowired
	Dao dao;
	
	public void fileUpload() {
		
	}

}

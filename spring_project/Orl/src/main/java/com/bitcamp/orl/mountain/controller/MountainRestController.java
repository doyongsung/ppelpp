package com.bitcamp.orl.mountain.controller;

import com.bitcamp.orl.mountain.domain.MountainLocInfo;
import com.bitcamp.orl.mountain.service.MountainRestService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MountainRestController {

	@Autowired
	private MountainRestService restService;
	
	//지역별 산 리스트
	@PostMapping("/mountain/local")
	@CrossOrigin
	public List<MountainLocInfo> getMountainLoc(String loc){
		return restService.getMountainLocList(loc);
	}
	
	// 전국 산 리스트
	@GetMapping("/mountain/all")
	@CrossOrigin
	public List<MountainLocInfo> getMountainAll(){
		return restService.getMountainAllList();
	}
	
	
	
}

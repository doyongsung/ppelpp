package com.bitcamp.orl.mountain.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.orl.mountain.service.MountainLocInfoViewService;

@Controller
public class MountainLocInfoController {

	@Autowired
	private MountainLocInfoViewService service;
	
	//겟방식으로 들어왔을때 전국 지도로 return
	@RequestMapping(value ="/mountain/mountainLocInfo",method = RequestMethod.GET)
	public String getMountainLocGet() {

		return "mountain/mountain_all";
	}

	//포스트 방식으로 들어왔을때 지역별 산 리스트페이지로 이동
	@RequestMapping(value ="/mountain/mountainLocInfo",method = RequestMethod.POST)
	public String getMountainLocPost(HttpServletRequest request, Model model) {

		String loc = null;
		loc = request.getParameter("locName");
		int countLoc = service.getCountLoc(loc);
		String locEn = service.getLocEn(loc);

		model.addAttribute("loc", loc);
		model.addAttribute("countLoc", countLoc);
		model.addAttribute("locEn", locEn);
		return "mountain/local";
	}
	
	
}

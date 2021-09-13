package com.bitcamp.orl.mountain.controller;


import com.bitcamp.orl.mountain.domain.MountainLocInfo;
import com.bitcamp.orl.mountain.service.MountainLocInfoViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MountainLocInfoController4beforepost {

	@Autowired
	private MountainLocInfoViewService service;
	
	@RequestMapping("/mountain/mountainLocInfo")
	public String getMountainLoc(HttpServletRequest request, Model model) {

		String loc = null;
		loc = request.getParameter("locName");
		List<MountainLocInfo> mountainLocInfoList = null;
		
		int countLoc = service.getCountLoc(loc);
		String locEn = service.getLocEn(loc);
		model.addAttribute("loc", loc);
		model.addAttribute("countLoc",countLoc);
		model.addAttribute("locEn", locEn);

		return "mountain/local";
	}
	
	
	
}

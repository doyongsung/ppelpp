package com.bitcamp.orl.crew.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewInfo;
import com.bitcamp.orl.crew.domain.CrewInsertRequest;
import com.bitcamp.orl.crew.service.CrewDetailService;
import com.bitcamp.orl.crew.service.CrewInsertService;

@Controller
@RequestMapping("/crew/insert")
public class CrewInsertController {

	@Autowired
	private CrewInsertService insertService;
	
	@Autowired
	private CrewDetailService detailService;
	
	//크루 생성 페이지 view 주는 method
	@RequestMapping(method = RequestMethod.GET)
	public String insert() {
		return "crew/insertForm";
	}
	
	//크루 생성 페이지에서 생성 눌렀을 때 post 처리하는 method
	@RequestMapping(method = RequestMethod.POST)
	public String reg(
			CrewInsertRequest crewRequest, 
			HttpServletRequest request, 
			Model model
			) {
		Crew crew = insertService.insert(crewRequest, request);
		if(crew != null) {
			CrewInfo crewinfo = detailService.getCrewInfo(request.getSession(), crew.getCrewIdx());
			model.addAttribute("crew", crewinfo);
		}
		return "crew/insert";
	}
}
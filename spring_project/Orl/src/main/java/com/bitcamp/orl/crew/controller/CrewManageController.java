package com.bitcamp.orl.crew.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewCommentCriteria;
import com.bitcamp.orl.crew.domain.CrewInfo;
import com.bitcamp.orl.crew.domain.CrewInsertRequest;
import com.bitcamp.orl.crew.service.CrewDetailService;
import com.bitcamp.orl.crew.service.CrewManageService;

@Controller
public class CrewManageController {
	
	@Autowired
	private CrewManageService service;
	
	@Autowired
	private CrewDetailService detailService;
	
	//크루 수정 page를 주는 get method
	@RequestMapping("/crew/edit/{crewIdx}")
	public String getCrewEditPage(
			HttpServletRequest request,
			@PathVariable("crewIdx")int crewIdx,
			Model model
			) {
		//크루 삭제 권한이 있는지(크루장인지) 확인
		boolean chk = service.isHaveAuth(crewIdx, request);
		CrewInfo crewinfo = detailService.getCrewInfo(request.getSession(), crewIdx);
		
		model.addAttribute("chk", chk);
		model.addAttribute("crew", crewinfo);
		
		return "crew/edit";
	}
	
	//크루 수정 page에서 post했을 시 method
	@RequestMapping(value = "/crew/edit/{crewIdx}", method = RequestMethod.POST)
	public String crewEdit(
			@PathVariable("crewIdx")int crewIdx,
			CrewInsertRequest crewRequest,
			HttpServletRequest request,
			Model model
			) {
		//크루 수정
		int result = service.updateCrew(crewRequest, request, crewIdx);
		CrewInfo crewinfo = detailService.getCrewInfo(request.getSession(), crewIdx);
		CrewCommentCriteria cri = new CrewCommentCriteria(crewIdx, 1);
		
		model.addAttribute("crew", crewinfo);
		model.addAttribute("cri", cri);
		model.addAttribute("updateResult", result);
		return "crew/detail";
	}
	
	//크루원 관리 page를 주는 get method
	@RequestMapping("/crew/memberManage/{crewIdx}")
	public String getCrewMemberMngPage(
			HttpServletRequest request,
			@PathVariable("crewIdx")int crewIdx,
			Model model
			) {
		//크루 삭제 권한이 있는지(크루장인지) 확인
		boolean chk = service.isHaveAuth(crewIdx, request);
		Crew crew = service.selectCrew(crewIdx);
		
		model.addAttribute("chk", chk);
		model.addAttribute("crew", crew);
		
		return "crew/memberManage";
	}
	
	//크루 삭제 page를 주는 get method
	@RequestMapping("/crew/remove/{crewIdx}")
	public String getCrewRemovePage(
			HttpServletRequest request,
			@PathVariable("crewIdx")int crewIdx,
			Model model
			) {
		//크루 삭제 권한이 있는지(크루장인지) 확인
		boolean chk = service.isHaveAuth(crewIdx, request);
		Crew crew = service.selectCrew(crewIdx);
		
		model.addAttribute("chk", chk);
		model.addAttribute("crew", crew);
		
		return "crew/remove";
	}
	
	//크루 삭제 page에서 post했을 시 method
	@RequestMapping(value="/crew/remove/{crewIdx}", method = RequestMethod.POST)
	public String crewRemove(
			HttpServletRequest request,
			@PathVariable("crewIdx")int crewIdx,
			@RequestParam("crewName")String crewName,
			Model model
			) {
		//삭제 처리
		int result = service.deleteCrew(crewIdx, crewName, request);
		
		//삭제 실패시 다시 해당 crew 페이지로 돌아가기 위해서 crew 값 구함
		Crew crew = service.selectCrew(crewIdx);
		
		model.addAttribute("crew", crew);
		model.addAttribute("result", result);
		
		return "crew/remove";
	}
}

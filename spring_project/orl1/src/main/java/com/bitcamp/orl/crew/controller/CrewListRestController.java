package com.bitcamp.orl.crew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewForPaging;
import com.bitcamp.orl.crew.domain.CrewListCriteria;
import com.bitcamp.orl.crew.domain.PageMaker;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.crew.service.CrewListViewService;

@RestController
public class CrewListRestController {

	@Autowired
	CrewListViewService service;
	
	@RequestMapping("/crew/searchList")
	@CrossOrigin
	public CrewForPaging getCrewList(
			@RequestParam(value="searchType", required = false)String searchType,
			@RequestParam(value="keyword", required = false)String keyword,
			@RequestParam(value="page", required = false, defaultValue = "1")int page
			){
		
		CrewForPaging crewForPaging = null;
		CrewListCriteria cri = new CrewListCriteria(page);
		
		//페이징 처리
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int totalNum;
		
		SearchType st = new SearchType(searchType, keyword, cri.getPageStart(), cri.getPerPageNum());
		
		List<Crew> allCrewList;
		if(st.getKeyword() !=null && st.getKeyword().trim().length() > 0) {
			allCrewList= service.getCrewListAll(st);
			totalNum = service.getCrewCountForSearching(st);
			pageMaker.setTotalCount(totalNum);
		} else {
			allCrewList = service.getCrewListAll(cri.getPageStart(), cri.getPerPageNum());
			totalNum = service.getCrewCount();
			pageMaker.setTotalCount(totalNum);
		}
		crewForPaging = new CrewForPaging(allCrewList, pageMaker);
		return crewForPaging;
	}
}

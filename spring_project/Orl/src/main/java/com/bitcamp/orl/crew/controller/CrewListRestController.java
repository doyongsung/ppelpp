package com.bitcamp.orl.crew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.Criteria;
import com.bitcamp.orl.crew.domain.PageMaker;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.crew.service.CrewRestService;

@RestController
public class CrewListRestController {
	
	@Autowired
	private CrewRestService restService;
	
	@GetMapping("/crew/crewName")
	@CrossOrigin
	public List<Crew> getSortingName(){
		return restService.getSortingName();
	}
		
	  @GetMapping("/crew/searchList")
	  @CrossOrigin 
	  public List<Crew> getCrewSearchList(
			  Model model,
			  Criteria cri,
			  SearchType searchType
			  ){
			List<Crew> list= null;
            //  커맨드 객체로 Criteria를 매개변수, 넘어오는 page와 perPageNum정보를 받기
    list = restService.getCrewListAll(searchType);
    System.out.println(searchType);
            // 이제 view jsp 페이지에서 페이징 처리를 위해 사용할 PageMaker 객체를 생성하고
    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(cri);
    int totalNum = restService.getCrewCount();
    pageMaker.setTotalCount(totalNum); 
            // /views/crew/list.jsp 에서 페이징 처리를 하기 위해 PageMaker 객체를 저장
            // 화면에 게시글을 뿌려주기 위해서 꺼내온 dto도 저장(model 객체에)
    model.addAttribute("pageMaker", pageMaker);
    model.addAttribute("list", list);
    
		  return list;
	  }

	
	  
	  }
	 



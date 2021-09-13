package com.bitcamp.orl.crew.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.Criteria;
import com.bitcamp.orl.crew.domain.PageMaker;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.crew.service.CrewListViewService;

@Controller
@RequestMapping("/crew/list")
public class CrewListViewController {
	
	@Autowired
	CrewListViewService service;

	
	
	  @RequestMapping(method = RequestMethod.GET) 
	  public String getCrewList(
	  HttpServletRequest request, Model model,
	  Criteria cri,
	  @ModelAttribute("searchType")SearchType searchType
	  
	 ) {
	  
	  //내 크루 리스트 처리//
		  List<Crew> myCrewList = null; 
		  myCrewList = service.getMyCrewList(request); 
		  model.addAttribute("myCrewList", myCrewList);

		  
		  //페이징 리스트//
		  
			List<Crew> list= null;
		            //  커맨드 객체로 Criteria를 매개변수, 넘어오는 page와 perPageNum정보를 받기
		    list = service.getCrewListAll(searchType);
		    System.out.println(searchType);
		            // 이제 view jsp 페이지에서 페이징 처리를 위해 사용할 PageMaker 객체를 생성하고
		    PageMaker pageMaker = new PageMaker();
		    pageMaker.setCri(cri);
		    int totalNum = service.getCrewCount();
		    pageMaker.setTotalCount(totalNum); 
		            // /views/crew/list.jsp 에서 페이징 처리를 하기 위해 PageMaker 객체를 저장
		            // 화면에 게시글을 뿌려주기 위해서 꺼내온 dto도 저장(model 객체에)
		    model.addAttribute("pageMaker", pageMaker);
		    model.addAttribute("list", list);
		
		
		  //크루 검색기능 더해서 전체 크루 리스트 처리 
			
			  
			/*
			 * if(searchType.getKeyword() !=null && searchType.getKeyword().trim().length()
			 * > 0) { list = service.getCrewListAll(searchType); } else { list =
			 * service.getCrewListAll(); } model.addAttribute("crewList", list);
			 * 
			 */
			  return "crew/list"; 
 }
			 

}

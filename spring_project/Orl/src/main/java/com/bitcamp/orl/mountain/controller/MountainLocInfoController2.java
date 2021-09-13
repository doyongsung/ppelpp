/*
 * package com.bitcamp.orl.mountain.controller;
 * 
 * 
 * import com.bitcamp.orl.mountain.domain.MountainLocInfo; import
 * com.bitcamp.orl.mountain.service.MountainLocInfoViewService; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * import javax.servlet.http.HttpServletRequest; import java.util.List;
 * 
 * @Controller public class MountainLocInfoController2 {
 * 
 * @Autowired private MountainLocInfoViewService service;
 * 
 * @RequestMapping("/mountain/mountainLocInfo2") public String
 * getMountainLoc(HttpServletRequest request, Model model) {
 * 
 * String loc = null; loc = request.getParameter("locName");
 * List<MountainLocInfo> mountainLocInfoList = null; String
 * heightlist=request.getParameter("heightlist"); String
 * namelist=request.getParameter("namelist");
 * 
 * if(heightlist!=null) { mountainLocInfoList =
 * service.getMountainNameInfo(loc);
 * 
 * }else { mountainLocInfoList = service.getMountainLocInfo(loc);
 * 
 * }
 * 
 * int countLoc = service.getCountLoc(loc);
 * model.addAttribute("mountainLocInfoList",mountainLocInfoList);
 * model.addAttribute("loc", loc); model.addAttribute("countLoc",countLoc); //
 * return "mountain/local"; return "mountain/local2"; }
 * 
 * 
 * 
 * }
 */
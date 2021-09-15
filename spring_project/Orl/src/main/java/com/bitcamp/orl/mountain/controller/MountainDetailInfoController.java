package com.bitcamp.orl.mountain.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.orl.mountain.domain.MountainLocInfo;
import com.bitcamp.orl.mountain.service.MountainDetailInfoViewService;

@Controller
public class MountainDetailInfoController {

   @Autowired
   MountainDetailInfoViewService service;

   // 산 상세 보여주는 컨트롤러
   @RequestMapping(value = "/mountain/mountainDetailInfo",method = RequestMethod.GET)
   public String getMountainLoc() {
      return "mountain/mountain_all";
   }

   @RequestMapping(value = "/mountain/mountainDetailInfo",method = RequestMethod.POST)
   public String postMountainLoc(HttpServletRequest request, Model model) {

      String mountainName;
      mountainName = request.getParameter("mountainName");
      System.out.println(mountainName);
      MountainLocInfo mountainLocInfo = service.getMountainLocInfo(mountainName);
      model.addAttribute("mountainLocInfo",mountainLocInfo);
      return "mountain/mountain_info";
   }

   
}
package com.bitcamp.orl.mountain.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.mountain.domain.MountainLocInfo;
import com.bitcamp.orl.mountain.service.MountainLocInfoViewService;

@Controller
/* @RequestMapping("/mountain/search") */
public class SearchController {


    @Autowired
    private MountainLocInfoViewService locService;




    @RequestMapping("/mountain/search")
    public String search(HttpServletRequest request,Model model
    ) {

        String search =null;
        search=request.getParameter("mysearch");


        List<MountainLocInfo> mountainLocInfoList = null;
        List<MountainLocInfo> mountainLocInfoList2 = null;

        mountainLocInfoList = locService.getMountainName1(search);

        mountainLocInfoList2 = locService.getMountainLocInfo(search);





        model.addAttribute("mountainList",mountainLocInfoList);
        model.addAttribute("mountainList2",mountainLocInfoList2);
        return "mountain/search";


    }

}
package com.bitcamp.orl.mountain.controller;

import com.bitcamp.orl.mountain.domain.MountainLocInfo;
import com.bitcamp.orl.mountain.service.MountainRestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MountainRestController {
    @Autowired
    private MountainRestService restService;

    @GetMapping("/mountain/height")
    @CrossOrigin
    public List<MountainLocInfo> getSortingHeight(String loc){
        return restService.getSortingHeight(loc);
    }

}

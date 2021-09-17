package com.bitcamp.orl.feed.controller;

import com.bitcamp.orl.feed.domain.NewFeedList;
import com.bitcamp.orl.feed.service.FeedManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// 산별 피드보기 용민 작성
@RestController
public class MountainFeedRestController {

    @Autowired
    FeedManageService manageService;

    //피드 리스트 (최신순)
    @GetMapping("/feed/feedmain/selectNewMountainFeed")
    public List<NewFeedList> newFeedList (String mName){
        System.out.println("rest 진입 산이름 : "+mName);
        List<NewFeedList> feedList = manageService.getNewFeedByMountain(mName);
        System.out.println("rest controller =>" + feedList);

        return feedList;
    }
}

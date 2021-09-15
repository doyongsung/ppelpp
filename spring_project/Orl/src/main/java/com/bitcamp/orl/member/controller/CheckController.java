package com.bitcamp.orl.member.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.member.service.CheckService;

@RestController
public class CheckController {

    @Autowired
    private CheckService service;

    @GetMapping("/member/idCheck")
    @CrossOrigin
    public String idCheck(
            @RequestParam("mid") String uid
    ) {
        return service.idCheck(uid);
    }


    @GetMapping("/member/nickNameCheck")
    @CrossOrigin
    public String nickNameCheck(
            @RequestParam("nickname") String nickname) {

        return service.nickNameCheck(nickname);
    }

    @GetMapping("/member/emailCheck")
    @CrossOrigin
    public String emailCheck(
            @RequestParam("email") String email) {
        return service.emailCheck(email);
    }

}
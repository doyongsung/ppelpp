package org.hello.web;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.hello.dao.MemberDAO;
import org.hello.domain.MemberVO;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class TestDAO {

	@Inject
    private MemberDAO dao;
   
    @RequestMapping(value = "/testDAO", method = RequestMethod.GET)
    public void testDAO(){
        MemberVO vo = new MemberVO();
        vo.setUser_id("fjfj");
        vo.setUser_pw("1234");
        vo.setUser_email("min-it.tistory.com");
       
        dao.insertMember(vo);
    }
}

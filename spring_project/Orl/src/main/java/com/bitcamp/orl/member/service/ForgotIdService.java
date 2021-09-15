package com.bitcamp.orl.member.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.member.dao.Dao;

@Service
public class ForgotIdService {

	  private Dao dao;
	   
	   @Autowired
	   private SqlSessionTemplate template;
	   
	   public String FindId( HttpServletRequest request, String membername,
		         String memberEmail
		         ) {
		   String findId=null;
		   
		   dao=template.getMapper(Dao.class);
		   
		  if(membername != null && memberEmail != null && membername.trim().length() > 1 && memberEmail.trim().length() > 1) {
			  findId=dao.selectByIdEmail(membername, memberEmail);
			  
		  }
		   
		   return findId;
	   }

}

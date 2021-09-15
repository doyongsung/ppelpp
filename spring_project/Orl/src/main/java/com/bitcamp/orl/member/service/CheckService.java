package com.bitcamp.orl.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.member.dao.Dao;

@Service
public class CheckService {

   private Dao dao;
   @Autowired
   private SqlSessionTemplate template;
   
   public String idCheck(String id) {
      
      String result ="Y";
      dao=template.getMapper(Dao.class);
      
      if(dao.selectById(id)>0 ||id ==null || id.trim().equals("")) {
         result="N";
      }
      return result;
   }
   
   public String nickNameCheck(String nickname) {
      
      String result ="Y";
      dao=template.getMapper(Dao.class);
      
      if(dao.selectByNickName(nickname)>0 ||nickname ==null || nickname.trim().equals("")) {
         result="N";
      }
      return result;
   }

   public String emailCheck(String email) {

      String result ="Y";
      dao=template.getMapper(Dao.class);

      if(dao.selectByEmail(email)>0 ||email ==null || email.trim().equals("")) {
         result="N";
      }
      return result;
   }

}
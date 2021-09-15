package com.bitcamp.orl.member.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.member.dao.Dao;

@Service
public class ForgotPwService {
	

	  private Dao dao;
	   
	   @Autowired
	   private SqlSessionTemplate template;
	   
	   public String FindPw( HttpServletRequest request,String memberId, String membername,
		         String memberEmail
		         ) {
		   
		   String findPw=null;
		   
		   dao=template.getMapper(Dao.class);
		   
		  if(memberId!=null && membername != null && memberEmail != null&& 
			  memberId.trim().length() > 1 && membername.trim().length() > 1
			  && memberEmail.trim().length() > 2) {
			  
			  
			  findPw=dao.selectPw(memberId,membername, memberEmail);
		  }
		  
		  System.out.println("비번서비스"+findPw);
		   return findPw;
	   }
	   
	   public void mailSender(String pw, String email) throws AddressException, MessagingException {
		   
	        System.out.println("메일 시작");
	        // 네이버일 경우 smtp.naver.com 을 입력합니다.// Google일 경우 smtp.gmail.com 을 입력합니다.
	        String host = "smtp.naver.com";
	        final String username = "orullay"; // 네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요.
	        final String password = "bitcamp205!";   // 네이버 이메일 비밀번호를 입력해주세요.
	        int port = 465;   // 포트번호
	// 메일 내용
	        String recipient = email; //받는 사람의 메일주소를 입력해주세요.
	        String subject = "비밀번호 입니다"; //메일 제목 입력해주세요.
	        String body = "비밀번호는 '" + pw + "'입니다."; //메일 내용 입력해주세요
	        Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성
	// SMTP 서버 정보 설정
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", port);
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.ssl.enable", "true");
	        props.put("mail.smtp.ssl.trust", host);

	// Session 생성
	        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	            String un = username;
	            String pw = password;

	            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	                return new javax.mail.PasswordAuthentication(un, pw);
	            }
	        });
	        session.setDebug(true); //for debug
	        Message mimeMessage = new MimeMessage(session); //MimeMessage 생성
	        mimeMessage.setFrom(new InternetAddress("orullay@naver.com")); //발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다.
	// 이때는 이메일 풀 주소를 다 작성해주세요.
	        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음
	        mimeMessage.setSubject(subject); //제목셋팅
	        mimeMessage.setText(body); //내용셋팅
	        Transport.send(mimeMessage); //javax.mail.Transport.send() 이용
	    }

}

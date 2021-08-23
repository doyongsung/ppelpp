package com.bitcamp.op.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.domain.Member;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender sender;

	public int send(Member member) {

		int result = 1;

		MimeMessage message = sender.createMimeMessage();

		try {

			// 메일 제목
			message.setSubject("[안내] 회원가입을 축하합니다.", "UTF-8");

			// 메일 내용 컨텐츠 html
			String html = "<h1>회원가입을 축하합니다.</h1>";
			html += "<a href=\"https://www.naver.com\">네이버로 갈까요?!!!</a>";

			// message에 내용 적용
			message.setText(html, "utf-8", "html");

			// from 설정
			message.setFrom(new InternetAddress("aia.jin.202009@gmail.com"));

			// to 설정
			message.addRecipient(RecipientType.TO,
					new InternetAddress(member.getMemberid(), member.getMembername() + " 님", "UTF-8"));

			// 메일 발송
			sender.send(message);

		} catch (MessagingException e) {
			result = 0;
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			result = 0;
			e.printStackTrace();
		}
		return result;
	}
}

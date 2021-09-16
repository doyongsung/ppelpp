package com.bitcamp.orl.member.domain;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberRequest {

   private String memberId;
   private String memberPw;
   private String memberPw2;
   private String memberName;
   private String memberEmail;
   private String memberNickname;
   private String year;
   private String month;
   private String date;

   public MemberRequest() {
   }

   public MemberRequest(
         String memberId, 
         String memberPw, 
         String memberPw2,
         String memberName, 
         String memberEmail, 
         String memberNickname,
         String year,
         String month,
         String date) {
      this.memberId = memberId;
      this.memberPw = memberPw;
      this.memberPw2 = memberPw2;
      this.memberName = memberName;
      this.memberEmail = memberEmail;
      this.memberNickname = memberNickname;
      this.year = year;
      this.month = month;
      this.date = date;
   }

   public String getMemberId() {
      return memberId;
   }

   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }

   public String getMemberPw() {
      return memberPw;
   }

   public void setMemberPw(String memberPw) {
      this.memberPw = memberPw;
   }
   
   public String getMemberPw2() {
      return memberPw2;
   }
   
   public void setMemberPw2(String memberPw2) {
      this.memberPw2 = memberPw2;
   }

   public String getMemberName() {
      return memberName;
   }

   public void setMemberName(String memberName) {
      this.memberName = memberName;
   }

   public String getMemberEmail() {
      return memberEmail;
   }

   public void setMemberEmail(String memberEmail) {
      this.memberEmail = memberEmail;
   }

   public String getMemberNickname() {
      return memberNickname;
   }

   public void setMemberNickname(String memberNickname) {
      this.memberNickname = memberNickname;
   }

   public String getYear() {
      return year;
   }

   public void setYear(String year) {
      this.year = year;
   }

   public String getMonth() {
      return month;
   }

   public void setMonth(String month) {
      this.month = month;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getMemberBirth() throws ParseException {
	      
	      if(month.length()==1) {
	         month = "0"+month;
	      } if(date.length()==1) {
	         date = "0"+date;
	      }
	      
	      String dataFormatString = year+month+date;
	      return dataFormatString;
	   }
}
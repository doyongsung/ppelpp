package com.bitcamp.orl.member.domain;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {

   private int memberIdx;
   private String memberId;
   private String memberPw;
   private String memberName;
   private String memberEmail;
   private String memberProfile;
   private String memberNickname;
   private Timestamp memberRegdate;
   private String memberBirth;

   public Member() {}
   
   public Member(String memberName, String memberEmail,
              String memberProfile, String memberNickname,String memberBirth) {
      this.memberName = memberName;
      this.memberEmail = memberEmail;
      this.memberProfile = memberProfile;
      this.memberNickname = memberNickname;
      this.memberBirth = memberBirth;
   }
   
   public Member(int memberIdx, String memberId, String memberPw, String memberName, String memberEmail,
              String memberProfile, String memberNickname, Timestamp memberRegdate, String memberBirth) {
      this.memberIdx = memberIdx;
      this.memberId = memberId;
      this.memberPw = memberPw;
      this.memberName = memberName;
      this.memberEmail = memberEmail;
      this.memberProfile = memberProfile;
      this.memberNickname = memberNickname;
      this.memberRegdate = memberRegdate;
      this.memberBirth = memberBirth;
   }

   public int getMemberIdx() {
      return memberIdx;
   }

   public void setMemberIdx(int memberIdx) {
      this.memberIdx = memberIdx;
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

   public String getMemberProfile() {
      return memberProfile;
   }

   public void setMemberProfile(String memberProfile) {
      this.memberProfile = memberProfile;
   }

   public String getMemberNickname() {
      return memberNickname;
   }

   public void setMemberNickname(String memberNickname) {
      this.memberNickname = memberNickname;
   }

   public Timestamp getMemberRegdate() {
      return memberRegdate;
   }

   public void setMemberRegdate(Timestamp memberRegdate) {
      this.memberRegdate = memberRegdate;
   }

   public String getMemberBirth() {
      return memberBirth;
   }

   public void setMemberBirth(String date) {
      this.memberBirth = date;
   }

   @Override
   public String toString() {
      return "Member [memberIdx=" + memberIdx + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName="
            + memberName + ", memberEmail=" + memberEmail + ", memberProfile=" + memberProfile + ", memberNickname="
            + memberNickname + ", memberRegdate=" + memberRegdate + ", memberBirth=" + memberBirth + "]";
   }


   public MemberDto memberToMemberVo(){
      return new MemberDto(memberIdx, memberNickname);
   }





}
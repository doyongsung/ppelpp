package com.bitcamp.orl.member.domain;

public class MemberDto {
	  	private int memberIdx;
	    private String memberNickname;

	    public MemberDto(int memberIdx, String memberNickname) {
	        this.memberIdx = memberIdx;
	        this.memberNickname = memberNickname;
	    }

	    public int getMemberIdx() {
	        return memberIdx;
	    }

	    public void setMemberIdx(int memberIdx) {
	        this.memberIdx = memberIdx;
	    }

	    public String getMemberNickname() {
	        return memberNickname;
	    }

	    public void setMemberNickname(String memberNickname) {
	        this.memberNickname = memberNickname;
	    }

	    @Override
	    public String toString() {
	        return "MemberVo{" +
	                "memberIdx=" + memberIdx +
	                ", memberNickname='" + memberNickname + '\'' +
	                '}';
	    }
	}
package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CrewMemberList {
	private int memberIdx;
	private String memberId;
	private String memberProfile;
	private String memberNickName;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp memberBirth;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp crewRegdate;
	private int crewIdx;
	
	public CrewMemberList() {}
	
	public CrewMemberList(int memberIdx, String memberId, String memberProfile, String memberNickName,
			Timestamp memberBirth, Timestamp crewRegdate, int crewIdx) {
		super();
		this.memberIdx = memberIdx;
		this.memberId = memberId;
		this.memberProfile = memberProfile;
		this.memberNickName = memberNickName;
		this.memberBirth = memberBirth;
		this.crewRegdate = crewRegdate;
		this.crewIdx = crewIdx;
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

	public String getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}

	public String getMemberNickName() {
		return memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public Timestamp getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(Timestamp memberBirth) {
		this.memberBirth = memberBirth;
	}

	public Timestamp getCrewRegdate() {
		return crewRegdate;
	}

	public void setCrewRegdate(Timestamp crewRegdate) {
		this.crewRegdate = crewRegdate;
	}

	public int getCrewIdx() {
		return crewIdx;
	}

	public void setCrewIdx(int crewIdx) {
		this.crewIdx = crewIdx;
	}

	@Override
	public String toString() {
		return "CrewMemberList [memberIdx=" + memberIdx + ", memberId=" + memberId + ", memberProfile=" + memberProfile
				+ ", memberNickName=" + memberNickName + ", memberBirth=" + memberBirth + ", crewRegdate=" + crewRegdate
				+ ", crewIdx=" + crewIdx + "]";
	}
	
	
}

package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

public class CrewMemberList {
	private int memberIdx;
	private String memberId;
	private String memberPhoto;
	private String memberNickName;
	private Timestamp memberBirth;
	private Timestamp crewRegdate;
	private int crewIdx;
	
	public CrewMemberList() {}
	
	public CrewMemberList(int memberIdx, String memberId, String memberPhoto, String memberNickName,
			Timestamp memberBirth, Timestamp crewRegdate, int crewIdx) {
		super();
		this.memberIdx = memberIdx;
		this.memberId = memberId;
		this.memberPhoto = memberPhoto;
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

	public String getMemberPhoto() {
		return memberPhoto;
	}

	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
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
		return "CrewMemberList [memberIdx=" + memberIdx + ", memberId=" + memberId + ", memberPhoto=" + memberPhoto
				+ ", memberNickName=" + memberNickName + ", memberBirth=" + memberBirth + ", crewRegdate=" + crewRegdate
				+ ", crewIdx=" + crewIdx + "]";
	}
	
	
}

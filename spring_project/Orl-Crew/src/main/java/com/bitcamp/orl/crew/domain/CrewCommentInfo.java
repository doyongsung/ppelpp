package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CrewCommentInfo {
	private int crewCommentIdx;
	private String crewComment;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp crewCommentDate;
	private int memberIdx;
	private int crewIdx;
	private String memberNickName;
	private String memberProfile;
	
	public CrewCommentInfo() {}
	
	public CrewCommentInfo(int crewCommnetIdx, String crewComment, Timestamp crewCommentDate, int memberIdx,
			int crewIdx, String memberNickName, String memberProfile) {
		this.crewCommentIdx = crewCommnetIdx;
		this.crewComment = crewComment;
		this.crewCommentDate = crewCommentDate;
		this.memberIdx = memberIdx;
		this.crewIdx = crewIdx;
		this.memberNickName = memberNickName;
		this.memberProfile = memberProfile;
	}

	public int getCrewCommentIdx() {
		return crewCommentIdx;
	}

	public void setCrewCommentIdx(int crewCommentIdx) {
		this.crewCommentIdx = crewCommentIdx;
	}

	public String getCrewComment() {
		return crewComment;
	}

	public void setCrewComment(String crewComment) {
		this.crewComment = crewComment;
	}

	public Timestamp getCrewCommentDate() {
		return crewCommentDate;
	}

	public void setCrewCommentDate(Timestamp crewCommentDate) {
		this.crewCommentDate = crewCommentDate;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public int getCrewIdx() {
		return crewIdx;
	}

	public void setCrewIdx(int crewIdx) {
		this.crewIdx = crewIdx;
	}

	public String getMemberNickName() {
		return memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public String getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}
	
}

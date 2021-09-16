package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CrewComment {
	private int crewCommentIdx;
	private String crewComment;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp crewCommentDate;
	private int memberIdx;
	private int crewIdx;
	
	public CrewComment() {}
	
	public CrewComment(int crewCommentIdx, String crewComment, Timestamp crewCommentDate, int memberIdx, int crewIdx) {
		this.crewCommentIdx = crewCommentIdx;
		this.crewComment = crewComment;
		this.crewCommentDate = crewCommentDate;
		this.memberIdx = memberIdx;
		this.crewIdx = crewIdx;
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
	
	public CrewCommentInfo CommentToInfo() {
		CrewCommentInfo info = new CrewCommentInfo(crewCommentIdx, 
				crewComment, crewCommentDate, memberIdx, crewIdx, null, null);
		return info;
	}
	
}

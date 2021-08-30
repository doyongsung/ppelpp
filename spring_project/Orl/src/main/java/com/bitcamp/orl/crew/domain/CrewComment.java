package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

public class CrewComment {
	private int crewCommnetIdx;
	private String crewComment;
	private Timestamp crewCommentDate;
	private int memberIdx;
	private int crewIdx;
	
	public CrewComment() {}
	
	public CrewComment(int crewCommnetIdx, String crewComment, Timestamp crewCommentDate, int memberIdx, int crewIdx) {
		this.crewCommnetIdx = crewCommnetIdx;
		this.crewComment = crewComment;
		this.crewCommentDate = crewCommentDate;
		this.memberIdx = memberIdx;
		this.crewIdx = crewIdx;
	}

	public int getCrewCommnetIdx() {
		return crewCommnetIdx;
	}

	public void setCrewCommnetIdx(int crewCommnetIdx) {
		this.crewCommnetIdx = crewCommnetIdx;
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
		CrewCommentInfo info = new CrewCommentInfo(crewCommnetIdx, 
				crewComment, crewCommentDate, memberIdx, crewIdx, null, null);
		return info;
	}
	
}

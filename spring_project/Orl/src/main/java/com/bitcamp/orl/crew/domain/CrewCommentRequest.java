package com.bitcamp.orl.crew.domain;

public class CrewCommentRequest {
	private int crewIdx;
	private String crewComment;
	
	public CrewCommentRequest() {}
	
	public CrewCommentRequest(int crewIdx, String crewComment) {
		super();
		this.crewIdx = crewIdx;
		this.crewComment = crewComment;
	}

	public int getCrewIdx() {
		return crewIdx;
	}

	public void setCrewIdx(int crewIdx) {
		this.crewIdx = crewIdx;
	}

	public String getCrewComment() {
		return crewComment;
	}

	public void setCrewComment(String crewComment) {
		this.crewComment = crewComment;
	}
	
	
}

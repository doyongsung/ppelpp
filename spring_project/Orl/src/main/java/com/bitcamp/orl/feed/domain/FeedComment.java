package com.bitcamp.orl.feed.domain;

public class FeedComment {
	
	//피드 상세보기 (댓글 리스트)
	
	private int boardCommentIdx;
	private String comment;
	private int boardIdx;
	private int memberIdx;
	private String memberNickname;
	private String memberProfile;
	
	public FeedComment(){
		
	}

	public FeedComment(String comment, int boardIdx, int memberIdx) {
		this.comment = comment;
		this.boardIdx = boardIdx;
		this.memberIdx = memberIdx;
	}

	public FeedComment(int boardCommentIdx, String comment, int boardIdx, int memberIdx, String memberNickname,
			String memberProfile) {
		this.boardCommentIdx = boardCommentIdx;
		this.comment = comment;
		this.boardIdx = boardIdx;
		this.memberIdx = memberIdx;
		this.memberNickname = memberNickname;
		this.memberProfile = memberProfile;
	}

	public int getBoardCommentIdx() {
		return boardCommentIdx;
	}

	public void setBoardCommentIdx(int boardCommentIdx) {
		this.boardCommentIdx = boardCommentIdx;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
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

	public String getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}

	@Override
	public String toString() {
		return "FeedComment [boardCommentIdx=" + boardCommentIdx + ", comment=" + comment + ", boardIdx=" + boardIdx
				+ ", memberIdx=" + memberIdx + ", memberNickname=" + memberNickname + ", memberProfile=" + memberProfile
				+ "]";
	}

}

package com.bitcamp.orl.feed.domain;

import java.sql.*;

public class NewFeedList {

	// 피드정렬 : 최신순 (기본정렬)
	// 인기순에도 사용
	// 검색에도 사용

	private int boardIdx;
	private String boardPhoto;
	private Timestamp boardDate;
	private int memberIdx;
	private String memberNickname;

	public NewFeedList() {
	}

	public NewFeedList(int boardIdx, String boardPhoto, Timestamp boardDate, int memberIdx, String memberNickname) {
		this.boardIdx = boardIdx;
		this.boardPhoto = boardPhoto;
		this.boardDate = boardDate;
		this.memberIdx = memberIdx;
		this.memberNickname = memberNickname;
	}

	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}

	public String getBoardPhoto() {
		return boardPhoto;
	}

	public void setBoardPhoto(String boardPhoto) {
		this.boardPhoto = boardPhoto;
	}

	public Timestamp getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
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
		return "NewFeedList [boardIdx=" + boardIdx + ", boardPhoto=" + boardPhoto + ", boardDate=" + boardDate
				+ ", memberIdx=" + memberIdx + ", memberNickname=" + memberNickname + "]";
	};	

}
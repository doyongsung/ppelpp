package com.bitcamp.orl.feed.domain;

import java.sql.*;

import com.fasterxml.jackson.annotation.*;

public class Feed {

	private int boardIdx;
	private String boardPhoto;
	private String boardDiscription;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp boardDate;
	private String hashtag;
	private String tag;
	private int memberIdx;

	public Feed() {
	}
	
	public Feed(int boardIdx, String boardPhoto, String boardDiscription, Timestamp boardDate, String hashtag,
			String tag, int memberIdx) {
		this.boardIdx = boardIdx;
		this.boardPhoto = boardPhoto;
		this.boardDiscription = boardDiscription;
		this.boardDate = boardDate;
		this.hashtag = hashtag;
		this.tag = tag;
		this.memberIdx = memberIdx;
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

	public String getBoardDiscription() {
		return boardDiscription;
	}

	public void setBoardDiscription(String boardDiscription) {
		this.boardDiscription = boardDiscription;
	}

	public Timestamp getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	
	@Override
	public String toString() {
		return "Feed [boardIdx=" + boardIdx + ", boardPhoto=" + boardPhoto + ", boardDiscription=" + boardDiscription
				+ ", boardDate=" + boardDate + ", hashtag=" + hashtag + ", tag=" + tag + ", memberIdx=" + memberIdx + "]";
	}
	
	


}
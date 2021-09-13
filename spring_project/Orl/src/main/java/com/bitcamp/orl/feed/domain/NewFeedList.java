package com.bitcamp.orl.feed.domain;

public class NewFeedList {

	// 피드정렬 : 최신순 (기본정렬)

	private int boardIdx;
	private String boardPhoto;
	private int memberIdx;
//	private String nickName;

	public NewFeedList() {
	};

	public NewFeedList(int boardIdx, String boardPhoto, int memberIdx) {
		this.boardIdx = boardIdx;
		this.boardPhoto = boardPhoto;
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

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

}

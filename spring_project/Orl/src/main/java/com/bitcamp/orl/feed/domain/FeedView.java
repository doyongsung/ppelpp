package com.bitcamp.orl.feed.domain;

public class FeedView {
	
	// 피드 상세보기
	
	private int boardIdx;
	private String boardPhoto;
	private String boardDiscription;
	private String hashtag;
	private String tag;
	private int memberIdx;
	private String memberNickname;
	private String memberProfile;
	
	public FeedView(){
		
	}

	public FeedView(int boardIdx, String boardPhoto, String boardDiscription, String hashtag, String tag, int memberIdx,
			String memberNickname, String memberProfile) {
		this.boardIdx = boardIdx;
		this.boardPhoto = boardPhoto;
		this.boardDiscription = boardDiscription;
		this.hashtag = hashtag;
		this.tag = tag;
		this.memberIdx = memberIdx;
		this.memberNickname = memberNickname;
		this.memberProfile = memberProfile;
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
		return "FeedView [boardIdx=" + boardIdx + ", boardPhoto=" + boardPhoto + ", boardDiscription="
				+ boardDiscription + ", hashtag=" + hashtag + ", tag=" + tag + ", memberIdx=" + memberIdx
				+ ", memberNickname=" + memberNickname + ", memberProfile=" + memberProfile + "]";
	}


}

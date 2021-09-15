package com.bitcamp.orl.feed.domain;

import org.springframework.stereotype.Repository;

@Repository
public class FeedLikeGallery {
	
	// 좋아요 한 사진 갤러리 정보 담는다.
	
	private int boardIdx; //게시물 idx
	private String boardPhoto;
	private int memberIdx; //좋아요 누른 남의 memberIdx -> 비동기통신으로 사진 상세보기할 때 넘겨줘야 하니까 필요할듯
	
	
	public FeedLikeGallery(){};
	
	public FeedLikeGallery(int boardIdx, String boardPhoto, int memberIdx) {
		this.boardIdx = boardIdx;
		this.boardPhoto = boardPhoto;
		this.memberIdx = memberIdx;
	}
	
	
	//getter, setter
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

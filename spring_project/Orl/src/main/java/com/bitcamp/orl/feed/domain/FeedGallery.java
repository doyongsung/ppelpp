package com.bitcamp.orl.feed.domain;

import org.springframework.stereotype.Repository;

@Repository
public class FeedGallery {
	//처음 피드로 이동했을 때 사진 보여주기 위한 class
	
	
	private int boardIdx; // 사진게시판 idx
	private String boardPhoto; //사진
	
	
	public FeedGallery(){};
	
	
	public FeedGallery(int boardIdx, String boardPhoto) {
		super();
		this.boardIdx = boardIdx;
		this.boardPhoto = boardPhoto;
	}

	
	//getter setter
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
	
	
	
	
	
	
	
	
}

package com.bitcamp.orl.feed.domain;

import org.springframework.web.multipart.*;

public class FeedCreateRequest {
	
	// 피드 작성
	
	private MultipartFile boardPhoto;
	private String boardDiscription;
	private String hashtag;
	private String tag;
	
	public FeedCreateRequest(){}

	public FeedCreateRequest(MultipartFile boardPhoto, String boardDiscription, String hashtag, String tag) {
		this.boardPhoto = boardPhoto;
		this.boardDiscription = boardDiscription;
		this.hashtag = hashtag;
		this.tag = tag;
	}

	public MultipartFile getBoardPhoto() {
		return boardPhoto;
	}

	public void setBoardPhoto(MultipartFile boardPhoto) {
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
	
	@Override
	public String toString() {
		return "FeedCreateRequest [boardPhoto=" + boardPhoto + ", boardDiscription=" + boardDiscription + ", hashtag="
				+ hashtag + ", tag=" + tag + "]";
	}

	//FeedCreateRequest -> Feed
	public Feed toFeed() {
		return new Feed (0, boardPhoto.getName(), boardDiscription, null, hashtag, tag, 0);
	}
	
}
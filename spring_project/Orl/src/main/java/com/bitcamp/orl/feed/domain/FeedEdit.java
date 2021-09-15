package com.bitcamp.orl.feed.domain;

public class FeedEdit {
	
	// 피드 수정
	
	private String boardDiscription;
	private String hashtag;
	private String tag;
	
	public FeedEdit() {
	}

	public FeedEdit(String boardDiscription, String hashtag, String tag) {
		this.boardDiscription = boardDiscription;
		this.hashtag = hashtag;
		this.tag = tag;
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
		return "FeedEdit [boardDiscription=" + boardDiscription + ", hashtag=" + hashtag + ", tag=" + tag + "]";
	}

	//FeedCreateRequest -> Feed
	public Feed toFeed() {
		return new Feed (0, null, boardDiscription, null, hashtag, tag, 0);
	}
	

}

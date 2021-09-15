package com.bitcamp.orl.crew.domain;

public class CrewCommentCriteria {
	private int crewIdx;
	private int currentPageNum; // 현재 페이지 번호
	private int amountPerPage; //페이지당 보여줄 게시물 수
	
	public CrewCommentCriteria() {}

	public CrewCommentCriteria(int crewIdx, int currentPageNum) {
		this.crewIdx = crewIdx;
		this.currentPageNum = currentPageNum;
		this.amountPerPage = 8;
	}
	
	public int getCrewIdx() {
		return crewIdx;
	}

	public void setCrewIdx(int crewIdx) {
		this.crewIdx = crewIdx;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getAmountPerPage() {
		return amountPerPage;
	}

	public void setAmountPerPage(int amountPerPage) {
		this.amountPerPage = amountPerPage;
	}
	
	
}

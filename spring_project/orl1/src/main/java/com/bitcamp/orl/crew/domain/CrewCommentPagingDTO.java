package com.bitcamp.orl.crew.domain;

import java.util.List;

public class CrewCommentPagingDTO {
	
	private List<CrewCommentInfo> infoList;
	private int totalCommentNum; // 총 댓글 수
	private int totalPageNum; // 총 페이지 개수
	private CrewCommentCriteria cri; // 현재 페이지와, 페이지당 게시물 수 받아옴

	private int startRow; // 시작위치
	private int endRow; // 끝위치
	
	public CrewCommentPagingDTO(
			List<CrewCommentInfo> infoList,
			int totalCommentNum,
			CrewCommentCriteria cri,
			int startRow,
			int endRow
			) {
		this.infoList = infoList;
		this.totalCommentNum = totalCommentNum;
		this.cri = cri;
		calTotalPageNum();
		this.startRow = startRow;
		this.endRow = endRow;
	}
	
	public void calTotalPageNum() {
		if(this.totalCommentNum == 0) {
			//총 댓글 수가 0이면, 페이지수도 0
			this.totalPageNum = 0;
		} else {
			// 총 댓글수가 0이 아니면 페이지수 = 총 댓글 수/페이지당 담을 댓글 수
			this.totalPageNum = this.totalCommentNum / this.cri.getAmountPerPage();
			// 근데 총 댓글수 % 페이지당 담을 댓글 수 > 0 이면, 즉 딱 안떨어지고 나머지가 남는 경우는 +1 시켜줌 
			if(this.totalCommentNum % this.cri.getAmountPerPage() > 0) {
				this.totalPageNum += 1;
			}
		}
	}
	
	public List<CrewCommentInfo> getInfoList() {
		return infoList;
	}

	public int getTotalCommentNum() {
		return totalCommentNum;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public CrewCommentCriteria getCri() {
		return cri;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

}
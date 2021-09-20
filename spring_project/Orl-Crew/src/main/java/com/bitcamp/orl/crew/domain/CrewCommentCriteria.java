package com.bitcamp.orl.crew.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewCommentCriteria {
	private int crewIdx;
	private int currentPageNum; // 현재 페이지 번호
	private int amountPerPage; //페이지당 보여줄 게시물 수
	
	public CrewCommentCriteria(int crewIdx, int currentPageNum) {
		this.crewIdx = crewIdx;
		this.currentPageNum = currentPageNum;
		this.amountPerPage = 8;
	}
}

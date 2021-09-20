package com.bitcamp.orl.crew.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageMaker {
	
	private CrewListCriteria cri;// page, perPageNum 을 가지고 있음
    private int totalCount;// 전체 게시글 수
    
    private int startPage;// 게시글 번호에 따른 (보여지는)페이지의 시작 번호
    private int endPage;// 게시글 번호에 따른 (보여지는)페이지의 마지막 번호
    
    private boolean prev;// 이전 버튼을 누를 수 있는 경우/없는 경우 분류를 위함
    private boolean next;
 
    private int displayPageNum =5;// 화면 하단에 보여지는 페이지의 개수
    private int tempEndPage;
 
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();// 전체 필드 변수들 세팅 : 전체 게시글 수의 setter가 호출될 때 전체 세팅되도록 함
    }
 
    private void calcData() {// 전체 필드 변수 값들을 계산하는 메서드
        endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
        startPage = (endPage - displayPageNum) +1;
 
        int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
        this.tempEndPage = tempEndPage;
 
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }
        prev = startPage ==1 ?false :true;// 1페이지면 이전 누를 수 없게 false
        next = endPage * cri.getPerPageNum() >= totalCount ?false :true;
    }
}

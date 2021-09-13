package com.bitcamp.orl.crew.domain;

public class SearchType {

	private int page; // 페이징처리시 페이지 번호
	private int perPageNum;
	private String searchType;
	private String keyword;

	public SearchType() {
		this(1,10);
	}
	

	public SearchType(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}


	public int getPageStart() {
		return(this.page - 1) * perPageNum;
	}
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchType [page=" + page + ", perPageNum=" + perPageNum + ", searchType=" + searchType + ", keyword="
				+ keyword + "]";
	}
	
	
}
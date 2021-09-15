package com.bitcamp.orl.crew.domain;

public class SearchType extends CrewListCriteria {

	private String searchType;
	private String keyword;
	private int pageStart;
	private int perPageNum;

	public SearchType(String searchType, String keyword, int pageStart, int perPageNum) {
		this.searchType = searchType;
		this.keyword = keyword;
		this.pageStart = pageStart;
		this.perPageNum = perPageNum;
	}

	public SearchType() {
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
	
	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	@Override
	public String toString() {
		return "SearchType [searchType=" + searchType + ", keyword=" + keyword + "]";
	}

}
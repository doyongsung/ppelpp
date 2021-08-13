package com.bitcamp.op.member.domain;


public class SearchType {
	
	private int p; // 페이징처리시 페이지 번호
	private String serachType;
	private String keyword;
	
	public SearchType(int p, String serachType, String keyword) {
		
		this.p = p;
		this.serachType = serachType;
		this.keyword = keyword;
	}
	
	public SearchType() {
		this.p = 1;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public String getSerachType() {
		return serachType;
	}

	public void setSerachType(String serachType) {
		this.serachType = serachType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchType [p=" + p + ", serachType=" + serachType + ", keyword=" + keyword + "]";
	}
	
	

}

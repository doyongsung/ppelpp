package com.bitcamp.orl.feed.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

@Repository
public class Follow {
	// 아직 안씀!!!
	// 팔로워 수 랑 팔로잉 수는 int 반환하기 때문에 이 객체 쓸 필요 없음.
	
	private int followIdx;
	private Timestamp followDate;
	private int memberIdx;  //나의 idx
	private int memberIdx2; //내가 팔로우 하는 사람의 idx
	
	//기본 생성자
	public Follow(){};
	
	public Follow(int followIdx, Timestamp followDate, int memberIdx, int memberIdx2) {
		this.followIdx = followIdx;
		this.followDate = followDate;
		this.memberIdx = memberIdx;
		this.memberIdx2 = memberIdx2;
	}
	public int getFollowIdx() {
		return followIdx;
	}
	public void setFollowIdx(int followIdx) {
		this.followIdx = followIdx;
	}
	public Timestamp getFollowDate() {
		return followDate;
	}
	public void setFollowDate(Timestamp followDate) {
		this.followDate = followDate;
	}
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public int getMemberIdx2() {
		return memberIdx2;
	}
	public void setMemberIdx2(int memberIdx2) {
		this.memberIdx2 = memberIdx2;
	}
	
	
	
	@Override
	public String toString() {
		return "FollowService [followIdx=" + followIdx + ", followDate=" + followDate + ", memberIdx=" + memberIdx
				+ ", memberIdx2=" + memberIdx2 + "]";
	}
	
	
	
	
	
}

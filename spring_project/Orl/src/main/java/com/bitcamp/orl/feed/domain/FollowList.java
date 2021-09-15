package com.bitcamp.orl.feed.domain;

public class FollowList {
	//db에서 follow table 과 member table을 조인하여 가져올 때 사용
	
	 private int followIdx;
	 private int memberIdx; //내 idx
	 private int memberIdx2; // 남 idx
	 private String memberNickname; // 남 닉네임
	 private String memberProfile; //남 프사
	 
	//default constructor
	private FollowList(){};
	
	public FollowList(int followIdx, int memberIdx, int memberIdx2, String memberNickname, String memberProfile) {
		this.followIdx = followIdx;
		this.memberIdx = memberIdx;
		this.memberIdx2 = memberIdx2;
		this.memberNickname = memberNickname;
		this.memberProfile = memberProfile;
	}

	public int getFollowIdx() {
		return followIdx;
	}

	public void setFollowIdx(int followIdx) {
		this.followIdx = followIdx;
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

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}

	@Override
	public String toString() {
		return "FollowList [followIdx=" + followIdx + ", memberIdx=" + memberIdx + ", memberIdx2=" + memberIdx2
				+ ", memberNickname=" + memberNickname + ", memberProfile=" + memberProfile + "]";
	}

	
	 
	
}

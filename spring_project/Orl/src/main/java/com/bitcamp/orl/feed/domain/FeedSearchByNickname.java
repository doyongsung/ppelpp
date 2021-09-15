package com.bitcamp.orl.feed.domain;

public class FeedSearchByNickname {

	private int memberIdx;
	private String memberNickname;
	private String memberProfile;
	
	
	public FeedSearchByNickname(){};
	
	public FeedSearchByNickname(int memberIdx, String memberNickname, String memberProfile) {
		super();
		this.memberIdx = memberIdx;
		this.memberNickname = memberNickname;
		this.memberProfile = memberProfile;
	}
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
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
		return "FeedSearchByNickname [memberIdx=" + memberIdx + ", memberNickname=" + memberNickname
				+ ", memberProfile=" + memberProfile + "]";
	}
	
	
}

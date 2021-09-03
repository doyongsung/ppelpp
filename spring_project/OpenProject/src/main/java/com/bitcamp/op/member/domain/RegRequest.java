package com.bitcamp.op.member.domain;

public class RegRequest {

	private MemberRegRequest memberRegRequest;
	private MemberRequestAddress memberRequestAddress;

	public MemberRegRequest getMemberRegRequest() {
		return memberRegRequest;
	}

	public void setMemberRegRequest(MemberRegRequest memberRegRequest) {
		this.memberRegRequest = memberRegRequest;
	}

	public MemberRequestAddress getMemberRequestAddress() {
		return memberRequestAddress;
	}

	public void setMemberRequestAddress(MemberRequestAddress memberRequestAddress) {
		this.memberRequestAddress = memberRequestAddress;
	}

	@Override
	public String toString() {
		return "RegRequest [memberRegRequest=" + memberRegRequest + ", memberRequestAddress=" + memberRequestAddress
				+ "]";
	}
	
	
	

}

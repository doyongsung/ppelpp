package com.bitcamp.op.member.domain;

public class MemberAddress {

	private int idx;
	private int memberidx;
	private String zipcode;
	private String address1;
	private String address2;
	
	public MemberAddress() {}
	
	public MemberAddress(int idx, int memberidx, String zipcode, String address1, String address2) {
		this.idx = idx;
		this.memberidx = memberidx;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
	}



	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getMemberidx() {
		return memberidx;
	}

	public void setMemberidx(int memberidx) {
		this.memberidx = memberidx;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public boolean formValidate() {
		boolean check = false;
		if(zipcode != null && address1 != null && address2 != null) {
			if(!(zipcode.trim().isEmpty() || address1.trim().isEmpty() || address2.trim().isEmpty())) {
				check = true;
			}
		}
		return check;
	}

	@Override
	public String toString() {
		return "MemberAddress [idx=" + idx + ", memberidx=" + memberidx + ", zipcode=" + zipcode + ", address1="
				+ address1 + ", address2=" + address2 + "]";
	}
	
	

}

package com.bitcamp.firstSpring.member.domain;

public class OrderItem {
	
	private String itemid;
	private int number;
	private String remark;
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "OrderItem [itemid=" + itemid + ", number=" + number + ", remark=" + remark + "]";
	}
	
	

}

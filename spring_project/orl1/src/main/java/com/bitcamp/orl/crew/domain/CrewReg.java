package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CrewReg {
	
	private int crewRegIdx;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp crewRegdate;
	private int memberIdx;
	private int crewIdx;
	
	public CrewReg() {}
	
	public CrewReg(int crewRegIdx, Timestamp crewRegdate, int memberIdx, int crewIdx) {
		this.crewRegIdx = crewRegIdx;
		this.crewRegdate = crewRegdate;
		this.memberIdx = memberIdx;
		this.crewIdx = crewIdx;
	}

	public int getCrewRegIdx() {
		return crewRegIdx;
	}

	public void setCrewRegIdx(int crewRegIdx) {
		this.crewRegIdx = crewRegIdx;
	}

	public Timestamp getCrewRegdate() {
		return crewRegdate;
	}

	public void setCrewRegdate(Timestamp crewRegdate) {
		this.crewRegdate = crewRegdate;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public int getCrewIdx() {
		return crewIdx;
	}

	public void setCrewIdx(int crewIdx) {
		this.crewIdx = crewIdx;
	}
	
	
}

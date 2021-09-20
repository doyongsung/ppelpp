package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Crew {
	private int crewIdx;
	private String crewName;
	private String crewPhoto;
	private String crewDiscription;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp crewCreatedate;
	private String crewTag;
	private int memberIdx;
	private String memberNickName;
	
	public Crew() {}
	
	public Crew(int crewIdx, 
			String crewName, 
			String crewPhoto, 
			String crewDiscription, 
			Timestamp crewCreatedate,
			String crewTag, 
			int memberIdx,
			String memberNickName) {
		this.crewIdx = crewIdx;
		this.crewName = crewName;
		this.crewPhoto = crewPhoto;
		this.crewDiscription = crewDiscription;
		this.crewCreatedate = crewCreatedate;
		this.crewTag = crewTag;
		this.memberIdx = memberIdx;
		this.memberNickName = memberNickName;
	}
	
	public int getCrewIdx() {
		return crewIdx;
	}
	
	public void setCrewIdx(int crewIdx) {
		this.crewIdx = crewIdx;
	}
	
	public String getCrewName() {
		return crewName;
	}
	
	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}
	
	public String getCrewPhoto() {
		return crewPhoto;
	}
	
	public void setCrewPhoto(String crewPhoto) {
		this.crewPhoto = crewPhoto;
	}
	
	public String getCrewDiscription() {
		return crewDiscription;
	}
	
	public void setCrewDiscription(String crewDiscription) {
		this.crewDiscription = crewDiscription;
	}
	
	public Timestamp getCrewCreatedate() {
		return crewCreatedate;
	}
	
	public void setCrewCreatedate(Timestamp crewCreatedate) {
		this.crewCreatedate = crewCreatedate;
	}
	
	public String getCrewTag() {
		return crewTag;
	}
	
	public void setCrewTag(String crewTag) {
		this.crewTag = crewTag;
	}
	
	public int getMemberIdx() {
		return memberIdx;
	}
	
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	
	public String getMemberNickName() {
		return memberNickName;
	}
	
	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public CrewInfo crewToCrewInfo() {
		CrewInfo crewinfo = new CrewInfo(crewIdx, crewName, 
				crewPhoto, crewDiscription, crewCreatedate, 
				crewTag, memberIdx, memberNickName, null,
				0, 0, false);
		return crewinfo;
	}
	
	public CrewInfo crewToCrewInfo(
			String memberProfile,
			int crewMemberNum, 
			int crewCommentNum,
			boolean isReg) {
		CrewInfo crewinfo = new CrewInfo(crewIdx, crewName,
				crewPhoto, crewDiscription, crewCreatedate,
				crewTag, memberIdx, memberNickName, memberProfile,
				crewMemberNum, crewCommentNum, isReg);
		return crewinfo;
				
	}

	@Override
	public String toString() {
		return "Crew [crewIdx=" + crewIdx + ", crewName=" + crewName + ", crewPhoto=" + crewPhoto + ", crewDiscription="
				+ crewDiscription + ", crewCreatedate=" + crewCreatedate + ", crewTag=" + crewTag + ", memberIdx="
				+ memberIdx + ", memberNickName=" + memberNickName + "]";
	}
	
	
}

package com.bitcamp.orl.crew.domain;

import org.springframework.web.multipart.MultipartFile;

public class CrewRequest {
	private String crewName;
	private MultipartFile crewPhoto;
	private String crewDiscription;
	private String crewTag;
	
	public CrewRequest() {};
	
	
	public CrewRequest(String crewName, MultipartFile crewPhoto, String crewDiscription, String crewTag) {
		this.crewName = crewName;
		this.crewPhoto = crewPhoto;
		this.crewDiscription = crewDiscription;
		this.crewTag = crewTag;
	}


	public String getCrewName() {
		return crewName;
	}


	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}


	public MultipartFile getCrewPhoto() {
		return crewPhoto;
	}


	public void setCrewPhoto(MultipartFile crewPhoto) {
		this.crewPhoto = crewPhoto;
	}


	public String getCrewDiscription() {
		return crewDiscription;
	}


	public void setCrewDiscription(String crewDiscription) {
		this.crewDiscription = crewDiscription;
	}


	public String getCrewTag() {
		return crewTag;
	}


	public void setCrewTag(String crewTag) {
		this.crewTag = crewTag;
	}


	@Override
	public String toString() {
		return "CrewRequest [crewId=" + crewName + ", crewPhoto=" + crewPhoto + ", crewDiscription=" + crewDiscription
				+ ", crewTag=" + crewTag + "]";
	};
	
	
	
	
}

package com.bitcamp.orl.crew.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewInsertRequest {
	private String crewName;
	private MultipartFile crewPhoto;
	private String crewDiscription;
	private String crewTag;
	private int memberIdx;
	private String memberNickName;
	
	public Crew toCrew() {
		return new Crew(0, crewName, crewPhoto.getName(), crewDiscription, null, crewTag, memberIdx, null);
	}
}
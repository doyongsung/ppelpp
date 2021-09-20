package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
	public CrewInfo crewToCrewInfo() {
		CrewInfo crewinfo = new CrewInfo(crewIdx, crewName, 
				crewPhoto, crewDiscription, crewCreatedate, 
				crewTag, memberIdx, memberNickName, 
				0, 0, false);
		return crewinfo;
	}
	
	public CrewInfo crewToCrewInfo(
			int crewMemberNum, int crewCommentNum, boolean isReg) {
		CrewInfo crewinfo = new CrewInfo(crewIdx, crewName,
				crewPhoto, crewDiscription, crewCreatedate,
				crewTag, memberIdx, memberNickName,
				crewMemberNum, crewCommentNum, isReg);
		return crewinfo;
				
	}
}

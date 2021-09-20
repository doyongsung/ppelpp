package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewInfo {
	private int crewIdx;
	private String crewName;
	private String crewPhoto;
	private String crewDiscription;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp crewCreatedate;
	private String crewTag;
	private int memberIdx; //크루장 
	private String memberNickName;
	private int crewMemberNum;
	private int crewCommentNum;
	private boolean isReg;
}

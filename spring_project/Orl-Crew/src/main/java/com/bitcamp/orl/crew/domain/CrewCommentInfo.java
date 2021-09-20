package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewCommentInfo {
	private int crewCommentIdx;
	private String crewComment;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp crewCommentDate;
	private int memberIdx;
	private int crewIdx;
	private String memberNickName;
	private String memberProfile;
	
}

package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewMemberList {
	private int memberIdx;
	private String memberId;
	private String memberProfile;
	private String memberNickName;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp memberBirth;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp crewRegdate;
	private int crewIdx;
	
}

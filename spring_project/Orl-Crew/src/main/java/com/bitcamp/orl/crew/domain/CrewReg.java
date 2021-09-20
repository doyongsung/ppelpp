package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewReg {
	
	private int crewRegIdx;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp crewRegdate;
	private int memberIdx;
	private int crewIdx;
	
}

package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewComment {
	private int crewCommentIdx;
	private String crewComment;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp crewCommentDate;
	private int memberIdx;
	private int crewIdx;
	
	public CrewCommentInfo CommentToInfo() {
		CrewCommentInfo info = new CrewCommentInfo(crewCommentIdx, 
				crewComment, crewCommentDate, memberIdx, crewIdx, null, null);
		return info;
	}
	
}

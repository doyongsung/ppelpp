package com.bitcamp.orl.crew.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewCommentRequest {
	private int crewIdx;
	private String crewComment;
	private int memberIdx;
}

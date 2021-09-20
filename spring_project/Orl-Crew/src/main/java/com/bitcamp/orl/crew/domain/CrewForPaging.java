package com.bitcamp.orl.crew.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrewForPaging {
	private List<Crew> crewList;
	private PageMaker pk;
	
}

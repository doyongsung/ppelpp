package com.bitcamp.orl.crew.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchType {

	private String searchType;
	private String keyword;
	private int pageStart;
	private int perPageNum;

}
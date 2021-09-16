package com.bitcamp.orl.crew.domain;

import java.util.List;

public class CrewForPaging {
	private List<Crew> crewList;
	private PageMaker pk;
	
	public CrewForPaging(List<Crew> allCrewList, PageMaker pk) {
		this.crewList = allCrewList;
		this.pk = pk;
	}

	public List<Crew> getCrewList() {
		return crewList;
	}

	public void setCrewList(List<Crew> crewList) {
		this.crewList = crewList;
	}

	public PageMaker getPk() {
		return pk;
	}

	public void setPk(PageMaker pk) {
		this.pk = pk;
	}
	
}

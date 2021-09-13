package com.bitcamp.orl.mountain.dao;

import java.util.List;


import com.bitcamp.orl.mountain.domain.MountainLocInfo;
import org.apache.ibatis.annotations.Param;


public interface Dao {
	
	// 지역별 산 리스트
	List<MountainLocInfo> selectByLocName(String var1);
	// 지역별 산 리스트(서울/경기)
	List<MountainLocInfo> selectByLocNameSeoul();
	
	//전국 모든 산 리스트
	List<MountainLocInfo> selectAllMountain();
	
	//이름으로 검색시 산 리스트
	List<MountainLocInfo> selectBySearchName(String var1);
	
	//이름별 산 검색하기
	MountainLocInfo selectByName(@Param("mountainName")String mountainName);
	
	//지역별 산 갯수
	int countByLocName(@Param("locName")String var1);
	//지역별 산 갯수 (서울경기)
	int countByLocNameSeoul();
	
	
	
}

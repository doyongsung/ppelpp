package com.bitcamp.orl.mountain.dao;

import java.util.List;


import com.bitcamp.orl.mountain.domain.MountainLocInfo;
import org.apache.ibatis.annotations.Param;


public interface Dao {

	// 지역별 산 리스트
	List<MountainLocInfo> selectByLocName(String var1);
	List<MountainLocInfo> selectByLocNameSeoul();


	List<MountainLocInfo> selectByName1(String var1);

	MountainLocInfo selectByName(@Param("mountainName")String mountainName);

	//지역별 산 갯수
	int countByLocName(@Param("locName")String var1);
	int countByLocNameSeoul();

}

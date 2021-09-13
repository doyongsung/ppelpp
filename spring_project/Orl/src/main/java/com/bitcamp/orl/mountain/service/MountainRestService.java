package com.bitcamp.orl.mountain.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.mountain.dao.Dao;
import com.bitcamp.orl.mountain.domain.MountainLocInfo;

@Service
public class MountainRestService {

	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	 //지역별 산 리스트 
    public List<MountainLocInfo> getMountainLocList(String loc){
        List<MountainLocInfo> mountainLocInfoList = null;
        dao=template.getMapper(Dao.class);
        if (loc.equals("서울경기")) {
            mountainLocInfoList = dao.selectByLocNameSeoul();
        }else{
            mountainLocInfoList = dao.selectByLocName(loc);
        }
        return mountainLocInfoList;
    }
	
	//모든 산 리스트
    public List<MountainLocInfo> getMountainAllList(){
    	 List<MountainLocInfo> mountainLocInfoList = null;
         dao=template.getMapper(Dao.class);
         mountainLocInfoList=dao.selectAllMountain();
         return mountainLocInfoList;
    }
		
		
		

}

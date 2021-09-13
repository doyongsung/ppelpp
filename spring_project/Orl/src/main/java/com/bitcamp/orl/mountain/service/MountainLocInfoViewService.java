package com.bitcamp.orl.mountain.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.mountain.dao.Dao;
import com.bitcamp.orl.mountain.domain.MountainLocInfo;

@Service
public class MountainLocInfoViewService {
	
	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	//지역별 산 리스트 
	public List<MountainLocInfo> getMountainLocInfo(String loc){
		List<MountainLocInfo> mountainLocInfoList = null;
		 if (loc != null) {
	            dao = template.getMapper(Dao.class);
	            if (loc.equals("서울경기")) {
	                mountainLocInfoList = dao.selectByLocNameSeoul();
	            } else {
	                mountainLocInfoList = dao.selectByLocName(loc);
	            }
	        }
		return mountainLocInfoList;
	}
	

	//이름검색시 산 리스트
			public List<MountainLocInfo> getMountainSearchName(String mname){
				List<MountainLocInfo> mountainLocInfoList = null;
				 if (mname != null) {
			            dao = template.getMapper(Dao.class);
			                mountainLocInfoList = dao.selectBySearchName(mname);
			        }
				return mountainLocInfoList;
			}
		
		
	
	
	//지역별 산 갯수
	public int getCountLoc(String loc) {
		 int result = 0;
	        if (loc != null) {
	            this.dao = (Dao)this.template.getMapper(Dao.class);
	            if(loc.equals("서울경기")){
	                result = this.dao.countByLocNameSeoul();
	            }else{
	                result = this.dao.countByLocName(loc);
	            }
	        }

		return result;
	}

	//날씨 api를 위한 함수(지역을 영어로)
	public String getLocEn(String loc){
        String locEn = "";
        switch (loc){
            case "서울경기":
                locEn = "seoul";
                break;
            case "강원":
                locEn = "wonju";
                break;
            case "충청남도":
                locEn = "gongju";
                break;
            case "충청북도":
                locEn = "cheongju";
                break;
            case "경상북도":
                locEn = "ulsan";
                break;
            case "경상남도":
                locEn = "busan";
                break;
            case "전라북도":
                locEn = "jeonju";
                break;
            case "전라남도":
                locEn = "mokpo";
                break;
            default:
                locEn = "jeju";
        }

        return locEn;
    }

	
	
}

package com.bitcamp.orl.mountain.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.mountain.dao.Dao;
import com.bitcamp.orl.mountain.domain.MountainLocInfo;

@Service
public class MountainDetailInfoViewService {

    private Dao dao;
    @Autowired
    private SqlSessionTemplate template;

    // 산 이름에 해당하는 산 객체 가져오는 서비스
    public MountainLocInfo getMountainLocInfo(String mountainName) {
        MountainLocInfo mountainLocInfo = null;
        if (mountainName != null) {
            dao = template.getMapper(Dao.class);
            mountainLocInfo = dao.selectByName(mountainName);

        }
        return mountainLocInfo;
    }
    
}
package com.bitcamp.orl.mountain.service;

import com.bitcamp.orl.mountain.dao.Dao;
import com.bitcamp.orl.mountain.domain.MountainLocInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MountainDetailInfoViewService {

    private Dao dao;
    @Autowired
    private SqlSessionTemplate template;

    public MountainLocInfo getMountainLocInfo(String mountainName) {
        MountainLocInfo mountainLocInfo = null;
        if (mountainName != null) {
            dao = template.getMapper(Dao.class);
            mountainLocInfo = dao.selectByName(mountainName);

        }
        return mountainLocInfo;
    }

}

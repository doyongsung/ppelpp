package com.bitcamp.orl.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.orl.member.domain.Member;


public interface Dao {
	
	List<Member> selectAll();
	
	int insertMember(Member member);
	
	Member selectByIdPw(@Param("memberId")String memberId, @Param("memberPw")String memberPw);
}

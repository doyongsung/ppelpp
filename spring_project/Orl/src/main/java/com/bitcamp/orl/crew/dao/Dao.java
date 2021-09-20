package com.bitcamp.orl.crew.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewMemberList;
import com.bitcamp.orl.member.domain.Member;

public interface Dao {

	// 관리자 crew 전체 리스트
	List<Crew> selectCrewListByAdmin();
	
	// 관리자 crewreg 전체 리스트
	List<CrewMemberList> selectAllCrewMemberList();
	
	// 크루 게시물 총 개수
	int CrewCount();

	// session의 memberIdx을 이용하여 내가 가입한 crew 리스트
	List<Crew> selectMyCrewList(@Param("memberIdx") int memberIdx);

	// crewIdx를 이용하여 한 특정 crew 조회
	Crew selectCrew(@Param("crewIdx") int crewIdx);

	// 한 특정 crew의 멤버 수 카운트
	int selectCrewMemberNum(@Param("crewIdx") int crewIdx);

	// 한 특정 crew의 댓글 갯수 카운트
	int selectCrewCommentNum(@Param("crewIdx") int crewIdx);

	// session의 memberIdx을 이용하여 한 특정 crew의 가입여부 확인하기
	int selectCountMemberToRegCrew(@Param("memberIdx") int memberIdx, @Param("crewIdx") int crewIdx);

	// memberIdx를 이용하여 한 멤버 특정하기
	Member selectMemberByMemberIdx(@Param("memberIdx") int memberIdx);

	// 크루에 가입
	int insertCrewReg(@Param("memberIdx") int memberIdx, @Param("crewIdx") int crewIdx);

	// 크루 생성
	int insertCrew(Crew crew);

	// 크루 삭제
	int deleteCrew(@Param("crewIdx") int crewIdx);

	// 크루 수정
	int updateCrew(@Param("crewName") String crewName, @Param("crewPhoto") String crewPhoto,
			@Param("crewDiscription") String crewDiscription, @Param("crewTag") String crewTag,
			@Param("crewIdx") int crewIdx);

	// 크루 수정인데, 사진을 수정하지 않는 경우
	int updateCrewWithoutPhoto(@Param("crewName") String crewName, @Param("crewDiscription") String crewDiscription,
			@Param("crewTag") String crewTag, @Param("crewIdx") int crewIdx);

}

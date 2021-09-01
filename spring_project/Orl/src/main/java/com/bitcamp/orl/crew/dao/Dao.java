package com.bitcamp.orl.crew.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewComment;
import com.bitcamp.orl.crew.domain.Paging;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.member.domain.Member;

public interface Dao {
	
	int insertCrew(Crew crew);
	
	int getCrewListCnt();

	List<Crew> selectAll();
	
	List<Crew> selectAll(SearchType searchType);
	
	List<Crew> selectMyCrewList(@Param("memberIdx")int memberIdx);

	List<Crew> selectMyCrewList(@Param("memberIdx")int memberIdx, SearchType searchType);
	
	Crew selectCrew(@Param("crewIdx")int crewIdx);
	
	int selectCrewMemberNum(@Param("crewIdx")int crewIdx);
	
	int selectCrewCommentNum(@Param("crewIdx")int crewIdx);
	
	int selectCountMemberToRegCrew(@Param("memberIdx")int memberIdx, @Param("crewIdx")int crewIdx);
	
	List<CrewComment> selectCrewComment(@Param("crewIdx")int crewIdx);
	
	Member selectCommentMember(@Param("memberIdx")int memberIdx);

	int getCrewListCnt(Paging paging);
}

package com.bitcamp.orl.crew.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewComment;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.member.domain.Member;

public interface Dao {
	
	

	int insertCrew(Crew crew);
	
	int getCrewListCnt();
	
	int selectByCrewName(String id);
	
	//전체 크루 수
	List<Crew> selectAll();	
	//검색을 통한 crew 리스트 
	List<Crew> selectCrewAll(SearchType searchType);
	//크루 이름순
	List<Crew> selectAll(String crewName);
	
	
	List<Crew> selectMyCrewList(@Param("memberIdx")int memberIdx);

	List<Crew> selectMyCrewList(@Param("memberIdx")int memberIdx, SearchType searchType);
	
	Crew selectCrew(@Param("crewIdx")int crewIdx);
	
	int selectCrewMemberNum(@Param("crewIdx")int crewIdx);
	
	int selectCrewCommentNum(@Param("crewIdx")int crewIdx);
	
	int selectCountMemberToRegCrew(@Param("memberIdx")int memberIdx, @Param("crewIdx")int crewIdx);
	
	Member selectCrewCommentMember(@Param("memberIdx")int memberIdx);
	
	List<CrewComment> selectCrewComment(@Param("crewIdx")int crewIdx);
	
	int insertCrewReg(@Param("memberIdx")int memberIdx, @Param("crewIdx")int crewIdx);
	
	int insertCrewComment(@Param("crewComment")String crewComment, @Param("memberIdx")int memberIdx, @Param("crewIdx")int crewIdx);
	
	List <CrewComment> selectCrewCommentPaging(@Param("crewIdx")int crewIdx, @Param("firstRow")int firstRow, @Param("amountPerPage")int amountPerPage);

	
	
}

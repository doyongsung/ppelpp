package com.bitcamp.orl.crew.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.orl.crew.domain.Crew;
import com.bitcamp.orl.crew.domain.CrewComment;
import com.bitcamp.orl.crew.domain.CrewCommentInfo;
import com.bitcamp.orl.crew.domain.CrewMemberList;
import com.bitcamp.orl.crew.domain.SearchType;
import com.bitcamp.orl.member.domain.Member;

public interface CrewMapper {
	
	//모든 crew 리스트
	List<Crew> selectAll(@Param("pageStart")int pageStart, @Param("perPageNum")int perPageNum);
	
	//검색을 통한 crew 리스트 
	List<Crew> selectCrewAll(SearchType searchType);
	
	//관리자 crew 전체 리스트
	List<Crew> selectCrewListByAdmin();
	
	//크루 게시물 총 개수
	int CrewCount();
		
	//검색 결과에 대한 크루 게시물 총 개수
	int CrewCountForSearching(SearchType searchType);
	
	//session의 memberIdx을 이용하여 내가 가입한 crew 리스트
	List<Crew> selectMyCrewList(@Param("memberIdx")int memberIdx);

	//crewIdx를 이용하여 한 특정 crew 조회
	Crew selectCrew(@Param("crewIdx")int crewIdx);
	
	//한 특정 crew의 멤버 수 카운트
	int selectCrewMemberNum(@Param("crewIdx")int crewIdx);
	
	//한 특정 crew의 댓글 갯수 카운트
	int selectCrewCommentNum(@Param("crewIdx")int crewIdx);
	
	//session의 memberIdx을 이용하여 한 특정 crew의 가입여부 확인하기
	int selectCountMemberToRegCrew(@Param("memberIdx")int memberIdx, @Param("crewIdx")int crewIdx);
	
	//memberIdx를 이용하여 한 멤버 특정하기
	Member selectMemberByMemberIdx(@Param("memberIdx")int memberIdx);
	
	//크루에 가입
	int insertCrewReg(@Param("memberIdx")int memberIdx, @Param("crewIdx")int crewIdx);
	
	//크루 댓글 기입
	int insertCrewComment(@Param("crewComment")String crewComment, @Param("memberIdx")int memberIdx, @Param("crewIdx")int crewIdx);
	
	//한 특정 crew의 댓글 리스트 가져오기(페이징+)
	List <CrewComment> selectCrewCommentPaging(@Param("crewIdx")int crewIdx, @Param("firstRow")int firstRow, @Param("amountPerPage")int amountPerPage);
	
	//크루 생성
	int insertCrew(Crew crew);
	
	//크루 이름으로 크루 찾기 (크루 이름 중복체크를 위해)
	int selectByCrewName(@Param("crewName")String crewName);
	
	//크루 삭제
	int deleteCrew(@Param("crewIdx")int crewIdx);
	
	//크루 수정
	int updateCrew(@Param("crewName")String crewName, @Param("crewPhoto")String crewPhoto, @Param("crewDiscription")String crewDiscription, @Param("crewTag")String crewTag, @Param("crewIdx")int crewIdx);

	//크루 수정인데, 사진을 수정하지 않는 경우
	int updateCrewWithoutPhoto(@Param("crewName")String crewName, @Param("crewDiscription")String crewDiscription, @Param("crewTag")String crewTag, @Param("crewIdx")int crewIdx);
	
	//크루 멤버리스트 조회(크루원 관리를 위해)
	List<CrewMemberList> selectCrewMemberList(@Param("crewIdx")int crewIdx);
	
	//크루원 강퇴
	int deleteFromCrewMemberList(@Param("memberIdx")int memberIdx, @Param("crewIdx")int crewIdx);
	
	//크루 댓글 삭제
	int deleteCrewComment(@Param("crewCommentIdx")int crewCommentIdx);
	
	//크루 댓글 중 한 특정 댓글 정보 조회(댓글 수정을 위해)
	CrewCommentInfo getCrewCommentInfo(@Param("crewCommentIdx")int crewCommentIdx);
	
	//크루 댓글 수정
	int updateCrewComment(@Param("crewComment")String crewComment, @Param("crewCommentIdx")int crewCommentIdx);

}

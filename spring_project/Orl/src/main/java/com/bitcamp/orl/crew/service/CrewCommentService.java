package com.bitcamp.orl.crew.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.CrewComment;
import com.bitcamp.orl.crew.domain.CrewCommentCriteria;
import com.bitcamp.orl.crew.domain.CrewCommentInfo;
import com.bitcamp.orl.crew.domain.CrewCommentPagingDTO;
import com.bitcamp.orl.member.domain.Member;
import com.bitcamp.orl.member.domain.MemberDto;

@Service
public class CrewCommentService {
	
	Dao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public CrewCommentPagingDTO getCrewComment(CrewCommentCriteria cri) {
		dao = template.getMapper(Dao.class);
		
		//현재 페이지가 0이면 1로 설정
		if(cri.getCurrentPageNum() == 0) {
			cri.setCurrentPageNum(1);
		}
		
		//DB에 사용할 시작값, 끝값, 총 컨텐츠 개수 계산
		int startRow = (cri.getCurrentPageNum()-1) * (cri.getAmountPerPage());
		int endRow = startRow + cri.getAmountPerPage();
		int totalCommentNum = dao.selectCrewCommentNum(cri.getCrewIdx());
		
		//페이징 적용해서 list 가져옴
		List<CrewComment> list = dao.selectCrewCommentPaging(cri.getCrewIdx(), startRow, cri.getAmountPerPage()); 
		
		//crew에 member정보를 더해서 담을 수 있도록 새 List 생성
		List<CrewCommentInfo> infoList = new ArrayList<CrewCommentInfo>();
		
		//반복문으로 돌려서 memberNickName과 Profile값 설정
		if(list != null) {
			for(int i = 0 ; i < list.size() ; i++) {
				CrewCommentInfo info = list.get(i).CommentToInfo();
				Member commentMember = getCommentMember(list.get(i).getMemberIdx());
				info.setMemberNickName(commentMember.getMemberNickname());
				info.setMemberProfile(commentMember.getMemberProfile());
				infoList.add(info);
			}
		}
		
		//만든 리스트와, 페이징 정보를 담아서 return
		CrewCommentPagingDTO dto = new CrewCommentPagingDTO(
				infoList, totalCommentNum, cri, startRow, endRow);
		return dto;
	}
	
	//댓글 단 해당 멤버 정보를 가져오는 method
	public Member getCommentMember(int memberIdx) {
		return template.getMapper(Dao.class).selectMemberByMemberIdx(memberIdx);
	}
	
	//댓글 수정할 때 댓글 정보(crew+member)를 가져오기 위한 method
	public CrewCommentInfo getCrewCommentInfo(int crewCommentIdx) {
		return template.getMapper(Dao.class).getCrewCommentInfo(crewCommentIdx);
	}
	
	//크루 댓글 입력
	public int insertCrewComment(
			String crewComment,
			HttpSession session,
			int crewIdx
			) {
		int resultCnt = 0;
		dao = template.getMapper(Dao.class);
		MemberDto dto = (MemberDto)session.getAttribute("memberVo");
		resultCnt = dao.insertCrewComment(crewComment, dto.getMemberIdx(), crewIdx);
		return resultCnt;
	}
	
	//크루 댓글 삭제
	public int deleteCrewComment(
			int crewCommentIdx
			) {
		return template.getMapper(Dao.class).deleteCrewComment(crewCommentIdx);
	}
	
	//크루 댓글 수정
	public int updateCrewComment(
			String crewComment,
			int crewCommentIdx
			) {
		return template.getMapper(Dao.class).updateCrewComment(crewComment, crewCommentIdx);
	}
}

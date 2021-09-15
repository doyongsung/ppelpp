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
		
		if(cri.getCurrentPageNum() == 0) {
			cri.setCurrentPageNum(1);
		}
		int startRow = (cri.getCurrentPageNum()-1) * (cri.getAmountPerPage());
		int endRow = startRow + cri.getAmountPerPage();
		int totalCommentNum = dao.selectCrewCommentNum(cri.getCrewIdx());
		
		List<CrewComment> list = dao.selectCrewCommentPaging(cri.getCrewIdx(), startRow, cri.getAmountPerPage());
		List<CrewCommentInfo> infoList = new ArrayList<CrewCommentInfo>();
		if(list != null) {
			for(int i = 0 ; i < list.size() ; i++) {
				CrewCommentInfo info = list.get(i).CommentToInfo();
				Member commentMember = getCommentMember(list.get(i).getMemberIdx());
				info.setMemberNickName(commentMember.getMemberNickname());
				info.setMemberProfile(commentMember.getMemberProfile());
				infoList.add(info);
			}
		}
		CrewCommentPagingDTO dto = new CrewCommentPagingDTO(
				infoList, totalCommentNum, cri, startRow, endRow);
		return dto;
	}
	
	public Member getCommentMember(int memberIdx) {
		return template.getMapper(Dao.class).selectMemberByMemberIdx(memberIdx);
	}
	
	public CrewCommentInfo getCrewCommentInfo(int crewCommentIdx) {
		return template.getMapper(Dao.class).getCrewCommentInfo(crewCommentIdx);
	}
	
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
	
	public int deleteCrewComment(
			int crewCommentIdx
			) {
		return template.getMapper(Dao.class).deleteCrewComment(crewCommentIdx);
	}
	
	public int updateCrewComment(
			String crewComment,
			int crewCommentIdx
			) {
		return template.getMapper(Dao.class).updateCrewComment(crewComment, crewCommentIdx);
	}
}

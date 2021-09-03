package com.bitcamp.orl.crew.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.crew.dao.Dao;
import com.bitcamp.orl.crew.domain.CrewComment;
import com.bitcamp.orl.crew.domain.CrewCommentInfo;
import com.bitcamp.orl.member.domain.Member;

@Service
public class CrewCommentService {
	
	Dao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public int insertCrewComment(
			String crewComment,
			HttpSession session,
			int crewIdx
			) {
		int resultCnt = 0;
		
		dao = template.getMapper(Dao.class);
		
		Member member = (Member)session.getAttribute("member");
		resultCnt = dao.insertCrewComment(crewComment, member.getMemberIdx(), crewIdx);
		
		return resultCnt;
	}
	
	public List<CrewCommentInfo> getCrewComment(int crewIdx) {
		dao = template.getMapper(Dao.class);
		
		List<CrewComment> list = dao.selectCrewComment(crewIdx);
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
		
		return infoList;
	}
	
	public Member getCommentMember(int memberIdx) {
		dao = template.getMapper(Dao.class);
		return dao.selectCommentMember(memberIdx);
	}
}
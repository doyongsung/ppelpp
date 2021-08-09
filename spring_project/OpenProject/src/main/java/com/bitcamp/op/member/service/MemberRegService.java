package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.op.domain.Member;
import com.bitcamp.op.domain.MemberRegRequest;
import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
@Service
public class MemberRegService {
	
	final String UPLOAD_URI = "/uploadfile";
	
	@Autowired
	MemberDao dao;

	public int reg(
			MemberRegRequest memberRegRequest,
			HttpServletRequest request
			) {

		int resultCnt = 0;
		Connection conn = null;
		File newFile = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			Member member = new Member();
			
			member.setMemberid(memberRegRequest.getMemberid());
			member.setPassword(memberRegRequest.getPassword());
			member.setMembername(memberRegRequest.getMembername());
			
			if(memberRegRequest.getMemberphoto() != null) {
				member.setMemberphoto(memberRegRequest.getMemberphoto().getOriginalFilename());
				newFile = saveFile(request, memberRegRequest.getMemberphoto());
			} else {
				member.setMemberphoto("");
			}
			resultCnt = dao.insertMember(conn, member);

			
		} catch (SQLException | IllegalStateException | IOException e) {
			//예외처리 질문
			e.printStackTrace();
			if(newFile != null & newFile.exists()) {
				newFile.delete();
				System.out.println("파일 삭제");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultCnt;
	}
	
	private File saveFile(
			HttpServletRequest request, 
			MultipartFile file
			) throws IllegalStateException, IOException {
		
		String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		File newFile = new File(saveDir, file.getOriginalFilename());
		file.transferTo(newFile);
		
		return newFile;
	}

}

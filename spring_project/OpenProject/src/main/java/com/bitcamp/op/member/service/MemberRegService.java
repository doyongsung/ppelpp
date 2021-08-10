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
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.dao.MemberDao;
@Service
public class MemberRegService {
	
	final String UPLOAD_URI = "/uploadfile";
	
	@Autowired
   private MemberDao dao;

	public int reg(
			MemberRegRequest memberRegRequest,
			HttpServletRequest request
			) {

		int resultCnt = 0;
		Connection conn = null;
		File newFile = null;
		// 1. 파일 저장
		//   시스템 경로
		String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		// 새로운 폴더 저장
		File newDir = new File(path);
		
		try {
		// 폴더가 존재하지 않으면 폴더 생성
		if(!newDir.exists()) {
			newDir.mkdir();
			System.out.println("저장 폴더를 생성했습니다.");
		}
		
		// 파일 저장시에 파일 이름이 같으면 덮어쓴다 -> 회원별 고유한 파일 이름을 만들자!!
		String newFileName = memberRegRequest.getMemberid()+System.currentTimeMillis();
		//  cool123334341332 
		
		// 새로운 File 객체
		newFile = new File(newDir,newFileName);
		// 파일 저장
			if(memberRegRequest.getMemberphoto() != null && !memberRegRequest.getMemberphoto().isEmpty()) {
				memberRegRequest.getMemberphoto().transferTo(newFile);
			}
				
				
		// 2. dao 저장
			conn = ConnectionProvider.getConnection();
			
			// Member 객체 생성 -> 저장된 파일의 이름을 set
			Member member = memberRegRequest.toMember();
					member.setMemberphoto(newFileName);
			
					resultCnt = dao.insertMember(conn, member);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			//DB 예외 발생 시 -> 저장된 파일 삭제
			if(newFile != null && newFile.exists()) {
				newFile.delete();
				System.out.println("파일 삭제");
			}
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		return resultCnt;
		
	}
//		try {
//			conn = ConnectionProvider.getConnection();
//			Member member = new Member();
//			
//			member.setMemberid(memberRegRequest.getMemberid());
//			member.setPassword(memberRegRequest.getPassword());
//			member.setMembername(memberRegRequest.getMembername());
//			
//			if(memberRegRequest.getMemberphoto() != null) {
//				member.setMemberphoto(memberRegRequest.getMemberphoto().getOriginalFilename());
//				newDir = saveFile(request, memberRegRequest.getMemberphoto());
//			} else {
//				member.setMemberphoto("");
//			}
//			resultCnt = dao.insertMember(conn, member);
//
//			
//		} catch (SQLException | IllegalStateException | IOException e) {
//			//예외처리 질문
//			e.printStackTrace();
//			if(newDir != null & newDir.exists()) {
//				newDir.delete();
//				System.out.println("파일 삭제");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	
	
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

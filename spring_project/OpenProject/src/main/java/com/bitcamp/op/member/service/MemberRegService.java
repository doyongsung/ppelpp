package com.bitcamp.op.member.service;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.domain.Member;
import com.bitcamp.op.domain.MemberRegRequest;
import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.dao.MemberDao;
@Service
public class MemberRegService {
	
	final String UPLOAD_URI = "/uploadfile";
	
	//@Autowired
	//private MemberDao dao;
	
	@Autowired
	private JdbcTemplateMemberDao dao;
	
	public int memberReg(
			MemberRegRequest regRequest,
			HttpServletRequest request
			) {
		
		int resultCnt = 0;
		//Connection conn = null;
		File newFile = null;
		
		try {
			// 1. 파일 저장
			
			// 시스템 경로
			String path = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
			// 새로운 저장 폴더 : File
			File newDir = new File(path);
			
			// 폴더가 존재하지 않으면 폴더 생성
			if(!newDir.exists()) {
				newDir.mkdir();
				System.out.println("저장 폴더를 생성했습니다.");
			}
			// 파일 저장시에 파일 이름이 같으면 덮어쓴다 -> 회원별 고유한 파일 이름을 만들자!!
			String newFileName = regRequest.getMemberid()+System.currentTimeMillis(); 
			//   cool123128936798123987
			
			// 파일 확장자 구하기
			String fileName = regRequest.getPhoto().getOriginalFilename();
			// 업로드 파일의 contentType
			String contentType = regRequest.getPhoto().getContentType();
			
			// String[] java.lang.String.split(String regex) 
			// : 정규식의 패턴 문자열을 전달해야하기 때문에 \\. 으로 처리
			String[] nameTokens = fileName.split("\\.");   /// tet.mini2.jpg   PNG png
			
			// 토큰의 마지막 index의 문자열을 가져옴 : 배열의 개수-1
			String fileType = nameTokens[nameTokens.length-1];
			fileType = fileType.toLowerCase();
			
			// 이미지 파일 이외의 파일 업로드 금지
			// 파일 확장자 체크
//			if(!(fileType.equals("jpg")||fileType.equals("png")||fileType.equals("gif")) ) {
//				// 파일 contentType 체크
//				if(!(contentType.equals("image/jpg")||contentType.equals("image/png")||contentType.equals("image/gif"))) {
//					throw new Exception("허용하지 않는 파일 타입 : " + contentType);
//				}
//			}
			
			// 새로운 파일이름에 확장자 추가
			newFileName += "."+fileType;

			// 새로운 File 객체
			newFile = new File(newDir, newFileName);
			
			
			// Member 객체 생성 -> 저장된 파일의 이름을 set
			Member member = regRequest.toMember();
			
			
			// 파일 저장
			if(regRequest.getPhoto() != null && !regRequest.getPhoto().isEmpty()) {
				regRequest.getPhoto().transferTo(newFile);
				member.setMemberphoto(newFileName);
			}
			
			// 2. dao 저장
			//conn = ConnectionProvider.getConnection();
			
			
			
			resultCnt = dao.insertMember(member);
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// DB 예외 발생 시 -> 저장된 파일을 삭제
			if(newFile != null && newFile.exists() ) {
				newFile.delete();
			}
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		
		return resultCnt;
	}

}
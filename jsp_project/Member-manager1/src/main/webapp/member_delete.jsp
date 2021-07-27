<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	// 사용자가 전달하는 idx 받고 -> 실행 -> 결과
	String idx = request.getParameter("idx");
	
	// DB 에 있는 데이터를 삭제
	int resultCnt = 0;
	
	// 데이터베이스 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = null;
	MemberDao dao = MemberDao.getInstance();
	
	conn = ConnectionProvider.getConnection();
	
	resultCnt = dao.deleteMember(conn, Integer.parseInt(idx));
	
	if(resultCnt > 0){
		%>
		<script>
		alert('삭제되었습니다.');
		location.href= 'member_list';
		</script>
		<%
	}else{
		%>
		<script>
		alert("해당 데이터를 찾지 못했습니다.");
		location.href= 'member_list';
		</script>
		<%
	}
%>
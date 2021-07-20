<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 1. 사용자가 입력한 데이터를 받고
	// 입력데이터의 한글 처리!!!
	request.setCharacterEncoding("utf-8");
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	int resultCnt = 0;
	// 2. DB 처리 : insert
	// 데이터베이스 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	// 연결
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		conn = ConnectionProvider.getConnection();
		// PreparedStatement
		String sqlInsert = "insert into dept values(?, ?, ?)";
		pstmt = conn.prepareStatement(sqlInsert);
		pstmt.setInt(1, Integer.parseInt(deptno));
		pstmt.setString(2, dname);
		pstmt.setString(3, loc);
		resultCnt = pstmt.executeUpdate();
		//out.println(resultCnt);
		// insert -> int
		// 3. dept_list.jsp 이동	
		//response.sendRedirect("dept_list.jsp");
	} catch (Exception e) {
	}
	if (resultCnt > 0) {
%>
<script>
	alert('등록되었습니다.');
	location.href = 'dept_list.jsp';
</script>
<%
	} else {
%>
<script>
	alert('오류 발생으로 등록되지 않았습니다.\n입력페이지로 다시 이동합니다.');
	//location.href = 'dept_regForm.jsp';
	window.history.go(-1);
</script>
<%
	}
%>
<%@page import="domain.Dept"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자가 전달하는 부서번호 받기
	String deptno = request.getParameter("deptno");
	//out.println(deptno);
	
	// 전달받은 부서번호로 부서정보를 가져온다
	// 1. 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	// 2. DB 연결
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// jdbcUrl 
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user = "bit";
	String pw = "1234";
	conn = DriverManager.getConnection(jdbcUrl, user, pw);
	
	Dept dept = null;
	
	String sqlSelect = "select * from dept where deptno=? ";
	pstmt = conn.prepareStatement(sqlSelect);
	pstmt.setInt(1, Integer.parseInt(deptno));
	
	rs = pstmt.executeQuery();
	
	if(rs.next()){
		dept = new Dept();
		dept.setDeptno(rs.getInt("deptno"));
		dept.setDname(rs.getString("dname"));
		dept.setLoc(rs.getString("loc"));
	}
	
	//out.println(dept);
	
	// 부서정보를 form_view.jsp 전달(공유)
	request.setAttribute("dept", dept);
	
%>
<jsp:forward page="form_view.jsp"/>




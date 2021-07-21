<%@page import="member.Member"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <% 
    request.setCharacterEncoding("UTF-8");
    
    String memberId = request.getParameter("memberId");
    String memberPw = request.getParameter("memberPw");
    String memberName = request.getParameter("memberName");
    
    
    int resultCnt = 0;
    
    // 데이터베이스 드라이버 로드
    
    Connection conn = null;
    MemberDao dao = null;
    
    conn = ConnectionProvider.getConnection();
    dao = MemberDao.getInstance();
    
    resultCnt = dao.updateMember(conn,new Member(memberId,memberPw,memberName));
    
    
    if(resultCnt > 0){
    	%>
    	<script>
    	alert('수정되었습니다');
    	location.href = 'memberList.jsp';
    	</script>
    	<%
    }else{
    	%>
    	<script>
    	alert("해당 데이터를 찾지 못했습니다.");
    	location.href = 'memberList.jsp';
    	</script>
    	<%
    }
    %>
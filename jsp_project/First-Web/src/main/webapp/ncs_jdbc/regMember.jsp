<%@page import="member.Member"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
     
<%
   // 사용자가 입력한 데이터를 받고 -> 처리 -> 결과를 속성에 저장 -> view 저장
   // 입력데이터의 한글 처리!!!
   request.setCharacterEncoding("utf-8");
   String memberId = request.getParameter("memberId");
   String memberPw = request.getParameter("memberPw");
   String memberName = request.getParameter("memberName");
   
   int resultCnt = 0;
   
   // DB처리 : insert
   // 데이터베이스 드라이버 로드
   // 연결
   Connection conn = null;
   MemberDao dao = MemberDao.getInstance();
   try{
   conn = ConnectionProvider.getConnection();
   resultCnt = dao.insertMember(conn, new Member(memberId, memberPw, memberName));
   }catch(Exception e){
	   
   }
   if(resultCnt > 0){
	   %>
	   <script>
	   alert('등록되었습니다.');
	   location.href = 'member_List.jsp';
	   </script>
	   <%
   }else{
	   %>
	   <script>
	   alert('오류 발생으로 등록되지 않았습니다. \n 이전페이지로 이동합니다.');
	   window.history.go(-1);
	   </script>
	   <%
   }
  
       %>
       <html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
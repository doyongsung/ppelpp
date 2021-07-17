<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%
        // 사용자가 전달한 데이터의 한글 처리 post로 받을때 필수
        request.setCharacterEncoding("utf-8");
        
    String userName = request.getParameter("username");
    String job = request.getParameter("job");
    
    String[] interests = request.getParameterValues("interest");
    
    request.setAttribute("userName", userName);
    request.setAttribute("job", job);
    request.setAttribute("age", 30); // 30 -> auto Boxing 자동으로 감싸짐
    
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>request Form Test: result</h1>
    <hr>
    <!-- 데이터를 처리할 위치로 전송 : input 요소에 ->name 속성을 반드시!!! 정의해주어야한다!!-->
    <table border="1">
        <tr>
            <td>이름</td>
            <td>
            <%= userName %>
            </td>
        </tr>
        <tr>
            <td>직업</td>
            <td>
            <%= job %>
            </td>
        </tr>
        <tr>
            <td>관심사항</td>
            <td>
            <%
            
            if(interests != null && interests.length > 0){
            	for(int i =0; i < interests.length; i++){
            		out.println(interests[i]+"<br>");
            	}
            }
            
            
            %>
            </td>
        </tr>
        
        <tr>
        
        <td></td>
        <td>
        <jsp:include page="view.jsp"/>
        
        </td>
        
        </tr>
    </table>

</body>
</html>
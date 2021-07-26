<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h3>
		1. 선택한 상품 : ${param.select} <br>
		2. 상품의 설명 : ${product.display} <br>
		<!-- display 변수는 없다!! -> EL 은 메소드를 호출하는것이다!! -->
		3. 첫번째 상품 : ${product.productList[0]} <br>
	</h3>

</body>
</html>


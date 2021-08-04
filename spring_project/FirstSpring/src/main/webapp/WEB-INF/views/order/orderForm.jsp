<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>주문</h1>
	<hr>
	<form>
		<table>
			<tr>
				<td>상품 - 1</td>
				<td>ID</td>
				<td><input type="text" name="orderItems[0].itemId"></td>
			</tr>
			<tr>
				<td>상품 - 2</td>
				<td>수량</td>
				<td><input type="number" name="orderItems[0].itemId"></td>
			</tr>
		</table>
		
	</form>

</body>
</html>
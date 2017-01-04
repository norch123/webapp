<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<table border="1">
		<tr>
			<td>Название</td>
			<td>Описание</td>
			<td>Цена</td>
			<td>Тип</td>
		</tr>
		<c:forEach items="${listProducts}" var="product">
			<tr name = <c:out value="${product.id}" />>
				<td><c:out value="${product.name}" /></td>
				<td><c:out value="${product.description}" /></td>
				<td><c:out value="${product.price}" /></td>
				<td><c:out value="${product.productType.type}" /></td>
				<td><button>Удалить</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<a href="todoForm.do">글쓰기</a> <br>
<table border="1">
	<thead>
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>글 분류</td>
			<td>작성자</td>
			<td>등록일</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${todoBoardList }" var="todoBoard">
			<tr>
				<td>${todoBoard.boNo }</td>
				<td><a href="todoView.do?boNo=${todoBoard.boNo }"> ${todoBoard.boTitle } </a> </td>
				<td>${todoBoard.boCategory }</td>
				<td>${todoBoard.boWriter }</td>
				<td>${todoBoard.boRegDate }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>
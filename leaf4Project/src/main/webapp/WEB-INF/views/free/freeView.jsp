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


<table border="1">
	<tr><td>글번호</td>   <td>${freeBoard.boNo }</td></tr>
	<tr><td>제목</td>    <td>${freeBoard.boTitle }</td></tr>
	<tr><td>분류</td>    <td>${freeBoard.boCategory }</td></tr>
	<tr><td>작성자</td>   <td>${freeBoard.boWriter }</td></tr>
	<tr><td>비밀번호</td> <td>${freeBoard.boPass }</td></tr>
	<tr><td>내용</td>    <td><textarea readonly="readonly" rows="5">${freeBoard.boContent }</textarea></td></tr>
	<tr><td>등록일</td>   <td>${freeBoard.boRegDate }</td></tr>
	<tr><td>삭제여부</td> <td>${freeBoard.boDelYn }</td></tr>
	<tr> <td> <a href="freeEdit.wow?boNo=${freeBoard.boNo }">수정</a></td></tr>
</table>




</body>
</html>
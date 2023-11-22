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

<a href="freeForm.wow">글쓰기</a> <br>
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
		<c:forEach items="${freeBoardList }" var="freeBoard">
			<tr>
				<td>${freeBoard.boNo }</td>
				<td><a href="freeView.wow?boNo=${freeBoard.boNo }"> ${freeBoard.boTitle } </a> </td>
				<td>${freeBoard.boCategory }</td>
				<td>${freeBoard.boWriter }</td>
				<td>${freeBoard.boRegDate }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- paging -->
<a href="freeList.wow?curPage=1">&laquo;</a>
<a href="freeList.wow?curPage=${paging.curPage-1 }">&lt;</a>
<c:forEach begin="${paging.firstPage }"  end="${paging.lastPage }" var="i">
   	<a href="freeList.wow?curPage=${i }"  >  
   		<c:if test="${i eq paging.curPage }">  <span style="color: red">  ${i } </span> </c:if>
   		<c:if test="${i ne paging.curPage }">  ${i } </c:if> 
   	</a>
</c:forEach>
<a href="freeList.wow?curPage=${paging.curPage+1 }">&gt;</a>
<a href="freeList.wow?curPage=${paging.totalPageCount }">&raquo;</a>
<!-- paging -->

</body>
</html>
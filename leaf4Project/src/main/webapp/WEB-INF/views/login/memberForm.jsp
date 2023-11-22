<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%request.setCharacterEncoding("utf-8"); %>
</head>
<body>

<form action="memberRegist.wow" method="post">
<table border="1">
		<tbody>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="memId" required="required"  ></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="memPass"  required="required"></td>
			</tr>
			<tr>
				<th>회원명</th>
				<td><input type="text" name="memName"  required="required" ></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input type="text" name="memZip" ></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="memAdd1" >
					<input type="text" name="memAdd2">
				</td>
			</tr>
			<tr>
				<th>생일</th>
				<td><input type="date" name="memBir" ></td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="text" name="memMail"></td>
			</tr>
			<tr>
				<th>핸드폰</th>
				<td><input type="text" name="memHp"></td>
			</tr>
			<tr>
				<th>직업</th>
				<td>
					<input type="tel" name="memJob"  placeholder="JB01 ~ JB04" >			
				</td>
			</tr>
			<tr>
				<th>취미</th>
				<td>
					<input type="tel" name="memHobby"  placeholder="HB01 ~ HB04">				
				</td>
			</tr>			
			<tr>
				<td>
					<button type="submit">회원가입</button>
				</td>
			</tr>
		</tbody>	
	</table>

</form>













</body>
</html>
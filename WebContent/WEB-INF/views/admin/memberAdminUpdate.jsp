<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	MemberVO mv = (MemberVO)request.getAttribute("mv");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="memberAdminUpdate.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="memId" value="<%=mv.getMemId() %>">
<%-- 	<input type="hidden" name="atchFileId" value="<%=mv.getAtchFileId() %>"> --%>
		<table>
			<tr>
				<td>I D:</td>
				<td><%=mv.getMemId() %></td>
			</tr>
			<tr>
				<td>이름:</td>
				<td><input type="text" name="memName" value="<%=mv.getMemName() %>"></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="text" name="memPw" value="<%=mv.getMemPw() %>"></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><input type="text" name="memMail" value="<%=mv.getMemMail() %>"></td>
			</tr>
			<tr>
				<td>성별:</td>
				<td><input type="text" name="memGender" value="<%=mv.getmemGender() %>"></td>
			</tr>
			<tr>
				<td>생일:</td>
				<td><input type="text" name="memBirth" value="<%=mv.getMemBirth() %>"></td>
			</tr>
			<tr>
				<td>전화번호:</td>
				<td><input type="text" name="memTel" value="<%=mv.getMemTel() %>"></td>
			</tr>
			<tr>
				<td>주소:</td>
				<td><textarea name="memAddr" ><%=mv.getMemAddr() %></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" method="post" value="수정하기"></td>
			</tr>
		</table>
	</form>

</body>
</html>
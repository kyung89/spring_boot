<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>글 목록</title>
</head>
<body>
	<center>
		<h1>게시글 목록</h1>
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">등록일</th>
				<th bgcolor="orange" width="100">초회수</th>
			</tr>
			<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${ board.seq }</td>
				<td align="left"><a href="getBoard?seq=${ board.seq }">${ board.title }</a></td>
				<td>${ board.writer }</td>
				<td><fmt:formatDate value="${ board.createDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
				<td>${ board.cnt }</td>
			</tr>
			</c:forEach>
		</table>
		
		<br>
		<a href="insertBoard">새글 작성</a>
	</center>
</body>
</html>
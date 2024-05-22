<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>글 상세</title>
</head>
<body>
	<center>
		<h1>글 상세</h1>
		<form action="updateBoard" method="post">
		<input type="hidden" name="seq" value="${ board.seq }"/>
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input type="text" name="title" value="${ board.title }"/></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left"><input type="text" name="writer" size="10" value="${ board.writer }"/></td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left"><textarea name="content" cols="40" rows="10">${ board.content }</textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td>
				<td align="left"><fmt:formatDate value="${ board.createDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
			</tr>
			<tr>
				<td bgcolor="orange">조회수</td>
				<td align="left">${ board.cnt }</td>
			</tr>
			<tr>
				<td colspan ="2" align="center">
				<input type="submit" value="글 수정 " /></td>
			</tr>
		</table>
		</form>
	<hr>
	<a href="insertBoard">글 등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard?seq=${ board.seq }">글 삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList">글목록</a>
	</center>
</body>
</html>
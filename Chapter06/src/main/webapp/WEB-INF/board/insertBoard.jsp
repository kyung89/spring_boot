<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���</title>
</head>
<body>
	<center>
		<h1>���� ����ϱ�</h1>
		<form action="insertBoard" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange" width="70">����</td>
				<td align="left"><input type="text" name="title"/></td>
			</tr>
			<tr>
				<td bgcolor="orange">�ۼ���</td>
				<td align="left"><input type="text" name="writer" size="10"/></td>
			</tr>
			<tr>
				<td bgcolor="orange">����</td>
				<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan ="2" align="center">
				<input type="submit" value=" ���� ��� " /></td>
			</tr>
		</table>
		</form>
	<hr>
	</center>
</body>
</html>
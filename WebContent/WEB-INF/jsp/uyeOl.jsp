<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ÜYE OLss

<form action="${pageContext.request.contextPath }/uyeEkle" method="post">
	<table>
		<tr>
			<td>Kullanici Adi : </td>
			<td><input type="text" name="username" value=""></td>
		</tr>
		<tr>
			<td>Ad : </td>
			<td><input type="text" name="name" value=""></td>
		</tr>
		<tr>
			<td>Soyad :</td>
			<td><input type="text" name="surname" value=""></td>
		</tr>
		<tr>
			<td>E-Mail : </td>
			<td><input type="text" name="email" value=""></td>
		</tr>
		<tr>
			<td>Şifre : </td>
			<td><input type="password" name="password" value=""></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Uye Ol"></td>
		</tr>
	</table>
		<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
</form>
</body>
</html>
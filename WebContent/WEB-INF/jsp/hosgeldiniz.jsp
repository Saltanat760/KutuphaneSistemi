<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	HOSGELDINIZ
	<p>
		<a href="${pageContext.request.contextPath }/login">Giris Yap</a><br>
		<a href="${pageContext.request.contextPath }/kitapListesi">Kitap Listesi</a><br> 
		<a href="${pageContext.request.contextPath }/uyeOl">Uye Ol</a><br>

		<sec:authorize access="isAuthenticated()">
			<a href="${pageContext.request.contextPath }/odemeYap">Odeme Yap</a>
			<br>
		</sec:authorize>
		<sec:authorize access="hasRole('ADMIN')">
			<a href="${pageContext.request.contextPath }/kitapEkleme">Kitap Ekleme</a>
			<br>
		</sec:authorize>
</body>
</html>
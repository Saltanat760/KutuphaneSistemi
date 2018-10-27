<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	HOSGELDINIZ  
	<p>
		<sec:authorize access="isAnonymous()">
			<a href="${pageContext.request.contextPath }/login">Giris Yap</a><br>
			<br>
		</sec:authorize> 
		<sec:authorize access="isAnonymous()">
			<a href="${pageContext.request.contextPath }/uyeOl">Uye Ol</a><br>
			<br>
		</sec:authorize> 
		<a href="${pageContext.request.contextPath }/kitapListesi">Kitap Listesi</a><br> 
		<sec:authorize access="isAuthenticated()">
			<a href="${pageContext.request.contextPath }/kiraladigimKitaplar">Kiraladigim Kitaplar</a>
			<br>
		</sec:authorize> 
		<sec:authorize access="hasRole('ADMIN')">
			<a href="${pageContext.request.contextPath }/yonetici">Yonetici Sayfasi</a>
			<br>
		</sec:authorize> 
		
		
		<c:url var="logoutUrl" value="/logout"></c:url>
		
		<form action="${logoutUrl }" method="post">
			<input type="submit" value="Log out !">
			<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
		
		</form>
</body>
</html>
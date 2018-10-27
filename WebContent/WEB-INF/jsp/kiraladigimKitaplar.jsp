<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body>
	<h1>KITAP LISTEM</h1>
<p>
	<form action="${pageContext.request.contextPath }/odemeYap" method="post">
	<table>
		<tr>
			<td></td>
			<td>Kitap Adi</td>
			<td>Yazar Adi</td>
			<td>Kiralama Ucreti</td>
		</tr>
			<c:forEach var="kitap" items="${kitapListesi }">
				<tr> 
					<td><input type="checkbox" name="kitapID" value="${kitap.kitapID }"></td> 
					<td>${kitap.kitapAdi }</td>
					<td>${kitap.yazarAdi }</td>  
					<td>${kitap.kiralamaUcreti }</td>
				</tr>
			</c:forEach>
		<tr>
			<td></td>
			<td></td>
			<td><sec:authorize access="isAuthenticated()"><input type="submit" value="Öde"></sec:authorize></td>
		</tr>
		</table>
		<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
	</form>
</body>
</html>
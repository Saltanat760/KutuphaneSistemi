<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	KITAP LISTESI
<p>
<table>
	<th>
		<td>Kitap Adi</td>
		<td>Yazar Adi</td>
		<td>Kiralama Ucreti</td>
	</th>
		<c:forEach var="kitap" items="${kitapListesi }">
			<tr> 
				<td>${kitap.kitapAdi }</td> 
				<td>${kitap.yazarAdi }</td>  
				<td>${kitap.kiralamaUcreti }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Kitap Ekleme

<form action="${pageContext.request.contextPath }/kitapEkle" method="POST">
	<table>
		<tr>
			<td>Kitap Adi : </td>
			<td><input type="text" name="kitapAdi" value=""></td>
		</tr>
		<tr>
			<td>Yazar Adi : </td>
			<td><input type="text" name="yazarAdi" value=""></td>
		</tr>
		<tr>
			<td>Kiralama Ücreti :</td>
			<td><input type="number" name="kiralamaUcreti" value=""></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Ekle"></td>
		</tr>
	</table>
		<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>

</form>

</body>
</html>
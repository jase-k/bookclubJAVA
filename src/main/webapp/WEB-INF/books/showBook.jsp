<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container w-50">
<div class="d-flex justify-content-between">
	<div>
		<h1><c:out value="${book.title}" ></c:out></h1>
	</div>
	<div>
		<a href="/logout" class="btn btn-danger">Logout</a>
		<a href="/books" class="btn btn-primary">Dashboard</a>
	</div>
</div>
<table class="table">
	<tr>
		<td>Author:</td>
		<td><c:out value="${book.author }"></c:out></td>
	</tr>
	<tr>
		<td>Thoughts from <c:out value="${book.user.userName }"></c:out>: </td>
		<td><c:out value="${book.myThoughts }"></c:out></td>
	</tr>
	<tr>
		<td>Added By: </td>
		<td><c:out value="${book.user.userName }"></c:out></td>
	</tr>
</table>
<c:if test="${book.user.id == user.id}">
	<a href="/books/${book.id }/edit" class="btn btn-info">Edit</a>
</c:if>
</div>

</body>
</html>
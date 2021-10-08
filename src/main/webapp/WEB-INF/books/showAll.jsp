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
		<h1>Welcome ${user.userName }</h1>
		<p>Books from Everyone Shelves </p>
	</div>
	<div>
		<a href="/logout" class="btn btn-danger">Logout</a>
				<a href="/books/new" class="btn btn-primary">+ Add to My Shelf</a>
	</div>
</div>
<table class="table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Added By</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="book" items="${books}" >
		<tr>
			<td><c:out value="${book.id}" ></c:out></td>
			<td><a href="/books/${book.id}"><c:out value="${book.title }"></c:out></a></td>
			<td><c:out value="${book.author}"></c:out></td>
			<td><c:out value="${book.user.userName }"></c:out></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>
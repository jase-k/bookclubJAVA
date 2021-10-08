<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
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
	<h1>New Book</h1>
	<div>
		<a href="/logout" class="btn btn-danger">Logout</a>
		<a href="/books" class="btn btn-primary">Dashboard</a>
	</div>
</div>
<form:form action="/books" method="post" modelAttribute="book" class="form-control">
	<p>
		<form:input type="hidden" path="user" value="${user.id}" />
	</p>
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="author">Author</form:label>
        <form:errors path="author"/>
        <form:textarea path="author"/>
    </p>
    <p>
        <form:label path="myThoughts">My Thoughts</form:label>
        <form:errors path="myThoughts"/>
        <form:textarea path="myThoughts"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>    

</div>
</body>
</html>
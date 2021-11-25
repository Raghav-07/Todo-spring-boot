<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<br>
<br>
<h1> YOUR TODOS </h1>
<div class="container">
		<table class="table">
<tr>
<th>ID</th>
<th>NAME </th>
<th>DESCRIPTION</th>
<th>TARGET_DATE</th>
<th>COMPLETED?</th>
<th> DELETE </th>
<th> UPDATE </th>
</tr>
<c:forEach items="${output}" var="item">
<tr>

<td> ${item.getId()}</td>
<td> ${item.getUser()}</td>
<td> ${item.getDesc()}</td>
<td> ${item.getTargetDate()}</td>
<td> ${item.isDone()}</td>
<td> <a type="button" class="btn btn-success" href="/updateTodo?id=${item.getId()}">Update</a>
<td> <a type="button" class="btn btn-warning" href="/deleteTodo?id=${item.getId()}">Delete</a>
</c:forEach>

</tr>
</div>
</table>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
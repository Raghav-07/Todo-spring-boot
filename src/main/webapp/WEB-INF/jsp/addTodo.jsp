<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 		<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 


<div class="container">
<form:form method="post" modelAttribute="todo">
<fieldset class="form-group">
<form:label path="id">ID:</form:label> 
<form:input type="number" path="id" class="form-control" required="required"/>

<form:label path="desc">DESCRIPTION:</form:label>
<form:input type="text" path="desc" class="form-control" required="required"/>

<form:label path="targetDate">TARGER DATE:</form:label>
<form:input type="Date" path="targetDate" class="form-control" required="required"/>

<form:label path="done">ISDONE:</form:label>
<form:checkbox path="done"/>

<br>
<form:errors path="desc"/>
<button type="submit" class="btn btn-success"> Submit </button>
</fieldset>
</form:form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
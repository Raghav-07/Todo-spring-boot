<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
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
<th> UPDATE </th>
<th> DELETE </th>
</tr>
<c:forEach items="${output}" var="item">
<tr>

<td> ${item.getId()}</td>
<td> ${item.getUser()}</td>
<td> ${item.getDesc()}</td>
<td><fmt:formatDate value="${item.getTargetDate()}" pattern="dd/MM/yyyy"/> </td>
<td> ${item.isDone()}</td>
<td> <a type="button" class="btn btn-success" href="/updateTodo?id=${item.getId()}">Update</a>
<td> <a type="button" class="btn btn-warning" href="/deleteTodo?id=${item.getId()}">Delete</a>
</c:forEach>

</tr>
</div>
</table>
</div>
<%@include file="common/footer.jspf" %>


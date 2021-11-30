
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
<form:form method="post" modelAttribute="todo">
<fieldset class="form-group">
<form:label path="id">ID:</form:label> 
<form:input type="number" path="id" class="form-control" required="required"/>

<form:label path="desc">DESCRIPTION:</form:label>
<form:input type="text" path="desc" class="form-control" required="required"/>

<form:label path="targetDate">TARGER DATE:</form:label>
<form:input type="text" path="targetDate" class="form-control" required="required"/> 

<%-- <form:label path="done">ISDONE:</form:label>
<form:checkbox path="done"/>  --%>

<br>
<form:errors path="desc"/>
<button type="submit" class="btn btn-success"> Submit </button>
</fieldset>
</form:form>
</div>
<%@include file="common/footer.jspf" %>

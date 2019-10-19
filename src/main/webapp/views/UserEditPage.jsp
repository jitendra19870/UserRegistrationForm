<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
readMode {
	background-color: blue;
}
</style>
</head>
<body>
	<h3>Welcome to Edit Page</h3>
	<form:form action="update" method="post" modelAttribute="user">
		<pre>
User ID  :<form:input path="userId" readOnly="true" cssClass="readMode" />
Name     :<form:input path="userName" />
Password :<form:password path="userPassword" />
Gender   :<form:radiobutton path="userGen" value="Male" />M
          <form:radiobutton path="userGen" value="Female" />F
        
Roles    :<form:checkbox path="userRoles" value="Admin" />Admin
          <form:checkbox path="userRoles" value="Employee" />Employee
City     :<form:select path="userCity">
          <form:option value="">-select-</form:option>
          <form:option value="Hyd">Hyd</form:option>
          <form:option value="Pune">Pune</form:option>
         </form:select>
         <input type="submit" value="update" />
</pre>
	</form:form>

</body>
</html>
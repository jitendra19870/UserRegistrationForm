<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.err {
	color: red;
}
</style>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(function() {
		$('form[id="userRegForm"]').validate({
			rules : {
				userName : 'required',
				userPassword : 'required',
				userGen : 'required',
				userRoles : 'required',
				userCity : 'required',
			},
			messages : {
				username : 'Please enter username',
				userPassword : 'please enter password',
				userGen : 'Please enter user gender',
				userRoles : 'please enter user roles',
				userCity : 'please enter user city',
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>

</head>
<body>
	<font color='green'>${SUCCESS}</font>
	<font color='red'>${ERROR}</font>
	<h3 align="center">USER REGISTRATION FORM</h3>

	<form:form action="save" method="post" modelAttribute="user"
		id="userRegForm">
		<table align="center">

			<tr>
				<td>NAME</td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="err" /></td>

			</tr>

			<tr>
				<td>PASSWORD</td>
				<td><form:password path="userPassword" /></td>
				<td><form:errors path="userPassword" cssClass="err" /></td>
			</tr>

			<tr>
				<td>GENDER</td>
				<td>Male<form:radiobutton path="userGen" value="Male" />
					Female<form:radiobutton path="userGen" value="Female" />
				</td>
				<td><form:errors path="userGen" cssClass="err" /></td>

			</tr>

			<tr>
				<td>ROLES</br></td>


				<td>Admin <form:checkbox path="userRoles" value="Admin" />
					Employee <form:checkbox path="userRoles" value="Employee" />
				</td>
				<td><form:errors path="userRoles" cssClass="err" /></td>
			</tr>


			<tr>
				<td>CITY</td>
				<td>
					<div align="center">
						<form:select path="userCity">
							<form:option value="">Select City</form:option>
							<form:option value="Hyd">Hyd</form:option>
							<form:option value="Pune">Pune</form:option>
						</form:select>
					</div>
				</td>
				<td><form:errors path="userCity" cssClass="err" /></td>
			</tr>


			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="register" /></td>

			</tr>


		</table>
	</form:form>

	<br />
	<a href="all">View All</a>
</body>
</html>
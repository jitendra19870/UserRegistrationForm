<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<c:if test="${empty list}">
		<h3>No Data Found</h3>
	</c:if>
	<c:if test="${! empty list}">
		<h2>User Data Page</h2>
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>PASSWORD</th>
					<th>GENDER</th>
					<th>ROLE</th>
					<th>CITY</th>
					<th>OPTION</th>

				</tr>
			</thead>
			<c:forEach items="${list}" var="ob">
				<tr>
					<%-- <td>${index.count}</td> --%>
					<td><c:out value="${ob.userId}" /></td>
					<td><c:out value="${ob.userName}" /></td>
					<td><c:out value="${ob.userPassword}" /></td>
					<td><c:out value="${ob.userGen}" /></td>
					<td><c:out value="${ob.userRoles}" /></td>
					<td><c:out value="${ob.userCity}" /></td>
					<td><a href="delete?userId=${ob.userId}">DELETE</a></td>
					<td><a href="edit?userId=${ob.userId}">EDIT</a></td>
				</tr>

			</c:forEach>
		</table>
		<%-- <c:forEach begin="1" end="${tp}" var="i">
		<a href="#"><c:out value="${i}" />

			<c:choose>
				<a href="all?pn=${i}"><c:out value="${i}" /> </a> &nbsp
			
				  <c:when test="${cp == 1}">
					<c:out value="${i}" />
				</c:when>
				<c:otherwise>
					<a href="all?pn=${i}"><c:out value="${i}"></c:out></a>
				</c:otherwise>
			</c:choose>		
		</c:forEach> --%>
	</c:if>
	${msg}
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css"
		href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css" />

	<script type="text/javascript"
		src="//cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">   -->
	<!-- $(document).ready(function () { 
    	 
    	 var datatableVariable = $('#usertab').DataTable({  
             data: json,  
             columns: [  
                 { 'data': 'userId' },  
                 { 'data': 'userName' },  
                 { 'data': 'userPassword' }
				 
                 ]
         });  
          $.ajax({  
             type: "POST",  
             dataType: "json",

             contentType: "application/json; charset=utf-8",
             url: "UserFormApp/rest/user/all",  
             success: function (data) {  
                 var datatableVariable = $('#usertab').DataTable({  
                     data: json,  
                     columns: [  
                         { 'data': 'userId' },  
                         { 'data': 'userName' },  
                         { 'data': 'userPassword' }
						 
                         ]
                 });  
                
               
                   
             }  
         });   */
  
     }); -->
	<!--  var json=[{"userId":20,"userName":"Ramsh","userPassword":"gdskl","userGen":"Male","userRoles":["Admin"],"userCity":"Hyd"},{"userId":19,"userName":"Ashok","userPassword":"fgdfjdg","userGen":"Male","userRoles":["Employee"],"userCity":"Hyd"},{"userId":12,"userName":"Raman","userPassword":"raman","userGen":"Male","userRoles":["Employee"],"userCity":"Pune"},{"userId":14,"userName":"Raghu","userPassword":"rrrr","userGen":"Male","userRoles":["Employee"],"userCity":"Hyd"},{"userId":16,"userName":"Amit","userPassword":"aniirt","userGen":"Male","userRoles":["Admin"],"userCity":"Hyd"},{"userId":17,"userName":"Rita","userPassword":"jsdgjk","userGen":"Female","userRoles":["Employee"],"userCity":"Hyd"},{"userId":18,"userName":"Nita","userPassword":"sdgsjdl","userGen":"Female","userRoles":["Admin"],"userCity":"Pune"},{"userId":21,"userName":"Harish","userPassword":"dsjjds","userGen":"Male","userRoles":["Employee"],"userCity":"Pune"}]; */ -->
	<!-- </script> -->


</body>

</html>
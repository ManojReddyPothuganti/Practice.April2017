<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form >
	<input type="submit" formaction="/EmployeeSpringMVc/viewAllEmployees" class="btnCreate" name="submit" id="submit" tabindex="8"
				value="ViewAll"> 
	
</form>
		
		<table class="sortable" id="myDummyTable" >
			
				<c:if test="${model.employees ne null}">
				<h4>Click on headers to sort the data after the table generation</h4>	
				<thead>
				<tr><th id="firstName">First Name</th><th id="lastName">Last Name</th><th id="salary">Salary</th><th id="address">Address</th><th>Gender</th><th>Employee Id</th></tr>
				</thead>
				</c:if>
			
			
			<tbody>
			<c:forEach items="${employees}" var="employee">
			
			
			<tr >
			  	
				<td>${employee.firstName} </td>
				<td>${employee.lastName}</td>
				<td>${employee.salary}</td>
				<td>${employee.address}</td>
				<td>${employee.gender}</td>
				<td>${employee.id} </td>
				
				
			</tr>
			
			
			
			</c:forEach>
			</tbody> 
		</table>



</body>
</html>
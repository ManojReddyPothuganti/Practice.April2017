<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateEmployee</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>

<style>
#panel, #flip {
	padding: 1px;
	text-align: center;
	border: solid 1px;
}

h5 {
	height: 670px;
	width: 332px;
	position: absolute;
	left: 45%;
	top: 70%;
	margin: -130px 0 0 -166px;
	font: 20px/22px Arial, Helvetica, Sans-serif;
}

#update {
	height: 670px;
	width: 332px;
	position: absolute;
	left: 45%;
	top: 90%;
	margin: -130px 0 0 -166px;
	font: 20px/22px Arial, Helvetica, Sans-serif;
}

.box {
	border: 1px;
	border-top: 1px;
	-webkit-border-radius: 1px;
	-moz-border-radius: 1px;
	border-radius: 1px;
	-moz-box-shadow: rgba(0, 0, 0, 0) 0 0 0px;
	-webkit-box-shadow: rgba(0, 0, 0, 0) 0 0 0px;
	box-shadow: rgba(0, 0, 0, 0) 0 0 0px;
	color: #000;
	font: normal 12px/14px Arial, Helvetica, Sans-serif;
	margin: 1 auto 1px;
	overflow: hidden;
}

.box.create {
	height: 670px;
	width: 332px;
	position: absolute;
	left: 45%;
	top: 30%;
	margin: -130px 0 0 -166px;
	font: 14px/22px Arial, Helvetica, Sans-serif;
}

#resultData {
	position: absolute;
	left: 10%;
	top: 40%;
	border: 1px solid black;
	border-collapse: collapse;
	padding: 2px 10px;
}

td, th {
	border-collapse: collapse;
	padding: 2px 10px;
	width: 100px;
}

th {
	cursor: n-resize;
	background-color: lightgrey;
}

.boxBody {
	background: #fefefe;
	border-top: 1px;
	border-bottom: 1px;
	padding: 0px 20px;
}

.box footer {
	background: #eff4f6;
	border-top: 2px;
	padding: 22px 26px;
	overflow: hidden;
	height: 32px;
}

.box label {
	display: block;
	font: 14px/22px Arial, Helvetica, Sans-serif;
	margin: 10px 0 0 6px;
}

#reg_label {
	display: block;
	font: 12px/12px Arial, Helvetica, Sans-serif;
	margin: 10px 0 0 6px;
}

.box footer label {
	float: left;
	margin: 4px 0 0;
}

.box footer input[type=checkbox] {
	vertical-align: sub;
	*vertical-align: middle;
	margin-right: 10px;
}

.box input[type=text], .box input[type=password], .txtField {
	border: 6px solid #F7F9FA;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	-moz-box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.06) inset, 0 0 1px #95a2a7
		inset;
	-webkit-box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.06) inset, 0 0 1px
		#95a2a7 inset;
	box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.06) inset, 0 0 1px #95a2a7 inset;
	margin: 3px 0 4px;
	padding: 8px 6px;
	width: 270px;
	display: block;
}

.box input[type=text]:focus, .box input[type=password]:focus, .txtField:focuss
	{
	border: 6px solid #f0f7fc;
	-moz-box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.04) inset, 0 0 1px #0d6db6
		inset;
	-webkit-box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.04) inset, 0 0 1px
		#0d6db6 inset;
	box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.04) inset, 0 0 1px #0d6db6 inset;
	color: #333;
}

.txtField.small {
	padding: 3px 6px;
	width: 200px;
	border-width: 3px !important;
}

.rLink {
	padding: 0 6px 0 0;
	font-size: 11px;
	float: right;
}

.box a {
	color: #999;
}

.box a:hover, .box a:focus {
	text-decoration: underline;
}

.box a:active {
	color: #f84747;
}

.btnCreate {
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 15px;
	background: #a1d8f0;
	background: -moz-linear-gradient(top, #badff3, #7acbed);
	background: -webkit-gradient(linear, left top, left bottom, from(#badff3),
		to(#7acbed));
	-ms-filter:
		"progid:DXImageTransform.Microsoft.gradient(startColorStr='#badff3', EndColorStr='#7acbed')";
	border: 1px solid #7db0cc !important;
	cursor: pointer;
	padding: 11px 16px;
	font: bold 11px/14px Verdana, Tahomma, Geneva;
	text-shadow: rgba(0, 0, 0, 0.2) 0 1px 0px;
	color: #fff;
	-moz-box-shadow: inset rgba(255, 255, 255, 0.6) 0 1px 1px,
		rgba(0, 0, 0, 0.1) 0 1px 1px;
	-webkit-box-shadow: inset rgba(255, 255, 255, 0.6) 0 1px 1px,
		rgba(0, 0, 0, 0.1) 0 1px 1px;
	box-shadow: inset rgba(255, 255, 255, 0.6) 0 1px 1px, rgba(0, 0, 0, 0.1)
		0 1px 1px;
	margin-left: 12px;
	float: right;
	padding: 7px 21px;
}

.btnCreate:hover, .btnCreate:focus, .btnCreate:active {
	background: #a1d8f0;
	background: -moz-linear-gradient(top, #7acbed, #badff3);
	background: -webkit-gradient(linear, left top, left bottom, from(#7acbed),
		to(#badff3));
	-ms-filter:
		"progid:DXImageTransform.Microsoft.gradient(startColorStr='#7acbed', EndColorStr='#badff3')";
}

.btnCreate:active {
	text-shadow: rgba(0, 0, 0, 0.3) 0 -1px 0px;
}

footer#main {
	position: fixed;
	left: 0;
	bottom: 10px;
	text-align: center;
	font: normal 11px/16px Arial, Helvetica, sans-serif;
	width: 100%;
}

table.sortable th:not (.sorttable_sorted ):not (.sorttable_sorted_reverse
	):not (.sorttable_nosort ):after {
	content: " \25B4\25BE"
}

DIV.table {
	display: table;
}

FORM.tr, DIV.tr {
	display: table-row;
}

SPAN.td {
	display: table-cell;
}
</style>




<script>
	$(function() {
		$("#myDummyTable").tablesorter({
			widgets : [ 'zebra' ]
		});
	});
</script>




</head>
<body>
	<h4 id="flip">Please enter employee id to query the employee and
		then update or delete</h4>
	<form action="/EmployeeWebApp/updateemployee?action=search" id="create"
		class="box create" method="post">
		<fieldset class="boxBody">

			<p>
				<label>Employee Id</label>
			</p>
			<input type="text" name="employeeId" tabindex="1"
				placeholder="employeeId" required> <input type="submit"
				class="btnCreate" name="submit" id="submit" tabindex="2"
				value="View">
			<a href="/EmployeeWebApp/home.html"><input type="button" class="btnCreate" value="Home"/></a>

		</fieldset>
	</form>

	<%
		boolean notFound = false;
	%>
	<c:if test="${requestScope.notFound eq true}">
		<h5>Employee with given Id not found</h5>
	</c:if>
	<c:if test="${requestScope.updated eq true}">
		<h5 id="update">Updated Successfully</h5>
	</c:if>
	<c:if test="${requestScope.deleted eq true}">
		<h5>Deleted Successfully</h5>
	</c:if>

	<c:if test="${requestScope.employee ne null}">
		<form
			action='<%=request.getContextPath()%>/updateemployee?action=update'
			id="resultData" method="post">
			<table>
				<tr>
					<th id="firstName">First Name</th>
					<th id="lastName">Last Name</th>
					<th id="salary">Salary</th>
					<th id="address">Address</th>
					<th>Gender</th>
				</tr>
				<tr>

					<td><input type="text"
						value='${requestScope.employee.firstName}' name="firstName"></td>
					<td><input type="text"
						value='${requestScope.employee.lastName}' name="lastName"></td>
					<td><input type="text" value='${requestScope.employee.salary}'
						pattern="^\d+|\d+.\d+$" title="Please enter only numbers"
						name="salary" required></td>
					<td><input type="text"
						value='${requestScope.employee.address}' name="address"></td>
					<td><input type="text" value='${requestScope.employee.gender}'
						readonly></td>
					<td><input type='hidden' name='employeeId'
						value='${requestScope.employee.id}' /> <input type="submit"
						formaction='<%=request.getContextPath()%>/updateemployee?action=update'
						value=update method="post"> <input type="submit"
						formaction='<%=request.getContextPath()%>/updateemployee?action=delete'
						value=delete method="post"></td>
				</tr>
			</table>
		</form>
	</c:if>




</body>
</html>




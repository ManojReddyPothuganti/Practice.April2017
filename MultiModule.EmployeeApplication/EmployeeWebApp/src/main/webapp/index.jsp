<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This is home page</title>
<style>
.btnCreate
{
    -moz-border-radius:2px;
    -webkit-border-radius:2px;
    border-radius:15px;
    background:#a1d8f0;
    background:-moz-linear-gradient(top, #badff3, #7acbed);
    background:-webkit-gradient(linear, left top, left bottom, from(#badff3), to(#7acbed));
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorStr='#badff3', EndColorStr='#7acbed')";
    border:1px solid #7db0cc !important;
    cursor: pointer;
    padding:11px 16px;
    font:bold 11px/14px Verdana, Tahomma, Geneva;
    text-shadow:rgba(0,0,0,0.2) 0 1px 0px; 
    color:#fff;
    -moz-box-shadow:inset rgba(255,255,255,0.6) 0 1px 1px, rgba(0,0,0,0.1) 0 1px 1px;
    -webkit-box-shadow:inset rgba(255,255,255,0.6) 0 1px 1px, rgba(0,0,0,0.1) 0 1px 1px;
    box-shadow:inset rgba(255,255,255,0.6) 0 1px 1px, rgba(0,0,0,0.1) 0 1px 1px;
    margin-left:12px;
	padding:7px 21px;
}



.btnCreate:hover,
.btnCreate:focus,
.btnCreate:active{
    background:#a1d8f0;
    background:-moz-linear-gradient(top, #7acbed, #badff3);
    background:-webkit-gradient(linear, left top, left bottom, from(#7acbed), to(#badff3));
	-ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorStr='#7acbed', EndColorStr='#badff3')";
}
.btnCreate:active
{
    text-shadow:rgba(0,0,0,0.3) 0 -1px 0px; 
}
</style>
</head>
<body>
	
	<a href="/EmployeeWebApp/CreateEmployee.jsp"><input type="button" class="btnCreate" value="Create Employee"/></a>
	<a href="/EmployeeWebApp/ViewEmployee.jsp"> <input type="button" class="btnCreate" value="View Employee"/></a>
	<a href="/EmployeeWebApp/UpdateEmployee.jsp"><input type="button" class="btnCreate" value="Update Employee"/></a> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Form</title>
</head>
<body>
<s:form action="EmpAction" method="post">
<s:textfield label="Enter Id" name="eid" value=""/>
<s:textfield label="Enter Name" name="name" value=""/>
<s:textfield label="Enter City" name="city" value=""/>
<s:textfield label="Enter Salary" name="salary" value="0"/>
	<s:submit action="saveEmpAction" value="Save Emp"/>
	<s:submit action="deleteEmpAction" value="Delete Emp"/>
	<s:submit action="updateEmpAction" value="Update Emp"/>
	<s:submit action="queryEmpAction" value="Query Emp"/>
	<s:submit action="showallEmpAction" value="ShowAll"/>
</s:form>
<hr>
<s:property value="message"/>
<hr>
<table border="1">
	<s:iterator value="emps">
	<tr>
	<td><s:property value="eid"/> </td> 
	<td><s:property value="name"/></td>
	<td><s:property value="city"/></td>
	<td><s:property value="salary"/></td>
	</tr>
</s:iterator>
</table>
</body>
</html>
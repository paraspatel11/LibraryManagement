<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Final Exam-Paras_Patel</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>


<h1>Index.jsp of Final Exam</h1>


<a href="/Location">Add Location</a>
	
	<br>
	<br>
	<br>
	
<a href="/Book">Add Book</a>
	
	<br>
	<br>
	<br>
	

<a href="/DummyRecords">Generate Dummy Records(1 Locations => 5 Books * 3)</a>
	<br>
	<p style="color: green;">${mess}</p>
		
	<br>
	<br>
	<br>

<a href="/ViewRecords">View Book Name based on Library Location</a>
	<br>
	<p style="color: red;">${messDel}</p>
		
	<br>
	<br>
	<br>
<a href="/ListOfBookName">Search Book Name based Title Name</a>
		
	<br>
	<br>
	<br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Book Names</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h1>List Of Books Based on Their Location (Campus)</h1>
	<c:url var="url" value="/ListBookName"></c:url>
	<form:form action="${url}" method="get" modelAttribute="book"> 
		
	List Of Location Name: <form:select path="location" >
					<form:options items="${listLocation}" />
			</form:select>	
	
	<input type="submit" value="Search Book at This Location" />
	</form:form>
	
	<br>
	<br>
	<br>
	<br>
	
	<table id="tabular">
	<tr>
		<th>Book Name</th><th>Book Author Name</th><th>Book Genre</th><th>Book Library Location</th>
	</tr>
	<c:forEach var="bookLi" items ="${bookList}">
	
	<tr>
		<td>${bookLi.bookName}</td>
		<td>${bookLi.author}</td>
		<td>${bookLi.genre}</td>
		<td>${bookLi.location}</td>
		<td>
			<a href="<c:url value="/delete/${bookLi.bookId}" />">Delete</a>
		</td>
	</tr>
	
	</c:forEach>
	
	</table>

<br>
<br>
<br>
<br>
<form:form action="/" method="get"> 
				<input style="background-color: navy;" type="submit" value="Home Page" />
</form:form>
</body>
</html>
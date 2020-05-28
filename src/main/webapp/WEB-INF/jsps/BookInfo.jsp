<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Book By Title</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h1>Search Books Based on Their Title Name</h1>
	<c:url var="url" value="/BookNameTitle"></c:url>
	<form:form action="${url}" method="get" modelAttribute="book"> 
		
	Search By Book Title Name:<form:input path="search" /><br>
	
	<input type="submit" value="Search Book with Title Name" />
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
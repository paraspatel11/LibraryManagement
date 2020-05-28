<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
	 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Add Book to Library</h1>

	<c:url var="url" value="/AddBook"></c:url>
	<form:form action="${url}" method="post" modelAttribute="book"> 
		Book Name: <form:input path="bookName"/><br/>
		Author Name: <form:input path="author"/><br/>
		Genre: <form:select items="${book.genreList}" path="genre" /><br>
		
		List Of Location Name: <form:select path="location">
				<form:options items="${listLocation}" />
		</form:select>	
		
		
		<input type="submit" value="Add Book" />
		<p style="color: red;">${mess}</p>
		
	</form:form>


<form:form action="/" method="get"> 
				<input style="background-color: navy;" type="submit" value="Home Page" />
</form:form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
	    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Location</title>
 <link rel="stylesheet" href="css/style.css">
 </head>
<body>
<h1>Add Library Location Here</h1>

	<c:url var="url" value="/AddLocation"></c:url>
	<form:form action="${url}" method="post" modelAttribute="location"> 
		Name: <form:input path="locationName"/><br/>
		Address: <form:input path="address"/><br/>
		Phone Number: <form:input path="phoneNum"/><br/>
		Store Hours: <form:input path="storeHours"/><br/>
		
		<input type="submit" value="Add Location" />
		<p style="color: red;">${mess}</p>
		
	</form:form>


<form:form action="/" method="get"> 
				<input style="background-color: navy;" type="submit" value="Home Page" />
</form:form>

</body>
</html>
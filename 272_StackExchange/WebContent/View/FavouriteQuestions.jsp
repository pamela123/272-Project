<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Servlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Most Scored Questions</title>

<link href="css/basic.css" type="text/css" rel="stylesheet" />
</head>
<body>
<%
	DataBean[] favouriteQuestions = (DataBean[])session.getAttribute("favouriteQuestions");
%>
<table border="1">
<tr>
	<th>Question</th>
	<th>Score</th>
	
	
</tr>
<%    for (int i=0; i < favouriteQuestions.length; i++)
    {      
%>
<tr>
		<td><%=favouriteQuestions[i].getFavouriteQuestion()%></td>
		<td><%=favouriteQuestions[i].getFavouriteCount()%></td>
		
		
		
	</tr>

<%
    }
%>
</table>

</body>
</html>
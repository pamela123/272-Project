<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-Up</title>
<style type="text/css">
body{
	text-align: center;
}
</style>
</head>
<body>
<%String table="webapps"; %>

<a href="TotalNoOfAnswersServlet?t=<%=table %>">Total Number of Answers per year(webapps)</a><br>
<a href="TotalNoOfQuestionsServlet?t=<%=table %>">Total Number of Questions per year(webapps)</a><br>
<a href="QuestionsPerHourServlet?t=<%=table %>">Total Number of Questions per hour(webapps)</a><br>
<a href="AnswersPerHourServlet?t=<%=table %>">Total Number of Answers per hour(webapps)</a><br>
<a href="QuesInTopTags?t=<%=table %>">Total number of questions in top 10 tags(webapps)</a><br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="Header.jsp" %>
<%String table="stackoverflow"; %>

<a href="TotalNoOfAnswersServlet?t=<%=table %>">Total Number of Answers per year(stackoverflow)</a><br>
<a href="TotalNoOfQuestionsServlet?t=<%=table %>">Total Number of Questions per year(stackoverflow)</a><br>
<a href="QuestionsPerHourServlet?t=<%=table %>">Total Number of Questions per hour(stackoverflow)</a><br>
<a href="AnswersPerHourServlet?t=<%=table %>">Total Number of Answers per hour(stackoverflow)</a><br>
<a href="QuesInTopTags?t=<%=table %>">Total number of questions in top 10 tags(stackoverflow)</a><br>
</body>
</html>
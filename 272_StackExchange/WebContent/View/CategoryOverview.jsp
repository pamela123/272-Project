<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Servlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-Up</title>

<link href="css/basic.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="js/enhance.js"></script>	
	<script type="text/javascript">
		// Run capabilities test
		enhance({
			loadScripts: [
				{src: 'js/excanvas.js', iecondition: 'all'},
				'js/jquery.js',
				'js/visualize.jQuery.js',
				'js/line.js'
			],
			loadStyles: [
				'css/visualize.css',
				'css/visualize-dark.css'
			]	
		});   
    </script>
</head>
<body>
<%
	DataBean[] totalAnswersPerYear = (DataBean[])session.getAttribute("totalAnswersPerYear");
	DataBean[] totalQuestionsPerYear = (DataBean[])session.getAttribute("totalQuestionsPerYear");
%>
<table border="1">
	<caption>Total number of questions and answers</caption>
		<thead>
			<tr>
				<td></td>
				<%    for (int i=0; i < totalAnswersPerYear.length; i++)
	    {      
	%>
				<th scope="col"><%=totalQuestionsPerYear[i].getCreationYear()%></th>
				
	<%
	    }
	%>
			</tr>
		</thead>
		
		<tbody>
		<tr>
			<th scope="row">Questions</th>
	<%    for (int i=0; i < totalQuestionsPerYear.length; i++)
	    {      
	%>
		
			<td><%=totalQuestionsPerYear[i].getTotalQuestions()%></td>
			
		
	
	<%
	    }
	%>
	</tr>
		<tr>
			<th scope="row">Answers</th>
	<%    for (int i=0; i < totalAnswersPerYear.length; i++)
	    {      
	%>
		
			<td><%=totalAnswersPerYear[i].getTotalAnswers()%></td>
			
		
	
	<%
	    }
	%>
	</tr>
	</tbody>
</table>
</body>
</html>
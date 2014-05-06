<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Servlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Overview</title>

<link href="css/basic.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="js/enhance.js"></script>	
	<script type="text/javascript">
		// Run capabilities test
		enhance({
			loadScripts: [
				{src: 'js/excanvas.js', iecondition: 'all'},
				'js/jquery.js',
				'js/visualize.jQuery.js',
				'js/pie.js'
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
	int[] totalQuestionsOverview = (int[])session.getAttribute("totalQuestionsOverview");
%>
<table >
	<caption>No of questions per hour</caption>
	<thead>
		<tr>
			<td></td>
			<th scope="col">Questions Overview</th>
			
		</tr>
	</thead>
	<tbody>
		<tr>
			<th scope="row">Programmers</th>
			<td><%=totalQuestionsOverview[0]%></td>
			
		</tr>
		<tr>
			<th scope="row">DBA</th>
			<td><%=totalQuestionsOverview[1]%></td>
			
		</tr>
		<tr>
			<th scope="row">Web Apps</th>
			
			<td><%=totalQuestionsOverview[2]%></td>
			
		</tr>
		<tr>
			<th scope="row">Stack Overflow</th>
			
			<td><%=totalQuestionsOverview[3]%></td>
			
		</tr>
		<tr>
			<th scope="row">Android</th>
			<td><%=totalQuestionsOverview[4]%></td>
			
		</tr>			
	</tbody>
</table>	
</body>
</html>
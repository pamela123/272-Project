<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Servlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-Up</title>

<link href="css/basic.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="http://filamentgroup.github.com/EnhanceJS/enhance.js"></script>	
	<script type="text/javascript">
		// Run capabilities test
		enhance({
			loadScripts: [
				{src: 'js/excanvas.js', iecondition: 'all'},
				'js/jquery.js',
				'js/visualize.jQuery.js',
				'js/bar.js'
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
	DataBean[] quesPerHour = (DataBean[])session.getAttribute("totalQuesPerHour");
%>
<table border="1">
	<caption>No of Questions per hour</caption>
		<thead>
			<tr>
				<td></td>
				
				<th scope="col">Number of Questions per Hour</th>
				
			</tr>
		</thead>
		
		<tbody>
	<%    for (int i=0; i < quesPerHour.length; i++)
	    {      
	%>
		<tr>
			<th scope="row"><%=quesPerHour[i].getCreationHour()%></th>
			<td><%=quesPerHour[i].getTotalQuestions()%></td>			
		</tr>
	
	<%
	    }
	%>
	</tbody>
</table>
</body>
</html>
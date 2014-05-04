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
	Welcome to this test Page
<%
	DataBean[] topTagesPerYear = (DataBean[])session.getAttribute("topTagesPerYear");
%>
<table border="1">
	<caption>Top 5 tags</caption>
		<thead>
			<tr>
				<td></td>
				
				<th scope="col">Top 5 tags</th>
				
			</tr>
		</thead>
		
		<tbody>
	<%    for (int i=0; i < topTagesPerYear.length; i++)
	    {  
	    	String tagValue =topTagesPerYear[i].getTags(); 
	    	tagValue=tagValue.replace("<", "");   
	    	tagValue=tagValue.replace(">", ""); 
	%>
				
				
		<tr>
			<th scope="row"><%=tagValue%></th>
			<td><%=topTagesPerYear[i].getTotalQuestions()%></td>
			
		</tr>
	
	<%
	    }
	%>
	</tbody>
</table>
</body>
</html>
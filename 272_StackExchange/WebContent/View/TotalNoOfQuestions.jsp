<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Servlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Total Questions</title>

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
<style>
    	table{display:none;}
    	.enhanced_toggleResult{display:none;}
    	.enter{height:488px !important; }
    	.visualize{
			float: left;
			margin-left: 160px;}
.visualize-labels-y li span.label{padding-right: 0px !important;margin-right: 0px !important;}
    </style>
</head>
<%@include file="Header.jsp" %>
<body>
	<%String t =(String)session.getAttribute("tableName");%>
	<%String sessionVar = t + "_totalQuestionsPerYear";
DataBean[] totalQuestionsPerYear = (DataBean[])session.getAttribute(sessionVar);
int year = 2011;
 %>
<div class="section_slogan"><span class="cursive"><%=t%> Analysis </span></div>
<middle>    
      <div class="enter">
      <div style="float:left;">
      	<ul>
      		
      		<li><a href="TotalNoOfAnswersServlet?t=<%=t%>">Answers</a></li>
      		<li>Questions</li>
      		<ul>
      			<li><a href="TotalNoOfQuestionsServlet?t=<%=t%>">Number of Questions per year</a></li>
      			<li><a href="QuestionsPerHourServlet?t=<%=t%>">Number of Questions per hour</a></li>
      		</ul>
			<li><a href="QuesInTopTags?t=<%=t%>">Tags</a></li>
			<li><a href="FavouriteQuestions?t=<%=t%>">Favorite questions</a></li>
			<li><a href="MostScoredQuestions?t=<%=t%>">Most scored questions</a></li>
							
 	     	</ul>
      </div>
<table border="1" style="float:left;">
	<caption>No of Questions per year</caption>
		<thead>
			<tr>
				<td></td>
				
				<th scope="col"></th>
				
			</tr>
		</thead>
		
		<tbody>
	<%    for (int i=0; i < totalQuestionsPerYear.length; i++)
	    {      
	%>
		<tr>
			<th scope="row"><%=totalQuestionsPerYear[i].getCreationYear()%></th>
			<td><%=totalQuestionsPerYear[i].getTotalQuestions()%></td>			
		</tr>
	
	<%
	    }
	%>
	</tbody>
</table>
</div>
 </middle>
</body>
</html>
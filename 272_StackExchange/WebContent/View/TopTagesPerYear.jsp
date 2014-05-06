<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Servlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Top Tags/Year</title>

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
    </style>
</head>
<%@include file="Header.jsp" %>
<body>
	
 <%String t =(String)session.getAttribute("tableName");%>
	<%String sessionVar = t + "_topTagesPerYear";
	int y = (Integer)session.getAttribute("year");
	sessionVar = sessionVar + "_" + y;
DataBean[] topTagesPerYear = (DataBean[])session.getAttribute(sessionVar);
 %>
<%
	int year1 = 2011;
	int year2 = 2012;
	int year3 = 2013;
	int year4 = 2014;
%>

<div class="section_slogan"><span class="cursive"><%=t%> Analysis </span></div>
<middle>    
      <div class="enter">
      <div style="float:left;">
      	<ul>
      		
      		<li><a href="TotalNoOfAnswersServlet?t=<%=t%>">Answers</a></li>
      		<li><a href="TotalNoOfQuestionsServlet?t=<%=t%>">Questions</a></li>
			<li>Tags</li>
				<ul>
					<li><a href="TopTagesPerYearServlet?t=<%=t%>&y=<%=year1 %>">Top tags in 2011</a></li>
					<li><a href="TopTagesPerYearServlet?t=<%=t%>&y=<%=year2 %>">Top tags in 2012</a></li>
					<li><a href="TopTagesPerYearServlet?t=<%=t%>&y=<%=year3 %>">Top tags in 2013</a></li>
					<li><a href="TopTagesPerYearServlet?t=<%=t%>&y=<%=year4 %>">Top tags in 2014</a></li>
				</ul>
			<li><a href="FavouriteQuestions?t=<%=t%>">Favorite questions</a></li>
			<li><a href="MostScoredQuestions?t=<%=t%>">Most scored questions</a></li>
							
 	     	</ul>
      </div>
<table border="1" style="float:left;">
	<caption>Top 5 tags in </caption>
		<thead>
			<tr>
				<td></td>
				
				<th scope="col"></th>
				
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
</div>
 </middle>
</body>
</html>
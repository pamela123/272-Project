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
				'js/line.js'
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
			margin-left: 238px;}
    </style>
</head>
<%@include file="Header.jsp" %>
<body>
<%String t =(String)session.getAttribute("tableName");

%>

<%
String sessionVar = t + "_totalAnswersPerYear";
DataBean[] totalAnswersPerYear = (DataBean[])session.getAttribute(sessionVar);
 sessionVar = t + "_totalQuestionsPerYear";
DataBean[] totalQuestionsPerYear = (DataBean[])session.getAttribute(sessionVar);

//DataBean[] totalAnswersPerYear = (DataBean[])session.getAttribute("totalAnswersPerYear");
//DataBean[] totalQuestionsPerYear = (DataBean[])session.getAttribute("totalQuestionsPerYear");

/*DataBean[] totalAnswersPerYear=null;
DataBean[] totalQuestionsPerYear=null;*/

/*if(t.equalsIgnoreCase("programmer")){
			totalAnswersPerYear = (DataBean[])session.getAttribute("p_totalAnswersPerYear");
			totalQuestionsPerYear = (DataBean[])session.getAttribute("p_totalQuestionsPerYear");	
}else if(t.equalsIgnoreCase("dba")){
	 totalAnswersPerYear = (DataBean[])session.getAttribute("d_totalAnswersPerYear");
	 totalQuestionsPerYear = (DataBean[])session.getAttribute("d_totalQuestionsPerYear");	
}else if(t.equalsIgnoreCase("webapps")){
	 totalAnswersPerYear = (DataBean[])session.getAttribute("w_totalAnswersPerYear");
	 totalQuestionsPerYear = (DataBean[])session.getAttribute("w_totalQuestionsPerYear");	
}else if(t.equalsIgnoreCase("android")){
	 totalAnswersPerYear = (DataBean[])session.getAttribute("a_totalAnswersPerYear");
	 totalQuestionsPerYear = (DataBean[])session.getAttribute("a_totalQuestionsPerYear");	
}else if(t.equalsIgnoreCase("stackoverflow")){
	 totalAnswersPerYear = (DataBean[])session.getAttribute("s_totalAnswersPerYear");
	 totalQuestionsPerYear = (DataBean[])session.getAttribute("s_totalQuestionsPerYear");	
}else{
	totalAnswersPerYear = (DataBean[])session.getAttribute("p_totalAnswersPerYear");
	 totalQuestionsPerYear = (DataBean[])session.getAttribute("p_totalQuestionsPerYear");
	}*/

int year = 2011;
%>

<div class="section_slogan"><span class="cursive"><%=t%> Analysis </span></div>
<middle>    
      <div class="enter">
      <div style="float:left;">
      	<ul>
      		<li><a href="TotalNoOfAnswersServlet?t=<%=t%>">Answers</a></li>
      		<li><a href="TotalNoOfQuestionsServlet?t=<%=t%>">Questions</a></li>
			<li><a href="QuesInTopTags?t=<%=t%>">Tags</a></li>
			<li><a href="FavouriteQuestions?t=<%=t%>">Favorite Questions</a></li>
			<li><a href="MostScoredQuestions?t=<%=t%>">Most scored Questions</a></li>
							
 	     	</ul>
      </div>
      	
		
  
   
<table border="1" style="float:left;">
	<caption>Total number of questions and answers</caption>
		<thead>
			<tr>
				<td></td>
				 
				<%    for (int i=0; i < 4; i++)
	    {      
	%>
				<th scope="col"><%=totalAnswersPerYear[i].getCreationYear()%></th>
				
	<%
	    }
	%>
			</tr>
		</thead>
			<tbody>
		<tr>
			<th scope="row">Questions</th>
	<%   for (int i=0; i < 4; i++)
	    {      
	%>
		
			<td><%=totalQuestionsPerYear[i].getTotalQuestions()%></td>
			
		
	
	<%
	   }
	%>
	</tr>
		<tr>
			<th scope="row">Answers</th>
	<%    for (int i=0; i < 4; i++)
	    {      
	%>
		
			<td><%=totalAnswersPerYear[i].getTotalAnswers()%></td>
			
		
	
	<%
	    }
	%>
	</tr>
	</tbody>
	
</table>
</div>
 </middle>
</body>
</html>
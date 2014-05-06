<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Servlets.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Favorite Questions</title>

<link href="css/basic.css" type="text/css" rel="stylesheet" />
<style>
    	
    	.enhanced_toggleResult{display:none;}
    	.enter{height:600px !important;padding-bottom: 40px }
    	#box-table-a {
font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
font-size: 12px;
width:630px;
text-align: left;
border-collapse: collapse;
margin:40px 10px 0 0;
}
#box-table-a td {
background: #e8edff;
border-bottom: 1px solid #fff;
border-top: 1px solid transparent;
padding: 8px;
color:#339;
font-weight: bolder;
}
#box-table-a th {
font-weight: bolder;
font-size: 13px;
font-weight: normal;
background: #b9c9fe;
border-top: 4px solid #aabcfe;
border-bottom: 1px solid #fff;
color: #039;
padding: 8px;
}
    	
    </style>
</head>
<%@include file="Header.jsp" %>
<body>
<%String t =(String)session.getAttribute("tableName");%>
	<%String sessionVar = t + "_favouriteQuestions";
DataBean[] favouriteQuestions = (DataBean[])session.getAttribute(sessionVar);
 %>
<%
	
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
			<li>Favorite questions</li>
			<li><a href="MostScoredQuestions?t=<%=t%>">Most scored questions</a></li>
							
 	     	</ul>
      </div>
<table border="1" style="float:right;" id="box-table-a">
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
</div>
 </middle>
</body>
</html>
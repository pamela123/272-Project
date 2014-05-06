<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="Header.jsp" %>
<%String table="programmer"; %>
<%int year=2011; %>
<div class="section_slogan"><span class="cursive">Programmer Analysis </span></div>
<middle>    
      <div class="enter">
      <div style="float:left;">
      	<ul>
      		<li><a href="TotalNoOfAnswersServlet?t=<%=table %>">Total Number of Answers per year</a></li>
			<li><a href="TotalNoOfQuestionsServlet?t=<%=table %>">Total Number of Questions per year</a></li>
			<li><a href="QuestionsPerHourServlet?t=<%=table %>">Total Number of Questions per hour</a></li>
			<li><a href="AnswersPerHourServlet?t=<%=table %>">Total Number of Answers per hour</a></li>
			<li><a href="QuesInTopTags?t=<%=table %>">Total number of questions in top 10 tags</a></li>
			<li><a href="CategoryOverview?t=<%=table %>">Total Number of Questions and Answers per year</a></li>
			<li><a href="MostScoredQuestions?t=<%=table %>">Most scored questions</a></li>
			<li><a href="FavouriteQuestions?t=<%=table %>">Favorite Questions</a></li>
			<li><a href="TopTagesPerYearServlet?t=<%=table %>&y=<%=year %>">Top 5 tags for year 2011</a></li>
 	     	</ul>
      </div>
      	
		</div>
  
    </middle>

</body>
</html>
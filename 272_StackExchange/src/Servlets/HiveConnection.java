package Servlets;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

import org.apache.hadoop.hive.jdbc.*;




public class HiveConnection {
	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	/**
	* @param args
	* @throws SQLException
	**/
	Connection con = null;
	static ResultSet rs;
    Statement stmt = null;
	HiveConnection(){
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection("jdbc:hive://54.186.188.245:10000/default", "", "");
			stmt = con.createStatement();
		} catch (ClassNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		/*String tableName = "testHiveDriverTable";
		stmt.executeQuery("drop table " + tableName);
		ResultSet res = stmt.executeQuery("create table " + tableName + " (key int, value string)");*/
		
		
	}
	public DataBean[] TotalNoOfAnswers(String tableName) throws SQLException {
		System.out.println("hive function called");
		String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
		int result =0;
		ResultSet res = null;
		
		// show tables
		
		
		String sql = "Select CreationYear,count(*) as Total from " + tableName + " where postTypeId=2 and creationYear >=2011 group by CreationYear";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		DataBean[] totalAnswersPerYear = new DataBean[4];
		int i=0;
		while(res.next())
		{
			totalAnswersPerYear[i] = new DataBean();
			System.out.println(String.valueOf(res.getInt(1)));
			System.out.println(String.valueOf(res.getInt(2)));
			totalAnswersPerYear[i].setCreationYear(String.valueOf(res.getInt(1)));
			totalAnswersPerYear[i].setTotalAnswers(String.valueOf(res.getInt(2)));
			i++;
		}
		while (res.next()){
			System.out.println(String.valueOf(res.getInt(1)));
			System.out.println(String.valueOf(res.getInt(2)));
			
		}
				
	return totalAnswersPerYear;
	}
	
	public DataBean[] TotalNoOfQuestions(String tableName) throws SQLException {
		String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
		int result =0;
		ResultSet res = null;
		
		// show tables
		
		
		String sql = "Select CreationYear,count(*) as Total from " + tableName + " where postTypeId=1 and creationYear >= 2011 group by CreationYear";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		DataBean[] totalQuestionsPerYear = new DataBean[4];
		int i=0;
		while(res.next())
		{
			totalQuestionsPerYear[i] = new DataBean();
			System.out.println(String.valueOf(res.getInt(1)));
			System.out.println(String.valueOf(res.getInt(2)));
			totalQuestionsPerYear[i].setCreationYear(String.valueOf(res.getInt(1)));
			totalQuestionsPerYear[i].setTotalQuestions(String.valueOf(res.getInt(2)));
			i++;
		}
		
				
	return totalQuestionsPerYear;
	}
	
	public DataBean[] TotalNoOfQuestionsHour(String tableName) throws SQLException {
		String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
		int result =0;
		ResultSet res = null;
						
		String sql = "Select CreationHour,count(*) as Total from " + tableName + " where postTypeId = 1 group by CreationHour";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		//res.last();
		//int numRows = res.getRow();
		//res.beforeFirst();
		//System.out.println("numRows:" + numRows);
		DataBean[] totalQuestionsPerHour = new DataBean[24];
		int i=0;
		while(res.next())
		{
			totalQuestionsPerHour[i] = new DataBean();
			System.out.println(String.valueOf(res.getInt(1)));
			System.out.println(String.valueOf(res.getInt(2)));
			totalQuestionsPerHour[i].setCreationHour(String.valueOf(res.getInt(1)));
			totalQuestionsPerHour[i].setTotalQuestions(String.valueOf(res.getInt(2)));
			i++;
		}
		
				
	return totalQuestionsPerHour;
	}
	
	public DataBean[] TotalNoOfAnswersHour(String tableName) throws SQLException {
		String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
		int result =0;
		ResultSet res = null;
						
		String sql = "Select CreationHour,count(*) as Total from " + tableName + " where postTypeId = 2  group by CreationHour";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		//res.last();
		//int numRows = res.getRow();
		//res.beforeFirst();
		//System.out.println("numRows:" + numRows);
		DataBean[] totalAnswersPerHour = new DataBean[24];
		int i=0;
		while(res.next())
		{
			totalAnswersPerHour[i] = new DataBean();
			System.out.println(String.valueOf(res.getInt(1)));
			System.out.println(String.valueOf(res.getInt(2)));
			totalAnswersPerHour[i].setCreationHour(String.valueOf(res.getInt(1)));
			totalAnswersPerHour[i].setTotalAnswers(String.valueOf(res.getInt(2)));
			i++;
		}
		
				
	return totalAnswersPerHour;
	}
	
	public DataBean[] QuesInTopTags(String tableName) throws SQLException {
		
		ResultSet res = null;
						
		String sql = "select result.cnt,result.tag from (select count(*) as cnt ,tag from (select id,tag from "+ tableName + " lateral view explode(tags) temp as tag where postTypeId=1) t group by t.tag) result order by result.cnt desc limit 10";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		//res.last();
		//int numRows = res.getRow();
		//res.beforeFirst();
		//System.out.println("numRows:" + numRows);
		DataBean[] quesPerTag = new DataBean[10];
		int i=0;
		while(res.next())
		{
			quesPerTag[i] = new DataBean();
			System.out.println(String.valueOf(res.getInt(1)));
			System.out.println(String.valueOf(res.getString(2)));
			quesPerTag[i].setTotalQuestions(String.valueOf(res.getInt(1)));
			quesPerTag[i].setTags(String.valueOf(res.getString(2)));
			System.out.println(quesPerTag[i].getTags());
			i++;
		}				
	return quesPerTag;
	}
	
	public DataBean[] MostScoredQuestions(String tableName) throws SQLException {
		ResultSet res = null;
		
		// show tables
		
		
		String sql = "select title, score from "+tableName+" where postTypeID=1 order by score desc limit 10";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		DataBean[] mostScoredQuestions = new DataBean[10];
		int i=0;
		while(res.next())
		{
			mostScoredQuestions[i] = new DataBean();
			System.out.println(String.valueOf(res.getString(1)));
			System.out.println(String.valueOf(res.getInt(2)));
			mostScoredQuestions[i].setMostScoredQuestion(String.valueOf(res.getString(1)));
			mostScoredQuestions[i].setScore(String.valueOf(res.getInt(2)));
			i++;
		}
		
				
	return mostScoredQuestions;
	}
	
	public DataBean[] FavouriteQuestions(String tableName) throws SQLException {
		ResultSet res = null;
		String sql = "select title, favoriteCount from "+tableName+" where postTypeID=1 order by favoriteCount desc limit 10";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		DataBean[] favouriteQuestions = new DataBean[10];
		int i=0;
		while(res.next())
		{
			favouriteQuestions[i] = new DataBean();
			System.out.println(String.valueOf(res.getString(1)));
			System.out.println(String.valueOf(res.getInt(2)));
			favouriteQuestions[i].setFavouriteQuestion(String.valueOf(res.getString(1)));
			favouriteQuestions[i].setFavouriteCount(String.valueOf(res.getInt(2)));
			i++;
		}
	return favouriteQuestions;
	}
	
	public int[] OverviewQuestions() throws SQLException {
		ResultSet res1 = null;
		int[] overview = new int[5];
		String sql1;
		
		sql1 = "select count(*) from programmer where postTypeID=1 ";	
		System.out.println("Running: " + sql1);
		res1 = stmt.executeQuery(sql1);
		while(res1.next())
		{
			overview[0] = res1.getInt(1);
			System.out.println(String.valueOf(res1.getInt(1)));
		}
		
		sql1 ="select count(*) from dba where postTypeID=1 ";	
		System.out.println("Running: " + sql1);
		res1 = stmt.executeQuery(sql1);
		while(res1.next())
		{
			overview[1] = res1.getInt(1);
			System.out.println(String.valueOf(res1.getInt(1)));
		}
		
		sql1 ="select count(*) from webapps where postTypeID=1 ";	
		System.out.println("Running: " + sql1);
		res1 = stmt.executeQuery(sql1);
		while(res1.next())
		{
			overview[2] = res1.getInt(1);
			System.out.println(String.valueOf(res1.getInt(1)));
		}
		
		sql1 ="select count(*) from stackoverflow where postTypeID=1 ";	
		System.out.println("Running: " + sql1);
		res1 = stmt.executeQuery(sql1);
		while(res1.next())
		{
			overview[3] = res1.getInt(1);
			System.out.println(String.valueOf(res1.getInt(1)));
		}
		
		sql1 ="select count(*) from android where postTypeID=1 ";	
		System.out.println("Running: " + sql1);
		res1 = stmt.executeQuery(sql1);
		while(res1.next())
		{
			overview[4] = res1.getInt(1);
			System.out.println(String.valueOf(res1.getInt(1)));
		}
	return overview;
	}
	public DataBean[] TopTagesPerYear(String tableName,int year) throws SQLException {
		ResultSet res = null;
		String sql = "select result.* from (select count(*) as cnt ,tag, year from (select id,creationYear year,tag from "+tableName+" lateral view explode(tags) temp as tag) t group by t.tag,t.year) result where year="+year+" order by result.cnt desc limit 5";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		DataBean[] topTagesPerYear = new DataBean[5];
		int i=0;
		while(res.next())
		{
			topTagesPerYear[i] = new DataBean();
			System.out.println(String.valueOf(res.getInt(1)));
			System.out.println(String.valueOf(res.getString(2)));
			topTagesPerYear[i].setTotalQuestions(String.valueOf(res.getInt(1)));
			topTagesPerYear[i].setTags(String.valueOf(res.getString(2)));
			topTagesPerYear[i].setCreationYear(String.valueOf(res.getInt(3)));
			i++;
		}
	return topTagesPerYear;
	}

}


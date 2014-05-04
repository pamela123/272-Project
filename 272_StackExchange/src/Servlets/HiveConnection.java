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
		
		
		String sql = "Select CreationYear,count(*) as Total from "+tableName+" where postTypeId=2 group by CreationYear";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		DataBean[] totalAnswersPerYear = new DataBean[7];
		int i=0;
		while(res.next())
		{
			totalAnswersPerYear[i] = new DataBean();
			System.out.println(String.valueOf(res.getInt(1)));
			System.out.println(String.valueOf(res.getInt(2)));
			totalAnswersPerYear[i].setCreationYear(String.valueOf(res.getInt(1)));
			totalAnswersPerYear[i].setTotalAnswers(String.valueOf(res.getInt(2)));
			//hm.put(i,productList[i]);
			//al.add(productList[i]);
			i++;
		}
		while (res.next()){
			System.out.println(String.valueOf(res.getInt(1)));
			System.out.println(String.valueOf(res.getInt(2)));
			
		}
		// regular hive query
		/*sql = "select count(1) from " + tableName;
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
		while (res.next()){
			System.out.println(res.getString(1));
		}*/
	return totalAnswersPerYear;
	}
	public void overview(){
		
	}
}


package Servlets;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import org.apache.hadoop.hive.jdbc.*;

public class HiveClient {
	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	/**
	* @param args
	* @throws SQLException
	**/
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		Connection con = DriverManager.getConnection("jdbc:hive://54.186.188.245:10000/default", "", "");
		Statement stmt = con.createStatement();
		/*String tableName = "testHiveDriverTable";
		stmt.executeQuery("drop table " + tableName);
		ResultSet res = stmt.executeQuery("create table " + tableName + " (key int, value string)");*/
		ResultSet res = null;
		// show tables
		
		
		String sql = "Select CreationYear,count(*) as Total from programmer where postTypeId=2 group by CreationYear";
		System.out.println("Running: " + sql);
		res = stmt.executeQuery(sql);
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
	}
}


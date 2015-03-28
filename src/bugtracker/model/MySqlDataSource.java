package bugtracker.model;

import java.io.*;
import java.sql.*;

public class MySqlDataSource {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/bugtrack";
	//  Database credentials
	static final String USER = "dumber";
	static final String PASS = "asdfQq22";
	Connection conn = null;
	Statement stmt = null;
	
	public MySqlDataSource() throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// Register JDBC driver
		Class.forName(JDBC_DRIVER).newInstance();
		
		// Open a connection
		System.out.println("Connecting to database...");
	    conn = DriverManager.getConnection(DB_URL,USER,PASS);
	    stmt = conn.createStatement();
	}
	
	public void executeQueries() throws SQLException {
	    String sql = "select * from priorities";
	    ResultSet rs = stmt.executeQuery(sql);
	    while (rs.next()) {
	    	int id = rs.getInt("pr_id");
	    	String priority = rs.getString("priority");
	    	System.out.println("ID" + id);
	    	System.out.println("Priority" + priority);
	    }
		rs.close();
	}
	
	public void MySqlDataSourceCloser() throws SQLException {	      
	      stmt.close();
	      conn.close();
	}
}

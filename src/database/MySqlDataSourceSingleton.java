/**
 * 
 */
package database;


import java.sql.*;

/** 
 * 
 * @since 1.0
 * @author dumber
 * @version 1.1 
 *
 */
public class MySqlDataSourceSingleton {
	private static MySqlDataSourceSingleton instance = null;	
	
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost:3306/bugtrack";
	
	private Connection conn = null;
	private Statement stmt = null;
	
	private String sql_command;
	private ResultSet rs;
	
	protected MySqlDataSourceSingleton() {
		// Exists only to defeat instantiation.
	}
	
	public static MySqlDataSourceSingleton getInstance()  {
		if(instance == null) {
	         instance = new MySqlDataSourceSingleton();
	      }
	    return instance;
		
	}
	
	public void setupConnection(String user, String passw) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// Register JDBC driver
		Class.forName(JDBC_DRIVER).newInstance();		
		// Open a connection
		System.out.println("Connecting to database...");
	    conn = DriverManager.getConnection(DB_URL, user, passw);
	    stmt = conn.createStatement();
	}
	
	public void executeQueryDemo() throws SQLException {
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

	public void MySqlDataSourceCloseConections() throws SQLException {		
	    stmt.close();
	    conn.close();
	}

	public Statement getStmt() {
		return stmt;
	}
	
	public String getSqlCommand() {
		return sql_command;
	}

	public void setSqlCommand(String sql) {
		this.sql_command = sql;
	}

	public ResultSet getResultSet() {
		return rs;
	}

	public void setResultSet(ResultSet rs) {
		this.rs = rs;
	}
}

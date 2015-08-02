/**
 * 
 */
package database;


import java.sql.*;

/** 
 * 
 * @author dumber
 *
 */
public class MySqlDataSourceSingleton {
	private static MySqlDataSourceSingleton instance = null;	
	
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost:3306/bugtrack";
	
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs;
	
	private String select_command = "SELECT * FROM `bugtrack`.";	
	private String insert_command = "INSERT INTO `bugtrack`.";
	private String update_command = "UPDATE `bugtrack`.";
	private String delete_command = "DELETE FROM `bugtrack`.";
	private String custom_select_command = "SELECT ";	

	/**
	 * Exists only to defeat instantiation.
	 */
	protected MySqlDataSourceSingleton() {}	
	
	/**
	 * Singleton
	 */
	public static MySqlDataSourceSingleton getInstance()  {
		if(instance == null) {
	         instance = new MySqlDataSourceSingleton();
	      }
	    return instance;
		
	}
	
	/**
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SQLException 
	 * 
	 */
	public void setupConnection(String user, String passw) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// Register JDBC driver
		Class.forName(JDBC_DRIVER).newInstance();		
		// Open a connection
		System.out.println("Connecting to database...");
	    conn = DriverManager.getConnection(DB_URL, user, passw);
	    stmt = conn.createStatement();
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void executeQueryDemo() throws SQLException {
	    String sql = "select * from priorities";
	    rs = stmt.executeQuery(sql);
	    while (rs.next()) {
	    	int id = rs.getInt("pr_id");
	    	String priority = rs.getString("priority");
	    	System.out.println("ID" + id);
	    	System.out.println("Priority" + priority);
	    }
	    rs.close();
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void executeSelectCommand() throws SQLException {
		rs = stmt.executeQuery(select_command);
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void executeInsertCommand() throws SQLException {
		stmt.executeUpdate(insert_command);
	}
	
	public void executeUpdateCommand() throws SQLException {
		stmt.executeUpdate(update_command);
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void executeDeleteCommand() throws SQLException {
		stmt.executeUpdate(delete_command);
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void executeCustomSelectCommand() throws SQLException {
		rs = stmt.executeQuery(custom_select_command);
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void MySqlDataSourceCloseConections() throws SQLException {		
	    stmt.close();
	    conn.close();
	}

	/**
	 * @return the statement
	 */
	public Statement getStmt() {
		return stmt;
	}	
	
	/**
	 * @return rs the result set
	 */
	public ResultSet getResultSet() {
		return rs;
	}

	/**
	 * @param rs the result set to set
	 */
	public void setResultSet(ResultSet rs) {
		this.rs = rs;
	}
	
	/**
	 * @return the select_command
	 */
	public String getSelect_command() {
		return select_command;
	}

	/**
	 * @param command_part the part to add to the select_command 
	 */
	public void setSelect_command(String command_part) {
		this.select_command += command_part;
	}
	
	/**
	 * @return the insert_command
	 */
	public String getInsert_command() {
		return insert_command;
	}
	
	/**
	 * @param command_part the part to add to the insert_command
	 */
	public void setInsert_command(String command_part) {
		this.insert_command += command_part;
	}

	/**
	 * @return the update_command
	 */
	public String getUpdate_command() {
		return update_command;
	}
	
	/**
	 * @param command_part the part to add to the update_command
	 */
	public void setUpdate_command(String command_part) {
		this.update_command += command_part;
	}

	/**
	 * @return the delete_command
	 */
	public String getDelete_command() {
		return delete_command;
	}	
	
	/**
	 * @param command_part the part to add to the delete_command
	 */
	public void setDelete_command(String command_part) {
		this.delete_command += command_part;
	}

	/**
	 * @return the custom_select_command
	 */
	public String getCustom_select_command() {
		return custom_select_command;
	}

	/**
	 * @param command_part the part to add to the custom_select_command
	 */
	public void setCustom_select_command(String command_part) {
		this.custom_select_command += custom_select_command;
	}
	
}

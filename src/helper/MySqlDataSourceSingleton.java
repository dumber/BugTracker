/**
 * 
 */
package helper;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.sql.DatabaseMetaData;

/** 
 * 
 * @author dumber
 *
 */
public class MySqlDataSourceSingleton {
	private static MySqlDataSourceSingleton instance = null;	
	
	// JDBC driver name and helper URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost:3306/bugtrack";
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs;
	private PropertyManager pm;
	
	private String select_all_query_string = "SELECT * FROM `bugtrack`.";	
	private String insert_query_string = "INSERT INTO `bugtrack`.";
	private String update_query_string = "UPDATE `bugtrack`.";
	private String delete_query_string = "DELETE FROM `bugtrack`.";
	private String custom_select_query_string = "SELECT";	

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
//	    stmt = conn.createStatement();
	    System.out.println("Connection has been set up");
	}
	
    public void getDatabaseMetaData()
    {
//        try {
//
//            DatabaseMetaData dbmd = conn.getMetaData();
//            String[] types = {"TABLE"};
//            ResultSet rs = dbmd.getTables(null, null, "%", types);
//            while (rs.next()) {
//                System.out.println(rs.getString("TABLE_NAME"));
//            }
//        } 
//            catch (SQLException e) {
//            e.printStackTrace();
//        }
    	try {
			pm = new PropertyManager(conn);
			pm.printTableData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	    resetSelectAllCommands();
	    rs.close();
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void executeSelectQuery() throws SQLException {
		rs = stmt.executeQuery(select_all_query_string);
		resetSelectAllCommands();
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void executeInsertQuery() throws SQLException {
		stmt.executeUpdate(insert_query_string);
		resetInsertCommands();
	}
	
	public void executeUpdateQuery() throws SQLException {
		stmt.executeUpdate(update_query_string);
		resetUpdateCommands();
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void executeDeleteQuery() throws SQLException {
		stmt.executeUpdate(delete_query_string);
		resetDeleteCommands();
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void executeSelectByIdQuery(int id) throws SQLException {
		stmt = conn.prepareStatement(custom_select_query_string);
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		resetCustomSelectCommands();
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void MySqlDataSourceCloseConections() throws SQLException {		
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	/**
	 * @return the statement
	 */
	public PreparedStatement getStatement() {
		return stmt;
	}	
	
	/**
	 * @param stmt the stmt to set
	 */
	protected void setStmt(PreparedStatement stmt) {
		this.stmt = stmt;
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
	 * @return the select_all_query_string
	 */
	public String getSelectQueryString() {
		return select_all_query_string;
	}

	/**
	 * @param command_part the part to add to the select_all_query_string 
	 */
	public void setSelectQueryString(String command_part) {
		this.select_all_query_string += command_part;
	}
	
	/**
	 * @return the insert_query_string
	 */
	public String getInsertQueryString() {
		return insert_query_string;
	}
	
	/**
	 * @param command_part the part to add to the insert_query_string
	 */
	public void setInsertQueryString(String command_part) {
		this.insert_query_string += command_part;
	}

	/**
	 * @return the update_query_string
	 */
	public String getUpdateQueryString() {
		return update_query_string;
	}
	
	/**
	 * @param command_part the part to add to the update_query_string
	 */
	public void setUpdateQueryString(String command_part) {
		this.update_query_string += command_part;
	}

	/**
	 * @return the delete_query_string
	 */
	public String getDeleteQueryString() {
		return delete_query_string;
	}	
	
	/**
	 * @param command_part the part to add to the delete_query_string
	 */
	public void setDeleteQueryString(String command_part) {
		this.delete_query_string += command_part;
	}

	/**
	 * @return the custom_select_query_string
	 */
	public String getCustomQueryString() {
		return custom_select_query_string;
	}

	/**
	 * @param command_part the part to add to the custom_select_query_string
	 */
	public void setCustomQueryString(String command_part) {
		this.custom_select_query_string += command_part;
	}
	
	public void resetSelectAllCommands() {
		select_all_query_string = "SELECT * FROM `bugtrack`.";	
	}
	
	public void resetInsertCommands() {	
		insert_query_string = "INSERT INTO `bugtrack`.";
	}
	
	public void resetUpdateCommands() {
		update_query_string = "UPDATE `bugtrack`.";	
	}
	
	public void resetDeleteCommands() {
		delete_query_string = "DELETE FROM `bugtrack`.";
	}
	
	public void resetCustomSelectCommands() {
		custom_select_query_string = "SELECT";	
	}
	
}

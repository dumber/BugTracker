/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.GenericDaoIFC;
import helper.MySqlDataSourceSingleton;

/**
 * @author dumber
 *
 */
public class GenericDaoFactory implements GenericDaoIFC {
	
	protected final MySqlDataSourceSingleton dataSource = MySqlDataSourceSingleton.getInstance();
	protected String table_name;
	
	/**
	 * 	default ctor to provide access to the singleton instance
	 */
	public GenericDaoFactory(String name) {
		super();
		table_name = name;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getMaxId()
	 */
	@Override
	public int getMaxId() throws SQLException {
		dataSource.setCustomQueryString(" MAX(id) FROM " + table_name);
		dataSource.executeCustomQuery();
		ResultSet rs = dataSource.getResultSet();
		if (rs.next()) {
			return rs.getInt(1);			
		} else {
			return -1;
		}
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int id) throws SQLException {
		dataSource.setDeleteQueryString(table_name + " WHERE `id` = " + id + ";");
		dataSource.executeDeleteQuery();
	}
}

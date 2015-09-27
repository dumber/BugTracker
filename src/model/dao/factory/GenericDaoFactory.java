/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.GenericTableElement;
import model.dao.GenericDaoIFC;
import helper.MySqlDataSourceSingleton;

/**
 * @author dumber
 *
 */
public class GenericDaoFactory { //implements GenericDaoIFC {
	
	protected final MySqlDataSourceSingleton dataSource = MySqlDataSourceSingleton.getInstance();
	protected String table_name;
	/**
	 * 	default ctor to provide access to the singleton instance
	 */
	public GenericDaoFactory(String name) {
		super();
		table_name = name;
	}

//	@Override
//	public List<? extends GenericTableElement> getAllTableElements()
//			throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <T extends GenericTableElement> T findElementById(int id,
//			Class<T> type) throws SQLException {
//		Object o = null;
//		return type.cast(o);
//	}
//
//	@Override
//	public <T extends GenericTableElement> void addElementToTable(T elem)
//			throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public <T extends GenericTableElement> void updateElementInTalbe(int id,
//			T elem) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteElementFromTable(int id) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
	
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
}

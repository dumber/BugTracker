/**
 * 
 */
package model.dao.factory;

import java.sql.SQLException;
import java.util.List;

import model.GenericTableElement;
import model.dao.GenericDaoIFC;
import helper.MySqlDataSourceSingleton;

/**
 * @author dumber
 *
 */
public class GenericDaoFactory { //implements GenericDaoIFC {
	
	protected final MySqlDataSourceSingleton dataSource = MySqlDataSourceSingleton.getInstance();

	/**
	 * 	default ctor to provide access to the singleton instance
	 */
	public GenericDaoFactory() {
		super();
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

}

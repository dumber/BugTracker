/**
 * 
 */
package model.dao.factory;

import database.MySqlDataSourceSingleton;

/**
 * @author dumber
 *
 */
public abstract class GenericDaoFactory {
	
	protected final MySqlDataSourceSingleton dataSource = MySqlDataSourceSingleton.getInstance();

	/**
	 * 
	 */
	public GenericDaoFactory() {
		super();
	}

}

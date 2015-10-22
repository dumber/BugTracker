/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserType;
import model.dao.UserTypeDao;

/**
 * @author dumber
 *
 */
public class UserTypeDaoFactory extends GenericDaoFactory implements UserTypeDao {
	
	/**
	 * 
	 */
	public UserTypeDaoFactory() {
		super("`user_types`");
	}
	
	/* (non-Javadoc)
	 * @see model.dao.UserTypeDao#getAllTableElements()
	 */
	@Override
	public List<UserType> getAllTableElements() throws SQLException {
		List<UserType> user_types = new ArrayList<UserType>();
		dataSource.setSelectQueryString("`user_types`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			UserType ut = new UserType(rs.getInt("id"), rs.getString("user_type"));
			user_types.add(ut);
		}
		rs.close();
		return user_types;
	}

	/* (non-Javadoc)
	 * @see model.dao.UserTypeDao#findElementById(int)
	 */
	@Override
	public UserType findElementById(int id) throws SQLException {
		UserType ut = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`user_types` WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			ut = new UserType(rs.getInt("id"), rs.getString("user_type"));
		}
		rs.close();
		return ut;
	}

	/* (non-Javadoc)
	 * @see model.dao.UserTypeDao#addElementToTable(model.UserType)
	 */
	@Override
	public void addElementToTable(UserType user_type) throws SQLException {
		if (user_type != null) {
			dataSource.setInsertQueryString("`user_types` (`user_type`) VALUES (" +	user_type.toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt user_type into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.UserTypeDao#updateElementInTalbe(int, model.UserType)
	 */
	@Override
	public void updateElementInTalbe(int id, UserType user_type) throws SQLException {
		if (user_type != null) {
			dataSource.setUpdateQueryString("`user_types` SET " + user_type.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt user_type \n");
		}
	}

}

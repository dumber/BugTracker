/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.UserType;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class UserTypeDaoFactory extends GenericDaoFactory implements GenericDaoIFC {
	
	/**
	 * 
	 */
	public UserTypeDaoFactory() throws SQLException {
		super();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<UserType> user_types = new ArrayList<UserType>();
		dataSource.setSelectQueryString("`user_types`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			UserType ut = new UserType(rs.getInt("ut_id"), rs.getString("user_type"));
			user_types.add(ut);
		}
		rs.close();
		return user_types;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int ut_id, Class<T> type) throws SQLException {
		UserType ut = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`user_types` WHERE ut_id = ?" );
		dataSource.executeSelectByIdQuery(ut_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			ut = new UserType(rs.getInt("ut_id"), rs.getString("user_type"));
		}
		rs.close();
		return type.cast(ut);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public UserType findUserTypeById(int id) throws SQLException {
		return findElementById(id, UserType.class);
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T user_type) throws SQLException {
		if (((UserType)user_type) != null) {
			dataSource.setInsertQueryString("`user_types` (`user_type`) VALUES (" +	((UserType)user_type).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt user_type into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int ut_id, T user_type) throws SQLException {
		if (((UserType)user_type) != null) {
			dataSource.setUpdateQueryString("`user_types` SET " + ((UserType)user_type).toUpdateString() 
					+ " WHERE `ut_id` = " + ut_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt user_type \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int ut_id) throws SQLException {
		dataSource.setDeleteQueryString("`user_types` WHERE ut_id = " + ut_id + ";");
		dataSource.executeDeleteQuery();
	}
}

/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.User;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class UserDaoFactory extends GenericDaoFactory implements GenericDaoIFC {

	/**
	 * 
	 * 
	 */
	public UserDaoFactory() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 * 	TODO Password hashing
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<User> users = new ArrayList<User>();
		dataSource.setSelectQueryString("`users`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			User usr = new User(rs.getInt("u_id"), rs.getString("username"), rs.getString("password"), rs.getInt("user_type_id"));
			users.add(usr);
		}
		rs.close();
		return users;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, Class<T>)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int u_id, Class<T> type) throws SQLException {
		User u = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`users` WHERE u_id = ?" );
		dataSource.executeSelectByIdQuery(u_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			u = new User(rs.getInt("u_id"), rs.getString("username"), rs.getString("password"), rs.getInt("user_type_id"));
		}
		rs.close();
		return type.cast(u);
	}

	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public User findUserById(int id) throws SQLException {
		return findElementById(id, User.class);
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(T user)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T user) throws SQLException {
		if (((User)user) != null) {
			dataSource.setInsertQueryString("`users` (`username`,`password`,`user_type_id`) VALUES (\'" + ((User)user).getUsername()
											+ "\', \'" + ((User)user).getPassword() + "\', " + ((User)user).getUserType_id() +  ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt user into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, T)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int u_id, T user) throws SQLException {
		if (((User)user) != null) {
			dataSource.setUpdateQueryString("`users` SET `username` = \'" + ((User)user).getUsername() + "\', `password` = \'" 
									+ ((User)user).getPassword()+ "\', `user_type_id` = " + ((User)user).getUserType_id() + ", WHERE `u_id` = " + u_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt user \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int u_id) throws SQLException {
		dataSource.setDeleteQueryString("`users` WHERE u_id = " + u_id + ";");
		dataSource.executeDeleteQuery();
	}
	
}

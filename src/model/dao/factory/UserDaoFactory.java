/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import model.dao.UserDao;

/**
 * @author dumber
 *
 */
public class UserDaoFactory extends GenericDaoFactory implements UserDao {

	/**
	 * 
	 */
	public UserDaoFactory() {
		super("`users`");
	}
	
	/* (non-Javadoc)
	 * @see model.dao.UserDao#getAllTableElements()
	 * 	TODO Password hashing
	 */
	@Override
	public List<User> getAllTableElements() throws SQLException {
		List<User> users = new ArrayList<User>();
		dataSource.setSelectQueryString("`users_view`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			User usr = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("user_type"), rs.getString("salt"));
			users.add(usr);
		}
		rs.close();
		return users;
	}

	/* (non-Javadoc)
	 * @see model.dao.UserDao#findElementById(int)
	 */
	@Override
	public User findElementById(int id) throws SQLException {
		User u = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`users_view` WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			u = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("user_type"), rs.getString("salt"));
		}
		rs.close();
		return u;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.UserDao#findUserByName(int)
	 */
	@Override
	public User findUserByName(String name) throws SQLException {
		User u = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`users_view` WHERE username = ?" );
		dataSource.executeSelectByStringQuery(name);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			u = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("user_type"), rs.getString("salt"));
		}
		rs.close();
		return u;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.UserDao#addElementToTable(model.User)
	 */
	@Override
	public void addElementToTable(User user) throws SQLException {
		if (user != null) {
			dataSource.setInsertQueryString("`users` (`username`,`password`,`user_type_id`,`salt`) VALUES (" 
					+ user.toInsertString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt user into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.UserDao#updateElementInTalbe(int, model.User)
	 */
	@Override
	public void updateElementInTalbe(int id, User user) throws SQLException {
		if (user != null) {
			dataSource.setUpdateQueryString("`users` SET " + user.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt user \n");
		}
	}

}

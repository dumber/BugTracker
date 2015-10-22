/**
 * 
 */
package service;

import java.sql.SQLException;

import model.User;
import model.dao.factory.UserDaoFactory;

/**
 * @author dumber
 *
 */
public class LoginService {
	private final UserDaoFactory user_dao;
	/**
	 * 
	 */
	public LoginService() {
		this.user_dao = new UserDaoFactory();
	}
	
	public User getUserByName(String name) throws SQLException {
		return user_dao.findUserByName(name);
	}
}

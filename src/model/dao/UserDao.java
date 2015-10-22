/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.User;

/**
 * @author dumber
 *
 */
public interface UserDao extends GenericDaoIFC {
	public List<User> getAllTableElements() throws SQLException;
	public User findElementById(int id) throws SQLException;
	public User findUserByName(String name) throws SQLException;
	public void addElementToTable(User elem) throws SQLException;
	public void updateElementInTalbe(int id, User elem) throws SQLException;
}

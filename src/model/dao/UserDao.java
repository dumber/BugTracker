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
public interface UserDao {
	public List<User> getAllUsers();	
	public User findUser(int u_id);
	public void addUser(User user) throws SQLException;
	public void updateUser(int u_id, String username, String password, int user_type_id) throws SQLException;
	public void deleteUser(int u_id) throws SQLException;
}

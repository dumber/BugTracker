/**
 * 
 */
package model.dao;

import java.util.List;

import model.User;

/**
 * @author dumber
 *
 */
public interface UserDao {
	public List<User> getAllUsers();	
	public User getUser(int u_id);
	public String findUsername(int u_id);
	public String findUserType(int u_id);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int u_id);
}

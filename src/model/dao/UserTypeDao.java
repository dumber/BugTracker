/**
 * 
 */
package model.dao;

import java.util.List;

import model.UserType;

/**
 * @author dumber
 *
 */
public interface UserTypeDao {
	public List<UserType> getAllUserTypes();
	public UserType getUserType(int ut_id);
	public String findUserType(int ut_id);
	public void addUserType(UserType user_type);
	public void updateUserType(UserType user_type);
	public void deleteUserType(int ut_id);
}

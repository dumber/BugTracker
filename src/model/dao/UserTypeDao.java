/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.UserType;

/**
 * @author dumber
 *
 */
public interface UserTypeDao {
	public List<UserType> getAllUserTypes();
	public UserType findUserType(int ut_id);
	public void addUserType(UserType user_type) throws SQLException;
	public void updateUserType(int ut_id, String user_type) throws SQLException;
	public void deleteUserType(int ut_id) throws SQLException;
}

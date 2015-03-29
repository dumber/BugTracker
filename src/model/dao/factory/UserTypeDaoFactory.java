/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.MySqlDataSourceSingleton;
import model.UserType;
import model.dao.UserTypeDao;

/**
 * @author dumber
 *
 */
public class UserTypeDaoFactory implements UserTypeDao {
	MySqlDataSourceSingleton db = MySqlDataSourceSingleton.getInstance();
	List<UserType> user_types;
	
	private static final String SQL_QUERY = "select * from user_types";
	
	public UserTypeDaoFactory() throws SQLException {
		user_types = new ArrayList<UserType>();
		db.setResultSet(db.getStmt().executeQuery(SQL_QUERY));
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			UserType ut = new UserType(rs.getInt("ut_id"),rs.getString("user_type"));
			user_types.add(ut);
		}
	}
	
	/* (non-Javadoc)
	 * @see model.dao.UserTypeDao#getAllUserTypes()
	 */
	@Override
	public List<UserType> getAllUserTypes() {
		return user_types;
	}

	/* (non-Javadoc)
	 * @see model.dao.UserTypeDao#getUserType(int)
	 */
	@Override
	public UserType getUserType(int ut_id) {
		return user_types.get(ut_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.UserTypeDao#findUserType(int)
	 */
	@Override
	public String findUserType(int ut_id) {
		return user_types.get(ut_id).getUserType();
	}

	/* (non-Javadoc)
	 * @see model.dao.UserTypeDao#addUserType(model.UserType)
	 */
	@Override
	public void addUserType(UserType user_type) {
		user_types.add(user_type);
		// TODO create the SQL insert command
	}

	/* (non-Javadoc)
	 * @see model.dao.UserTypeDao#updateUserType(model.UserType)
	 */
	@Override
	public void updateUserType(UserType user_type) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see model.dao.UserTypeDao#deleteUserType(model.UserType)
	 */
	@Override
	public void deleteUserType(int ut_id) {
		user_types.remove(ut_id);
		// TODO create the SQL delete command
	}

}

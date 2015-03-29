/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.MySqlDataSourceSingleton;
import model.User;
import model.dao.UserDao;

/**
 * @author dumber
 *
 */
public class UserDaoFactory implements UserDao {
	MySqlDataSourceSingleton db = MySqlDataSourceSingleton.getInstance();
	List<User> users;
	
	private static final String SQL_QUERY = "select * from users";
	
	// TODO Password hashing
	public UserDaoFactory() throws SQLException {
		users = new ArrayList<User>();
		db.setResultSet(db.getStmt().executeQuery(SQL_QUERY));
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			User usr = new User(rs.getInt("u_id"),rs.getString("username"),rs.getString("password"),rs.getString("type"));
			users.add(usr);
		}
	}
	
	/* (non-Javadoc)
	 * @see model.dao.UserDao#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		return users;
	}

	/* (non-Javadoc)
	 * @see model.dao.UserDao#getUser(int)
	 */
	@Override
	public User getUser(int u_id) {
		return users.get(u_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.UserDao#findUsername(int)
	 */
	@Override
	public String findUsername(int u_id) {
		return users.get(u_id).getUsername();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.UserDao#findUsertype(int)
	 */
	@Override
	public String findUserType(int u_id) {
		return users.get(u_id).getType();
	}	
	
	/* (non-Javadoc)
	 * @see model.dao.UserDao#addUser(model.User)
	 */
	@Override
	public void addUser(User user) {
		users.add(user);
		// TODO create the SQL insert command
	}

	/* (non-Javadoc)
	 * @see model.dao.UserDao#updateUser(model.User)
	 */
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see model.dao.UserDao#deleteUser(model.User)
	 */
	@Override
	public void deleteUser(int u_id) {
		users.remove(u_id);
		// TODO create the SQL delete command
	}


}

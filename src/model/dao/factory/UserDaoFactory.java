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
	
	/**
	 * TODO Password hashing
	 * 
	 * @throws SQLException 
	 * 
	 */
	public UserDaoFactory() throws SQLException {
		users = new ArrayList<User>();
		db.setSelect_command("`users`");
		db.executeSelectCommand();
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			User usr = new User(rs.getInt("u_id"),rs.getString("username"),rs.getString("password"),rs.getInt("user_type_id"));
			users.add(usr);
		}
		rs.close();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.UserDao#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		return users;
	}

	/* (non-Javadoc)
	 * @see model.dao.UserDao#findUsername(int)
	 */
	@Override
	public User findUser(int u_id) {
		return users.get(u_id);
	}
	
	/* (non-Javadoc)
	 * @see model.dao.UserDao#addUser(model.User)
	 */
	@Override
	public void addUser(User user) throws SQLException {
		users.add(user);
		// TODO create the SQL insert command
	}

	/* (non-Javadoc)
	 * @see model.dao.UserDao#updateUser(model.User)
	 */
	@Override
	public void updateUser(int u_id, String username, String password, int user_type_id) throws SQLException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see model.dao.UserDao#deleteUser(model.User)
	 */
	@Override
	public void deleteUser(int u_id) throws SQLException {
		users.remove(u_id);
		// TODO create the SQL delete command
	}
	
}

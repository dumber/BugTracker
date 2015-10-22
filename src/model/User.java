package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class User extends GenericTableElement {
	private StringProperty username;
	private StringProperty password;
	private StringProperty user_type;
	private StringProperty salt;
	
	/**
	 * @param user_id			the user id
	 * @param username			the user name
	 * @param password			the password
	 * @param user_type		the user type id
	 */
	public User(int user_id, String username, String password, String u_type, String salt) {
		super(user_id);
		this.username = new SimpleStringProperty(username);
		this.password = new SimpleStringProperty(password);
		this.user_type = new SimpleStringProperty(u_type);
		this.salt = new SimpleStringProperty(salt);
	}
	
	/**
	 * @param u					the user to copy
	 */
	public User(User u) {
		super(u.getId());
		this.username = u.username;
		this.password = u.password;
		this.user_type = u.user_type;
		this.salt = u.salt;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username.get();
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username.set(username);
	}
	
	/**
	 * @return the username
	 */
	public StringProperty usernameProperty() {
		return username;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password.get();
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password.set(password);
	}
	
	/**
	 * @return the password
	 */
	public StringProperty passwordProperty() {
		return password;
	}
	
	/**
	 * @return the user_type
	 */
	public String getUserType() {
		return user_type.get();
	}

	/**
	 * @param user_type the user_type to set
	 */
	public void setUserType(String u_type) {
		this.user_type.set(u_type);
	}
	
	/**
	 * @return the user_type
	 */
	public StringProperty userTypeProperty() {
		return user_type;
	}
	
	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt.get();
	}

	/**
	 * @param slt the salt to set
	 */
	public void setSalt(String slt) {
		this.salt.set(slt);
	}
	
	/**
	 * @return the salt
	 */
	public StringProperty saltProperty() {
		return salt;
	}
	
//	/**
//	 * @param un
//	 * @param pw
//	 * @param ut_id
//	 */
//	public void modifyUser(String un, String pw, int ut_id) {
//		this.username.set(un);
//		this.password.set(pw);
//		this.user_type.set(ut_id);
//	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + username.get() + "\', \'" + password.get() + "\', \'" + user_type.get() + "\', \'" + salt.get() + "\'";
	}
	
	/**
	 * @return
	 */
	public String toInsertString() {
		return "\'" + username.get() + "\', \'" + password.get() + "\', (select `id` from `user_types` where `user_types`.`user_type` = \'" + user_type.get() + "\'), \'" + salt.get() + "\'";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`username`=\'" + username.get() + "\', `password`=\'" + password.get() + "\', `user_type_id`=(select `id` from `user_types` where `user_types`.`user_type` = \'" + user_type.get() + "\'), `salt`=\'" + salt.get() + "\'";
	}
			
	/**
	 * @return 
	 */
	public String debug() {
		return "User [id=" + id.get() + ", username=" + username.get() + ", password=" + password.get()
				+ ", user_type=" + user_type.get() + ", salt=" + salt.get() + "]";
	}
	
}

package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class User extends GenericTableElement {
	private StringProperty username;
	private StringProperty password;
	private IntegerProperty user_type_id;
	
	/**
	 * @param user_id			the user id
	 * @param username			the user name
	 * @param password			the password
	 * @param user_type_id		the user type id
	 */
	public User(int user_id, String username, String password, int user_type_id) {
		super(user_id);
		this.username = new SimpleStringProperty(username);
		this.password = new SimpleStringProperty(password);
		this.user_type_id = new SimpleIntegerProperty(user_type_id);
	}
	
	/**
	 * @param u					the user to copy
	 */
	public User(User u) {
		super(u.getId());
		this.username = u.username;
		this.password = u.password;
		this.user_type_id = u.user_type_id;
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
	 * @return the user_type_id
	 */
	public int getUserType_id() {
		return user_type_id.get();
	}

	/**
	 * @param user_type_id the user_type_id to set
	 */
	public void setUserType_id(int user_type_id) {
		this.user_type_id.set(user_type_id);
	}
	
	/**
	 * @return the user_type_id
	 */
	public IntegerProperty userTypeIdProperty() {
		return user_type_id;
	}
	
	/**
	 * @param un
	 * @param pw
	 * @param ut_id
	 */
	public void modifyUser(String un, String pw, int ut_id) {
		this.username.set(un);
		this.password.set(pw);
		this.user_type_id.set(ut_id);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + username.get() + "\', \'" + password.get() + "\', " + user_type_id.get();
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`username`=\'" + username.get() + "\', `password`=\'" + password.get() + "\', `user_type_id`=" + user_type_id.get();
	}
			
	/**
	 * @return 
	 */
	public String debug() {
		return "User [id=" + id.get() + ", username=" + username.get() + ", password=" + password.get()
				+ ", user_type_id=" + user_type_id.get() + "]";
	}
		
}

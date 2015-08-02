package model;

/**
 * @author dumber
 *
 */
public class User {
	private int user_id;
	private String username;
	private String password;
	private int user_type_id;

	/**
	 * @param user_id
	 * @param username
	 * @param password
	 * @param user_type_id
	 */
	public User(int user_id, String username, String password, int user_type_id) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.user_type_id = user_type_id;
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the user_type_id
	 */
	public int getUserType_id() {
		return user_type_id;
	}

	/**
	 * @param user_type_id the user_type_id to set
	 */
	public void setUserType_id(int user_type_id) {
		this.user_type_id = user_type_id;
	}
	
}

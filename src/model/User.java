package model;

/**
 * @author dumber
 *
 */
public class User {
	private int user_id;
	private String username;
	private String password;
	private String type;
	
	public User(int user_id, String username, String password, String type) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.type = type;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}

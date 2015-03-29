package model;

/**
 * @author dumber
 *
 */
public class UserType {
	private int usertype_id;
	private String user_type;
	
	public UserType(int usertype_id, String user_type) {
		super();
		this.usertype_id = usertype_id;
		this.user_type = user_type;
	}

	public int getUserType_id() {
		return usertype_id;
	}
	
	public void setUserType_id(int usertype_id) {
		this.usertype_id = usertype_id;
	}
	
	public String getUserType() {
		return user_type;
	}
	
	public void setUserType(String user_type) {
		this.user_type = user_type;
	}	

}

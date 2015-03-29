package model;

/**
 * @author dumber
 *
 */
public class UserType {
	private int user_type_id;
	private String user_type;

	/**
	 * @param user_type_id
	 * @param user_type
	 */
	public UserType(int user_type_id, String user_type) {
		this.user_type_id = user_type_id;
		this.user_type = user_type;
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

	/**
	 * @return the user_type
	 */
	public String getUserType() {
		return user_type;
	}

	/**
	 * @param user_type the user_type to set
	 */
	public void setUserType(String user_type) {
		this.user_type = user_type;
	}
	
}

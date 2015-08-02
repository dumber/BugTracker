package model;

/**
 * @author dumber
 *
 */
public class UserType extends GenericTableElement {
	private String user_type;

	/**
	 * @param user_type_id
	 * @param user_type
	 */
	public UserType(int user_type_id, String user_type) {
		super(user_type_id);
		this.user_type = user_type;
	}

	/**
	 * @param ut
	 */
	public UserType(UserType ut) {
		super(ut.id);
		this.user_type = ut.user_type;
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

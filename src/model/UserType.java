package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class UserType extends GenericTableElement {
	private StringProperty user_type;

	/**
	 * @param user_type_id
	 * @param user_type
	 */
	public UserType(int user_type_id, String user_type) {
		super(user_type_id);
		this.user_type = new SimpleStringProperty(user_type);
	}

	/**
	 * @param ut
	 */
	public UserType(UserType ut) {
		super(ut.getId());
		this.user_type = ut.user_type;
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
	public void setUserType(String user_type) {
		this.user_type.set(user_type);
	}
	
	/**
	 * @return the user_type
	 */
	public StringProperty userTypeProperty() {
		return user_type;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + user_type.get() + "\'";
	}
	
	/**
	* @return 
	*/
	public String toUpdateString() {
		return "`user_type`=\'" + user_type.get() + "\'";
	}
	
	/**
	* @return 
	*/
	public String debug() {
		return "UserType [id=" + id.get() + ", user_type=" + user_type.get() + "]";
	}
	
}

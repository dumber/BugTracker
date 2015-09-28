/**
 * 
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author dumber
 *
 */
public class ProjectUser extends GenericTableElement {
	private IntegerProperty pu_project_id;
	private IntegerProperty pu_user_id;
	
	/**
	 * @param pu_id
	 * @param pu_project_id
	 * @param pu_user_id
	 */
	public ProjectUser(int pu_id, int pu_project_id, int pu_user_id) {
		super(pu_id);
		this.pu_project_id = new SimpleIntegerProperty(pu_project_id);
		this.pu_user_id = new SimpleIntegerProperty(pu_user_id);
	}

	/**
	 * @param pu
	 */
	public ProjectUser(ProjectUser pu) {
		super(pu.getId());
		this.pu_project_id = pu.pu_project_id;
		this.pu_user_id = pu.pu_user_id;
	}

	/**
	 * @return the pu_project_id
	 */
	public int getPuProject_id() {
		return pu_project_id.get();
	}

	/**
	 * @param pu_project_id the pu_project_id to set
	 */
	public void setPuProject_id(int pu_project_id) {
		this.pu_project_id.set(pu_project_id);
	}

	/**
	 * @return the pu_project_id
	 */
	public IntegerProperty puProjectIdProperty() {
		return pu_project_id;
	}
	
	/**
	 * @return the pu_user_id
	 */
	public int getPuUser_id() {
		return pu_user_id.get();
	}

	/**
	 * @param pu_user_id the pu_user_id to set
	 */
	public void setPuUser_id(int pu_user_id) {
		this.pu_user_id.set(pu_user_id);
	}

	/**
	 * @return the pu_user_id
	 */
	public IntegerProperty puUserIdProperty() {
		return pu_user_id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return pu_project_id.get() + ", " + pu_user_id.get();
	}

	/**
	 * @return 
	 */
	public String toUpdateString() {	
		return "`project_id`=" + pu_project_id.get() + ", `user_id`=" + pu_user_id.get();

	}
	
	/**
	 * @return 
	 */
	public String debug() {	
		return "ProjectUser [id=" + id.get() + ", pu_project_id=" + pu_project_id.get() + ", pu_user_id="
				+ pu_user_id.get() + "]";

	}
	
	
}

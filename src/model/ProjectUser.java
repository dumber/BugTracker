/**
 * 
 */
package model;

/**
 * @author dumber
 *
 */
public class ProjectUser extends GenericTableElement {
	private int pu_project_id;
	private int pu_user_id;
	
	/**
	 * @param pu_id
	 * @param pu_project_id
	 * @param pu_user_id
	 */
	public ProjectUser(int pu_id, int pu_project_id, int pu_user_id) {
		super(pu_id);
		this.pu_project_id = pu_project_id;
		this.pu_user_id = pu_user_id;
	}

	/**
	 * @param pu
	 */
	public ProjectUser(ProjectUser pu) {
		super(pu.id);
		this.pu_project_id = pu.pu_project_id;
		this.pu_user_id = pu.pu_user_id;
	}

	/**
	 * @return the pu_project_id
	 */
	public int getPuProject_id() {
		return pu_project_id;
	}

	/**
	 * @param pu_project_id the pu_project_id to set
	 */
	public void setPuProject_id(int pu_project_id) {
		this.pu_project_id = pu_project_id;
	}

	/**
	 * @return the pu_user_id
	 */
	public int getPuUser_id() {
		return pu_user_id;
	}

	/**
	 * @param pu_user_id the pu_user_id to set
	 */
	public void setPuUser_id(int pu_user_id) {
		this.pu_user_id = pu_user_id;
	}
	
}

/**
 * 
 */
package model;

/**
 * @author dumber
 *
 */
public class ProjectUser {
	private int project_user_id;
	private int pu_project_id;
	private int pu_user_id;
	
	/**
	 * @param pu_id
	 * @param pu_project_id
	 * @param pu_user_id
	 */
	public ProjectUser(int pu_id, int pu_project_id, int pu_user_id) {
		this.project_user_id = pu_id;
		this.pu_project_id = pu_project_id;
		this.pu_user_id = pu_user_id;
	}

	/**
	 * @return the project_user_id
	 */
	public int getProjectUser_id() {
		return project_user_id;
	}

	/**
	 * @param pu_id the project_user_id to set
	 */
	public void setProjectUser_id(int pu_id) {
		this.project_user_id = pu_id;
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

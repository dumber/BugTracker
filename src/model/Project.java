package model;

/**
 * @author dumber
 *
 */
public class Project {
	private int project_id;
	private String project_name;

	/**
	 * @param project_id
	 * @param project_name
	 */
	public Project(int project_id, String project_name) {
		this.project_id = project_id;
		this.project_name = project_name;
	}

	/**
	 * @return the project_id
	 */
	public int getProject_id() {
		return project_id;
	}

	/**
	 * @param project_id the project_id to set
	 */
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	/**
	 * @return the project_name
	 */
	public String getProjectName() {
		return project_name;
	}

	/**
	 * @param project_name the project_name to set
	 */
	public void setProjectName(String project_name) {
		this.project_name = project_name;
	}
		
}

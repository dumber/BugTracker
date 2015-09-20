package model;

/**
 * @author dumber
 *
 */
public class Project extends GenericTableElement {
	private String project_name;

	/**
	 * @param project_id
	 * @param project_name
	 */
	public Project(int project_id, String project_name) {
		super(project_id);
		this.project_name = project_name;
	}
	
	
	/**
	 * @param pr
	 */
	public Project(Project pr) {
		super(pr.id);
		this.project_name = pr.project_name;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + project_name + "\'";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`project_name`=\'" + project_name + "\'";
	}	
	
	/**
	 * @return 
	 */
	public String debug() {
		return "Project [id=" + id + ", project_name=" + project_name + "]";
	}	
}

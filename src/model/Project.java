package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class Project extends GenericTableElement {
	private StringProperty project_name;

	/**
	 * @param project_id
	 * @param project_name
	 */
	public Project(int project_id, String project_name) {
		super(project_id);
		this.project_name = new SimpleStringProperty(project_name);
	}
	
	
	/**
	 * @param pr
	 */
	public Project(Project pr) {
		super(pr.getId());
		this.project_name = pr.project_name;
	}
	
	/**
	 * @return the project_name
	 */
	public String getProjectName() {
		return project_name.get();
	}

	/**
	 * @param project_name the project_name to set
	 */
	public void setProjectName(String project_name) {
		this.project_name.set(project_name);
	}
	
	/**
	 * @return the project_name
	 */
	public StringProperty projectProperty() {
		return project_name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + project_name.get() + "\'";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`project_name`=\'" + project_name.get() + "\'";
	}	
	
	/**
	 * @return 
	 */
	public String debug() {
		return "Project [id=" + id.get() + ", project_name=" + project_name.get() + "]";
	}	
}

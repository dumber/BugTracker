package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class ProjectVersion extends GenericTableElement {
	private StringProperty project_name;
	private StringProperty version;

	/**
	 * @param pv_id
	 * @param version
	 */
	public ProjectVersion(int pv_id, String project, String version) {
		super(pv_id);
		this.project_name = new SimpleStringProperty(project);
		this.version = new SimpleStringProperty(version);
	}

	/**
	 * @param pv
	 */
	public ProjectVersion(ProjectVersion pv) {
		super(pv.getId());
		this.project_name = pv.project_name;
		this.version = pv.version;
	}

	/**
	 * @return the project_name
	 */
	public String getProject() {
		return project_name.get();
	}

	/**
	 * @param project_name the project_name to set
	 */
	public void setProject(String project) {
		this.project_name.set(project);
	}

	/**
	 * @return the project_name
	 */
	public StringProperty projectProperty() {
		return project_name;
	}
	
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version.get();
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version.set(version);
	}

	/**
	 * @return the version
	 */
	public StringProperty puVersionProperty() {
		return version;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return project_name.get() + ", \'" + version.get() + "\'";
	}
	
	/**
	 * @return
	 */
	public String toInsertString() {
		return "(select `id` from `projects` where `projects`.`project_name`=\'" + project_name.get() + "\'), \'" + version.get() + "\'";
	}	
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`project_id`=(select `id` from `projects` where `projects`.`project_name`=\'" + project_name.get() + "\'), `version`=\'" + version.get() + "\'";
	}	
	
	/**
	 * @return 
	 */
	public String debug() {
		return "ProjectVersion [id=" + id.get() + ", project_name=" + project_name.get() + ", version="
				+ version.get() + "]";
	}	
	
}

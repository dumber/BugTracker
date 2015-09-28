package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class ProjectVersion extends GenericTableElement {
	private IntegerProperty pv_project_id;
	private StringProperty version;

	/**
	 * @param pv_id
	 * @param version
	 */
	public ProjectVersion(int pv_id, int pr_id, String version) {
		super(pv_id);
		this.pv_project_id = new SimpleIntegerProperty(pr_id);
		this.version = new SimpleStringProperty(version);
	}

	/**
	 * @param pv
	 */
	public ProjectVersion(ProjectVersion pv) {
		super(pv.getId());
		this.version = pv.version;
	}

	/**
	 * @return the pv_project_id
	 */
	public int getPvProject_id() {
		return pv_project_id.get();
	}

	/**
	 * @param pv_project_id the pv_project_id to set
	 */
	public void setPvProject_id(int pv_project_id) {
		this.pv_project_id.set(pv_project_id);
	}

	/**
	 * @return the pv_project_id
	 */
	public IntegerProperty pvProjectIdProperty() {
		return pv_project_id;
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
		return pv_project_id.get() + ", \'" + version.get() + "\'";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`project_id`=" + pv_project_id.get() + ", `version`=\'" + version.get() + "\'";
	}	
	
	/**
	 * @return 
	 */
	public String debug() {
		return "ProjectVersion [id=" + id.get() + ", pv_project_id=" + pv_project_id.get() + ", version="
				+ version.get() + "]";
	}	
	
}

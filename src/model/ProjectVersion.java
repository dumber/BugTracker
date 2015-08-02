package model;

/**
 * @author dumber
 *
 */
public class ProjectVersion {
	private int project_version_id;
	private String version;

	/**
	 * @param pv_id
	 * @param version
	 */
	public ProjectVersion(int pv_id, String version) {
		this.project_version_id = pv_id;
		this.version = version;
	}

	/**
	 * @return the project_version_id
	 */
	public int getProjectVersion_id() {
		return project_version_id;
	}

	/**
	 * @param pv_id the project_version_id to set
	 */
	public void setProjectVersion_id(int pv_id) {
		this.project_version_id = pv_id;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
}

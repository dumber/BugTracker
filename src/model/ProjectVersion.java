package model;

/**
 * @author dumber
 *
 */
public class ProjectVersion extends GenericTableElement {
	private int pv_project_id;
	private String version;

	/**
	 * @param pv_id
	 * @param version
	 */
	public ProjectVersion(int pv_id, int pr_id, String version) {
		super(pv_id);
		this.pv_project_id = pr_id;
		this.version = version;
	}

	/**
	 * @param pv
	 */
	public ProjectVersion(ProjectVersion pv) {
		super(pv.id);
		this.version = pv.version;
	}

	/**
	 * @return the pv_project_id
	 */
	public int getPvProject_id() {
		return pv_project_id;
	}

	/**
	 * @param pv_project_id the pv_project_id to set
	 */
	public void setPvProject_id(int pv_project_id) {
		this.pv_project_id = pv_project_id;
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

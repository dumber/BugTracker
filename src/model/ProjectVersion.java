package model;

/**
 * @author dumber
 *
 */
public class ProjectVersion extends GenericTableElement {
	private String version;

	/**
	 * @param pv_id
	 * @param version
	 */
	public ProjectVersion(int pv_id, String version) {
		super(pv_id);
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

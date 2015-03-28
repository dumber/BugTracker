package bugtracker.model;

public class ProjectVersion {
	private int project_version_id;
	private String version;
	
	public int getProject_version_id() {
		return project_version_id;
	}
	
	public void setProject_version_id(int project_version_id) {
		this.project_version_id = project_version_id;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}	

}

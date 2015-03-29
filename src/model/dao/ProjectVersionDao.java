/**
 * 
 */
package model.dao;

import java.util.List;

import model.ProjectVersion;

/**
 * @author dumber
 *
 */
public interface ProjectVersionDao {
	public List<ProjectVersion> getAllProjectVersions();	
	public ProjectVersion getProjectVersion(int pv_id);
	public String findProjectVersion(int pv_id);
	public void addProjectVersion(ProjectVersion project_version);
	public void updateProjectVersion(ProjectVersion project_version);
	public void deleteProjectVersion(int pv_id);
}

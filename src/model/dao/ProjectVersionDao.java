/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.ProjectVersion;

/**
 * @author dumber
 *
 */
public interface ProjectVersionDao {
	public List<ProjectVersion> getAllProjectVersions();	
	public ProjectVersion findProjectVersion(int pv_id);
	public void addProjectVersion(ProjectVersion project_version) throws SQLException;
	public void updateProjectVersion(int pv_id, String project_version) throws SQLException;
	public void deleteProjectVersion(int pv_id) throws SQLException;
}

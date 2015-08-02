/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.Project;

/**
 * @author dumber
 *
 */
public interface ProjectDao {
	public List<Project> getAllProjects();	
	public Project findProject(int p_id);
	public void addProject(Project project) throws SQLException;
	public void updateProject(int p_id, String project) throws SQLException;
	public void deleteProject(int p_id) throws SQLException;
}

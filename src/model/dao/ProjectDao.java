/**
 * 
 */
package model.dao;

import java.util.List;

import model.Project;

/**
 * @author dumber
 *
 */
public interface ProjectDao {
	public List<Project> getAllProjects();	
	public Project getProject(int p_id);
	public String findProject(int p_id);
	public void addProject(Project project);
	public void updateProject(Project project);
	public void deleteProject(int p_id);
}

/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.ProjectUser;

/**
 * @author dumber
 *
 */
public interface ProjectUserDao {
	public List<ProjectUser> getAllProjectUsers();	
	public ProjectUser findProjectUser(int pu_id);
	public void addProjectUser(ProjectUser project_user) throws SQLException;
	public void updateProjectUser(int pu_id, int pu_project_id, int pu_user_id) throws SQLException;
	public void deleteProjectUser(int pu_id) throws SQLException;
}

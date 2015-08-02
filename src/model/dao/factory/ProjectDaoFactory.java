/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.MySqlDataSourceSingleton;
import model.Project;
import model.dao.ProjectDao;

/**
 * @author dumber
 *
 */
public class ProjectDaoFactory implements ProjectDao {
	MySqlDataSourceSingleton db = MySqlDataSourceSingleton.getInstance();
	List<Project> projects;
	
	/**
	 * @throws SQLException 
	 * 
	 */	
	public ProjectDaoFactory() throws SQLException {
		projects = new ArrayList<Project>();
		db.setSelect_command("`projects`");
		db.executeSelectCommand();
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			Project pro = new Project(rs.getInt("p_id"),rs.getString("project_name"));
			projects.add(pro);
		}
		rs.close();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#getAllProjects()
	 */
	@Override
	public List<Project> getAllProjects() {
		return projects;
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#findProject(int)
	 */
	@Override
	public Project findProject(int p_id) {
		return projects.get(p_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#addProject(model.Project)
	 */
	@Override
	public void addProject(Project project) throws SQLException {
		projects.add(project);
		db.setInsert_command("`projects` (`project`) VALUES (" + project.getProjectName() + ");");
		db.executeInsertCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#updateProject(model.Project)
	 */
	@Override
	public void updateProject(int p_id, String project) throws SQLException{
		findProject(p_id).setProjectName(project);
		db.setUpdate_command("`projects` SET `project` = " + project + " WHERE `p_id` = " + p_id + ";");
		db.executeUpdateCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#deleteProject(model.Project)
	 */
	@Override
	public void deleteProject(int p_id) throws SQLException {
		projects.remove(p_id);
		db.setDelete_command("`projects` WHERE p_id = " + p_id + ";");
		db.executeDeleteCommand();
	}

}

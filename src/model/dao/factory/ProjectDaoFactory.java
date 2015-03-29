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
	
	private static final String SQL_QUERY = "select * from projects";
	
	public ProjectDaoFactory() throws SQLException {
		projects = new ArrayList<Project>();
		db.setResultSet(db.getStmt().executeQuery(SQL_QUERY));
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			Project pro = new Project(rs.getInt("p_id"),rs.getString("project_name"));
			projects.add(pro);
		}
	}
	
	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#getAllProjects()
	 */
	@Override
	public List<Project> getAllProjects() {
		return projects;
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#getProject(int)
	 */
	@Override
	public Project getProject(int p_id) {
		return projects.get(p_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#findProject(int)
	 */
	@Override
	public String findProject(int p_id) {
		return projects.get(p_id).getProject();
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#addProject(model.Project)
	 */
	@Override
	public void addProject(Project project) {
		projects.add(project);
		// TODO create the SQL insert command
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#updateProject(model.Project)
	 */
	@Override
	public void updateProject(Project project) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#deleteProject(model.Project)
	 */
	@Override
	public void deleteProject(int p_id) {
		projects.remove(p_id);
		// TODO create the SQL delete command
	}

}

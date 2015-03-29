/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.MySqlDataSourceSingleton;
import model.ProjectVersion;
import model.dao.ProjectVersionDao;

/**
 * @author dumber
 *
 */
public class ProjectVersionDaoFactory implements ProjectVersionDao {
	MySqlDataSourceSingleton db = MySqlDataSourceSingleton.getInstance();
	List<ProjectVersion> project_versions;
	
	private static final String SQL_QUERY = "select * from project_versions";
	
	public ProjectVersionDaoFactory() throws SQLException {
		project_versions = new ArrayList<ProjectVersion>();
		db.setResultSet(db.getStmt().executeQuery(SQL_QUERY));
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			ProjectVersion pv = new ProjectVersion(rs.getInt("pv_id"),rs.getString("version"));
			project_versions.add(pv);
		}
	}
	
	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#getAllProjectVersions()
	 */
	@Override
	public List<ProjectVersion> getAllProjectVersions() {
		return project_versions;
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#getProjectVersion(int)
	 */
	@Override
	public ProjectVersion getProjectVersion(int pv_id) {
		return project_versions.get(pv_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#findProjectVersion(int)
	 */
	@Override
	public String findProjectVersion(int pv_id) {
		return project_versions.get(pv_id).getVersion();
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#addProjectVersion(model.ProjectVersion)
	 */
	@Override
	public void addProjectVersion(ProjectVersion project_version) {
		project_versions.add(project_version);
		// TODO create the SQL insert command
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#updateProjectVersion(model.ProjectVersion)
	 */
	@Override
	public void updateProjectVersion(ProjectVersion project_version) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#deleteProjectVersion(model.ProjectVersion)
	 */
	@Override
	public void deleteProjectVersion(int pv_id) {
		project_versions.remove(pv_id);
		// TODO create the SQL delete command
	}

}

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
	
	public ProjectVersionDaoFactory() throws SQLException {
		project_versions = new ArrayList<ProjectVersion>();
		db.setSelect_command("`project_versions`");
		db.executeSelectCommand();
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			ProjectVersion pv = new ProjectVersion(rs.getInt("pv_id"), rs.getString("version"));
			project_versions.add(pv);
		}
		rs.close();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#getAllProjectVersions()
	 */
	@Override
	public List<ProjectVersion> getAllProjectVersions() {
		return project_versions;
	}


	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#findProjectVersion(int)
	 */
	@Override
	public ProjectVersion findProjectVersion(int pv_id) {
		return project_versions.get(pv_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#addProjectVersion(model.ProjectVersion)
	 */
	@Override
	public void addProjectVersion(ProjectVersion project_version) throws SQLException {
		project_versions.add(project_version);
		db.setInsert_command("`project_versions` (`version`) VALUES (" + project_version.getVersion() + ");");
		db.executeInsertCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#updateProjectVersion(model.ProjectVersion)
	 */
	@Override
	public void updateProjectVersion(int pv_id, String project_version) throws SQLException {
		findProjectVersion(pv_id).setVersion(project_version);
		db.setUpdate_command("`project_versions` SET `version` = " + project_version + "WHERE `pv_id = " + pv_id + ";");
		db.executeUpdateCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#deleteProjectVersion(model.ProjectVersion)
	 */
	@Override
	public void deleteProjectVersion(int pv_id) throws SQLException {
		project_versions.remove(pv_id);
		db.setDelete_command("`project_versions` WHERE pv_id = " + pv_id + ";");
		db.executeDeleteCommand();
	}

}

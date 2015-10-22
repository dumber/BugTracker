/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProjectVersion;
import model.dao.ProjectVersionDao;

/**
 * @author dumber
 *
 */
public class ProjectVersionDaoFactory extends GenericDaoFactory implements ProjectVersionDao {
	
	/*
	 * 
	 */
	public ProjectVersionDaoFactory() {
		super("`project_versions`");
	}
	
	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#getAllTableElements()
	 */
	@Override
	public List<ProjectVersion> getAllTableElements() throws SQLException {
		List<ProjectVersion> project_versions = new ArrayList<ProjectVersion>();
		dataSource.setSelectQueryString("`project_versions_view`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			ProjectVersion pv = new ProjectVersion(rs.getInt("id"), rs.getString("project_name"), rs.getString("version"));
			project_versions.add(pv);
		}
		rs.close();
		return project_versions;
	}


	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#ProjectVersionDao#findElementById(int)
	 */
	@Override
	public ProjectVersion findElementById(int pu_id) throws SQLException {
		ProjectVersion pv = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`project_versions_view` WHERE id = ?;" );
		dataSource.executeSelectByIdQuery(pu_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			pv = new ProjectVersion(rs.getInt("id"), rs.getString("project_name"), rs.getString("version"));
		}
		rs.close();
		return pv;
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#addElementToTable(model.ProjectVersion)
	 */
	@Override
	public void addElementToTable(ProjectVersion project_version) throws SQLException {
		if (project_version != null) {
			dataSource.setInsertQueryString("`project_versions` (`project_id`, `version`) VALUES (" + 
					project_version.toInsertString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt project_version into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectVersionDao#updateElementInTalbe(int, model.ProjectVersion)
	 */
	@Override
	public void updateElementInTalbe(int id, ProjectVersion project_version) throws SQLException {
		if (project_version != null) {
			dataSource.setUpdateQueryString("`project_versions` SET " + project_version.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt project_version \n");
		}
	}
	
}

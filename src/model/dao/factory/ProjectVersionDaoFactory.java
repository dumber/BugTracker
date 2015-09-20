/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.ProjectVersion;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class ProjectVersionDaoFactory extends GenericDaoFactory implements GenericDaoIFC {
	
	/*
	 * 
	 */
	public ProjectVersionDaoFactory() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<ProjectVersion> getAllTableElements() throws SQLException {
		List<ProjectVersion> project_versions = new ArrayList<ProjectVersion>();
		dataSource.setSelectQueryString("`project_versions`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			ProjectVersion pv = new ProjectVersion(rs.getInt("pv_id"), rs.getInt("project_id"), rs.getString("version"));
			project_versions.add(pv);
		}
		rs.close();
		return project_versions;
	}


	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int pu_id, Class<T> type) throws SQLException {
		ProjectVersion pv = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.project_versions WHERE pv_id = ?" );
		dataSource.executeSelectByIdQuery(pu_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			pv = new ProjectVersion(rs.getInt("pv_id"), rs.getInt("project_id"), rs.getString("version"));
		}
		rs.close();
		return type.cast(pv);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ProjectVersion findProjectVersionById(int id) throws SQLException {
		return findElementById(id, ProjectVersion.class);
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T project_version) throws SQLException {
		if (((ProjectVersion)project_version) != null) {
			dataSource.setInsertQueryString("`project_versions` (`project_id`, `version`) VALUES (" + 
					((ProjectVersion)project_version).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt project_version into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int pv_id, T project_version) throws SQLException {
		if (((ProjectVersion)project_version) != null) {
			dataSource.setUpdateQueryString("`project_versions` SET " + ((ProjectVersion)project_version).toUpdateString() 
					+ " WHERE `pv_id` = " + pv_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt project_version \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int pv_id) throws SQLException {
		dataSource.setDeleteQueryString("`project_versions` WHERE pv_id = " + pv_id + ";");
		dataSource.executeDeleteQuery();
	}

}

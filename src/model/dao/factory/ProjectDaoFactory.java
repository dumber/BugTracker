/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.Project;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class ProjectDaoFactory extends GenericDaoFactory implements GenericDaoIFC {
	
	/** 
	 * 
	 */	
	public ProjectDaoFactory(){
		super("`projects`");

	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements()  throws SQLException {
		List<Project> projects = new ArrayList<Project>();
		dataSource.setSelectQueryString("`projects`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			Project pro = new Project(rs.getInt("id"),rs.getString("project_name"));
			projects.add(pro);
		}
		rs.close();
		return projects;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int id, Class<T> type) throws SQLException {
		Project p = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.projects WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			p = new Project(rs.getInt("id"), rs.getString("project_name"));
		}
		rs.close();
		return type.cast(p);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Project findProjectById(int id) throws SQLException {
		return findElementById(id, Project.class);
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T project) throws SQLException {
		if (((Project)project) != null) {
			dataSource.setInsertQueryString("`projects` (`project_name`) VALUES (" + ((Project)project).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt project into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int id, T project) throws SQLException{
		if (((Project)project) != null) {
			dataSource.setUpdateQueryString("`projects` SET " + ((Project)project).toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt project \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int id) throws SQLException {
		dataSource.setDeleteQueryString("`projects` WHERE `id` = " + id + ";");
		dataSource.executeDeleteQuery();
	}

}

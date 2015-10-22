/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import model.dao.ProjectDao;

/**
 * @author dumber
 *
 */
public class ProjectDaoFactory extends GenericDaoFactory implements ProjectDao {
	
	/** 
	 * 
	 */	
	public ProjectDaoFactory(){
		super("`projects`");

	}
	
	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#getAllTableElements()
	 */
	@Override
	public List<Project> getAllTableElements()  throws SQLException {
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
	 * @see model.dao.ProjectDao#findElementById(int)
	 */
	@Override
	public Project findElementById(int id) throws SQLException {
		Project p = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.projects WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			p = new Project(rs.getInt("id"), rs.getString("project_name"));
		}
		rs.close();
		return p;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#addElementToTable(model.Project)
	 */
	@Override
	public void addElementToTable(Project project) throws SQLException {
		if (project != null) {
			dataSource.setInsertQueryString("`projects` (`project_name`) VALUES (" + project.toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt project into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectDao#updateElementInTalbe(int, model.Project)
	 */
	@Override
	public void updateElementInTalbe(int id, Project project) throws SQLException{
		if (project != null) {
			dataSource.setUpdateQueryString("`projects` SET " + project.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt project \n");
		}
	}
}

/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.ProjectUser;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class ProjectUserDaoFactory extends GenericDaoFactory implements GenericDaoIFC {
	
	/**
	 * 
	 */
	public ProjectUserDaoFactory() {
		super();
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<ProjectUser> project_users = new ArrayList<ProjectUser>();
		dataSource.setSelectQueryString("`project_users`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			ProjectUser dp = new ProjectUser(rs.getInt("pu_id"), rs.getInt("project_id"), rs.getInt("user_id"));
			project_users.add(dp);
		}
		rs.close();
		return project_users;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, Class<T>)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int pu_id, Class<T> type) throws SQLException {
		ProjectUser pu = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`project_users` WHERE pu_id = ?" );
		dataSource.executeSelectByIdQuery(pu_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			pu = new ProjectUser(rs.getInt("pu_id"), rs.getInt("project_id"), rs.getInt("user_id"));
		}
		rs.close();
		return type.cast(pu);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ProjectUser findProjectUserById(int id) throws SQLException {
		return findElementById(id, ProjectUser.class);
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(T)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T project_user) throws SQLException {
		if (((ProjectUser)project_user) != null) {
			dataSource.setInsertQueryString("`project_users` (`project_id`, `user_id` ) VALUES (" +
				((ProjectUser)project_user).getPuProject_id() + ", " + ((ProjectUser)project_user).getPuUser_id() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt project_user into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, T)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int pu_id, T project_user) throws SQLException {
		if (((ProjectUser)project_user) != null) {
			dataSource.setUpdateQueryString("`project_users` SET `project_id` = " + ((ProjectUser)project_user).getPuProject_id() + 
				", `user_id` = " + ((ProjectUser)project_user).getPuUser_id() + " WHERE `pu_id` = " + pu_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt project user \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int pu_id) throws SQLException {
		dataSource.setDeleteQueryString("`project_users` WHERE pu_id = " + pu_id + ";");
		dataSource.executeDeleteQuery();
	}

}

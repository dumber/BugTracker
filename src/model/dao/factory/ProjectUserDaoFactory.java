/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProjectUser;
import model.dao.ProjectUserDao;

/**
 * @author dumber
 *
 */
public class ProjectUserDaoFactory extends GenericDaoFactory implements ProjectUserDao {
	
	/**
	 * 
	 */
	public ProjectUserDaoFactory() {
		super("`project_users`");
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectUserDao#getAllTableElements()
	 */
	@Override
	public List<ProjectUser> getAllTableElements() throws SQLException {
		List<ProjectUser> project_users = new ArrayList<ProjectUser>();
		dataSource.setSelectQueryString("`project_users_view`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			ProjectUser dp = new ProjectUser(rs.getInt("id"), rs.getString("project_name"), rs.getString("username"));
			project_users.add(dp);
		}
		rs.close();
		return project_users;
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectUserDao#findElementById(int)
	 */
	@Override
	public ProjectUser findElementById(int id) throws SQLException {
		ProjectUser pu = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`project_users_view` WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			pu = new ProjectUser(rs.getInt("id"), rs.getString("project_name"), rs.getString("username"));
		}
		rs.close();
		return pu;
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectUserDao#addElementToTable(model.ProjectUser)
	 */
	@Override
	public void addElementToTable(ProjectUser project_user) throws SQLException {
		if (project_user != null) {
			dataSource.setInsertQueryString("`project_users` (`project_id`, `user_id` ) VALUES (" +
				project_user.toInsertString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt project_user into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectUserDao#updateElementInTalbe(int, model.ProjectUser)
	 */
	@Override
	public void updateElementInTalbe(int id, ProjectUser project_user) throws SQLException {
		if (project_user != null) {
			dataSource.setUpdateQueryString("`project_users` SET " + project_user.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt project user \n");
		}
	}
}

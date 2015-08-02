/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.MySqlDataSourceSingleton;
import model.ProjectUser;
import model.dao.ProjectUserDao;

/**
 * @author dumber
 *
 */
public class ProjectUserDaoFactory implements ProjectUserDao {
	MySqlDataSourceSingleton db = MySqlDataSourceSingleton.getInstance();
	List<ProjectUser> project_users;
	ProjectUser project_user;
	/**
	 * @throws SQLException 
	 * 
	 */
	public ProjectUserDaoFactory() throws SQLException {
		project_users = new ArrayList<ProjectUser>();
		db.setSelectQueryString("`project_users`");
		db.executeSelectQuery();
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			ProjectUser dp = new ProjectUser(rs.getInt("pu_id"), rs.getInt("project_id"), rs.getInt("user_id"));
			project_users.add(dp);
		}
		rs.close();
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectUserDao#getAllProjectUsers()
	 */
	@Override
	public List<ProjectUser> getAllProjectUsers() {
		return project_users;
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectUserDao#findProjectUser(int)
	 */
	@Override
	public ProjectUser findProjectUser(int pu_id) {
		return project_users.get(pu_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectUserDao#addProjectUser(model.ProjectUser)
	 */
	@Override
	public void addProjectUser(ProjectUser project_user) throws SQLException {
		project_users.add(project_user);
		db.setInsertQueryString("`project_users` (`project_id`, `user_id` ) VALUES (" +
				project_user.getPuProject_id() + ", " + project_user.getPuUser_id() + ");");
		db.executeInsertQuery();
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectUserDao#updateProjectUser(model.ProjectUser)
	 */
	@Override
	public void updateProjectUser(int pu_id, int pu_project_id, int pu_user_id) throws SQLException {
		ProjectUser pu = findProjectUser(pu_id);
		pu.setPuUser_id(pu_project_id);
		pu.setPuProject_id(pu_user_id);
		db.setUpdateQueryString("`project_users` SET `project_id` = " + pu_project_id + 
				"`user_id` = " + pu_user_id + " WHERE `pu_id` = " + pu_id + ";");
		db.executeUpdateQuery();
	}

	/* (non-Javadoc)
	 * @see model.dao.ProjectUserDao#deleteProjectUser(int)
	 */
	@Override
	public void deleteProjectUser(int pu_id) throws SQLException {
		project_users.remove(pu_id);
		db.setDeleteQueryString("`project_users` WHERE pu_id = " + pu_id + ";");
		db.executeDeleteQuery();
	}

}

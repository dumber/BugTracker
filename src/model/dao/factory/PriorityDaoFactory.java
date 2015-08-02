/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.MySqlDataSourceSingleton;
import model.Priority;
import model.dao.PriorityDao;

/**
 * @author dumber
 *
 */
public class PriorityDaoFactory implements PriorityDao {
	MySqlDataSourceSingleton db = MySqlDataSourceSingleton.getInstance();
	List<Priority> priorities;
		
	public PriorityDaoFactory() throws SQLException {
		priorities = new ArrayList<Priority>();
		db.setSelect_command("`priorities`");
		db.executeSelectCommand();
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			Priority prio = new Priority(rs.getInt("pr_id"),rs.getString("priority"));
			priorities.add(prio);
		}
		rs.close();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#getAllPrioritys()
	 */
	@Override
	public List<model.Priority> getAllPrioritys() {
		return priorities;
	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#findPriority(int)
	 */
	@Override
	public Priority findPriority(int p_id) {
		return priorities.get(p_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#addPriority(model.Priority)
	 */
	@Override
	public void addPriority(Priority priority) throws SQLException {
		priorities.add(priority);
		db.setInsert_command("`priorities` (`priority`) VALUES (" + priority.getPriority() + ");");
		db.executeInsertCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#updatePriority(model.Priority)
	 */
	@Override
	public void updatePriority(int p_id, String priority) throws SQLException {
		findPriority(p_id).setPriority(priority);
		db.setUpdate_command("`priorities` SET `priority` = " + priority + " WHERE `p_id` = " + p_id + ";");
		db.executeUpdateCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#deletePriority(model.Priority)
	 */
	@Override
	public void deletePriority(int p_id) throws SQLException {
		priorities.remove(p_id);
		db.setDelete_command("`priorities` WHERE p_id = " + p_id + ";");
		db.executeDeleteCommand();
	}

}

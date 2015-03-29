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
	
	private static final String SQL_QUERY = "select * from priorities";
	
	public PriorityDaoFactory() throws SQLException {
		priorities = new ArrayList<Priority>();
		db.setResultSet(db.getStmt().executeQuery(SQL_QUERY));
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			Priority prio = new Priority(rs.getInt("pr_id"),rs.getString("priority"));
			priorities.add(prio);
		}
	}
	
	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#getAllPrioritys()
	 */
	@Override
	public List<model.Priority> getAllPrioritys() {
		return priorities;
	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#getPriority(int)
	 */
	@Override
	public Priority getPriority(int p_id) {
		return priorities.get(p_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#findPriority(int)
	 */
	@Override
	public String findPriority(int p_id) {
		return priorities.get(p_id).getPriority();
	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#addPriority(model.Priority)
	 */
	@Override
	public void addPriority(Priority priority) {
		priorities.add(priority);
		// TODO create the SQL insert command
	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#updatePriority(model.Priority)
	 */
	@Override
	public void updatePriority(Priority priority) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#deletePriority(model.Priority)
	 */
	@Override
	public void deletePriority(int p_id) {
		priorities.remove(p_id);
		// TODO create the SQL delete command
	}

}

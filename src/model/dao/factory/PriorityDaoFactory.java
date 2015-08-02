/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.Priority;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class PriorityDaoFactory extends GenericDaoFactory implements GenericDaoIFC {
	List<Priority> priorities;
		
	public PriorityDaoFactory() throws SQLException {
		super();
		priorities = new ArrayList<Priority>();
		dataSource.setSelectQueryString("`priorities`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
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
	public List<? extends GenericTableElement> getAllTableElements() {
		return priorities;
	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#findPriority(int)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int p_id, Class<T> type) {
		Priority tmp = null;
		for (Priority p : priorities) {
			if (p_id == p.getId()) {
				tmp = p;
			}
		}
		return type.cast(tmp);
	}

	public Priority findPriority(int id) {
		return findElementById(id, Priority.class);
	}
	
	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#addPriority(model.Priority)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T priority) throws SQLException {
		priorities.add((Priority)priority);
		dataSource.setInsertQueryString("`priorities` (`priority`) VALUES (" + ((Priority)priority).getPriority() + ");");
		dataSource.executeInsertQuery();
	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#updatePriority(model.Priority)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int p_id, T priority) throws SQLException {
		Priority p = findPriority(p_id);
		if (p != null) {
			p.setPriority(((Priority)priority).getPriority());
			dataSource.setUpdateQueryString("`priorities` SET `priority` = " + p.getPriority() + " WHERE `p_id` = " + p_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			// TODO throw some exceptions
		}		
	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#deletePriority(model.Priority)
	 */
	@Override
	public void deleteElementFromTable(int p_id) throws SQLException {
		priorities.remove(p_id);
		dataSource.setDeleteQueryString("`priorities` WHERE p_id = " + p_id + ";");
		dataSource.executeDeleteQuery();
	}

}

/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Priority;
import model.dao.PriorityDao;

/**
 * @author dumber
 *
 */
public class PriorityDaoFactory extends GenericDaoFactory implements PriorityDao {
	
	/*
	 * 
	 */
	public PriorityDaoFactory() {
		super("`priorities`");
	}
	
	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#getAllTableElements()
	 */
	@Override
	public List<Priority> getAllTableElements() throws SQLException {
		List<Priority> priorities = new ArrayList<Priority>();
		dataSource.setSelectQueryString("`priorities`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			Priority prio = new Priority(rs.getInt("id"),rs.getString("priority"));
			priorities.add(prio);
		}
		rs.close();
		return priorities;
	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#findElementById(int, java.lang.Class)
	 */
	@Override
	public Priority findElementById(int p_id) throws SQLException {
		Priority p = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.priorities WHERE id = ?" );
		dataSource.executeSelectByIdQuery(p_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			p = new Priority(rs.getInt("id"), rs.getString("priority"));
		}
		rs.close();
		return p;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#addElementToTable(model.Priority)
	 */
	@Override
	public void addElementToTable(Priority priority) throws SQLException {
		if (priority != null){
			dataSource.setInsertQueryString("`priorities` (`priority`) VALUES (" + priority.toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt priority into database");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.PriorityDao#updateElementInTalbe(int, model.Priority)
	 */
	@Override
	public void updateElementInTalbe(int p_id, Priority priority) throws SQLException {
		if (priority != null) {
			dataSource.setUpdateQueryString("`priorities` SET " + priority.toUpdateString() 
					+ " WHERE `id` = " + p_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt priority\n");
		}		
	}

}

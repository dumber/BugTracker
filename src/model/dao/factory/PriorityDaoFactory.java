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
	
	/*
	 * 
	 */
	public PriorityDaoFactory() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<Priority> priorities = new ArrayList<Priority>();
		dataSource.setSelectQueryString("`priorities`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			Priority prio = new Priority(rs.getInt("pr_id"),rs.getString("priority"));
			priorities.add(prio);
		}
		rs.close();
		return priorities;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int p_id, Class<T> type) throws SQLException {
		Priority p = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.actions WHERE pr_id = ?" );
		dataSource.executeSelectByIdQuery(p_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			p = new Priority(rs.getInt("pr_id"), rs.getString("priority"));
		}
		rs.close();
		return type.cast(p);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Priority findPriorityById(int id) throws SQLException {
		return findElementById(id, Priority.class);
	}

	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T priority) throws SQLException {
		if (priority != null){
			dataSource.setInsertQueryString("`priorities` (`priority`) VALUES (" + ((Priority)priority).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt priority into database");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int p_id, T priority) throws SQLException {
		if (((Priority)priority) != null) {
			dataSource.setUpdateQueryString("`priorities` SET " + ((Priority)priority).toUpdateString() 
					+ " WHERE `pr_id` = " + p_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt priority\n");
		}		
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int p_id) throws SQLException {
		dataSource.setDeleteQueryString("`priorities` WHERE pr_id = " + p_id + ";");
		dataSource.executeDeleteQuery();
	}

}

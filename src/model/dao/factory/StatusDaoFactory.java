/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.Status;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class StatusDaoFactory extends GenericDaoFactory implements GenericDaoIFC {

	/*
	 * 
	 */
	public StatusDaoFactory() throws SQLException {
		super();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, Class<T>)
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<Status> statuses = new ArrayList<Status>();
		dataSource.setSelectQueryString("`statuses`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			Status s = new Status(rs.getInt("s_id"), rs.getString("status"));
			statuses.add(s);
		}
		rs.close();
		return statuses;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, Class<T>)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int s_id, Class<T> type) throws SQLException {
		Status s = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.statuses WHERE s_id = ?" );
		dataSource.executeSelectByIdQuery(s_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			s = new Status(rs.getInt("s_id"), rs.getString("status"));
		}
		rs.close();
		return type.cast(s);
	}

	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Status findTicketStateById(int id) throws SQLException {
		return findElementById(id, Status.class);
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(T)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T status) throws SQLException {
		if (((Status)status) != null) {
			dataSource.setInsertQueryString("`statuses` (`status`) VALUES (\'" + ((Status)status).getStatus() + "\');");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt status into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, T)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int s_id, T status) throws SQLException {		
		if (((Status)status) != null) {
			dataSource.setUpdateQueryString("`statuses` SET `status` = \'" + ((Status)status).getStatus() + "\' WHERE `s_id` = " + s_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt status \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int s_id) throws SQLException {
		dataSource.setDeleteQueryString("`statuses` WHERE s_id = " + s_id + ";");
		dataSource.executeDeleteQuery();
	}

}

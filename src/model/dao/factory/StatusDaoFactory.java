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
	public StatusDaoFactory() {
		super("`statuses`");
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<Status> statuses = new ArrayList<Status>();
		dataSource.setSelectQueryString("`statuses`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			Status s = new Status(rs.getInt("id"), rs.getString("status"));
			statuses.add(s);
		}
		rs.close();
		return statuses;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int id, Class<T> type) throws SQLException {
		Status s = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.statuses WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			s = new Status(rs.getInt("id"), rs.getString("status"));
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
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T status) throws SQLException {
		if (((Status)status) != null) {
			dataSource.setInsertQueryString("`statuses` (`status`) VALUES (" + ((Status)status).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt status into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int id, T status) throws SQLException {		
		if (((Status)status) != null) {
			dataSource.setUpdateQueryString("`statuses` SET " + ((Status)status).toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt status \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int id) throws SQLException {
		dataSource.setDeleteQueryString("`statuses` WHERE `id` = " + id + ";");
		dataSource.executeDeleteQuery();
	}

}

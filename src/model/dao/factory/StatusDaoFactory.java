/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Status;
import model.dao.StatusDao;

/**
 * @author dumber
 *
 */
public class StatusDaoFactory extends GenericDaoFactory implements StatusDao {

	/*
	 * 
	 */
	public StatusDaoFactory() {
		super("`statuses`");
	}
	
	/* (non-Javadoc)
	 * @see model.dao.StatusDao#getAllTableElements()
	 */
	@Override
	public List<Status> getAllTableElements() throws SQLException {
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
	 * @see model.dao.StatusDao#findElementById(int)
	 */
	@Override
	public Status findElementById(int id) throws SQLException {
		Status s = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.statuses WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			s = new Status(rs.getInt("id"), rs.getString("status"));
		}
		rs.close();
		return s;
	}

	/* (non-Javadoc)
	 * @see model.dao.StatusDao#addElementToTable(model.Status)
	 */
	@Override
	public void addElementToTable(Status status) throws SQLException {
		if (status != null) {
			dataSource.setInsertQueryString("`statuses` (`status`) VALUES (" + status.toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt status into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.StatusDao#updateElementInTalbe(int, model.Status)
	 */
	@Override
	public void updateElementInTalbe(int id, Status status) throws SQLException {		
		if (status != null) {
			dataSource.setUpdateQueryString("`statuses` SET " + status.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt status \n");
		}
	}

}

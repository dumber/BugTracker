/**
 * 
 */
package model.dao.factory;

import helper.MySqlDataSourceSingleton;

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
public class StatusDaoFactory implements StatusDao {
	MySqlDataSourceSingleton db = MySqlDataSourceSingleton.getInstance();
	List<Status> statuses;
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public StatusDaoFactory() throws SQLException {
		statuses = new ArrayList<Status>();
		db.setSelectQueryString("`statuses`");
		db.executeSelectQuery();
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			Status s = new Status(rs.getInt("s_id"),rs.getString("status"));
			statuses.add(s);
		}
		rs.close();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.StatusDao#getAllTicketState()
	 */
	@Override
	public List<Status> getAllTicketState() {
		return statuses;
	}

	/* (non-Javadoc)
	 * @see model.dao.StatusDao#findTicketState(int)
	 */
	@Override
	public Status findTicketState(int ts_id) {
		return statuses.get(ts_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.StatusDao#addTicketState(model.Status)
	 */
	@Override
	public void addTicketState(Status status) throws SQLException {
		statuses.add(status);
		db.setInsertQueryString("`actions` (`action`) VALUES (" + status.getStatus() + ");");
		db.executeInsertQuery();
	}

	/* (non-Javadoc)
	 * @see model.dao.StatusDao#updateTicketState(model.Status)
	 */
	@Override
	public void updateTicketState(int s_id, String status) throws SQLException {		
		findTicketState(s_id).setStatus(status);
		db.setUpdateQueryString("`actions` SET `action` = " + status + " WHERE `ts_id` = " + s_id + ";");
		db.executeUpdateQuery();
	}

	/* (non-Javadoc)
	 * @see model.dao.StatusDao#deleteTicketState(model.Status)
	 */
	@Override
	public void deleteTicketState(int s_id) throws SQLException {
		statuses.remove(s_id);
		db.setDeleteQueryString("`projects` WHERE ts_id = " + s_id + ";");
		db.executeDeleteQuery();
	}

}

/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TicketHistory;
import model.dao.TicketHistoryDao;

/**
 * @author dumber
 *
 */
public class TicketHistoryDaoFactory extends GenericDaoFactory implements
		TicketHistoryDao {

	/**
	 * 
	 */
	public TicketHistoryDaoFactory() {
		super("`ticket_histories`");
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketHistoryDao#getAllTableElements()
	 */
	@Override
	public List<TicketHistory> getAllTableElements() throws SQLException {
		List<TicketHistory> histories = new ArrayList<TicketHistory>();
		dataSource.setSelectQueryString("`ticket_histories_view`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketHistory th = new TicketHistory(rs.getInt("id"), rs.getInt("th_ticket_id"), 
					rs.getString("modifier"), rs.getString("old_status"), 
					rs.getString("new_status"), rs.getString("action"), 
					rs.getTimestamp("modification_date"));
			histories.add(th);
		}
		rs.close();
		return histories;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketHistoryDao#findElementById(int)
	 */
	@Override
	public TicketHistory findElementById(int ta_id) throws SQLException {
		TicketHistory th = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`ticket_histories_view` WHERE id = ?");
		dataSource.executeSelectByIdQuery(ta_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			th = new TicketHistory(rs.getInt("id"), rs.getInt("th_ticket_id"), 
						rs.getString("modifier"), rs.getString("old_status"), 
						rs.getString("new_status"), rs.getString("action"), 
						rs.getTimestamp("modification_date"));
		}
		rs.close();
		return th;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TicketHistoryDao#addElementToTable(model.TicketHistory)
	 */
	@Override
	public void addElementToTable(TicketHistory th) throws SQLException {
		if (th != null) {
			dataSource.setInsertQueryString("`ticket_histories` (`th_ticket_id`,`modifier_user_id`,`old_state_id`,"
					+ "`new_state_id`,`action_id`,`modification_date`) VALUES (" + th.toInsertString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_history into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketHistoryDao#updateElementInTalbe(int, model.TicketHistory)
	 */
	@Override
	public  void updateElementInTalbe(int id, TicketHistory th) throws SQLException {
		if (th != null) {
			dataSource.setUpdateQueryString("`ticket_histories` SET " + th.toUpdateString() 
					+ " WHERE `id` =" + id + ";" );
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_history \n");
		}
	}

}

/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.TicketHistory;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class TicketHistoryDaoFactory extends GenericDaoFactory implements
		GenericDaoIFC {

	/**
	 * 
	 */
	public TicketHistoryDaoFactory() {
		super();
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<TicketHistory> histories = new ArrayList<TicketHistory>();
		dataSource.setSelectQueryString("`ticket_histories`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketHistory th = new TicketHistory(rs.getInt("th_id"), rs.getInt("th_ticket_id"), 
						rs.getInt("modifier_user_id"), rs.getInt("old_state_id"), 
						rs.getInt("new_state_id"), rs.getInt("action_id"), 
						rs.getTimestamp("modification_date"));
			histories.add(th);
		}
		rs.close();
		return histories;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int ta_id, Class<T> type) throws SQLException {
		TicketHistory th = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.ticket_histories WHERE th_id = ?");
		dataSource.executeSelectByIdQuery(ta_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			th = new TicketHistory(rs.getInt("th_id"), rs.getInt("th_ticket_id"), 
						rs.getInt("modifier_user_id"), rs.getInt("old_state_id"), 
						rs.getInt("new_state_id"), rs.getInt("action_id"), 
						rs.getTimestamp("modification_date"));
		}
		rs.close();
		return type.cast(th);
	}

	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public TicketHistory findTicketHistoryById(int id) throws SQLException {
		return findElementById(id, TicketHistory.class);
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T th) throws SQLException {
		if (((TicketHistory)th) != null) {
			dataSource.setInsertQueryString("`ticket_histories` (`th_ticket_id`,`modifier_user_id`,`old_state_id`,"
					+ "`new_state_id`,`action_id`,`modification_date`) VALUES (" + ((TicketHistory)th).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_history into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int th_id, T th) throws SQLException {
		if (((TicketHistory)th) != null) {
			dataSource.setUpdateQueryString("`ticket_histories` SET " + ((TicketHistory)th).toUpdateString() 
					+ " WHERE th_id=" + th_id + ";" );
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_history \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int th_id) throws SQLException {
		dataSource.setDeleteQueryString("`ticket_histories` WHERE th_id = " + th_id +";");
		dataSource.executeDeleteQuery();
	}

}

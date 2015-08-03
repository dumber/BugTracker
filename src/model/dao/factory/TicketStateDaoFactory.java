/**
 * 
 */
package model.dao.factory;

import helper.MySqlDataSourceSingleton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TicketState;
import model.dao.TicketStateDao;

/**
 * @author dumber
 *
 */
public class TicketStateDaoFactory implements TicketStateDao {
	MySqlDataSourceSingleton db = MySqlDataSourceSingleton.getInstance();
	List<TicketState> ticket_states;
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public TicketStateDaoFactory() throws SQLException {
		ticket_states = new ArrayList<TicketState>();
		db.setSelectQueryString("`ticket_states`");
		db.executeSelectQuery();
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			TicketState ts = new TicketState(rs.getInt("ts_id"),rs.getString("ticket_state"));
			ticket_states.add(ts);
		}
		rs.close();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TicketStateDao#getAllTicketState()
	 */
	@Override
	public List<TicketState> getAllTicketState() {
		return ticket_states;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketStateDao#findTicketState(int)
	 */
	@Override
	public TicketState findTicketState(int ts_id) {
		return ticket_states.get(ts_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketStateDao#addTicketState(model.TicketState)
	 */
	@Override
	public void addTicketState(TicketState ticket_state) throws SQLException {
		ticket_states.add(ticket_state);
		db.setInsertQueryString("`actions` (`action`) VALUES (" + ticket_state.getTicketState() + ");");
		db.executeInsertQuery();
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketStateDao#updateTicketState(model.TicketState)
	 */
	@Override
	public void updateTicketState(int ts_id, String ticket_state) throws SQLException {		
		findTicketState(ts_id).setTicketState(ticket_state);
		db.setUpdateQueryString("`actions` SET `action` = " + ticket_state + " WHERE `ts_id` = " + ts_id + ";");
		db.executeUpdateQuery();
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketStateDao#deleteTicketState(model.TicketState)
	 */
	@Override
	public void deleteTicketState(int ts_id) throws SQLException {
		ticket_states.remove(ts_id);
		db.setDeleteQueryString("`projects` WHERE ts_id = " + ts_id + ";");
		db.executeDeleteQuery();
	}

}

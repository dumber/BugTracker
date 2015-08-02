/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.MySqlDataSourceSingleton;
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
		db.setSelect_command("`ticket_states`");
		db.executeSelectCommand();
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
		db.setInsert_command("`actions` (`action`) VALUES (" + ticket_state.getTicketState() + ");");
		db.executeInsertCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketStateDao#updateTicketState(model.TicketState)
	 */
	@Override
	public void updateTicketState(int ts_id, String ticket_state) throws SQLException {		
		findTicketState(ts_id).setTicketState(ticket_state);
		db.setUpdate_command("`actions` SET `action` = " + ticket_state + " WHERE `ts_id` = " + ts_id + ";");
		db.executeUpdateCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketStateDao#deleteTicketState(model.TicketState)
	 */
	@Override
	public void deleteTicketState(int ts_id) throws SQLException {
		ticket_states.remove(ts_id);
		db.setDelete_command("`projects` WHERE ts_id = " + ts_id + ";");
		db.executeDeleteCommand();
	}

}

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
	
	private static final String SQL_QUERY = "select * from ticket_states";
	
	public TicketStateDaoFactory() throws SQLException {
		ticket_states = new ArrayList<TicketState>();
		db.setResultSet(db.getStmt().executeQuery(SQL_QUERY));
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			TicketState ts = new TicketState(rs.getInt("ts_id"),rs.getString("ticket_state"));
			ticket_states.add(ts);
		}
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TicketStateDao#getAllTicketState()
	 */
	@Override
	public List<TicketState> getAllTicketState() {
		return ticket_states;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketStateDao#getTicketState(int)
	 */
	@Override
	public TicketState getTicketState(int ts_id) {
		return ticket_states.get(ts_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketStateDao#findTicketState(int)
	 */
	@Override
	public String findTicketState(int ts_id) {
		return ticket_states.get(ts_id).getTicketState();
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketStateDao#addTicketState(model.TicketState)
	 */
	@Override
	public void addTicketState(TicketState ticket_state) {
		ticket_states.add(ticket_state);
		// TODO create the SQL insert command

	}

	/* (non-Javadoc)
	 * @see model.dao.TicketStateDao#updateTicketState(model.TicketState)
	 */
	@Override
	public void updateTicketState(TicketState ticket_state) {		
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketStateDao#deleteTicketState(model.TicketState)
	 */
	@Override
	public void deleteTicketState(int ts_id) {
		ticket_states.remove(ts_id);
		// TODO create the SQL delete command
	}

}

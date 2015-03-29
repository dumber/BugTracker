/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.TicketState;

/**
 * @author dumber
 *
 */
public interface TicketStateDao {
	public List<TicketState> getAllTicketState();
	public TicketState findTicketState(int ts_id);
	public void addTicketState(TicketState ticket_state) throws SQLException;
	public void updateTicketState(int ts_id, String ticket_state) throws SQLException;
	public void deleteTicketState(int ts_id) throws SQLException;
}

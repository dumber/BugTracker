/**
 * 
 */
package model.dao;

import java.util.List;

import model.TicketState;

/**
 * @author dumber
 *
 */
public interface TicketStateDao {
	public List<TicketState> getAllTicketState();
	public TicketState getTicketState(int ts_id);
	public String findTicketState(int ts_id);
	public void addTicketState(TicketState ticket_state);
	public void updateTicketState(TicketState ticket_state);
	public void deleteTicketState(int ts_id);
}

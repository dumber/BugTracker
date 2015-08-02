/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.TicketHeader;

/**
 * @author dumber
 *
 */
public interface TicketHeaderDao {
	public List<TicketHeader> getAllTicketHeaders();
	public TicketHeader findTicket(int t_id);
	public void addTicketHeader(TicketHeader ticket) throws SQLException;
	public void updateTicketHeader(int t_id, int u_t_id, int p_id, String hl, 
			String desc, int s_id, int pri_id, int st_id, int lt_id) throws SQLException;
	public void deleteTicketHeader(int t_id) throws SQLException;
}

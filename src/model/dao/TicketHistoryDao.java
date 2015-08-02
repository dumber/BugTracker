/**
 * 
 */
package model.dao;

import java.util.List;
import model.TicketHistory;

/**
 * @author dumber
 *
 */
public interface TicketHistoryDao {
	public List<TicketHistory> getAllTicketHistorys();
	public TicketHistory getTicketHistory(int th_id);
	public String findTicketHistory(int th_id);
	public void addTicketHistory(TicketHistory ticket_history);
	public void updateTicketHistory(TicketHistory ticket_history);
	public void deleteTicketHistory(int th_id);
}

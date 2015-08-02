/**
 * 
 */
package model.dao;

import java.util.List;
import model.TicketWorkload;

/**
 * @author dumber
 *
 */
public interface TicketWorkloadDao {
	public List<TicketWorkload> getAllTicketWorkloads();
	public TicketWorkload getTicketWorkload(int tw_id);
	public String findTicketWorkload(int tw_id);
	public void addTicketWorkload(TicketWorkload ticket_workload);
	public void updateTicketWorkload(TicketWorkload ticket_workload);
	public void deleteTicketWorkload(int tw_id);
}

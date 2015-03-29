/**
 * 
 */
package model.dao;

import java.util.List;
import model.TicketRealisation;

/**
 * @author dumber
 *
 */
public interface TicketRealisationDao {
	public List<TicketRealisation> getAllTicketRealisations();
	public TicketRealisation getTicketRealisation(int tr_id);
	public String findTicketRealisation(int tr_id);
	public void addTicketRealisation(TicketRealisation ticket_realisation);
	public void updateTicketRealisation(TicketRealisation ticket_realisation);
	public void deleteTicketRealisation(int tr_id);
}

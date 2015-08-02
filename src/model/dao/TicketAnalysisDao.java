/**
 * 
 */
package model.dao;

import java.util.List;
import model.TicketAnalysis;

/**
 * @author dumber
 *
 */
public interface TicketAnalysisDao {
	public List<TicketAnalysis> getAllTicketAnalysiss();
	public TicketAnalysis getTicketAnalysis(int ta_id);
	public String findTicketAnalysis(int ta_id);
	public void addTicketAnalysis(TicketAnalysis ticket_analysis);
	public void updateTicketAnalysis(TicketAnalysis ticket_analysis);
	public void deleteTicketAnalysis(int ta_id);
}

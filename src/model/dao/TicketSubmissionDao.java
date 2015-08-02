/**
 * 
 */
package model.dao;

import java.util.List;
import model.TicketSubmission;

/**
 * @author dumber
 *
 */
public interface TicketSubmissionDao {
	public List<TicketSubmission> getAllTicketSubmissions();
	public TicketSubmission getTicketSubmission(int ts_id);
	public String findTicketSubmission(int ts_id);
	public void addTicketSubmission(TicketSubmission ticket_submission);
	public void updateTicketSubmission(TicketSubmission ticket_submission);
	public void deleteTicketSubmission(int ts_id);
}

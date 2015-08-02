/**
 * 
 */
package model.dao;

import java.util.List;
import model.TicketValidation;

/**
 * @author dumber
 *
 */
public interface TicketValidationDao {
	public List<TicketValidation> getAllTicketValidations();
	public TicketValidation getTicketValidation(int tv_id);
	public String findTicketValidation(int tv_id);
	public void addTicketValidation(TicketValidation ticket_validation);
	public void updateTicketValidation(TicketValidation ticket_validation);
	public void deleteTicketValidation(int tv_id);
}

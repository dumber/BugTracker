/**
 * 
 */
package model.dao;

import java.util.List;

import model.Ticket;

/**
 * @author dumber
 *
 */
public interface TicketDao {
	public List<Ticket> getAllTickets();
	public Ticket getTicket(int t_id);
	public String findTicket(int t_id);
	public void addTicket(Ticket ticket);
	public void updateTicket(Ticket ticket);
	public void deleteTicket(int t_id);
}

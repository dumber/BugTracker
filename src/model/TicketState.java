package model;

/**
 * @author dumber
 *
 */
public class TicketState extends GenericTableElement {
	private String ticket_state;

	/**
	 * @param ticket_state_id
	 * @param ticket_state
	 */
	public TicketState(int ticket_state_id, String ticket_state) {
		super(ticket_state_id);
		this.ticket_state = ticket_state;
	}

	/**
	 * @param ts
	 */
	public TicketState(TicketState ts) {
		super(ts.id);
		this.ticket_state = ts.ticket_state;
	}
	
	/**
	 * @return the ticket_state
	 */
	public String getTicketState() {
		return ticket_state;
	}

	/**
	 * @param ticket_state the ticket_state to set
	 */
	public void setTicketState(String ticket_state) {
		this.ticket_state = ticket_state;
	}
	
}

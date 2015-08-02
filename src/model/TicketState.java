package model;

/**
 * @author dumber
 *
 */
public class TicketState {
	private int ticket_state_id;
	private String ticket_state;

	/**
	 * @param ticket_state_id
	 * @param ticket_state
	 */
	public TicketState(int ticket_state_id, String ticket_state) {
		this.ticket_state_id = ticket_state_id;
		this.ticket_state = ticket_state;
	}

	/**
	 * @return the ticket_state_id
	 */
	public int getTicketState_id() {
		return ticket_state_id;
	}

	/**
	 * @param ticket_state_id the ticket_state_id to set
	 */
	public void setTicketState_id(int ticket_state_id) {
		this.ticket_state_id = ticket_state_id;
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

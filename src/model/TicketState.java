package model;

/**
 * @author dumber
 *
 */
public class TicketState {
	private int ticket_state_id;
	private String ticket_state;
	
	public TicketState(int ticket_state_id, String ticket_state) {
		super();
		this.ticket_state_id = ticket_state_id;
		this.ticket_state = ticket_state;
	}

	public int getTicketState_id() {
		return ticket_state_id;
	}
	
	public void setTicketState_id(int ticket_state_id) {
		this.ticket_state_id = ticket_state_id;
	}
	
	public String getTicketState() {
		return ticket_state;
	}
	
	public void setTicketState(String ticket_state) {
		this.ticket_state = ticket_state;
	}
	
}

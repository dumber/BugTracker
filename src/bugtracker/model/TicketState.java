package bugtracker.model;

public class TicketState {
	private int ticket_state_id;
	private String ticket_state;
	
	public int getTicket_state_id() {
		return ticket_state_id;
	}
	
	public void setTicket_state_id(int ticket_state_id) {
		this.ticket_state_id = ticket_state_id;
	}
	
	public String getTicket_state() {
		return ticket_state;
	}
	
	public void setTicket_state(String ticket_state) {
		this.ticket_state = ticket_state;
	}
	
}

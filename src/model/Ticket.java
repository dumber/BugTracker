package model;

/**
 * @author dumber
 *
 */
public class Ticket {
	private int t_id;
	private String ticket_name;
	private int t_project_id;
	private String headline;
	private String description;
	private int t_severity_id;
	private int t_priority_id;
	private int t_state_id;
	private int linked_ticket_id;
	
	/**
	 * @param t_id
	 * @param ticket_name
	 * @param t_project_id
	 * @param headline
	 * @param description
	 * @param t_severity_id
	 * @param t_priority_id
	 * @param t_state_id
	 * @param linked_ticket_id
	 */
	public Ticket(int t_id, String ticket_name, int t_project_id,
			String headline, String description, int t_severity_id,
			int t_priority_id, int t_state_id, int linked_ticket_id) {
		this.t_id = t_id;
		this.ticket_name = ticket_name;
		this.t_project_id = t_project_id;
		this.headline = headline;
		this.description = description;
		this.t_severity_id = t_severity_id;
		this.t_priority_id = t_priority_id;
		this.t_state_id = t_state_id;
		this.linked_ticket_id = linked_ticket_id;
	}

	/**
	 * @return the t_id
	 */
	public int getTicket_id() {
		return t_id;
	}

	/**
	 * @param t_id the t_id to set
	 */
	public void setTicket_id(int t_id) {
		this.t_id = t_id;
	}

	/**
	 * @return the ticket_name
	 */
	public String getTicketName() {
		return ticket_name;
	}

	/**
	 * @param ticket_name the ticket_name to set
	 */
	public void setTicketName(String ticket_name) {
		this.ticket_name = ticket_name;
	}

	/**
	 * @return the t_project_id
	 */
	public int getT_Project_id() {
		return t_project_id;
	}

	/**
	 * @param t_project_id the t_project_id to set
	 */
	public void setT_Project_id(int t_project_id) {
		this.t_project_id = t_project_id;
	}

	/**
	 * @return the headline
	 */
	public String getHeadline() {
		return headline;
	}

	/**
	 * @param headline the headline to set
	 */
	public void setHeadline(String headline) {
		this.headline = headline;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the t_severity_id
	 */
	public int getT_Severity_id() {
		return t_severity_id;
	}

	/**
	 * @param t_severity_id the t_severity_id to set
	 */
	public void setT_Severity_id(int t_severity_id) {
		this.t_severity_id = t_severity_id;
	}

	/**
	 * @return the t_priority_id
	 */
	public int getT_Priority_id() {
		return t_priority_id;
	}

	/**
	 * @param t_priority_id the t_priority_id to set
	 */
	public void setT_Priority_id(int t_priority_id) {
		this.t_priority_id = t_priority_id;
	}

	/**
	 * @return the t_state_id
	 */
	public int getT_State_id() {
		return t_state_id;
	}

	/**
	 * @param t_state_id the t_state_id to set
	 */
	public void setT_State_id(int t_state_id) {
		this.t_state_id = t_state_id;
	}

	/**
	 * @return the linked_ticket_id
	 */
	public int getLinked_Ticket_id() {
		return linked_ticket_id;
	}

	/**
	 * @param linked_ticket_id the linked_ticket_id to set
	 */
	public void setLinked_Ticket_id(int linked_ticket_id) {
		this.linked_ticket_id = linked_ticket_id;
	}
		
}

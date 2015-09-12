package model;

/**
 * @author dumber
 *
 */
public class TicketHeader extends GenericTableElement {
	private String unique_ticket_id;
	private int t_project_id;
	private String headline;
	private String description;
	private int t_severity_id;
	private int t_priority_id;
	private int t_state_id;
	private int linked_ticket_id;
	
	/**
	 * @param t_id				the ticket id
	 * @param u_t_id			the unique ticket id
	 * @param t_project_id		the project id of the ticket
	 * @param headline			the headline of the ticket
	 * @param description		the description of the ticket
	 * @param t_severity_id		the severity of the ticket
	 * @param t_priority_id		the priority of the ticket
	 * @param t_state_id		the state of the ticket
	 * @param linked_ticket_id	the linked ticket of the ticket
	 */
	public TicketHeader(int t_id, String u_t_id, int t_project_id,
			String headline, String description, int t_severity_id,
			int t_priority_id, int t_state_id, int linked_ticket_id) {
		super(t_id);
		this.unique_ticket_id = u_t_id;
		this.t_project_id = t_project_id;
		this.headline = headline;
		this.description = description;
		this.t_severity_id = t_severity_id;
		this.t_priority_id = t_priority_id;
		this.t_state_id = t_state_id;
		this.linked_ticket_id = linked_ticket_id;
	}
	
	/**
	 * @param t					the ticket to copy
	 */	
	public TicketHeader(TicketHeader t) {
		super(t.id);
		this.unique_ticket_id = t.unique_ticket_id;
		this.t_project_id = t.t_project_id;
		this.headline = t.headline;
		this.description = t.description;
		this.t_severity_id = t.t_severity_id;
		this.t_priority_id = t.t_priority_id;
		this.t_state_id = t.t_state_id;
		this.linked_ticket_id = t.linked_ticket_id;
	}

	/**
	 * @return the unique_ticket_id
	 */
	public String getUniqueTicke_id() {
		return unique_ticket_id;
	}

	/**
	 * @param u_t_id the ticket_name to set
	 */
	public void getUniqueTicket_id(String u_t_id) {
		this.unique_ticket_id = u_t_id;
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
	
	/**
	 * @param u_t_id
	 * @param t_project_id
	 * @param headline
	 * @param description
	 * @param t_severity_id
	 * @param t_priority_id
	 * @param t_state_id
	 * @param linked_ticket_id
	 */
	public void modifyTicketHeader(String u_t_id, int p_id, String hl, 
			String desc, int s_id, int pri_id, int st_id, int lt_id) {
		this.unique_ticket_id = u_t_id;
		this.t_project_id = p_id;
		this.headline = hl;
		this.description = desc;
		this.t_severity_id = s_id;
		this.t_priority_id = pri_id;
		this.t_state_id = st_id;
		this.linked_ticket_id = lt_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  unique_ticket_id + ", " + t_project_id + ", " + headline + ", " + description + ", "
				+ t_severity_id + ", " + t_priority_id + ", " + t_state_id + ", " + linked_ticket_id ;
	}
	
}

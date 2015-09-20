/**
 * 
 */
package model;

/**
 * @author dumber
 *
 */
public class TicketLink extends GenericTableElement {
	private int t_ticket_id;
	private int t_linked_ticket_id;
	
	/**
	 * @param id
	 * @param t_t_id
	 * @param t_lt_id
	 */
	public TicketLink(int id, int t_t_id, int t_lt_id) {
		super(id);
		this.t_ticket_id = t_t_id;
		this.t_linked_ticket_id = t_lt_id;
	}
	
	/**
	 * @param TicketLink tl
	 */
	public TicketLink(TicketLink tl) {
		super(tl.id);
		this.t_ticket_id = tl.t_ticket_id;
		this.t_linked_ticket_id = tl.t_linked_ticket_id;
	}
	
	/**
	 * @return the t_ticket_id
	 */
	public int getTlTicket_id() {
		return t_ticket_id;
	}
	
	/**
	 * @param t_ticket_id the t_ticket_id to set
	 */
	public void setTlTicket_id(int t_ticket_id) {
		this.t_ticket_id = t_ticket_id;
	}
	
	/**
	 * @return the t_linked_ticket_id
	 */
	public int getTlLinkedTicket_id() {
		return t_linked_ticket_id;
	}
	
	/**
	 * @param t_linked_ticket_id the t_linked_ticket_id to set
	 */
	public void setTlLinkedTicket_id(int t_linked_ticket_id) {
		this.t_linked_ticket_id = t_linked_ticket_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return t_ticket_id	+ ", " + t_linked_ticket_id;
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`t_ticket_id`=" + t_ticket_id + ", `t_linked_ticket_id`=" + t_linked_ticket_id;
	}
	
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketLink [id=" + id + "t_ticket_id=" + t_ticket_id + ", t_linked_ticket_id=" + t_linked_ticket_id + "]";
	}
	
}

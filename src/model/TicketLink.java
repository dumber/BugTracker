/**
 * 
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author dumber
 *
 */
public class TicketLink extends GenericTableElement {
	private IntegerProperty tl_ticket_id;
	private IntegerProperty tl_linked_ticket_id;
	
	/**
	 * @param id
	 * @param tl_t_id
	 * @param tl_lt_id
	 */
	public TicketLink(int id, int tl_t_id, int tl_lt_id) {
		super(id);
		this.tl_ticket_id = new SimpleIntegerProperty(tl_t_id);
		this.tl_linked_ticket_id = new SimpleIntegerProperty(tl_lt_id);
	}
	
	/**
	 * @param TicketLink tl
	 */
	public TicketLink(TicketLink tl) {
		super(tl.getId());
		this.tl_ticket_id = tl.tl_ticket_id;
		this.tl_linked_ticket_id = tl.tl_linked_ticket_id;
	}
	
	/**
	 * @return the tl_ticket_id
	 */
	public int getTlTicket_id() {
		return tl_ticket_id.get();
	}
	
	/**
	 * @param tl_ticket_id the tl_ticket_id to set
	 */
	public void setTlTicket_id(int tl_ticket_id) {
		this.tl_ticket_id.set(tl_ticket_id);
	}
	
	/**
	 * @return the tl_ticket_id
	 */
	public IntegerProperty tlTicketIdProperty() {
		return tl_ticket_id;
	}
	
	/**
	 * @return the tl_linked_ticket_id
	 */
	public int getTlLinkedTicket_id() {
		return tl_linked_ticket_id.get();
	}
	
	/**
	 * @param tl_linked_ticket_id the tl_linked_ticket_id to set
	 */
	public void setTlLinkedTicket_id(int tl_linked_ticket_id) {
		this.tl_linked_ticket_id.set(tl_linked_ticket_id);
	}
	
	/**
	 * @return the tl_linked_ticket_id
	 */
	public IntegerProperty tlLinkedTicketIdProperty() {
		return tl_linked_ticket_id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return tl_ticket_id	+ ", " + tl_linked_ticket_id;
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`tl_ticket_id`=" + tl_ticket_id + ", `tl_linked_ticket_id`=" + tl_linked_ticket_id;
	}
	
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketLink [id=" + id + ", tl_ticket_id=" + tl_ticket_id + ", tl_linked_ticket_id=" + tl_linked_ticket_id + "]";
	}
	
}

/**
 * 
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class TicketLink extends GenericTableElement {
	private IntegerProperty tl_ticket_id;
	private StringProperty linked_ticket;
	private StringProperty linked_headline;
	
	/**
	 * @param id
	 * @param tl_t_id
	 * @param tl_lt_id
	 */
	public TicketLink(int id, int tl_t_id, String linked_t, String linked_h) {
		super(id);
		this.tl_ticket_id = new SimpleIntegerProperty(tl_t_id);
		this.linked_ticket = new SimpleStringProperty(linked_t);
		this.linked_headline = new SimpleStringProperty(linked_h);
	}
	
	/**
	 * @param TicketLink tl
	 */
	public TicketLink(TicketLink tl) {
		super(tl.getId());
		this.tl_ticket_id = tl.tl_ticket_id;
		this.linked_ticket = tl.linked_ticket;
		this.linked_headline = tl.linked_headline;
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
	 * @return the linked_ticket
	 */
	public String getLinkedTicket() {
		return linked_ticket.get();
	}

	/**
	 * @param linked_ticket the linked_ticket to set
	 */
	public void setLinkedTicket(String linked_ticket) {
		this.linked_ticket.set(linked_ticket);
	}

	/**
	 * @return the linked_ticket
	 */
	public StringProperty linkedTicketProperty() {
		return linked_ticket;
	}
	
	/**
	 * @return the linked_headline
	 */
	public String getLinkedHeadline() {
		return linked_headline.get();
	}

	/**
	 * @param linked_h the linked_h to set
	 */
	public void setLinkedHeadline(String linked_h) {
		this.linked_headline.set(linked_h);
	}

	/**
	 * @return the linked_headline 
	 */
	public StringProperty linkedLinkedHeadlineProperty() {
		return linked_headline;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return tl_ticket_id.get()	+ ", " + linked_ticket.get() + ", " + linked_headline.get();
	}
	
	/**
	 * return
	 */
	public String toInsertString() {
		return tl_ticket_id.get()	+ ", (select `id` from `ticket_headers` where `ticket_headers`.`unique_ticket_name` = \'" + linked_ticket.get() + "\')";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`tl_ticket_id`=" + tl_ticket_id.get() + ", `tl_linked_ticket_id`=(select `id` from `ticket_headers` where `ticket_headers`.`unique_ticket_name` = \'" + linked_ticket.get() + "\')";
	}
	
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketLink [id=" + id.get() + ", tl_ticket_id=" + tl_ticket_id.get() + ", linked_ticket=" + linked_ticket.get() + ", linked_headline=" + linked_headline.get() + "]";
	}
	
}

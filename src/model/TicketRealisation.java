/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author dumber
 *
 */
public class TicketRealisation extends GenericTableElement {
	private int tr_ticket_id;
	private String realised_items;
	private int realised_version_id;
	private Timestamp realisation_date;
	private int realiser_user_id;
	
	/**
	 * @param ticket_realisation_id
	 * @param tr_ticket_id
	 * @param realised_items
	 * @param realised_version_id
	 * @param realisation_date
	 * @param realiser_user_id
	 */
	public TicketRealisation(int ticket_realisation_id, int tr_ticket_id,
			String realised_items, int realised_version_id,
			Timestamp realisation_date, int realiser_user_id) {
		super(ticket_realisation_id);
		this.tr_ticket_id = tr_ticket_id;
		this.realised_items = realised_items;
		this.realised_version_id = realised_version_id;
		this.realisation_date = realisation_date;
		this.realiser_user_id = realiser_user_id;
	}

	/**
	 * @param tr
	 */
	public TicketRealisation(TicketRealisation tr) {
		super(tr.id);
		this.tr_ticket_id = tr.tr_ticket_id;
		this.realised_items = tr.realised_items;
		this.realised_version_id = tr.realised_version_id;
		this.realisation_date = tr.realisation_date;
		this.realiser_user_id = tr.realiser_user_id;
	}	

	/**
	 * @return the tr_ticket_id
	 */
	public int getTrTicket_id() {
		return tr_ticket_id;
	}

	/**
	 * @param tr_ticket_id the tr_ticket_id to set
	 */
	public void setTrTicket_id(int tr_ticket_id) {
		this.tr_ticket_id = tr_ticket_id;
	}

	/**
	 * @return the realised_items
	 */
	public String getRealisedItems() {
		return realised_items;
	}

	/**
	 * @param realised_items the realised_items to set
	 */
	public void setRealisedItems(String realised_items) {
		this.realised_items = realised_items;
	}

	/**
	 * @return the realised_version_id
	 */
	public int getRealisedVersion_id() {
		return realised_version_id;
	}

	/**
	 * @param realised_version_id the realised_version_id to set
	 */
	public void setRealisedVersion_id(int realised_version_id) {
		this.realised_version_id = realised_version_id;
	}

	/**
	 * @return the realisation_date
	 */
	public Timestamp getRealisationDate() {
		return realisation_date;
	}

	/**
	 * @param realisation_date the realisation_date to set
	 */
	public void setRealisationDate(Timestamp realisation_date) {
		this.realisation_date = realisation_date;
	}

	/**
	 * @return the realiser_user_id
	 */
	public int getRealiserUser_id() {
		return realiser_user_id;
	}

	/**
	 * @param realiser_user_id the realiser_user_id to set
	 */
	public void setRealiserUser_id(int realiser_user_id) {
		this.realiser_user_id = realiser_user_id;
	}
	
}

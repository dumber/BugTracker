/**
 * 
 */
package model;

import java.sql.Timestamp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class TicketRealisation extends GenericTableElement {
	private IntegerProperty tr_ticket_id;
	private StringProperty realised_items;
	private IntegerProperty realised_version_id;
	private ObjectProperty<Timestamp> realisation_date;
	private IntegerProperty realiser_user_id;
	
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
		this.tr_ticket_id = new SimpleIntegerProperty(tr_ticket_id);
		this.realised_items = new SimpleStringProperty(realised_items);
		this.realised_version_id = new SimpleIntegerProperty(realised_version_id);
		this.realisation_date = new SimpleObjectProperty<Timestamp>(realisation_date);
		this.realiser_user_id = new SimpleIntegerProperty(realiser_user_id);
	}

	/**
	 * @param tr
	 */
	public TicketRealisation(TicketRealisation tr) {
		super(tr.getId());
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
		return tr_ticket_id.get();
	}

	/**
	 * @param tr_ticket_id the tr_ticket_id to set
	 */
	public void setTrTicket_id(int tr_ticket_id) {
		this.tr_ticket_id.set(tr_ticket_id);
	}
	
	/**
	 * @return the tr_ticket_id
	 */
	public IntegerProperty trTicketIdProperty() {
		return tr_ticket_id;
	}
	
	/**
	 * @return the realised_items
	 */
	public String getRealisedItems() {
		return realised_items.get();
	}

	/**
	 * @param realised_items the realised_items to set
	 */
	public void setRealisedItems(String realised_items) {
		this.realised_items.set(realised_items);
	}
	
	/**
	 * @return the realised_items
	 */
	public StringProperty realisedItemsProperty() {
		return realised_items;
	}
	
	/**
	 * @return the realised_version_id
	 */
	public int getRealisedVersion_id() {
		return realised_version_id.get();
	}

	/**
	 * @param realised_version_id the realised_version_id to set
	 */
	public void setRealisedVersion_id(int realised_version_id) {
		this.realised_version_id.set(realised_version_id);
	}
	
	/**
	 * @return the realised_version_id
	 */
	public IntegerProperty realisedVersionIdProperty() {
		return realised_version_id;
	}
	
	/**
	 * @return the realisation_date
	 */
	public Timestamp getRealisationDate() {
		return realisation_date.get();
	}

	/**
	 * @param realisation_date the realisation_date to set
	 */
	public void setRealisationDate(Timestamp realisation_date) {
		this.realisation_date.set(realisation_date);
	}
	
	/**
	 * @return the realisation_date
	 */
	public ObjectProperty<Timestamp> realisationDateProperty() {
		return realisation_date;
	}
	
	/**
	 * @return the realiser_user_id
	 */
	public int getRealiserUser_id() {
		return realiser_user_id.get();
	}

	/**
	 * @param realiser_user_id the realiser_user_id to set
	 */
	public void setRealiserUser_id(int realiser_user_id) {
		this.realiser_user_id.set(realiser_user_id);
	}
	
	/**
	 * @return the realiser_user_id
	 */
	public IntegerProperty realiserUserIdProperty() {
		return realiser_user_id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (realisation_date != null) {
			return tr_ticket_id.get()	+ ", \'" + realised_items.get() + "\', " + realised_version_id.get()
				+ ", \'" + realisation_date.get()	+ "\', " + realiser_user_id.get();
		} else {
			return tr_ticket_id.get()	+ ", \'" + realised_items.get() + "\', " + realised_version_id.get()
					+ ",NULL , " + realiser_user_id.get();
		}
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		if (realisation_date != null) {
			return "`tr_ticket_id`=" + tr_ticket_id.get() + ", `realised_items`=\'" + realised_items.get()
					+ "\', `realised_ver_id`=" + realised_version_id.get() + ", `realisation_date`=\'" 
					+ realisation_date.get() + "\', `realiser_user_id`=" + realiser_user_id.get();
		} else {
			return "`tr_ticket_id`=" + tr_ticket_id.get() + ", `realised_items`=\'" + realised_items.get()
					+ "\', `realised_ver_id`=" + realised_version_id.get() + ", `realisation_date`= NULL" 
					+ ", `realiser_user_id`=" + realiser_user_id.get();
		}
	}	
		
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketRealisation [id=" + id.get() + ", tr_ticket_id=" + tr_ticket_id.get()
				+ ", realised_items=" + realised_items.get()
				+ ", realised_version_id=" + realised_version_id.get()
				+ ", realisation_date=" + realisation_date.get()
				+ ", realiser_user_id=" + realiser_user_id.get() + "]";
	}	
	
}

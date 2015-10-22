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
	private StringProperty realised_version;
	private ObjectProperty<Timestamp> realisation_date;
	private StringProperty realiser;
	
	private IntegerProperty project_id;
	
	/**
	 * @param ticket_realisation_id
	 * @param tr_ticket_id
	 * @param realised_items
	 * @param realised_version
	 * @param realisation_date
	 * @param realiser
	 */
	public TicketRealisation(int ticket_realisation_id, int tr_ticket_id,
			String realised_items, String realised_version,
			Timestamp realisation_date, String realiser, int project_id) {
		super(ticket_realisation_id);
		this.tr_ticket_id = new SimpleIntegerProperty(tr_ticket_id);
		this.realised_items = new SimpleStringProperty(realised_items);
		this.realised_version = new SimpleStringProperty(realised_version);
		this.realisation_date = new SimpleObjectProperty<Timestamp>(realisation_date);
		this.realiser = new SimpleStringProperty(realiser);
		
		this.project_id = new SimpleIntegerProperty(project_id);
	}

	/**
	 * @param tr
	 */
	public TicketRealisation(TicketRealisation tr) {
		super(tr.getId());
		this.tr_ticket_id = tr.tr_ticket_id;
		this.realised_items = tr.realised_items;
		this.realised_version = tr.realised_version;
		this.realisation_date = tr.realisation_date;
		this.realiser = tr.realiser;
		
		this.project_id = tr.project_id;
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
	 * @return the realised_version
	 */
	public String getRealisedVersion() {
		return realised_version.get();
	}

	/**
	 * @param realised_version the realised_version to set
	 */
	public void setRealisedVersion(String realissed_version) {
		this.realised_version.set(realissed_version);
	}

	/**
	 * @return the realised_version
	 */
	public StringProperty realisedVersionProperty() {
		return realised_version;
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
	 * @return the realiser
	 */
	public String getRealiser() {
		return realiser.get();
	}

	/**
	 * @param realiser the realiser to set
	 */
	public void setRealiser(String realiser) {
		this.realiser.set(realiser);
	}

	/**
	 * @return the realiser
	 */
	public StringProperty realiserProperty() {
		return realiser;
	}
	
	
	/**
	 * @return the project_id
	 */
	public int getProject_id() {
		return project_id.get();
	}

	/**
	 * @param project_id the project_id to set
	 */
	public void setProject_id(int project_id) {
		this.project_id.set(project_id);
	}
	
	/**
	 * @return the t_project_id
	 */
	public IntegerProperty projectIdProperty() {
		return project_id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (realisation_date.get() != null) {
			return tr_ticket_id.get()	+ ", \'" + realised_items.get() + "\', " + realised_version.get()
				+ ", \'" + realisation_date.get()	+ "\', " + realiser.get() + ", " 
				+ project_id.get();
		} else {
			return tr_ticket_id.get()	+ ", \'" + realised_items.get() + "\', " + realised_version.get()
					+ ",NULL , " + realiser.get()+ ", " 
							+ project_id.get();
		}
	}
	
	/**
	 * @return
	 */
	public String toInsertString() {
		if (realisation_date.get() != null) {
			return tr_ticket_id.get()	+ ", \'" + realised_items.get() + "\', (select `id` from `project_versions` where `project_versions`.`version` = \'" + realised_version.get()
				+ "\' and `project_versions`.`project_id` = " + project_id.get() + "), \'" + realisation_date.get()	+ "\', (select `id` from `users` where `users`.`username` = \'" + realiser.get() + "\'), " + project_id.get();
		} else {
			return tr_ticket_id.get()	+ ", \'" + realised_items.get() + "\', (select `id` from `project_versions` where `project_versions`.`version` = \'" + realised_version.get()
					+ "\' and `project_versions`.`project_id` = " + project_id.get() + "), NULL, (select `id` from `users` where `users`.`username` = \'" + realiser.get()+ "\'), " 	+ project_id.get();
		}
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		if (realisation_date.get() != null) {
			return "`tr_ticket_id`=" + tr_ticket_id.get() + ", `realised_items`=\'" + realised_items.get()
					+ "\', `realised_ver_id`=(select `id` from `project_versions` where `project_versions`.`version` = \'" + realised_version.get() + "\' and `project_versions`.`project_id` = " + project_id.get() + "), `realisation_date`=\'" 
					+ realisation_date.get() + "\', `realiser_user_id`=(select `id` from `users` where `users`.`username` = \'" + realiser.get() + "\'), project_id = " + project_id.get();
		} else {
			return "`tr_ticket_id`=" + tr_ticket_id.get() + ", `realised_items`=\'" + realised_items.get()
					+ "\', `realised_ver_id`=(select `id` from `project_versions` where `project_versions`.`version` = \'" + realised_version.get() + "\' and `project_versions`.`project_id` = " + project_id.get() + "), `realisation_date`= NULL" 
					+ ", `realiser_user_id`=(select `id` from `users` where `users`.`username` = \'" + realiser.get() + "\'), project_id = " + project_id.get();
		}
	}	
		
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketRealisation [id=" + id.get() + ", tr_ticket_id=" + tr_ticket_id.get()
				+ ", realised_items=" + realised_items.get()
				+ ", realised_version=" + realised_version.get()
				+ ", realisation_date=" + realisation_date.get()
				+ ", realiser=" + realiser.get() + ", " + project_id.get() + "]";
	}	
	
}

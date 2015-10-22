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
public class TicketHistory extends GenericTableElement {
	private IntegerProperty th_ticket_id;
	private StringProperty modifier;
	private StringProperty old_status;
	private StringProperty new_status;
	private StringProperty action;
	private ObjectProperty<Timestamp> modification_date;

	/**
	 * @param ticket_history_id
	 * @param th_ticket_id
	 * @param modifier
	 * @param old_status
	 * @param new_status
	 * @param action
	 * @param modification_date
	 */
	public TicketHistory(int ticket_history_id, int th_ticket_id,
			String modifier, String old_status, String new_status,
			String action, Timestamp modification_date) {
		super(ticket_history_id);
		this.th_ticket_id = new SimpleIntegerProperty(th_ticket_id);
		this.modifier = new SimpleStringProperty(modifier);
		this.old_status = new SimpleStringProperty(old_status);
		this.new_status = new SimpleStringProperty(new_status);
		this.action = new SimpleStringProperty(action);
		this.modification_date = new SimpleObjectProperty<Timestamp>(modification_date);
	}

	/**
	 * @param th
	 */
	public TicketHistory(TicketHistory th) {
		super(th.getId());
		this.th_ticket_id = th.th_ticket_id;
		this.modifier = th.modifier;
		this.old_status = th.old_status;
		this.new_status = th.new_status;
		this.action = th.action;
		this.modification_date = th.modification_date;
	}
	
	/**
	 * @return the th_ticket_id
	 */
	public int getThTicket_id() {
		return th_ticket_id.get();
	}

	/**
	 * @param th_ticket_id the th_ticket_id to set
	 */
	public void setThTicket_id(int th_ticket_id) {
		this.th_ticket_id.set(th_ticket_id);
	}
	
	/**
	 * @return the th_ticket_id
	 */
	public IntegerProperty thTicketIdProperty() {
		return th_ticket_id;
	}
	
	/**
	 * @return the modifier
	 */
	public String getModifier() {
		return modifier.get();
	}

	/**
	 * @param modifier the modifier to set
	 */
	public void setModifier(String modifier) {
		this.modifier.set(modifier);
	}
	
	/**
	 * @return the modifier
	 */
	public StringProperty modifierProperty() {
		return modifier;
	}
	
	/**
	 * @return the old_status
	 */
	public String getOldStatus() {
		return old_status.get();
	}

	/**
	 * @param old_status the old_status to set
	 */
	public void setOldStatus(String old_status) {
		this.old_status.set(old_status);
	}

	/**
	 * @return the old_status
	 */
	public StringProperty oldStatusProperty() {
		return old_status;
	}

	/**
	 * @return the new_status
	 */
	public String getNewStatus() {
		return new_status.get();
	}

	/**
	 * @param new_status the new_status to set
	 */
	public void setNewStatus(String new_status) {
		this.new_status.set(new_status);
	}

	/**
	 * @return the new_status
	 */
	public StringProperty newStatusProperty() {
		return new_status;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action.get();
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action.set(action);
	}

	/**
	 * @return the action
	 */
	public StringProperty actionProperty() {
		return action;
	}
	
	/**
	 * @return the modification_date
	 */
	public Timestamp getModificationDate() {
		return modification_date.get();
	}

	/**
	 * @param modification_date the modification_date to set
	 */
	public void setModificationDate(Timestamp modification_date) {
		this.modification_date.set(modification_date);
	}
		
	/**
	 * @return the modification_date
	 */
	public ObjectProperty<Timestamp> modificationDateProperty() {
		return modification_date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (modification_date.get() != null) {
			return th_ticket_id.get() + ", " + modifier.get() + ", " + old_status.get() + ", " + new_status.get()
				+ ", " + action.get() + ", \'" + modification_date.get() + "\'";
		} else {
			return th_ticket_id.get() + ", " + modifier.get() + ", " + old_status.get() + ", " + new_status.get()
					+ ", " + action.get() + ", NULL";
		}
	}
	
	/**
	 * 
	 */
	public String toInsertString() {
		if (modification_date.get() != null) {
			return th_ticket_id.get() + ", (select `id` from `users` where `users`.`username` = \'" + modifier.get() + "\'), (select `id` from `statuses` where `statuses`.`status` = \'" + old_status.get() + "\'), (select `id` from `statuses` where `statuses`.`status` = \'" + new_status.get()
				+ "\'), (select `id` from `actions` where `actions`.`action` = \'" + action.get() + "\'), \'" + modification_date.get() + "\'";
		} else {
			return th_ticket_id.get() + ", (select `id` from `users` where `users`.`username` = \'" + modifier.get() + "\'), (select `id` from `statuses` where `statuses`.`status` = \'" + old_status.get() + "\'), (select `id` from `statuses` where `statuses`.`status` = \'" + new_status.get()
					+ "\'), (select `id` from `actions` where `actions`.`action` = \'" + action.get() + ", NULL";
		}
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		if (modification_date.get() != null) {
			return "`th_ticket_id`=" + th_ticket_id.get() + ", `modifier_user_id`=(select `id` from `users` where `users`.`username` = \'" + modifier.get() + "\'), `old_status_id`=(select `id` from `statuses` where `statuses`.`status` = \'"
				+ old_status.get() + "\'), `new_status_id`=(select `id` from `statuses` where `statuses`.`status` = \'" + new_status.get() + "\'), `action_id`=(select `id` from `actions` where `actions`.`action` = \'" + action .get()
				+ "\'), `modification_date`=\'" + modification_date.get() + "\'";
		} else {
			return "`th_ticket_id`=" + th_ticket_id.get() + ", `modifier_user_id`=(select `id` from `users` where `users`.`username` = \'" + modifier.get() + "\'), `old_status_id`=(select `id` from `statuses` where `statuses`.`status` = \'"
					+ old_status.get() + "\'), `new_status_id`=(select `id` from `statuses` where `statuses`.`status` = \'" + new_status.get()	+ "\'), `action_id`=(select `id` from `actions` where `actions`.`action` = \'" + action .get()
					+ ", `modification_date`= NULL";
		}
	}
		
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketHistory [id=" + id.get() + ", th_ticket_id=" + th_ticket_id.get()
				+ ", modifier=" + modifier.get() + ", old_status="
				+ old_status.get() + ", new_status=" + new_status.get()
				+ ", action=" + action.get() + ", modification_date="
				+ modification_date.get() + "]";
	}	
	
}

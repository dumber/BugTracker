/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author dumber
 *
 */
public class TicketHistory extends GenericTableElement {
	private int th_ticket_id;
	private int modifier_user_id;
	private int old_state_id;
	private int new_state_id;
	private int action_id;
	private Timestamp modification_date;

	/**
	 * @param ticket_history_id
	 * @param th_ticket_id
	 * @param modifier_user_id
	 * @param old_state_id
	 * @param new_state_id
	 * @param action_id
	 * @param modification_date
	 */
	public TicketHistory(int ticket_history_id, int th_ticket_id,
			int modifier_user_id, int old_state_id, int new_state_id,
			int action_id, Timestamp modification_date) {
		super(ticket_history_id);
		this.th_ticket_id = th_ticket_id;
		this.modifier_user_id = modifier_user_id;
		this.old_state_id = old_state_id;
		this.new_state_id = new_state_id;
		this.action_id = action_id;
		this.modification_date = modification_date;
	}

	/**
	 * @param th
	 */
	public TicketHistory(TicketHistory th) {
		super(th.id);
		this.th_ticket_id = th.th_ticket_id;
		this.modifier_user_id = th.modifier_user_id;
		this.old_state_id = th.old_state_id;
		this.new_state_id = th.new_state_id;
		this.action_id = th.action_id;
		this.modification_date = th.modification_date;
	}
	
	/**
	 * @return the th_ticket_id
	 */
	public int getThTicket_id() {
		return th_ticket_id;
	}

	/**
	 * @param th_ticket_id the th_ticket_id to set
	 */
	public void setThTicket_id(int th_ticket_id) {
		this.th_ticket_id = th_ticket_id;
	}

	/**
	 * @return the modifier_user_id
	 */
	public int getModifierUser_id() {
		return modifier_user_id;
	}

	/**
	 * @param modifier_user_id the modifier_user_id to set
	 */
	public void setModifierUser_id(int modifier_user_id) {
		this.modifier_user_id = modifier_user_id;
	}

	/**
	 * @return the old_state_id
	 */
	public int getOldState_id() {
		return old_state_id;
	}

	/**
	 * @param old_state_id the old_state_id to set
	 */
	public void setOldState_id(int old_state_id) {
		this.old_state_id = old_state_id;
	}

	/**
	 * @return the new_state_id
	 */
	public int getNewState_id() {
		return new_state_id;
	}

	/**
	 * @param new_state_id the new_state_id to set
	 */
	public void setNewState_id(int new_state_id) {
		this.new_state_id = new_state_id;
	}

	/**
	 * @return the action_id
	 */
	public int getAction_id() {
		return action_id;
	}

	/**
	 * @param action_id the action_id to set
	 */
	public void setAction_id(int action_id) {
		this.action_id = action_id;
	}

	/**
	 * @return the modification_date
	 */
	public Timestamp getModificationDate() {
		return modification_date;
	}

	/**
	 * @param modification_date the modification_date to set
	 */
	public void setModificationDate(Timestamp modification_date) {
		this.modification_date = modification_date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return th_ticket_id + ", " + modifier_user_id + ", " + old_state_id + ", " + new_state_id 
				+ ", " + action_id + ", \'" + modification_date + "\'";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`th_ticket_id`=" + th_ticket_id + ", `modifier_user_id`=" + modifier_user_id + ", `old_state_id`="
				+ old_state_id + ", `new_state_id`=" + new_state_id	+ ", `action_id`=" + action_id 
				+ ", `modification_date`=\'" + modification_date + "\'";
	}
		
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketHistory [id=" + id + ", th_ticket_id=" + th_ticket_id
				+ ", modifier_user_id=" + modifier_user_id + ", old_state_id="
				+ old_state_id + ", new_state_id=" + new_state_id
				+ ", action_id=" + action_id + ", modification_date="
				+ modification_date + "]";
	}
	
	
}

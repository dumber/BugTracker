/**
 * 
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class Action extends GenericTableElement {
	private StringProperty action;

	public Action() {}
	
	/**
	 * @param action_id		the action id
	 * @param action		the action name
	 */
	public Action(int action_id, String action) {
		super(action_id);
		this.action = new SimpleStringProperty(action);
	}

	/**
	 * @param a				the action to copy
	 */
	public Action(Action a) {
		super(a.getId());
		this.action = a.action;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + action.get() + "\'";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {		
		return "`action`=\'" + action.get() + "\'";
	}
	
	/**
	 * @return 
	 */
	public String debug() {		
		return "Action [id=" + id.get() + ", action=" + action.get() + "]";
	}
	
}

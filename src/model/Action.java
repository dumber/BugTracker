/**
 * 
 */
package model;

/**
 * @author dumber
 *
 */
public class Action extends GenericTableElement {
	private String action;
	
	/**
	 * @param action_id		the action id
	 * @param action		the action name
	 */
	public Action(int action_id, String action) {
		super(action_id);
		this.action = action;
	}

	/**
	 * @param a				the action to copy
	 */
	public Action(Action a) {
		super(a.id);
		this.action = a.action;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}


	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + action + "\'";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {		
		return "`action`=\'" + action + "\'";
	}
	
	/**
	 * @return 
	 */
	public String debug() {		
		return "Action [id=" + id + ", action=" + action + "]";
	}
	
}

/**
 * 
 */
package model;

/**
 * @author dumber
 *
 */
public class Action {
	private int action_id;
	private String action;
	
	/**
	 * @param action_id
	 * @param action
	 */
	public Action(int action_id, String action) {
		this.action_id = action_id;
		this.action = action;
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
	
}

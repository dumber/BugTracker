package model;

/**
 * @author dumber
 *
 */
public class Priority {
	private int priority_id;
	private String priority;
	
	/**
	 * @param priority_id
	 * @param priority
	 */
	public Priority(int priority_id, String priority) {
		this.priority_id = priority_id;
		this.priority = priority;
	}
	
	/**
	 * @return the priority_id
	 */
	public int getPriority_id() {
		return priority_id;
	}
	
	/**
	 * @param priority_id the priority_id to set
	 */
	public void setPriority_id(int priority_id) {
		this.priority_id = priority_id;
	}
	
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}
	
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}
		
}

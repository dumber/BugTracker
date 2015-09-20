package model;

/**
 * @author dumber
 *
 */
public class Priority extends GenericTableElement {
	private String priority;
	
	/**
	 * @param priority_id		the priority id
	 * @param priority			the name of the priority
	 */
	public Priority(int priority_id, String priority) {
		super(priority_id);
		this.priority = priority;
	}
	
	/**
	 * @param p					the priority to copy
	 */
	public Priority(Priority p) {
		super(p.id);
		this.priority = p.priority;
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


	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + priority + "\'";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {				
		return "`priority`=\'" + priority + "\'";
	}
	
	/**
	 * @return 
	 */
	public String debug() {				
		return "Priority [id=" + id + ", priority=" + priority + "]";
	}	
	
}

package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class Priority extends GenericTableElement {
	private StringProperty priority;
	
	/**
	 * @param priority_id		the priority id
	 * @param priority			the name of the priority
	 */
	public Priority(int priority_id, String priority) {
		super(priority_id);
		this.priority = new SimpleStringProperty(priority);
	}
	
	/**
	 * @param p					the priority to copy
	 */
	public Priority(Priority p) {
		super(p.getId());
		this.priority = p.priority;
	}
		
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority.get();
	}
	
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority.set(priority);
	}
	
	/**
	 * @return the priority
	 */
	public StringProperty priorityProperty() {
		return priority;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + priority.get() + "\'";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {				
		return "`priority`=\'" + priority.get() + "\'";
	}
	
	/**
	 * @return 
	 */
	public String debug() {				
		return "Priority [id=" + id.get() + ", priority=" + priority.get() + "]";
	}	
	
}

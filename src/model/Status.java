package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class Status extends GenericTableElement {
	private StringProperty status;

	/**
	 * @param status_id
	 * @param status
	 */
	public Status(int status_id, String status) {
		super(status_id);
		this.status = new SimpleStringProperty(status);
	}

	/**
	 * @param s
	 */
	public Status(Status s) {
		super(s.getId());
		this.status = s.status;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status.get();
	}

	/**
	 * @param status the stataus to set
	 */
	public void setStatus(String status) {
		this.status.set(status);
	}
	
	/**
	 * @return the status
	 */
	public StringProperty statusProperty() {
		return status;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + status.get() + "\'";
	}

	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`status`=\'" + status.get() + "\'";
	}
	
	/**
	 * @return 
	 */
	public String debug() {
		return "Status [id=" + id.get() + ", status=" + status.get() + "]";
	}
	
}

package model;

/**
 * @author dumber
 *
 */
public class Status extends GenericTableElement {
	private String status;

	/**
	 * @param status_id
	 * @param status
	 */
	public Status(int status_id, String status) {
		super(status_id);
		this.status= status;
	}

	/**
	 * @param s
	 */
	public Status(Status s) {
		super(s.id);
		this.status = s.status;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the stataus to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + status + "\'";
	}
	
	public String debug() {
		return "Status [id=" + id + ", status=" + status + "]";
	}
	
}

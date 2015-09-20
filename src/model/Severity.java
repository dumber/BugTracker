package model;

/**
 * @author dumber
 *
 */
public class Severity extends GenericTableElement {
	private String severity;

	/**
	 * @param severity_id
	 * @param severity
	 */
	public Severity(int severity_id, String severity) {
		super(severity_id);
		this.severity = severity;
	}

	/**
	 * @param s
	 */
	public Severity(Severity s) {
		super(s.id);
		this.severity = s.severity;
	}	

	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + severity + "\'";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`severity`=\'" + severity + "\'";		
	}
	
	/**
	 * @return 
	 */
	public String debug() {
		return "Severity [id=" + id + ", severity=" + severity + "]";		
	}	
	
}

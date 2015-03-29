package model;

/**
 * @author dumber
 *
 */
public class Severity {
	private int severity_id;
	private String severity;

	/**
	 * @param severity_id
	 * @param severity
	 */
	public Severity(int severity_id, String severity) {
		this.severity_id = severity_id;
		this.severity = severity;
	}

	/**
	 * @return the severity_id
	 */
	public int getSeverity_id() {
		return severity_id;
	}

	/**
	 * @param severity_id the severity_id to set
	 */
	public void setSeverity_id(int severity_id) {
		this.severity_id = severity_id;
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
	
}

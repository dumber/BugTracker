package model;

/**
 * @author dumber
 *
 */
public class Severity {
	private int severity_id;
	private String severity;
	
	public Severity(int severity_id, String severity) {
		super();
		this.severity_id = severity_id;
		this.severity = severity;
	}

	public int getSeverity_id() {
		return severity_id;
	}
	
	public void setSeverity_id(int severity_id) {
		this.severity_id = severity_id;
	}
	
	public String getSeverity() {
		return severity;
	}
	
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
}

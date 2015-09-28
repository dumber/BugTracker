package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class Severity extends GenericTableElement {
	private StringProperty severity;

	/**
	 * @param severity_id
	 * @param severity
	 */
	public Severity(int severity_id, String severity) {
		super(severity_id);
		this.severity = new SimpleStringProperty(severity);
	}

	/**
	 * @param s
	 */
	public Severity(Severity s) {
		super(s.getId());
		this.severity = s.severity;
	}	

	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity.get();
	}
	
	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity.set(severity);
	}

	/**
	 * @return the severity
	 */
	public StringProperty severityProperty() {
		return severity;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + severity.get() + "\'";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`severity`=\'" + severity.get() + "\'";		
	}
	
	/**
	 * @return 
	 */
	public String debug() {
		return "Severity [id=" + id.get() + ", severity=" + severity.get() + "]";		
	}	
	
}

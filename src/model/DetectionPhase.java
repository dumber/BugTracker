package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class DetectionPhase extends GenericTableElement {
	private StringProperty phase_name;

	/**
	 * @param dp_id			the detection phase id
	 * @param phase			the name of the detection phase
	 */
	public DetectionPhase(int dp_id, String phase) {
		super(dp_id);
		this.phase_name = new SimpleStringProperty(phase);
	}
	
	/**
	 * @param dp			the detection phase to copy			
	 */
	public DetectionPhase(DetectionPhase dp) {
		super(dp.getId());
		this.phase_name = dp.phase_name;
	}

	/**
	 * @return the phase
	 */
	public String getPhaseName() {
		return phase_name.get();
	}

	/**
	 * @param phase_name the detection_phase to set
	 */
	public void setPhaseName(String phase_name) {
		this.phase_name.set(phase_name);
	}

	
	
	/**
	 * @return the phase_name
	 */
	public StringProperty phaseProperty() {
		return phase_name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\'" + phase_name.get() + "\'";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`phase_name`=\'" + phase_name.get() + "\'";
	}
	
	/**
	 * @return 
	 */
	public String debug() {
		return "DetectionPhase [id=" + id.get() + ", phase_name=" + phase_name.get() + "]";
	}
	
	
}

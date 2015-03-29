package model;

/**
 * @author dumber
 *
 */
public class DetectionPhase {
	private int detection_phase_id;
	private String phase_name;

	/**
	 * @param dp_id
	 * @param phase
	 */
	public DetectionPhase(int dp_id, String phase) {
		this.detection_phase_id = dp_id;
		this.phase_name = phase;
	}

	/**
	 * @return the detection_phase_id
	 */
	public int getDetectionPhase_id() {
		return detection_phase_id;
	}

	/**
	 * @param dp_id the detection_phase_id to set
	 */
	public void setDetectionPhase_id(int dp_id) {
		this.detection_phase_id = dp_id;
	}

	/**
	 * @return the phase
	 */
	public String getPhaseName() {
		return phase_name;
	}

	/**
	 * @param phase_name the detection_phase to set
	 */
	public void setPhaseName(String phase_name) {
		this.phase_name = phase_name;
	}
		
}

package model;

/**
 * @author dumber
 *
 */
public class DetectionPhase {
	private int detection_phase_id;
	private String phase;
		
	public DetectionPhase(int detection_phase_id, String phase) {
		super();
		this.detection_phase_id = detection_phase_id;
		this.phase = phase;
	}

	public int getDetection_phase_id() {
		return detection_phase_id;
	}
	
	public void setDetection_phase_id(int detection_phase_id) {
		this.detection_phase_id = detection_phase_id;
	}
	
	public String getPhase() {
		return phase;
	}
	
	public void setPhase(String phase) {
		this.phase = phase;
	}	
	
}

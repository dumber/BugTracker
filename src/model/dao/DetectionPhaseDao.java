/**
 * 
 */
package model.dao;

import java.util.List;

import model.DetectionPhase;

/**
 * @author dumber
 *
 */
public interface DetectionPhaseDao {	
	public List<DetectionPhase> getAllDetectionPhases();	
	public DetectionPhase getDetectionPhase(int dp_id);
	public String findDetectionPhase(int dp_id);
	public void addDetectionPhase(DetectionPhase detection_phase);
	public void updateDetectionPhase(DetectionPhase detection_phase);
	public void deleteDetectionPhase(int dp_id);
}

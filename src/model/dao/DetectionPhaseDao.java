/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.DetectionPhase;

/**
 * @author dumber
 *
 */
public interface DetectionPhaseDao {	
	public List<DetectionPhase> getAllDetectionPhases();	
	public DetectionPhase findDetectionPhase(int dp_id);
	public void addDetectionPhase(DetectionPhase detection_phase) throws SQLException;
	public void updateDetectionPhase(int dp_id, String phase_name) throws SQLException;
	public void deleteDetectionPhase(int dp_id) throws SQLException;
}

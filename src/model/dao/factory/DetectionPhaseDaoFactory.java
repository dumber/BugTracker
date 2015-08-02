/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.MySqlDataSourceSingleton;
import model.DetectionPhase;
import model.dao.DetectionPhaseDao;

/**
 * @author dumber
 *
 */
public class DetectionPhaseDaoFactory implements DetectionPhaseDao {
	MySqlDataSourceSingleton db = MySqlDataSourceSingleton.getInstance();
	List<DetectionPhase> detection_phases;
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public DetectionPhaseDaoFactory() throws SQLException {
		detection_phases = new ArrayList<DetectionPhase>();
		db.setSelect_command("`detection_phases`");
		db.executeSelectCommand();
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			DetectionPhase dp = new DetectionPhase(rs.getInt("dp_id"),rs.getString("phase_name"));
			detection_phases.add(dp);
		}
		rs.close();
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#getAllDetectionPhases()
	 */
	@Override
	public List<DetectionPhase> getAllDetectionPhases() {		
		return detection_phases;
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#findDetectionPhase(int)
	 */
	@Override
	public DetectionPhase findDetectionPhase(int dp_id) {		
		return detection_phases.get(dp_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#addDetectionPhase(model.DetectionPhase)
	 */
	@Override
	public void addDetectionPhase(DetectionPhase detection_phase) throws SQLException {		
		detection_phases.add(detection_phase);
		db.setInsert_command("`detection_phases` (`detection_phases`) VALUES (" + detection_phase.getPhaseName() + ");");
		db.executeInsertCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#updateDetectionPhase(model.DetectionPhase)
	 */
	@Override
	public void updateDetectionPhase(int dp_id, String phase_name) throws SQLException {
		findDetectionPhase(dp_id).setPhaseName(phase_name);
		db.setUpdate_command("`detection_phases` SET `detection_phase` = " + phase_name + " WHERE `dp_id` = " + dp_id + ";");
		db.executeUpdateCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#deleteDetectionPhase(model.DetectionPhase)
	 */
	@Override
	public void deleteDetectionPhase(int dp_id) throws SQLException {
		detection_phases.remove(dp_id);
		db.setDelete_command("`detection_phase` WHERE dp_id = " + dp_id + ";");
		db.executeDeleteCommand();
	}

}

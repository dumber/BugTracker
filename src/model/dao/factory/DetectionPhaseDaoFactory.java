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
	
	private static final String SQL_QUERY = "select * from detection_phases";
	
	public DetectionPhaseDaoFactory() throws SQLException {
		detection_phases = new ArrayList<DetectionPhase>();
		db.setResultSet(db.getStmt().executeQuery(SQL_QUERY));
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			DetectionPhase dp = new DetectionPhase(rs.getInt("dp_id"),rs.getString("detection_phase"));
			detection_phases.add(dp);
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#getAllDetectionPhases()
	 */
	@Override
	public List<DetectionPhase> getAllDetectionPhases() {		
		return detection_phases;
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#getDetectionPhase(int)
	 */
	@Override
	public DetectionPhase getDetectionPhase(int dp_id) {
		return detection_phases.get(dp_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#findDetectionPhase(int)
	 */
	@Override
	public String findDetectionPhase(int dp_id) {		
		return detection_phases.get(dp_id).getPhase();
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#addDetectionPhase(model.DetectionPhase)
	 */
	@Override
	public void addDetectionPhase(DetectionPhase detection_phase) {		
		detection_phases.add(detection_phase);
		// TODO create the SQL insert command
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#updateDetectionPhase(model.DetectionPhase)
	 */
	@Override
	public void updateDetectionPhase(DetectionPhase detection_phase) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#deleteDetectionPhase(model.DetectionPhase)
	 */
	@Override
	public void deleteDetectionPhase(int dp_id) {
		detection_phases.remove(dp_id);
		// TODO create the SQL delete command
	}

}

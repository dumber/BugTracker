/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DetectionPhase;
import model.GenericTableElement;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class DetectionPhaseDaoFactory extends GenericDaoFactory implements GenericDaoIFC {
	List<DetectionPhase> detection_phases;
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public DetectionPhaseDaoFactory() throws SQLException {
		super();
		detection_phases = new ArrayList<DetectionPhase>();
		dataSource.setSelectQueryString("`detection_phases`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
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
	public List<? extends GenericTableElement> getAllTableElements() {		
		return detection_phases;
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#findDetectionPhase(int)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int dp_id, Class<T> type) {		
		DetectionPhase tmp = null;
		for (DetectionPhase dp : detection_phases) {
			if (dp_id == dp.getId()) {
				tmp = dp;
			}
		}
		return type.cast(tmp);
	}
	
	public DetectionPhase findDetectionPhase(int id) {
		return findElementById(id, DetectionPhase.class);
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#addDetectionPhase(model.DetectionPhase)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T detection_phase) throws SQLException {		
		detection_phases.add((DetectionPhase)detection_phase);
		dataSource.setInsertQueryString("`detection_phases` (`detection_phases`) VALUES (" + ((DetectionPhase)detection_phase).getPhaseName() + ");");
		dataSource.executeInsertQuery();
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#updateDetectionPhase(model.DetectionPhase)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int dp_id, T elem) throws SQLException {
		DetectionPhase dp = findDetectionPhase(dp_id);
		if (dp != null) {
			dp.setPhaseName(((DetectionPhase)elem).getPhaseName());
			dataSource.setUpdateQueryString("`detection_phases` SET `detection_phase` = " + dp.getPhaseName() + " WHERE `dp_id` = " + dp_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			// TODO throw some exceptions
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#deleteDetectionPhase(model.DetectionPhase)
	 */
	@Override
	public void deleteElementFromTable(int dp_id) throws SQLException {
		detection_phases.remove(dp_id);
		dataSource.setDeleteQueryString("`detection_phase` WHERE dp_id = " + dp_id + ";");
		dataSource.executeDeleteQuery();
	}

}

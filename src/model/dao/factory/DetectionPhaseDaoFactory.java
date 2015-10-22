/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DetectionPhase;
import model.dao.DetectionPhaseDao;

/**
 * @author dumber
 *
 */
public class DetectionPhaseDaoFactory extends GenericDaoFactory implements DetectionPhaseDao {
	
	/**
	 * 
	 */
	public DetectionPhaseDaoFactory() {
		super("`detection_phases`");

	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#getAllTableElements()
	 */
	@Override
	public List<DetectionPhase> getAllTableElements() throws SQLException {		
		List<DetectionPhase> detection_phases = new ArrayList<DetectionPhase>();
		dataSource.setSelectQueryString("`detection_phases`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			DetectionPhase dp = new DetectionPhase(rs.getInt("id"),rs.getString("phase_name"));
			detection_phases.add(dp);
		}
		rs.close();
		return detection_phases;
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#findElementById(int)
	 */
	@Override
	public DetectionPhase findElementById(int id) throws SQLException {		
		DetectionPhase dp = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`detection_phases` WHERE id = ?");
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			dp = new DetectionPhase(rs.getInt("id"), rs.getString("phase_name"));
		}
		rs.close();
		return dp;
	}

	/* (non-Javadoc)
	 * @see model.dao.DetectionPhaseDao#addElementToTable(model.DetectionPhase)
	 */
	@Override
	public void addElementToTable(DetectionPhase detection_phase) throws SQLException {
		if (detection_phase != null) {
			dataSource.setInsertQueryString("`detection_phases` (`phase_name`) VALUES (" 
					+ detection_phase.toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt detection_phase into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.DetectionPhase)
	 */
	@Override
	public void updateElementInTalbe(int id, DetectionPhase phase) throws SQLException {
		if (phase != null) {
			dataSource.setUpdateQueryString("`detection_phases` SET " + phase.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt detection_phase \n");
		}
	}

}

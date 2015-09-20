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
	
	/**
	 * 
	 */
	public DetectionPhaseDaoFactory() {
		super();

	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {		
		List<DetectionPhase> detection_phases = new ArrayList<DetectionPhase>();
		dataSource.setSelectQueryString("`detection_phases`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			DetectionPhase dp = new DetectionPhase(rs.getInt("dp_id"),rs.getString("phase_name"));
			detection_phases.add(dp);
		}
		rs.close();
		return detection_phases;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int dp_id, Class<T> type) throws SQLException {		
		DetectionPhase dp = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`detection_phases` WHERE dp_id = ");
		dataSource.executeSelectByIdQuery(dp_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			dp = new DetectionPhase(rs.getInt("dp_id"), rs.getString("detection_phase"));
		}
		rs.close();
		return type.cast(dp);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public DetectionPhase findDetectionPhaseById(int id) throws SQLException {
		return findElementById(id, DetectionPhase.class);
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T detection_phase) throws SQLException {
		if (((DetectionPhase)detection_phase) != null) {
			dataSource.setInsertQueryString("`detection_phases` (`detection_phases`) VALUES (" 
					+ ((DetectionPhase)detection_phase).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt detection_phase into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int dp_id, T phase) throws SQLException {
		if (((DetectionPhase)phase) != null) {
			dataSource.setUpdateQueryString("`detection_phases` SET " + ((DetectionPhase)phase).toUpdateString() 
					+ " WHERE `dp_id` = " + dp_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt detection_phase \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int dp_id) throws SQLException {
		dataSource.setDeleteQueryString("`detection_phase` WHERE dp_id = " + dp_id + ";");
		dataSource.executeDeleteQuery();
	}

}

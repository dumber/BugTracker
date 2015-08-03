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
//	List<DetectionPhase> detection_phases;
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public DetectionPhaseDaoFactory() throws SQLException {
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
	 * @see model.dao.GenericDaoIFC#findElementById(int)
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
	 * @see model.dao.GenericDaoIFC#addElementToTable(T action)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T detection_phase) throws SQLException {		
		dataSource.setInsertQueryString("`detection_phases` (`detection_phases`) VALUES (\'" + ((DetectionPhase)detection_phase).getPhaseName() + "\');");
		dataSource.executeInsertQuery();
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(model.Action)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int dp_id, T phase) throws SQLException {
		if (((DetectionPhase)phase).getPhaseName() != null) {
			dataSource.setUpdateQueryString("`detection_phases` SET `detection_phase` = " + ((DetectionPhase)phase).getPhaseName() + " WHERE `dp_id` = " + dp_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt detection_phase; \n");
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

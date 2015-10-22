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
public interface DetectionPhaseDao extends GenericDaoIFC {
	public List<DetectionPhase> getAllTableElements() throws SQLException;
	public DetectionPhase findElementById(int id) throws SQLException;
	public void addElementToTable(DetectionPhase elem) throws SQLException;
	public void updateElementInTalbe(int id, DetectionPhase elem) throws SQLException;
}

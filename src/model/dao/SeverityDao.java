/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.Severity;

/**
 * @author dumber
 *
 */
public interface SeverityDao extends GenericDaoIFC {
	public List<Severity> getAllTableElements() throws SQLException;
	public Severity findElementById(int id) throws SQLException;
	public void addElementToTable(Severity elem) throws SQLException;
	public void updateElementInTalbe(int id, Severity elem) throws SQLException;
}

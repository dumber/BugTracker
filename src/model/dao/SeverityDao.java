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
public interface SeverityDao {
	public List<Severity> getAllSeverities();	
	public Severity findSeverity(int s_id);
	public void addSeverity(Severity severity) throws SQLException;
	public void updateSeverity(int s_id, String severity) throws SQLException;
	public void deleteSeverity(int s_id) throws SQLException;
}

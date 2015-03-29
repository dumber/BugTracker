/**
 * 
 */
package model.dao;

import java.util.List;

import model.Severity;

/**
 * @author dumber
 *
 */
public interface SeverityDao {
	public List<Severity> getAllSeverities();	
	public Severity getSeverity(int s_id);
	public String findSeverity(int s_id);
	public void addSeverity(Severity severity);
	public void updateSeverity(Severity severity);
	public void deleteSeverity(int s_id);
}

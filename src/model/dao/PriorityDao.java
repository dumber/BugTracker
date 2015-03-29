/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.Priority;

/**
 * @author dumber
 *
 */
public interface PriorityDao {
	public List<Priority> getAllPrioritys();	
	public Priority findPriority(int p_id);
	public void addPriority(Priority priority) throws SQLException;
	public void updatePriority(int p_id, String priority) throws SQLException;
	public void deletePriority(int p_id) throws SQLException;
}

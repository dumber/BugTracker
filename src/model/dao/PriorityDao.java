/**
 * 
 */
package model.dao;

import java.util.List;

import model.Priority;

/**
 * @author dumber
 *
 */
public interface PriorityDao {
	public List<Priority> getAllPrioritys();	
	public Priority getPriority(int p_id);
	public String findPriority(int p_id);
	public void addPriority(Priority priority);
	public void updatePriority(Priority priority);
	public void deletePriority(int p_id);
}

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
public interface PriorityDao extends GenericDaoIFC {
	public List<Priority> getAllTableElements() throws SQLException;
	public Priority findElementById(int id) throws SQLException;
	public void addElementToTable(Priority elem) throws SQLException;
	public void updateElementInTalbe(int id, Priority elem) throws SQLException;
}

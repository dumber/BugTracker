/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.Status;

/**
 * @author dumber
 *
 */
public interface StatusDao extends GenericDaoIFC {
	public List<Status> getAllTableElements() throws SQLException;
	public Status findElementById(int id) throws SQLException;
	public void addElementToTable(Status elem) throws SQLException;
	public void updateElementInTalbe(int id, Status elem) throws SQLException;
}

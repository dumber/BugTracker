/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.TicketWorkload;

/**
 * @author dumber
 *
 */
public interface TicketWorkloadDao extends GenericDaoIFC {
	public List<TicketWorkload> getAllTableElements() throws SQLException;
	public TicketWorkload findElementById(int id) throws SQLException;
	public void addElementToTable(TicketWorkload elem) throws SQLException;
	public void updateElementInTalbe(int id, TicketWorkload elem) throws SQLException;
}

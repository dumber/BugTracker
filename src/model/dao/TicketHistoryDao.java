/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.TicketHistory;

/**
 * @author dumber
 *
 */
public interface TicketHistoryDao extends GenericDaoIFC {
	public List<TicketHistory> getAllTableElements() throws SQLException;
	public TicketHistory findElementById(int id) throws SQLException;
	public void addElementToTable(TicketHistory elem) throws SQLException;
	public void updateElementInTalbe(int id, TicketHistory elem) throws SQLException;
}

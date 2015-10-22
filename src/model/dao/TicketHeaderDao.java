/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.TicketHeader;

/**
 * @author dumber
 *
 */
public interface TicketHeaderDao extends GenericDaoIFC {
	public List<TicketHeader> getAllTableElements() throws SQLException;
	public TicketHeader findElementById(int id) throws SQLException;
	public void addElementToTable(TicketHeader elem) throws SQLException;
	public void updateElementInTalbe(int id, TicketHeader elem) throws SQLException;
}

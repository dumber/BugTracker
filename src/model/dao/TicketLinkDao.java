/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.TicketLink;

/**
 * @author dumber
 *
 */
public interface TicketLinkDao extends GenericDaoIFC {
	public List<TicketLink> getAllTableElements() throws SQLException;
	public TicketLink findElementById(int id) throws SQLException;
	public void addElementToTable(TicketLink elem) throws SQLException;
	public void updateElementInTalbe(int id, TicketLink elem) throws SQLException;
}

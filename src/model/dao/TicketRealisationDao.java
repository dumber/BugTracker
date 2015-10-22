/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.TicketRealisation;

/**
 * @author dumber
 *
 */
public interface TicketRealisationDao extends GenericDaoIFC {
	public List<TicketRealisation> getAllTableElements() throws SQLException;
	public TicketRealisation findElementById(int id) throws SQLException;
	public void addElementToTable(TicketRealisation elem) throws SQLException;
	public void updateElementInTalbe(int id, TicketRealisation elem) throws SQLException;
}

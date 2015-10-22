/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.TicketValidation;

/**
 * @author dumber
 *
 */
public interface TicketValidationDao extends GenericDaoIFC {
	public List<TicketValidation> getAllTableElements() throws SQLException;
	public TicketValidation findElementById(int id) throws SQLException;
	public void addElementToTable(TicketValidation elem) throws SQLException;
	public void updateElementInTalbe(int id, TicketValidation elem) throws SQLException;
}

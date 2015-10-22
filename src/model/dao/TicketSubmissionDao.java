/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.TicketSubmission;

/**
 * @author dumber
 *
 */
public interface TicketSubmissionDao extends GenericDaoIFC {
	public List<TicketSubmission> getAllTableElements() throws SQLException;
	public TicketSubmission findElementById(int id) throws SQLException;
	public void addElementToTable(TicketSubmission elem) throws SQLException;
	public void updateElementInTalbe(int id, TicketSubmission elem) throws SQLException;
}

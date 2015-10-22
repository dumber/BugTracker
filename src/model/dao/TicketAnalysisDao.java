/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.TicketAnalysis;

/**
 * @author dumber
 *
 */
public interface TicketAnalysisDao extends GenericDaoIFC {
	public List<TicketAnalysis> getAllTableElements() throws SQLException;
	public TicketAnalysis findElementById(int id) throws SQLException;
	public void addElementToTable(TicketAnalysis elem) throws SQLException;
	public void updateElementInTalbe(int id, TicketAnalysis elem) throws SQLException;
}

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
public interface StatusDao {
	public List<Status> getAllTicketState();
	public Status findTicketState(int ts_id);
	public void addTicketState(Status status) throws SQLException;
	public void updateTicketState(int ts_id, String status) throws SQLException;
	public void deleteTicketState(int ts_id) throws SQLException;
}

/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.MySqlDataSourceSingleton;
import model.Ticket;
import model.dao.TicketDao;

/**
 * @author dumber
 *
 */
public class TicketDaoFactory implements TicketDao {
	MySqlDataSourceSingleton db = MySqlDataSourceSingleton.getInstance();
	List<Ticket> tickets;
	
	private static final String SQL_QUERY = "select * from tickets";
	
	// TODO Password hashing
	public TicketDaoFactory() throws SQLException {
		tickets = new ArrayList<Ticket>();
		db.setResultSet(db.getStmt().executeQuery(SQL_QUERY));
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
//			Ticket ticket = new Ticket();
//			tickets.add(ticket);
		}
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TicketDao#getAllTickets()
	 */
	@Override
	public List<Ticket> getAllTickets() {
		return tickets;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketDao#findTickete(int)
	 */
	@Override
	public Ticket findTicket(int t_id) {
		return tickets.get(t_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketDao#addTicket(model.Ticket)
	 */
	@Override
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
		// TODO create the SQL insert command
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketDao#updateTicket(model.Ticket)
	 */
	@Override
	public void updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see model.dao.TicketDao#deleteTicket(model.Ticket)
	 */
	@Override
	public void deleteTicket(int t_id) {
		tickets.remove(t_id);
		// TODO create the SQL delete command
	}

}

/**
 * 
 */
package model.dao.factory;

import helper.MySqlDataSourceSingleton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TicketHeader;
import model.dao.TicketHeaderDao;

/**
 * @author dumber
 *
 */
public class TicketHeaderDaoFactory implements TicketHeaderDao {
	MySqlDataSourceSingleton db = MySqlDataSourceSingleton.getInstance();
	List<TicketHeader> ticket_headers;
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public TicketHeaderDaoFactory() throws SQLException {
		ticket_headers = new ArrayList<TicketHeader>();
		db.setSelectQueryString("`tickets`");
		db.executeSelectQuery();
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			TicketHeader ticket_header = new TicketHeader(rs.getInt("t_id"), rs.getInt("unique_ticket_id"), rs.getInt("project_id"), 
					rs.getString("headline"), rs.getString("description"), rs.getInt("severity_id"), rs.getInt("priority_id"),
					rs.getInt("state_id"), rs.getInt("linked_ticket_id"));
			ticket_headers.add(ticket_header);
		}
		rs.close();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TicketHeaderDao#getAllTicketHeaders()
	 */
	@Override
	public List<TicketHeader> getAllTicketHeaders() {
		return ticket_headers;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketHeaderDao#findTicketHeader(int)
	 */
	@Override
	public TicketHeader findTicket(int t_id) {
		TicketHeader tmp = null;
		for (TicketHeader t : ticket_headers) {
			if (t_id == t.getId()) {
				tmp = t;
			}
		}
		return tmp;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketHeaderDao#addTicketHeader(model.TicketHeader)
	 */
	@Override
	public void addTicketHeader(TicketHeader ticket_header) throws SQLException {
		ticket_headers.add(ticket_header);
		db.setInsertQueryString("`tickets` (`unique_ticket_id`,`project_id`,`headline`,`description`,"
				+ "`severity_id`,`priority_id`,`state_id`,`linked_ticket_id`) VALUES (" + ticket_header.toString() + ");");
		db.executeInsertQuery();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TicketHeaderDao#updateTicketHeader(model.TicketHeader)
	 */
	@Override
	public void updateTicketHeader(int t_id, int u_t_id, int p_id, String hl,
			String desc, int s_id, int pri_id, int st_id, int lt_id) throws SQLException {
		TicketHeader t = findTicket(t_id);
		if (t != null) {
			t.modifyTicketHeader(u_t_id, p_id, hl, desc, s_id, pri_id, st_id, lt_id);
			db.setUpdateQueryString("`tickets` SET `unique_ticket_id` = " + u_t_id + ", `project_id` = " + p_id 
					+ ",`headline` = " + hl + ", `description` = " + desc + ",`severity_id` = " + s_id 
					+ ",`priority_id` = " + pri_id + ",`state_id` = " + st_id + ", `linked_ticket_id` = " + lt_id 
					+ "WHERE `t_id` = " + t_id + ";");
			db.executeUpdateQuery();
		} else {
			// TODO throw some exceptions
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketDao#deleteTicket(model.Ticket)
	 */
	@Override
	public void deleteTicketHeader(int t_id) throws SQLException {
		ticket_headers.remove(t_id);
		db.setDeleteQueryString("`tickets` WHERE t_id = " + t_id + ";");
		db.executeDeleteQuery();
	}

}

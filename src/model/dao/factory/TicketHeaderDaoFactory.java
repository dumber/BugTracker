/**
 * 
 */
package model.dao.factory;

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
public class TicketHeaderDaoFactory extends GenericDaoFactory implements TicketHeaderDao {
	
	/**
	 * 
	 */
	public TicketHeaderDaoFactory() {
		super("`ticket_headers`");
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TicketHeaderDao#getAllTableElements()
	 */
	@Override
	public List<TicketHeader> getAllTableElements() throws SQLException {
		List<TicketHeader> ticket_headers = new ArrayList<TicketHeader>();
		dataSource.setSelectQueryString("`ticket_headers_view`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketHeader ticket_header = new TicketHeader(rs.getInt("id"), rs.getString("unique_ticket_name"), rs.getString("project_name"), 
					rs.getString("headline"), rs.getString("description"), rs.getString("severity"), rs.getString("priority"),
					rs.getString("status"));
			ticket_headers.add(ticket_header);
		}
		rs.close();
		return ticket_headers;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketHeaderDao#findElementById(int)
	 */
	@Override
	public TicketHeader findElementById(int th_id) throws SQLException {
		TicketHeader th = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`ticket_headers_view` WHERE id = ?" );
		dataSource.executeSelectByIdQuery(th_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			th = new TicketHeader(rs.getInt("id"), rs.getString("unique_ticket_name"), rs.getString("project_name"), 
					rs.getString("headline"), rs.getString("description"), rs.getString("severity"), rs.getString("priority"),
					rs.getString("status"));
		}
		rs.close();
		return th;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketHeaderDao#addElementToTable(model.TicketHeader)
	 */
	@Override
	public void addElementToTable(TicketHeader ticket_header) throws SQLException {
		if (ticket_header != null) {
			dataSource.setInsertQueryString("`ticket_headers` (`unique_ticket_name`,`project_id`,`headline`,`description`,"
					+ "`severity_id`,`priority_id`,`status_id`) VALUES (" + ticket_header.toInsertString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_header into database \n");
		}
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TicketHeaderDao#updateElementInTalbe(int, model.TicketHeader)
	 */
	@Override
	public void updateElementInTalbe(int id, TicketHeader ticket_header) throws SQLException {
		if (ticket_header != null) {
			dataSource.setUpdateQueryString("`ticket_headers` SET " + ticket_header.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_header \n");
		}
	}
	
}

/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TicketLink;
import model.dao.TicketLinkDao;

/**
 * @author dumber
 *
 */
public class TicketLinkDaoFactory extends GenericDaoFactory implements TicketLinkDao {

	/**
	 * 
	 */
	public TicketLinkDaoFactory() {
		super("`ticket_links`");
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketLinkDao#getAllTableElements()
	 */
	@Override
	public List<TicketLink> getAllTableElements() throws SQLException {
		List<TicketLink> ticket_links = new ArrayList<TicketLink>();
		dataSource.setSelectQueryString("`ticket_links_view`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketLink tl = new TicketLink(rs.getInt("id"), rs.getInt("tl_ticket_id"), rs.getString("unique_ticket_name"), rs.getString("linked_headline"));
			ticket_links.add(tl);
		}
		rs.close();
		return ticket_links;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketLinkDao#findElementById(int)
	 */
	@Override
	public TicketLink findElementById(int id) throws SQLException {
		TicketLink tl = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`ticket_links_view` WHERE id = ?");
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			tl = new TicketLink(rs.getInt("id"), rs.getInt("tl_ticket_id"), rs.getString("unique_ticket_name"), rs.getString("linked_headline"));
		}
		rs.close();
		return tl;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TicketLinkDao#addElementToTable(model.TicketLink)
	 */
	@Override
	public void addElementToTable(TicketLink ticket_link) throws SQLException {
		if (ticket_link != null) {
			dataSource.setInsertQueryString("`ticket_links` (`tl_ticket_id`, `tl_linked_ticket_id`) VALUES ("
					+ ticket_link.toInsertString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_link into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketLinkDao#updateElementInTalbe(int, model.TicketLink)
	 */
	@Override
	public void updateElementInTalbe(int id, TicketLink ticket_link) throws SQLException {
		if (ticket_link != null) {
			dataSource.setUpdateQueryString("`ticket_links` SET " + ticket_link.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_link \n");
		}
	}
	
}

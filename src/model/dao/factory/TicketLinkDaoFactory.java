/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.TicketLink;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class TicketLinkDaoFactory extends GenericDaoFactory implements GenericDaoIFC {

	/**
	 * 
	 */
	public TicketLinkDaoFactory() {
		super("`ticket_links`");
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<TicketLink> ticket_links = new ArrayList<TicketLink>();
		dataSource.setSelectQueryString("`ticket_links`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketLink tl = new TicketLink(rs.getInt("id"), rs.getInt("tl_ticket_id"), rs.getInt("tl_linked_ticket_id"));
			ticket_links.add(tl);
		}
		rs.close();
		return ticket_links;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int id, Class<T> type) throws SQLException {
		TicketLink tl = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`ticket_links` WHERE id = ?");
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			tl = new TicketLink(rs.getInt("id"), rs.getInt("tl_ticket_id"), rs.getInt("tl_linked_ticket_id"));
		}
		rs.close();
		return type.cast(tl);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public TicketLink findTicketLinkById(int id) throws SQLException {
		return findElementById(id, TicketLink.class);
	}	
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T ticket_link) throws SQLException {
		if (((TicketLink)ticket_link) != null) {
			dataSource.setInsertQueryString("`ticket_links` (`tl_ticket_id`, `tl_linked_ticket_id`) VALUES ("
					+ ((TicketLink)ticket_link).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_link into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int id, T ticket_link) throws SQLException {
		if (((TicketLink)ticket_link) != null) {
			dataSource.setUpdateQueryString("`ticket_links` SET " + ((TicketLink)ticket_link).toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_link \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int id) throws SQLException {
		dataSource.setDeleteQueryString("`ticket_links` WHERE `id` = " + id + ";");
		dataSource.executeDeleteQuery();
	}
	
}

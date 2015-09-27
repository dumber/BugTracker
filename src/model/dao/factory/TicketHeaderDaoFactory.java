/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.TicketHeader;
import model.dao.GenericDaoIFC;


/**
 * @author dumber
 *
 */
public class TicketHeaderDaoFactory extends GenericDaoFactory implements GenericDaoIFC {
	
	/**
	 * 
	 */
	public TicketHeaderDaoFactory() {
		super("`ticket_headers`");
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<TicketHeader> ticket_headers = new ArrayList<TicketHeader>();
		dataSource.setSelectQueryString("`ticket_headers`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketHeader ticket_header = new TicketHeader(rs.getInt("id"), rs.getString("unique_ticket_name"), rs.getInt("project_id"), 
					rs.getString("headline"), rs.getString("description"), rs.getInt("severity_id"), rs.getInt("priority_id"),
					rs.getInt("status_id"));
			ticket_headers.add(ticket_header);
		}
		rs.close();
		return ticket_headers;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int th_id, Class<T> type) throws SQLException {
		TicketHeader th = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`ticket_headers` WHERE id = ?" );
		dataSource.executeSelectByIdQuery(th_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			th = new TicketHeader(rs.getInt("id"), rs.getString("unique_ticket_name"), rs.getInt("project_id"), 
					rs.getString("headline"), rs.getString("description"), rs.getInt("severity_id"), rs.getInt("priority_id"),
					rs.getInt("status_id"));
		}
		rs.close();
		return type.cast(th);
	}

	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public TicketHeader findTicketHeaderById(int id) throws SQLException {
		return findElementById(id, TicketHeader.class);
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T ticket_header) throws SQLException {
		if (((TicketHeader)ticket_header) != null) {
			dataSource.setInsertQueryString("`ticket_headers` (`unique_ticket_name`,`project_id`,`headline`,`description`,"
					+ "`severity_id`,`priority_id`,`status_id`) VALUES (" + ((TicketHeader)ticket_header).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_header into database \n");
		}
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int id, T ticket_header) throws SQLException {
		if (((TicketHeader)ticket_header) != null) {
			dataSource.setUpdateQueryString("`ticket_headers` SET " + ((TicketHeader)ticket_header).toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_header \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int id) throws SQLException {
		dataSource.setDeleteQueryString("`ticket_headers` WHERE `id` = " + id + ";");
		dataSource.executeDeleteQuery();
	}
	
}

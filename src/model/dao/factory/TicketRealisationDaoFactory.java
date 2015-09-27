package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.TicketRealisation;
import model.dao.GenericDaoIFC;

public class TicketRealisationDaoFactory extends GenericDaoFactory implements
		GenericDaoIFC {

	public TicketRealisationDaoFactory() {
		super("`ticket_realisations`");
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<TicketRealisation> ticket_realisations = new ArrayList<TicketRealisation>();
		dataSource.setSelectQueryString("`ticket_realisations`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketRealisation tr = new TicketRealisation(rs.getInt("id"), rs.getInt("tr_ticket_id"), rs.getString("realised_items"), 
					rs.getInt("realised_ver_id"), rs.getTimestamp("realisation_date"), rs.getInt("realiser_user_id"));
			ticket_realisations.add(tr);
		}
		rs.close();
		return ticket_realisations;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int id, Class<T> type) throws SQLException {
		TicketRealisation tr = null;
		dataSource.setSelectQueryString("`ticket_realisations`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			 tr = new TicketRealisation(rs.getInt("id"), rs.getInt("tr_ticket_id"), rs.getString("realised_items"), 
					 rs.getInt("realised_ver_id"), rs.getTimestamp("realisation_date"), rs.getInt("realiser_user_id"));
		}
		rs.close();
		return type.cast(tr);
	}

	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public TicketRealisation findTicketRealisationById(int id) throws SQLException {
		return findElementById(id, TicketRealisation.class);
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T ticket_real) throws SQLException {
		if (((TicketRealisation)ticket_real) != null) {
			dataSource.setInsertQueryString("`ticket_realisations` (`tr_ticket_id`,`realised_items`,`realised_ver_id`,"
					+ "`realisation_date`,`realiser_user_id`) VALUES (" + ((TicketRealisation)ticket_real).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_realisation into database \n");
		}

	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int id, T ticket_real) throws SQLException {
		if (((TicketRealisation)ticket_real) != null) {
			dataSource.setUpdateQueryString("`ticket_realisations` SET " + ((TicketRealisation)ticket_real).toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_realisation \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int id) throws SQLException {
		dataSource.setDeleteQueryString("`ticket_realisations` WHERE `id` = " + id + ";");
		dataSource.executeDeleteQuery();
	}

}

package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TicketRealisation;
import model.dao.TicketRealisationDao;

public class TicketRealisationDaoFactory extends GenericDaoFactory implements
		TicketRealisationDao {

	public TicketRealisationDaoFactory() {
		super("`ticket_realisations`");
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketRealisationDao#getAllTableElements()
	 */
	@Override
	public List<TicketRealisation> getAllTableElements() throws SQLException {
		List<TicketRealisation> ticket_realisations = new ArrayList<TicketRealisation>();
		dataSource.setSelectQueryString("`ticket_realisations_view`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketRealisation tr = new TicketRealisation(rs.getInt("id"), rs.getInt("tr_ticket_id"), rs.getString("realised_items"), 
					rs.getString("realised_version"), rs.getTimestamp("realisation_date"), rs.getString("realiser"),
					rs.getInt("project_id"));
			ticket_realisations.add(tr);
		}
		rs.close();
		return ticket_realisations;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketRealisationDao#findElementById(int)
	 */
	@Override
	public TicketRealisation findElementById(int id) throws SQLException {
		TicketRealisation tr = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`ticket_realisations_view` WHERE id = ?;");
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			 tr = new TicketRealisation(rs.getInt("id"), rs.getInt("tr_ticket_id"), rs.getString("realised_items"), 
						rs.getString("realised_version"), rs.getTimestamp("realisation_date"), rs.getString("realiser"),
						rs.getInt("project_id"));
		}
		rs.close();
		return tr;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketRealisationDao#addElementToTable(model.TicketRealisation)
	 */
	@Override
	public void addElementToTable(TicketRealisation ticket_real) throws SQLException {
		if (ticket_real != null) {
			dataSource.setInsertQueryString("`ticket_realisations` (`tr_ticket_id`,`realised_items`,`realised_ver_id`,"
					+ "`realisation_date`,`realiser_user_id`,`project_id`) VALUES (" + ticket_real.toInsertString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_realisation into database \n");
		}

	}

	/* (non-Javadoc)
	 * @see model.dao.TicketRealisationDao#updateElementInTalbe(int, model.TicketRealisation)
	 */
	@Override
	public  void updateElementInTalbe(int id, TicketRealisation ticket_real) throws SQLException {
		if (ticket_real != null) {
			dataSource.setUpdateQueryString("`ticket_realisations` SET " + ticket_real.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_realisation \n");
		}
	}

}

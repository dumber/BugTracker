/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TicketValidation;
import model.dao.TicketValidationDao;

/**
 * @author dumber
 *
 */
public class TicketValidationDaoFactory extends GenericDaoFactory implements TicketValidationDao {

	/**
	 * 
	 */
	public TicketValidationDaoFactory() {
		super("`ticket_validations`");
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketValidationDao#getAllTableElements()
	 */
	@Override
	public List<TicketValidation> getAllTableElements() throws SQLException {
		List<TicketValidation> ticket_validations = new ArrayList<TicketValidation>();
		dataSource.setSelectQueryString("`ticket_validations_view`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketValidation tv = new TicketValidation(rs.getInt("id"),  rs.getInt("tv_ticket_id"), 
					rs.getString("validator_comments"), rs.getString("validated_version"), rs.getTimestamp("validation_date"),
					rs.getString("validator"), rs.getTimestamp("closure_date"),
					rs.getInt("project_id"));
			ticket_validations.add(tv);
		}
		rs.close();
		return ticket_validations;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketValidationDao#findElementById(int)
	 */
	@Override
	public TicketValidation findElementById(int id) throws SQLException {
		TicketValidation tv = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`ticket_validations_view` WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			tv = new TicketValidation(rs.getInt("id"),  rs.getInt("tv_ticket_id"), 
					rs.getString("validator_comments"), rs.getString("validated_version"), rs.getTimestamp("validation_date"),
					rs.getString("validator"), rs.getTimestamp("closure_date"),
					rs.getInt("project_id"));
		}
		rs.close();
		return tv;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TicketValidationDao#addElementToTable(model.TicketValidation)
	 */
	@Override
	public void addElementToTable(TicketValidation ticket_val) throws SQLException {
		if (ticket_val != null) {
			dataSource.setInsertQueryString("`ticket_validations` (`tv_ticket_id`,`validator_comments`,"
					+ "`validated_ver_id`,`validation_date`,`validator_user_id`,`closure_date`, `project_id`) VALUES (" 
					+ ticket_val.toInsertString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_validation into database \n");
		}

	}

	/* (non-Javadoc)
	 * @see model.dao.TicketValidationDao#updateElementInTalbe(int, model.TicketValidation)
	 */
	@Override
	public  void updateElementInTalbe(int id, TicketValidation ticket_val) throws SQLException {
		if (ticket_val != null) {
			dataSource.setUpdateQueryString("`ticket_validations` SET " + ticket_val.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_validation \n");
		}
	}

}

/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.TicketValidation;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class TicketValidationDaoFactory extends GenericDaoFactory implements
		GenericDaoIFC {

	/**
	 * 
	 */
	public TicketValidationDaoFactory() {
		super();
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<TicketValidation> ticket_validations = new ArrayList<TicketValidation>();
		dataSource.setSelectQueryString("`ticket_validations`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketValidation tv = new TicketValidation(rs.getInt("tv_id"),  rs.getInt("tv_ticket_id"), 
					rs.getString("validator_comments"), rs.getInt("validated_ver_id"), rs.getTimestamp("validation_date"),
					rs.getInt("validator_user_id"), rs.getTimestamp("closure_date"));
			ticket_validations.add(tv);
		}
		rs.close();
		return ticket_validations;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int tv_id, Class<T> type) throws SQLException {
		TicketValidation tv = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`ticket_validations` WHERE tv_id = ?" );
		dataSource.executeSelectByIdQuery(tv_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			tv = new TicketValidation(rs.getInt("tv_id"),  rs.getInt("tv_ticket_id"), 
					rs.getString("validator_comments"), rs.getInt("validated_ver_id"), rs.getTimestamp("validation_date"),
					rs.getInt("validator_user_id"), rs.getTimestamp("closure_date"));
		}
		rs.close();
		return type.cast(tv);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public TicketValidation findTicketValidationById(int id) throws SQLException {
		return findElementById(id, TicketValidation.class);
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T ticket_val) throws SQLException {
		if (((TicketValidation)ticket_val) != null) {
			dataSource.setInsertQueryString("`ticket_validations` (`tv_ticket_id`,`validator_comments`,"
					+ "`validated_ver_id`,`validation_date`,`validator_user_id`,`closure_date`) VALUES (" 
					+ ((TicketValidation)ticket_val).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_validation into database \n");
		}

	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int tv_id, T ticket_val) throws SQLException {
		if (((TicketValidation)ticket_val) != null) {
			dataSource.setUpdateQueryString("`ticket_validations` SET " + ((TicketValidation)ticket_val).toUpdateString() 
					+ " WHERE tv_id = " + tv_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_validation \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int tv_id) throws SQLException {
		dataSource.setDeleteQueryString("`ticket_validations` WHERE tv_id = " + tv_id + ";");
		dataSource.executeDeleteQuery();
	}

}

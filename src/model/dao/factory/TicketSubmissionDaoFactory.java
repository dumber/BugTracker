/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.TicketSubmission;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class TicketSubmissionDaoFactory extends GenericDaoFactory implements
		GenericDaoIFC {

	/**
	 * 
	 */
	public TicketSubmissionDaoFactory() {
		super("`ticket_submissions`");
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<TicketSubmission> ticket_submissions = new ArrayList<TicketSubmission>();
		dataSource.setSelectQueryString("`ticket_submissions`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketSubmission ts = new TicketSubmission(rs.getInt("id"), rs.getInt("ts_ticket_id"), 
					rs.getInt("submission_ver_id"), rs.getInt("scheduled_ver_id"), rs.getInt("submitter_user_id"), 
					rs.getTimestamp("submission_date"), rs.getInt("detection_phase_id"));
			ticket_submissions.add(ts);
		}
		rs.close();
		return ticket_submissions;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int id, Class<T> type) throws SQLException {
		TicketSubmission ts = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`ticket_submissions` WHERE id = ?");
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			 ts = new TicketSubmission(rs.getInt("id"), rs.getInt("ts_ticket_id"), 
						rs.getInt("submission_ver_id"), rs.getInt("scheduled_ver_id"), rs.getInt("submitter_user_id"), 
						rs.getTimestamp("submission_date"), rs.getInt("detection_phase_id"));
		}
		rs.close();
		return type.cast(ts);
	}

	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public TicketSubmission findTicketSubmissionById(int id) throws SQLException {
		return findElementById(id, TicketSubmission.class);
	}	
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T ticket_subm) throws SQLException {
		if (((TicketSubmission)ticket_subm) != null) {
			dataSource.setInsertQueryString("`ticket_submissions` (`ts_ticket_id`, `submission_ver_id`, `scheduled_ver_id`, "
					+ "`submitter_user_id`, `submission_date`, `detection_phase_id`) VALUES (" + ((TicketSubmission)ticket_subm).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_submission into database \n");
		}

	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int id, T ticket_subm) throws SQLException {
		if (((TicketSubmission)ticket_subm) != null) {
			dataSource.setUpdateQueryString("`ticket_submissions` SET " + ((TicketSubmission)ticket_subm).toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_submission \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int id) throws SQLException {
		dataSource.setDeleteQueryString("`ticket_submissions` WHERE `id` = " + id + ";");
		dataSource.executeDeleteQuery();
	}

}

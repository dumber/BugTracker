/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TicketSubmission;
import model.dao.TicketSubmissionDao;

/**
 * @author dumber
 *
 */
public class TicketSubmissionDaoFactory extends GenericDaoFactory implements
		TicketSubmissionDao {

	/**
	 * 
	 */
	public TicketSubmissionDaoFactory() {
		super("`ticket_submissions`");
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketSubmissionDao#getAllTableElements()
	 */
	@Override
	public List<TicketSubmission> getAllTableElements() throws SQLException {
		List<TicketSubmission> ticket_submissions = new ArrayList<TicketSubmission>();
		dataSource.setSelectQueryString("`ticket_submissions_view`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketSubmission ts = new TicketSubmission(rs.getInt("id"), rs.getInt("ts_ticket_id"), 
					rs.getString("submission_version"), rs.getString("scheduled_version"), rs.getString("submitter"), 
					rs.getTimestamp("submission_date"), rs.getString("detection_phase"),
					rs.getInt("project_id"));
			ticket_submissions.add(ts);
		}
		rs.close();
		return ticket_submissions;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketSubmissionDao#findElementById(int)
	 */
	@Override
	public TicketSubmission findElementById(int id) throws SQLException {
		TicketSubmission ts = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`ticket_submissions_view` WHERE id = ?;");
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			 ts = new TicketSubmission(rs.getInt("id"), rs.getInt("ts_ticket_id"), 
						rs.getString("submission_version"), rs.getString("scheduled_version"), rs.getString("submitter"), 
						rs.getTimestamp("submission_date"), rs.getString("detection_phase"),
						rs.getInt("project_id"));
		}
		rs.close();
		return ts;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TicketSubmissionDao#addElementToTable(model.TicketSubmission)
	 */
	@Override
	public void addElementToTable(TicketSubmission ticket_subm) throws SQLException {
		if (ticket_subm != null) {
			dataSource.setInsertQueryString("`ticket_submissions` (`ts_ticket_id`, `submission_ver_id`, `scheduled_ver_id`, "
					+ "`submitter_user_id`, `submission_date`, `detection_phase_id`, `project_id`) VALUES (" + ticket_subm.toInsertString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_submission into database \n");
		}

	}

	/* (non-Javadoc)
	 * @see model.dao.TicketSubmissionDao#updateElementInTalbe(int, model.TicketSubmission)
	 */
	@Override
	public void updateElementInTalbe(int id, TicketSubmission ticket_subm) throws SQLException {
		if (ticket_subm != null) {
			dataSource.setUpdateQueryString("`ticket_submissions` SET " + ticket_subm.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_submission \n");
		}
	}

}

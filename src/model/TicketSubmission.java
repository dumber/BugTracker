/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author dumber
 *
 */
public class TicketSubmission extends GenericTableElement {
	private int ts_ticket_id;
	private int submission_version_id;
	private int scheduled_version_id;
	private int submitter_user_id;
	private Timestamp submission_date;
	private int detection_phase_id;
	
	/**
	 * @param ticket_submission_id
	 * @param ts_ticket_id
	 * @param submission_version_id
	 * @param scheduled_version_id
	 * @param submitter_user_id
	 * @param submission_date
	 * @param detection_phase_id
	 */
	public TicketSubmission(int ticket_submission_id, int ts_ticket_id,
			int submission_version_id, int scheduled_version_id,
			int submitter_user_id, Timestamp submission_date,
			int detection_phase_id) {
		super(ticket_submission_id);
		this.ts_ticket_id = ts_ticket_id;
		this.submission_version_id = submission_version_id;
		this.scheduled_version_id = scheduled_version_id;
		this.submitter_user_id = submitter_user_id;
		this.submission_date = submission_date;
		this.detection_phase_id = detection_phase_id;
	}

	/**
	 * @param ts
	 */
	public TicketSubmission(TicketSubmission ts) {
		super(ts.id);
		this.ts_ticket_id = ts.ts_ticket_id;
		this.submission_version_id = ts.submission_version_id;
		this.scheduled_version_id = ts.scheduled_version_id;
		this.submitter_user_id = ts.submitter_user_id;
		this.submission_date = ts.submission_date;
		this.detection_phase_id = ts.detection_phase_id;
	}

	/**
	 * @return the ts_ticket_id
	 */
	public int getTsTicket_id() {
		return ts_ticket_id;
	}

	/**
	 * @param ts_ticket_id the ts_ticket_id to set
	 */
	public void setTsTicket_id(int ts_ticket_id) {
		this.ts_ticket_id = ts_ticket_id;
	}

	/**
	 * @return the submission_version_id
	 */
	public int getSubmissionVersion_id() {
		return submission_version_id;
	}

	/**
	 * @param submission_version_id the submission_version_id to set
	 */
	public void setSubmissionVersion_id(int submission_version_id) {
		this.submission_version_id = submission_version_id;
	}

	/**
	 * @return the scheduled_version_id
	 */
	public int getScheduledVersion_id() {
		return scheduled_version_id;
	}

	/**
	 * @param scheduled_version_id the scheduled_version_id to set
	 */
	public void setScheduledVersion_id(int scheduled_version_id) {
		this.scheduled_version_id = scheduled_version_id;
	}

	/**
	 * @return the submitter_user_id
	 */
	public int getSubmitterUser_id() {
		return submitter_user_id;
	}

	/**
	 * @param submitter_user_id the submitter_user_id to set
	 */
	public void setSubmitterUser_id(int submitter_user_id) {
		this.submitter_user_id = submitter_user_id;
	}

	/**
	 * @return the submission_date
	 */
	public Timestamp getSubmissionDate() {
		return submission_date;
	}

	/**
	 * @param submission_date the submission_date to set
	 */
	public void setSubmissionDate(Timestamp submission_date) {
		this.submission_date = submission_date;
	}

	/**
	 * @return the detection_phase_id
	 */
	public int getDetectionPhase_id() {
		return detection_phase_id;
	}

	/**
	 * @param detection_phase_id the detection_phase_id to set
	 */
	public void setDetectionPhase_id(int detection_phase_id) {
		this.detection_phase_id = detection_phase_id;
	}
	
}

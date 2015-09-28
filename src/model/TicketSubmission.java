/**
 * 
 */
package model;

import java.sql.Timestamp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * @author dumber
 *
 */
public class TicketSubmission extends GenericTableElement {
	private IntegerProperty ts_ticket_id;
	private IntegerProperty submission_version_id;
	private IntegerProperty scheduled_version_id;
	private IntegerProperty submitter_user_id;
	private ObjectProperty<Timestamp> submission_date;
	private IntegerProperty detection_phase_id;
	
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
		this.ts_ticket_id = new SimpleIntegerProperty(ts_ticket_id);
		this.submission_version_id = new SimpleIntegerProperty(submission_version_id);
		this.scheduled_version_id = new SimpleIntegerProperty(scheduled_version_id);
		this.submitter_user_id = new SimpleIntegerProperty(submitter_user_id);
		this.submission_date = new SimpleObjectProperty<Timestamp>(submission_date);
		this.detection_phase_id = new SimpleIntegerProperty(detection_phase_id);
	}

	/**
	 * @param ts
	 */
	public TicketSubmission(TicketSubmission ts) {
		super(ts.getId());
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
		return ts_ticket_id.get();
	}

	/**
	 * @param ts_ticket_id the ts_ticket_id to set
	 */
	public void setTsTicket_id(int ts_ticket_id) {
		this.ts_ticket_id.set(ts_ticket_id);
	}
	
	/**
	 * @return the ts_ticket_id
	 */
	public IntegerProperty tsTicketIdProperty() {
		return ts_ticket_id;
	}
	
	/**
	 * @return the submission_version_id
	 */
	public int getSubmissionVersion_id() {
		return submission_version_id.get();
	}

	/**
	 * @param submission_version_id the submission_version_id to set
	 */
	public void setSubmissionVersion_id(int submission_version_id) {
		this.submission_version_id.set(submission_version_id);
	}
	
	/**
	 * @return the submission_version_id
	 */
	public IntegerProperty submissionVersionIdProperty() {
		return submission_version_id;
	}
	
	/**
	 * @return the scheduled_version_id
	 */
	public int getScheduledVersion_id() {
		return scheduled_version_id.get();
	}
	
	/**
	 * @param scheduled_version_id the scheduled_version_id to set
	 */
	public void setScheduledVersion_id(int scheduled_version_id) {
		this.scheduled_version_id.set(scheduled_version_id);
	}
	
	/**
	 * @return the scheduled_version_id
	 */
	public IntegerProperty scheduledVersionIdProperty() {
		return scheduled_version_id;
	}
	
	/**
	 * @return the submitter_user_id
	 */
	public int getSubmitterUser_id() {
		return submitter_user_id.get();
	}

	/**
	 * @param submitter_user_id the submitter_user_id to set
	 */
	public void setSubmitterUser_id(int submitter_user_id) {
		this.submitter_user_id.set(submitter_user_id);
	}
	
	/**
	 * @return the submitter_user_id
	 */
	public IntegerProperty submitterUserIdProperty() {
		return submitter_user_id;
	}
	
	/**
	 * @return the submission_date
	 */
	public Timestamp getSubmissionDate() {
		return submission_date.get();
	}

	/**
	 * @param submission_date the submission_date to set
	 */
	public void setSubmissionDate(Timestamp submission_date) {
		this.submission_date.set(submission_date);
	}
	
	/**
	 * @return the submission_date
	 */
	public ObjectProperty<Timestamp> submissionDateProperty() {
		return submission_date;
	}
	
	/**
	 * @return the detection_phase_id
	 */
	public int getDetectionPhase_id() {
		return detection_phase_id.get();
	}

	/**
	 * @param detection_phase_id the detection_phase_id to set
	 */
	public void setDetectionPhase_id(int detection_phase_id) {
		this.detection_phase_id.set(detection_phase_id);
	}
	
	/**
	 * @return the detection_phase_id
	 */
	public IntegerProperty detectionPhaseIdProperty() {
		return detection_phase_id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (submission_date != null) {
			return ts_ticket_id.get()	+ ", " + submission_version_id.get() + ", " + scheduled_version_id.get()
				+ ", " + submitter_user_id.get() + ", \'" + submission_date.get() + "\', " + detection_phase_id.get();
		} else {
			return ts_ticket_id.get()	+ ", " + submission_version_id.get() + ", " + scheduled_version_id.get()
					+ ", " + submitter_user_id.get() + ",NULL , " + detection_phase_id.get();
		}
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		if (submission_date != null) {
			return "`ts_ticket_id`=" + ts_ticket_id.get()	+ ", `submission_ver_id`=" + submission_version_id.get()
				+ ", `scheduled_ver_id`=" + scheduled_version_id.get() + ", `submitter_user_id`=" 
				+ submitter_user_id.get()	+ ", `submission_date`=\'" + submission_date.get() + "\', `detection_phase_id`="
				+ detection_phase_id.get();
		} else {
			return "`ts_ticket_id`=" + ts_ticket_id.get()	+ ", `submission_ver_id`=" + submission_version_id.get()
					+ ", `scheduled_ver_id`=" + scheduled_version_id.get() + ", `submitter_user_id`=" 
					+ submitter_user_id.get()	+ ", `submission_date`= NULL , `detection_phase_id`="
					+ detection_phase_id.get();
		}
	}	
	
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketSubmission [id=" + id.get()	+ ", ts_ticket_id=" + ts_ticket_id.get()
				+ ", submission_version_id=" + submission_version_id.get()
				+ ", scheduled_version_id=" + scheduled_version_id.get()
				+ ", submitter_user_id=" + submitter_user_id.get()
				+ ", submission_date=" + submission_date.get()
				+ ", detection_phase_id=" + detection_phase_id.get() + "]";
	}	
	
}

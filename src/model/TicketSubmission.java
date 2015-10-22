/**
 * 
 */
package model;

import java.sql.Timestamp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class TicketSubmission extends GenericTableElement {
	private IntegerProperty ts_ticket_id;
	private StringProperty submission_version;
	private StringProperty scheduled_version;
	private StringProperty submitter;
	private ObjectProperty<Timestamp> submission_date;
	private StringProperty detection_phase;

	private IntegerProperty project_id;
	
	/**
	 * @param ticket_submission_id
	 * @param ts_ticket_id
	 * @param submission_version
	 * @param scheduled_version
	 * @param submitter
	 * @param submission_date
	 * @param detection_phase
	 */
	public TicketSubmission(int ticket_submission_id, int ts_ticket_id,
			String submission_ver, String scheduled_ver,
			String submitter, Timestamp submission_date,
			String detection_phase, int project_id) {
		super(ticket_submission_id);
		this.ts_ticket_id = new SimpleIntegerProperty(ts_ticket_id);
		this.submission_version = new SimpleStringProperty(submission_ver);
		this.scheduled_version = new SimpleStringProperty(scheduled_ver);
		this.submitter = new SimpleStringProperty(submitter);
		this.submission_date = new SimpleObjectProperty<Timestamp>(submission_date);
		this.detection_phase = new SimpleStringProperty(detection_phase);
		
		this.project_id = new SimpleIntegerProperty(project_id);
	}

	/**
	 * @param ts
	 */
	public TicketSubmission(TicketSubmission ts) {
		super(ts.getId());
		this.ts_ticket_id = ts.ts_ticket_id;
		this.submission_version = ts.submission_version;
		this.scheduled_version = ts.scheduled_version;
		this.submitter = ts.submitter;
		this.submission_date = ts.submission_date;
		this.detection_phase = ts.detection_phase;
		
		this.project_id = ts.project_id;
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
	 * @return the submission_version
	 */
	public String getSubmissionVersion() {
		return submission_version.get();
	}

	/**
	 * @param submission_version the submission_version to set
	 */
	public void setSubmissionVersion(String submission_version) {
		this.submission_version.set(submission_version);
	}

	/**
	 * @return the submission_version
	 */
	public StringProperty submissionVersionProperty() {
		return submission_version;
	}
	
	/**
	 * @return the scheduled_version
	 */
	public String getScheduledVersion() {
		return scheduled_version.get();
	}

	/**
	 * @param scheduled_version the scheduled_version to set
	 */
	public void setScheduledVersion(String scheduled_version) {
		this.scheduled_version.set(scheduled_version);
	}

	/**
	 * @return the scheduled_version
	 */
	public StringProperty scheduledVersionProperty() {
		return scheduled_version;
	}
	
	/**
	 * @return the submitter
	 */
	public String getSubmitter() {
		return submitter.get();
	}

	/**
	 * @param submitter the submitter to set
	 */
	public void setSubmitter(String submitter) {
		this.submitter.set(submitter);
	}

	/**
	 * @return the submitter
	 */
	public StringProperty submitterProperty() {
		return submitter;
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
	 * @return the detection_phase
	 */
	public String getDetectionPhase() {
		return detection_phase.get();
	}

	/**
	 * @param detection_phase the detection_phase to set
	 */
	public void setDetectionPhase(String detection_phase) {
		this.detection_phase.set(detection_phase);
	}

	/**
	 * @return the detection_phase
	 */
	public StringProperty detectionPhaseProperty() {
		return detection_phase;
	}
	
	/**
	 * @return the project_id
	 */
	public int getT_Project_id() {
		return project_id.get();
	}

	/**
	 * @param project_id the project_id to set
	 */
	public void setProject_id(int project_id) {
		this.project_id.set(project_id);
	}
	
	/**
	 * @return the t_project_id
	 */
	public IntegerProperty projectIdProperty() {
		return project_id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (submission_date.get() != null) {
			return ts_ticket_id.get()	+ ", \'" + submission_version.get() + "\', \'" + scheduled_version.get()
				+ "\', \'" + submitter.get() + "\', \'" + submission_date.get() + "\', \'" + detection_phase.get() + "\', " + project_id.get();
		} else {
			return ts_ticket_id.get()	+ ", \'" + submission_version.get() + "\', \'" + scheduled_version.get()
					+ "\', \'" + submitter.get() + "\' ,NULL , \'" + detection_phase.get() + "\', " + project_id.get();
		}
	}
	
	/**
	 * @return
	 */
	public String toInsertString() {
		if (submission_date.get() != null) {
			return ts_ticket_id.get()	+ ", (select `id` from `project_versions` where `project_versions`.`version` = \'" + submission_version.get() + "\' and `project_versions`.`project_id` = " + project_id.get() + "), (select `id` from `project_versions` where `project_versions`.`version` = \'" + scheduled_version.get() + "\' and `project_versions`.`project_id` = " + project_id.get() + "), (select `id` from `users` where `users`.`username` = \'" + submitter.get() + "\'), \'" + submission_date.get() + "\', (select `id` from `detection_phases` where `detection_phases`.`phase_name` = \'" + detection_phase.get() + "\'), " + project_id.get();
		} else {
			return ts_ticket_id.get()	+ ", (select `id` from `project_versions` where `project_versions`.`version` = \'" + submission_version.get() + "\' and `project_versions`.`project_id` = " + project_id.get() + "), (select `id` from `project_versions` where `project_versions`.`version` = \'" + scheduled_version.get() + "\' and `project_versions`.`project_id` = " + project_id.get() + "), (select `id` from `users` where `users`.`username` = \'" + submitter.get() + "\'), NULL, (select `id` from `detection_phases` where `detection_phases`.`phase_name` = \'" + detection_phase.get() + "\'), " + project_id.get();
		}
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		if (submission_date.get() != null) {
			return "`ts_ticket_id`=" + ts_ticket_id.get()	+ ", `submission_ver_id`=(select `id` from `project_versions` where `project_versions`.`version` = \'" + submission_version.get()
				+ "\' and `project_versions`.`project_id` = " + project_id.get() + "), `scheduled_ver_id`=(select `id` from `project_versions` where `project_versions`.`version` = \'" + scheduled_version.get() + "\' and `project_versions`.`project_id` = " + project_id.get() + "), `submitter_user_id`=(select `id` from `users` where `users`.`username` = \'" 
				+ submitter.get()	+ "\'), `submission_date`=\'" + submission_date.get() + "\', `detection_phase_id`=(select `id` from `detection_phases` where `detection_phases`.`phase_name` = \'"
				+ detection_phase.get() + "\'), `project_id`=" + project_id.get();
		} else {
			return "`ts_ticket_id`=" + ts_ticket_id.get()	+ ", `submission_ver_id`=(select `id` from `project_versions` where `project_versions`.`version` = \'" + submission_version.get()
					+ "\' and `project_versions`.`project_id` = " + project_id.get() + "), `scheduled_ver_id`=(select `id` from `project_versions` where `project_versions`.`version` = \'" + scheduled_version.get() + "\' and `project_versions`.`project_id` = " + project_id.get() + "), `submitter_user_id`=(select `id` from `users` where `users`.`username` = \'" 
					+ submitter.get()	+ "\'), `submission_date`= NULL , `detection_phase_id`=(select `id` from `detection_phases` where `detection_phases`.`phase_name` = \'"
					+ detection_phase.get() + "\'), `project_id`=" + project_id.get();
		}
	}	
	
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketSubmission [id=" + id.get()	+ ", ts_ticket_id=" + ts_ticket_id.get()
				+ ", submission_version=" + submission_version.get()
				+ ", scheduled_version=" + scheduled_version.get()
				+ ", submitter=" + submitter.get()
				+ ", submission_date=" + submission_date.get()
				+ ", detection_phase=" + detection_phase.get() + ", " + project_id.get() +"]";
	}	
	
}

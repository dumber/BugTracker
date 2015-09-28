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
public class TicketValidation extends GenericTableElement {
	private IntegerProperty tv_ticket_id;
	private StringProperty validator_comments;
	private IntegerProperty validated_version_id;
	private ObjectProperty<Timestamp> validation_date;
	private IntegerProperty validator_user_id;
	private ObjectProperty<Timestamp> closure_date;
	
	/**
	 * @param ticket_validation_id
	 * @param tv_ticket_id
	 * @param validator_comments
	 * @param validated_version_id
	 * @param validation_date
	 * @param validator_user_id
	 * @param closure_date
	 */
	public TicketValidation(int ticket_validation_id, int tv_ticket_id,
			String validator_comments, int validated_version_id,
			Timestamp validation_date, int validator_user_id,
			Timestamp closure_date) {
		super(ticket_validation_id);
		this.tv_ticket_id = new SimpleIntegerProperty(tv_ticket_id);
		this.validator_comments = new SimpleStringProperty(validator_comments);
		this.validated_version_id = new SimpleIntegerProperty(validated_version_id);
		this.validation_date = new SimpleObjectProperty<Timestamp>(validation_date);
		this.validator_user_id = new SimpleIntegerProperty(validator_user_id);
		this.closure_date = new SimpleObjectProperty<Timestamp>(closure_date);
	}

	/**
	 * @param tv
	 */
	public TicketValidation(TicketValidation tv) {
		super(tv.getId());
		this.tv_ticket_id = tv.tv_ticket_id;
		this.validator_comments = tv.validator_comments;
		this.validated_version_id = tv.validated_version_id;
		this.validation_date = tv.validation_date;
		this.validator_user_id = tv.validator_user_id;
		this.closure_date = tv.closure_date;
	}

	/**
	 * @return the tv_ticket_id
	 */
	public int getTvTicket_id() {
		return tv_ticket_id.get();
	}

	/**
	 * @param tv_ticket_id the tv_ticket_id to set
	 */
	public void setTvTicket_id(int tv_ticket_id) {
		this.tv_ticket_id.set(tv_ticket_id);
	}
	
	/**
	 * @return the tv_ticket_id
	 */
	public IntegerProperty tvTicketIdProperty() {
		return tv_ticket_id;
	}
	
	/**
	 * @return the validator_comments
	 */
	public String getValidatorComments() {
		return validator_comments.get();
	}

	/**
	 * @param validator_comments the validator_comments to set
	 */
	public void setValidatorComments(String validator_comments) {
		this.validator_comments.set(validator_comments);
	}
	
	/**
	 * @return the validator_comments
	 */
	public StringProperty validatorCommentsProperty() {
		return validator_comments;
	}
	
	/**
	 * @return the validated_version_id
	 */
	public int getValidatedVersion_id() {
		return validated_version_id.get();
	}

	/**
	 * @param validated_version_id the validated_version_id to set
	 */
	public void setValidatedVersion_id(int validated_version_id) {
		this.validated_version_id.set(validated_version_id);
	}
	
	/**
	 * @return the validated_version_id
	 */
	public IntegerProperty validatedVersionIdProperty() {
		return validated_version_id;
	}
	
	/**
	 * @return the validation_date
	 */
	public Timestamp getValidationDate() {
		return validation_date.get();
	}

	/**
	 * @param validation_date the validation_date to set
	 */
	public void setValidationDate(Timestamp validation_date) {
		this.validation_date.set(validation_date);
	}
	
	/**
	 * @return the validation_date
	 */
	public ObjectProperty<Timestamp> validationDateProperty() {
		return validation_date;
	}
	
	/**
	 * @return the validator_user_id
	 */
	public int getValidatorUser_id() {
		return validator_user_id.get();
	}

	/**
	 * @param validator_user_id the validator_user_id to set
	 */
	public void setValidatorUser_id(int validator_user_id) {
		this.validator_user_id.set(validator_user_id);
	}
	
	/**
	 * @return the validator_user_id
	 */
	public IntegerProperty validatorUserIdProperty() {
		return validator_user_id;
	}
	
	/**
	 * @return the closure_date
	 */
	public Timestamp getClosureDate() {
		return closure_date.get();
	}

	/**
	 * @param closure_date the closure_date to set
	 */
	public void setClosureDate(Timestamp closure_date) {
		this.closure_date.set(closure_date);
	}
	
	/**
	 * @return the closure_date
	 */
	public ObjectProperty<Timestamp> closureDateProperty() {
		return closure_date;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (validation_date == null && closure_date == null) {
			return tv_ticket_id.get() + ", \'" + validator_comments.get() + "\', " + validated_version_id.get()
					+ ",NULL , " + validator_user_id.get() + ",NULL";
		} else if (validation_date == null) {
			return tv_ticket_id.get() + ", \'" + validator_comments.get() + "\', " + validated_version_id.get()
				+ ",NULL , " + validator_user_id.get() + ", \'" + closure_date.get() + "\'";
		} else if (closure_date == null) {
			return tv_ticket_id.get() + ", \'" + validator_comments.get() + "\', " + validated_version_id.get()
					+ ", \'" + validation_date.get() + "\', " + validator_user_id.get() + ",NULL";
		}  else {
			return tv_ticket_id.get() + ", \'" + validator_comments.get() + "\', " + validated_version_id.get()
					+ ", \'" + validation_date.get() + "\', " + validator_user_id.get() + ", \'" + closure_date.get() + "\'";
		}
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		if (validation_date == null && closure_date == null) {
			return "`tv_ticket_id`=" + tv_ticket_id.get()	+ ", `validator_comments`=\'" + validator_comments.get()
					+ "\', `validated_ver_id`=" + validated_version_id.get() + ", `validation_date`= NULL "
					+ ", `validator_user_id`=" + validator_user_id.get() + ", `closure_date`= NULL";
		} else if (validation_date == null) {
			return "`tv_ticket_id`=" + tv_ticket_id.get()	+ ", `validator_comments`=\'" + validator_comments.get()
					+ "\', `validated_ver_id`=" + validated_version_id.get() + ", `validation_date`= NULL" 
					+ ", `validator_user_id`=" + validator_user_id.get() + ", `closure_date`=\'" + closure_date.get() + "\'";
		} else if (closure_date == null) {
			return "`tv_ticket_id`=" + tv_ticket_id.get()	+ ", `validator_comments`=\'" + validator_comments.get()
					+ "\', `validated_ver_id`=" + validated_version_id.get() + ", `validation_date`=\'" + validation_date.get()
					+ "\', `validator_user_id`=" + validator_user_id.get() + ", `closure_date`= NULL";
		} else {
			return "`tv_ticket_id`=" + tv_ticket_id.get()	+ ", `validator_comments`=\'" + validator_comments.get()
					+ "\', `validated_ver_id`=" + validated_version_id.get() + ", `validation_date`=\'" + validation_date.get()
					+ "\', `validator_user_id`=" + validator_user_id.get() + ", `closure_date`=\'" + closure_date.get() + "\'";
		}
	}
		
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketValidation [id=" + id + "tv_ticket_id=" + tv_ticket_id.get()
				+ ", validator_comments=" + validator_comments.get()
				+ ", validated_version_id=" + validated_version_id.get()
				+ ", validation_date=" + validation_date.get()
				+ ", validator_user_id=" + validator_user_id.get()
				+ ", closure_date=" + closure_date.get() + "]";
	}
	
}

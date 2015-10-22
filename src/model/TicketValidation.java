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
	private StringProperty validated_version;
	private ObjectProperty<Timestamp> validation_date;
	private StringProperty validator;
	private ObjectProperty<Timestamp> closure_date;
	
	private IntegerProperty project_id;
	
	/**
	 * @param ticket_validation_id
	 * @param tv_ticket_id
	 * @param validator_comments
	 * @param validated_version
	 * @param validation_date
	 * @param validator
	 * @param closure_date
	 */
	public TicketValidation(int ticket_validation_id, int tv_ticket_id,
			String validator_comments, String validated_version,
			Timestamp validation_date, String validator,
			Timestamp closure_date, int project_id) {
		super(ticket_validation_id);
		this.tv_ticket_id = new SimpleIntegerProperty(tv_ticket_id);
		this.validator_comments = new SimpleStringProperty(validator_comments);
		this.validated_version = new SimpleStringProperty(validated_version);
		this.validation_date = new SimpleObjectProperty<Timestamp>(validation_date);
		this.validator = new SimpleStringProperty(validator);
		this.closure_date = new SimpleObjectProperty<Timestamp>(closure_date);
		
		this.project_id = new SimpleIntegerProperty(project_id);
	}

	/**
	 * @param tv
	 */
	public TicketValidation(TicketValidation tv) {
		super(tv.getId());
		this.tv_ticket_id = tv.tv_ticket_id;
		this.validator_comments = tv.validator_comments;
		this.validated_version = tv.validated_version;
		this.validation_date = tv.validation_date;
		this.validator = tv.validator;
		this.closure_date = tv.closure_date;
		
		this.project_id = tv.project_id;
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
	 * @return the validated_version
	 */
	public String getValidatedVersion() {
		return validated_version.get();
	}

	/**
	 * @param validated_version the validated_version to set
	 */
	public void setValidatedVersion(String validated_version) {
		this.validated_version.set(validated_version);
	}

	/**
	 * @return the validated_version
	 */
	public StringProperty validatedVersionProperty() {
		return validated_version;
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
	 * @return the validator
	 */
	public String getValidator() {
		return validator.get();
	}

	/**
	 * @param validator the validator to set
	 */
	public void setValidator(String validator) {
		this.validator.set(validator);
	}

	/**
	 * @return the validator
	 */
	public StringProperty validatorProperty() {
		return validator;
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
		if (validation_date.get() == null && closure_date.get() == null) {
			return tv_ticket_id.get() + ", \'" + validator_comments.get() + "\', " + validated_version.get()
					+ ",NULL , " + validator.get() + ",NULL";
		} else if (validation_date.get() == null) {
			return tv_ticket_id.get() + ", \'" + validator_comments.get() + "\', " + validated_version.get()
				+ ",NULL , " + validator.get() + ", \'" + closure_date.get() + "\'";
		} else if (closure_date.get() == null) {
			return tv_ticket_id.get() + ", \'" + validator_comments.get() + "\', " + validated_version.get()
					+ ", \'" + validation_date.get() + "\', " + validator.get() + ",NULL";
		}  else {
			return tv_ticket_id.get() + ", \'" + validator_comments.get() + "\', " + validated_version.get()
					+ ", \'" + validation_date.get() + "\', " + validator.get() + ", \'" + closure_date.get() + "\'";
		}
	}	
	
	/**
	 * @return
	 */
	public String toInsertString() {
		if (validation_date.get() == null && closure_date.get() == null) {
			return tv_ticket_id.get() + ", \'" + validator_comments.get() + "\', (select `id` from `project_versions` where `project_versions`.`version` = \'" + validated_version.get()
					+ "\' and `project_versions`.`project_id` = " + project_id.get() + "), NULL, (select `id` from `users` where `users`.`username` = \'" + validator.get() + "\'), NULL, " + project_id.get();
		} else if (validation_date.get() == null) {
			return tv_ticket_id.get() + ", \'" + validator_comments.get() + "\', (select `id` from `project_versions` where `project_versions`.`version` = \'" + validated_version.get()
					+ "\' and `project_versions`.`project_id` = " + project_id.get() + "), NULL, (select `id` from `users` where `users`.`username` = \'" + validator.get() + "\'), \'" + closure_date.get() + "\', " + project_id.get();
		} else if (closure_date.get() == null) {
			return tv_ticket_id.get() + ", \'" + validator_comments.get() + "\', (select `id` from `project_versions` where `project_versions`.`version` = \'" + validated_version.get()
					+ "\' and `project_versions`.`project_id` = " + project_id.get() + "), \'" + validation_date.get() + "\', (select `id` from `users` where `users`.`username` = \'" + validator.get() + "\'), NULL, " + project_id.get();
		}  else {
			return tv_ticket_id.get() + ", \'" + validator_comments.get() + "\', (select `id` from `project_versions` where `project_versions`.`version` = \'" + validated_version.get()
					+ "\' and `project_versions`.`project_id` = " + project_id.get() + "), \'" + validation_date.get() + "\', (select `id` from `users` where `users`.`username` = \'" + validator.get() + "\'), \'" + closure_date.get() + "\', " + project_id.get();
		}
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		if (validation_date.get() == null && closure_date.get() == null) {
			return "`tv_ticket_id`=" + tv_ticket_id.get()	+ ", `validator_comments`=\'" + validator_comments.get()
					+ "\', `validated_ver_id`=(select `id` from `project_versions` where `project_versions`.`version` = \'" + validated_version.get() + "\' and `project_versions`.`project_id` = " + project_id.get() + "), `validation_date`= NULL "
					+ ", `validator_user_id`=(select `id` from `users` where `users`.`username` = \'" + validator.get() + "\'), `closure_date`= NULL, `project_id`=" + project_id.get();
		} else if (validation_date.get() == null) {
			return "`tv_ticket_id`=" + tv_ticket_id.get()	+ ", `validator_comments`=\'" + validator_comments.get()
					+ "\', `validated_ver_id`=(select `id` from `project_versions` where `project_versions`.`version` = \'" + validated_version.get() + "\' and `project_versions`.`project_id` = " + project_id.get() + "), `validation_date`= NULL" 
					+ ", `validator_user_id`=(select `id` from `users` where `users`.`username` = \'" + validator.get() + "\'), `closure_date`=\'" + closure_date.get() + "\', `project_id`=" + project_id.get();
		} else if (closure_date.get()== null) {
			return "`tv_ticket_id`=" + tv_ticket_id.get()	+ ", `validator_comments`=\'" + validator_comments.get()
					+ "\', `validated_ver_id`=(select `id` from `project_versions` where `project_versions`.`version` = \'" + validated_version.get() + "\' and `project_versions`.`project_id` = " + project_id.get() + "), `validation_date`=\'" + validation_date.get()
					+ "\', `validator_user_id`=(select `id` from `users` where `users`.`username` = \'" + validator.get() + "\'), `closure_date`= NULL, `project_id`=" + project_id.get();
		} else {
			return "`tv_ticket_id`=" + tv_ticket_id.get()	+ ", `validator_comments`=\'" + validator_comments.get()
					+ "\', `validated_ver_id`=(select `id` from `project_versions` where `project_versions`.`version` = \'" + validated_version.get() + "\' and `project_versions`.`project_id` = " + project_id.get() + "), `validation_date`=\'" + validation_date.get()
					+ "\', `validator_user_id`=(select `id` from `users` where `users`.`username` = \'" + validator.get() + "\'), `closure_date`=\'" + closure_date.get() + "\', `project_id`=" + project_id.get();
		}
	}
		
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketValidation [id=" + id + "tv_ticket_id=" + tv_ticket_id.get()
				+ ", validator_comments=" + validator_comments.get()
				+ ", validated_version=" + validated_version.get()
				+ ", validation_date=" + validation_date.get()
				+ ", validator=" + validator.get()
				+ ", closure_date=" + closure_date.get() + ", project_id=" + project_id.get() + "]";
	}
	
}

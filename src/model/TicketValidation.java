/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author dumber
 *
 */
public class TicketValidation extends GenericTableElement {
	private int tv_ticket_id;
	private String validator_comments;
	private int validated_version_id;
	private Timestamp validation_date;
	private int validator_user_id;
	private Timestamp closure_date;
	
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
		this.tv_ticket_id = tv_ticket_id;
		this.validator_comments = validator_comments;
		this.validated_version_id = validated_version_id;
		this.validation_date = validation_date;
		this.validator_user_id = validator_user_id;
		this.closure_date = closure_date;
	}

	/**
	 * @param tv
	 */
	public TicketValidation(TicketValidation tv) {
		super(tv.id);
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
		return tv_ticket_id;
	}

	/**
	 * @param tv_ticket_id the tv_ticket_id to set
	 */
	public void setTvTicket_id(int tv_ticket_id) {
		this.tv_ticket_id = tv_ticket_id;
	}

	/**
	 * @return the validator_comments
	 */
	public String getValidatorComments() {
		return validator_comments;
	}

	/**
	 * @param validator_comments the validator_comments to set
	 */
	public void setValidatorComments(String validator_comments) {
		this.validator_comments = validator_comments;
	}

	/**
	 * @return the validated_version_id
	 */
	public int getValidatedVersion_id() {
		return validated_version_id;
	}

	/**
	 * @param validated_version_id the validated_version_id to set
	 */
	public void setValidatedVersion_id(int validated_version_id) {
		this.validated_version_id = validated_version_id;
	}

	/**
	 * @return the validation_date
	 */
	public Timestamp getValidationDate() {
		return validation_date;
	}

	/**
	 * @param validation_date the validation_date to set
	 */
	public void setValidationDate(Timestamp validation_date) {
		this.validation_date = validation_date;
	}

	/**
	 * @return the validator_user_id
	 */
	public int getValidatorUser_id() {
		return validator_user_id;
	}

	/**
	 * @param validator_user_id the validator_user_id to set
	 */
	public void setValidatorUser_id(int validator_user_id) {
		this.validator_user_id = validator_user_id;
	}

	/**
	 * @return the closure_date
	 */
	public Timestamp getClosureDate() {
		return closure_date;
	}

	/**
	 * @param closure_date the closure_date to set
	 */
	public void setClosureDate(Timestamp closure_date) {
		this.closure_date = closure_date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return tv_ticket_id + ", \'" + validator_comments + "\', " + validated_version_id
				+ ", \'" + validation_date + "\', " + validator_user_id + ", \'" + closure_date + "\'";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`tv_ticket_id`=" + tv_ticket_id	+ ", `validator_comments`=\'" + validator_comments
				+ "\', `validated_version_id`=" + validated_version_id + ", `validation_date`=\'" + validation_date
				+ "\', `validator_user_id`=" + validator_user_id + ", `closure_date`=\'" + closure_date + "\'";
	}
		
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketValidation [id=" + id + "tv_ticket_id=" + tv_ticket_id
				+ ", validator_comments=" + validator_comments
				+ ", validated_version_id=" + validated_version_id
				+ ", validation_date=" + validation_date
				+ ", validator_user_id=" + validator_user_id
				+ ", closure_date=" + closure_date + "]";
	}
	
}

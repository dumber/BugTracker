/**
 * 
 */
package model;

import java.sql.Timestamp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class Ticket {
	private IntegerProperty id;

	private StringProperty proposed_change;
	private StringProperty impacted_version;
	private ObjectProperty<Timestamp> analysis_date;
	private StringProperty analyst;
	
	private StringProperty unique_ticket_name;
	private StringProperty project_name;
	private StringProperty headline;
	private StringProperty description;
	private StringProperty severity;
	private StringProperty priority;
	private StringProperty status;
	
	private StringProperty modifier;
	private StringProperty old_status;
	private StringProperty new_status;
	private StringProperty action;
	private ObjectProperty<Timestamp> modification_date;
	
	private StringProperty ticket;
	private StringProperty linked_ticket;
	
	private StringProperty realised_items;
	private StringProperty realised_version;
	private ObjectProperty<Timestamp> realisation_date;
	private StringProperty realiser;
	
	private StringProperty submission_version;
	private StringProperty scheduled_version;
	private StringProperty submitter;
	private ObjectProperty<Timestamp> submission_date;
	private StringProperty detection_phase;
	
	private StringProperty validator_comments;
	private StringProperty validated_version;
	private ObjectProperty<Timestamp> validation_date;
	private StringProperty validator;
	private ObjectProperty<Timestamp> closure_date;
	
	private IntegerProperty estimated_analysis;
	private IntegerProperty estimated_realisation;
	private IntegerProperty estimated_validation;
	private IntegerProperty estimated_sum;
	private IntegerProperty analysis_workload;
	private IntegerProperty realisation_workload;
	private IntegerProperty validation_workload;
	private IntegerProperty workload_sum;
	
	/**
	 * 
	 */
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @return the id
	 */
	public IntegerProperty getId() {
		return id;
	}
	
// *********************
//		ANALYSIS
// *********************
	
	/**
	 * @param id the id to set
	 */
	public void setId(IntegerProperty id) {
		this.id = id;
	}

	/**
	 * @return the proposed_change
	 */
	public String getProposedChange() {
		return proposed_change.get();
	}

	/**
	 * @param proposed_change the proposed_change to set
	 */
	public void setProposedChange(String proposed_change) {
		this.proposed_change.set(proposed_change);
	}

	/**
	 * @return the proposed_change
	 */
	public StringProperty proposedChangeProperty() {
		return proposed_change;
	}

	/**
	 * @return the impacted_version
	 */
	public String getImpactedVersion() {
		return impacted_version.get();
	}

	/**
	 * @param impacted_version the impacted_version to set
	 */
	public void setImpactedVersion(String impacted_version) {
		this.impacted_version.set(impacted_version);
	}

	/**
	 * @return the impacted_version
	 */
	public StringProperty impactedVersionProperty() {
		return impacted_version;
	}

	/**
	 * @return the analysis_date
	 */
	public Timestamp getAnalysisDate() {
		return analysis_date.get();
	}

	/**
	 * @param analysis_date the analysis_date to set
	 */
	public void setAnalysisDate(Timestamp analysis_date) {
		this.analysis_date.set(analysis_date);
	}

	/**
	 * @return the analysis_date
	 */
	public ObjectProperty<Timestamp> analysisDateProperty() {
		return analysis_date;
	}

	/**
	 * @return the analyst
	 */
	public String getAnalyist() {
		return analyst.get();
	}

	/**
	 * @param analyst the analyst to set
	 */
	public void setAnalyist(String analyst) {
		this.analyst.set(analyst);
	}

	/**
	 * @return the analyst
	 */
	public StringProperty analyistProperty() {
		return analyst;
	}

// *********************
// 		HEADER
// *********************
	
	/**
	 * @return the unique_ticket_name
	 */
	public String getUniqueTicketName() {
		return unique_ticket_name.get();
	}

	/**
	 * @param unique_ticket_name the unique_ticket_name to set
	 */
	public void setUniqueTicketName(String unique_ticket_name) {
		this.unique_ticket_name.set(unique_ticket_name);
	}
	
	/**
	 * @return the unique_ticket_name
	 */
	public StringProperty uniqueTicketNameProperty() {
		return unique_ticket_name;
	}

	/**
	 * @return the project_name
	 */
	public String getProjectName() {
		return project_name.get();
	}

	/**
	 * @param project_name the project_name to set
	 */
	public void setProjectName(String project_name) {
		this.project_name.set(project_name);
	}

	/**
	 * @return the project_name
	 */
	public StringProperty projectNameProperty() {
		return project_name;
	}

	/**
	 * @return the headline
	 */
	public String getHeadline() {
		return headline.get();
	}

	/**
	 * @param headline the headline to set
	 */
	public void setHeadline(String headline) {
		this.headline.set(headline);
	}

	/**
	 * @return the headline
	 */
	public StringProperty headlineProperty() {
		return headline;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description.get();
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description.set(description);
	}

	/**
	 * @return the description
	 */
	public StringProperty descriptionProperty() {
		return description;
	}

	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity.get();
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity.set(severity);
	}

	/**
	 * @return the severity
	 */
	public StringProperty severityProperty() {
		return severity;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority.get();
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority.set(priority);
	}

	/**
	 * @return the priority
	 */
	public StringProperty priorityProperty() {
		return priority;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status.get();
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status.set(status);
	}

	/**
	 * @return the status
	 */
	public StringProperty statusPorperty() {
		return status;
	}

// *********************
//		HISTORY
// *********************
	
	/**
	 * @return the modifier
	 */
	public String getModifier() {
		return modifier.get();
	}

	/**
	 * @param modifier the modifier to set
	 */
	public void setModifier(String modifier) {
		this.modifier.set(modifier);
	}
	
	/**
	 * @return the modifier
	 */
	public StringProperty modifierProperty() {
		return modifier;
	}

	/**
	 * @return the old_status
	 */
	public String getOldStatus() {
		return old_status.get();
	}

	/**
	 * @param old_status the old_status to set
	 */
	public void setOldStatus(String old_status) {
		this.old_status.set(old_status);
	}

	/**
	 * @return the old_status
	 */
	public StringProperty oldStatusProperty() {
		return old_status;
	}

	/**
	 * @return the new_status
	 */
	public String getNewStatus() {
		return new_status.get();
	}

	/**
	 * @param new_status the new_status to set
	 */
	public void setNewStatus(String new_status) {
		this.new_status.set(new_status);
	}

	/**
	 * @return the new_status
	 */
	public StringProperty newStatusProperty() {
		return new_status;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action.get();
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action.set(action);
	}

	/**
	 * @return the action
	 */
	public StringProperty actionProperty() {
		return action;
	}

	/**
	 * @return the modification_date
	 */
	public Timestamp getModificationDate() {
		return modification_date.get();
	}

	/**
	 * @param modification_date the modification_date to set
	 */
	public void setModificationDate(Timestamp modification_date) {
		this.modification_date.set(modification_date);
	}

	/**
	 * @return the modification_date
	 */
	public ObjectProperty<Timestamp> modificationDateProperty() {
		return modification_date;
	}
	
// *********************
//		TICKET LINK
// *********************
	
	/**
	 * @return the ticket
	 */
	public String getTicketWithLink() {
		return ticket.get();
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicketWithLink(String ticket) {
		this.ticket.set(ticket);
	}

	/**
	 * @return the ticket
	 */
	public StringProperty ticketWithLinkProperty() {
		return ticket;
	}

	/**
	 * @return the linked_ticket
	 */
	public String getLinkedTicket() {
		return linked_ticket.get();
	}

	/**
	 * @param linked_ticket the linked_ticket to set
	 */
	public void setLinkedTicket(String linked_ticket) {
		this.linked_ticket.set(linked_ticket);
	}

	/**
	 * @return the linked_ticket
	 */
	public StringProperty linkedTicketProperty() {
		return linked_ticket;
	}

// *********************
//		REALISATION
// *********************
	
	/**
	 * @return the realised_items
	 */
	public String getRealisedItems() {
		return realised_items.get();
	}

	/**
	 * @param realised_items the realised_items to set
	 */
	public void setRealisedItems(String realised_items) {
		this.realised_items.set(realised_items);
	}

	/**
	 * @return the realised_items
	 */
	public StringProperty realisedItemsProperty() {
		return realised_items;
	}

	/**
	 * @return the realised_version
	 */
	public String getRealisedVersion() {
		return realised_version.get();
	}

	/**
	 * @param realised_version the realised_version to set
	 */
	public void setRealisedVersion(String realissed_version) {
		this.realised_version.set(realissed_version);
	}

	/**
	 * @return the realised_version
	 */
	public StringProperty realisedVersionProperty() {
		return realised_version;
	}

	/**
	 * @return the realisation_date
	 */
	public Timestamp getRealisationDate() {
		return realisation_date.get();
	}

	/**
	 * @param realisation_date the realisation_date to set
	 */
	public void setRealisationDate(Timestamp realisation_date) {
		this.realisation_date.set(realisation_date);
	}

	/**
	 * @return the realisation_date
	 */
	public ObjectProperty<Timestamp> realisationDateProperty() {
		return realisation_date;
	}

	/**
	 * @return the realiser
	 */
	public String getRealiser() {
		return realiser.get();
	}

	/**
	 * @param realiser the realiser to set
	 */
	public void setRealiser(String realiser) {
		this.realiser.set(realiser);
	}

	/**
	 * @return the realiser
	 */
	public StringProperty realiserProperty() {
		return realiser;
	}

// *********************
//		SUBMISSION
// *********************
	
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
	
// *********************
//		VALIDATION
// *********************
	
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
	
// *********************
// 		WORKLOAD	
// *********************
	
	/**
	 * @return the estimated_analysis
	 */
	public int getEstimatedAnalysis() {
		return estimated_analysis.get();
	}

	/**
	 * @param estimated_analysis the estimated_analysis to set
	 */
	public void setEstimatedAnalysis(int estimated_analysis) {
		this.estimated_analysis.set(estimated_analysis);
	}

	/**
	 * @return the estimated_analysis
	 */
	public IntegerProperty estimatedAnalysisProperty() {
		return estimated_analysis;
	}

	/**
	 * @return the estimated_realisation
	 */
	public int getEstimatedRealisation() {
		return estimated_realisation.get();
	}

	/**
	 * @param estimated_realisation the estimated_realisation to set
	 */
	public void setEstimatedRealisation(int estimated_realisation) {
		this.estimated_realisation.set(estimated_realisation);
	}

	/**
	 * @return the estimated_realisation
	 */
	public IntegerProperty estimatedRealisationProperty() {
		return estimated_realisation;
	}

	/**
	 * @return the estimated_validation
	 */
	public int getEstimatedValidation() {
		return estimated_validation.get();
	}

	/**
	 * @param estimated_validation the estimated_validation to set
	 */
	public void setEstimatedValidation(int estimated_validation) {
		this.estimated_validation.set(estimated_validation);
	}

	/**
	 * @return the estimated_validation
	 */
	public IntegerProperty estimatedValidationProperty() {
		return estimated_validation;
	}

	/**
	 * @return the estimated_sum
	 */
	public int getEstimatedSum() {
		return estimated_sum.get();
	}

	/**
	 * @param estimated_sum the estimated_sum to set
	 */
	public void setEstimatedSum(int estimated_sum) {
		this.estimated_sum.set(estimated_sum);
	}

	/**
	 * @return the estimated_sum
	 */
	public IntegerProperty estimatedSumProperty() {
		return estimated_sum;
	}
	
	/**
	 * @return the analysis_workload
	 */
	public int getAnalysisWorkload() {
		return analysis_workload.get();
	}

	/**
	 * @param analysis_workload the analysis_workload to set
	 */
	public void setAnalysisWorkload(int analysis_workload) {
		this.analysis_workload.set(analysis_workload);
	}

	/**
	 * @return the analysis_workload
	 */
	public IntegerProperty analysisWorkloadProperty() {
		return analysis_workload;
	}
	
	/**
	 * @return the realisation_workload
	 */
	public int getRealisationWorkload() {
		return realisation_workload.get();
	}

	/**
	 * @param realisation_workload the realisation_workload to set
	 */
	public void setRealisationWorkload(int realisation_workload) {
		this.realisation_workload.set(realisation_workload);
	}

	/**
	 * @return the realisation_workload
	 */
	public IntegerProperty realisationWorkloadProperty() {
		return realisation_workload;
	}
	
	/**
	 * @return the validation_workload
	 */
	public int getValidationWorkload() {
		return validation_workload.get();
	}

	/**
	 * @param validation_workload the validation_workload to set
	 */
	public void setValidationWorkload(int validation_workload) {
		this.validation_workload.set(validation_workload);
	}
	
	/**
	 * @return the validation_workload
	 */
	public IntegerProperty validationWorkloadProperty() {
		return validation_workload;
	}
	
	/**
	 * @return the workload_sum
	 */
	public int getWorkloadSum() {
		return workload_sum.get();
	}

	/**
	 * @param workload_sum the workload_sum to set
	 */
	public void setWorkloadSum(int workload_sum) {
		this.workload_sum.set(workload_sum);
	}
	
	/**
	 * @return the workload_sum
	 */
	public IntegerProperty workloadSumProperty() {
		return workload_sum;
	}
	
}

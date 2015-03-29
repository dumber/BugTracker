package model;

/**
 * @author dumber
 *
 */
public class Ticket {
	private int t_id;
	private String ticket_id;
	private int project_id;
	private String submission_version;
	private String headline;
	private String description;
	private String scheduled_version;
	private int submitter_user_id;
	private String submission_date;
	private String detection_phase;
	private String severity;
	private String priority;
	private int estimated_wl;
	private int workload;
	private String state;
	private String linked_ticket;
	private String linked_headline;
	private int analyser_id;
	private String proposed_change;
	private String impacted_version;
	private String analysis_date;
	private int realiser_id;
	private String realised_items;
	private String realised_version;
	private String realisation_date;
	private int validator_id;
	private String validator_comments;
	private String validated_version;
	private String validation_date;
	private String closure_date;
	
	public Ticket(int t_id, String ticket_id, int project_id,
			String submission_version, String headline, String description,
			String scheduled_version, int submitter_user_id,
			String submission_date, String detection_phase, String severity,
			String priority, int estimated_wl, int workload, String state,
			String linked_ticket, String linked_headline, int analyser_id,
			String proposed_change, String impacted_version,
			String analysis_date, int realiser_id, String realised_items,
			String realised_version, String realisation_date, int validator_id,
			String validator_comments, String validated_version,
			String validation_date, String closure_date) {
		super();
		this.t_id = t_id;
		this.ticket_id = ticket_id;
		this.project_id = project_id;
		this.submission_version = submission_version;
		this.headline = headline;
		this.description = description;
		this.scheduled_version = scheduled_version;
		this.submitter_user_id = submitter_user_id;
		this.submission_date = submission_date;
		this.detection_phase = detection_phase;
		this.severity = severity;
		this.priority = priority;
		this.estimated_wl = estimated_wl;
		this.workload = workload;
		this.state = state;
		this.linked_ticket = linked_ticket;
		this.linked_headline = linked_headline;
		this.analyser_id = analyser_id;
		this.proposed_change = proposed_change;
		this.impacted_version = impacted_version;
		this.analysis_date = analysis_date;
		this.realiser_id = realiser_id;
		this.realised_items = realised_items;
		this.realised_version = realised_version;
		this.realisation_date = realisation_date;
		this.validator_id = validator_id;
		this.validator_comments = validator_comments;
		this.validated_version = validated_version;
		this.validation_date = validation_date;
		this.closure_date = closure_date;
	}

	public int getT_id() {
		return t_id;
	}
	
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	
	public String getTicket_id() {
		return ticket_id;
	}
	
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	
	public int getProject_id() {
		return project_id;
	}
	
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	
	public String getSubmissionVersion() {
		return submission_version;
	}
	
	public void setSubmissionVersion(String submission_version) {
		this.submission_version = submission_version;
	}
	
	public String getHeadline() {
		return headline;
	}
	
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getScheduledVersion() {
		return scheduled_version;
	}
	
	public void setScheduledVersion(String scheduled_version) {
		this.scheduled_version = scheduled_version;
	}
	
	public int getSubmitterUser_id() {
		return submitter_user_id;
	}
	
	public void setSubmitterUser_id(int submitter_user_id) {
		this.submitter_user_id = submitter_user_id;
	}
	
	public String getSubmissionDate() {
		return submission_date;
	}
	
	public void setSubmissionDate(String submission_date) {
		this.submission_date = submission_date;
	}
	
	public String getDetectionPhase() {
		return detection_phase;
	}
	
	public void setDetectionPhase(String detection_phase) {
		this.detection_phase = detection_phase;
	}
	
	public String getSeverity() {
		return severity;
	}
	
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public int getEstimatedWorkload() {
		return estimated_wl;
	}
	
	public void setEstimatedWorkload(int estimated_wl) {
		this.estimated_wl = estimated_wl;
	}
	
	public int getWorkload() {
		return workload;
	}
	
	public void setWorkload(int workload) {
		this.workload = workload;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getLinkedTicket() {
		return linked_ticket;
	}
	
	public void setLinkedTicket(String linked_ticket) {
		this.linked_ticket = linked_ticket;
	}
	
	public String getLinkedHeadline() {
		return linked_headline;
	}
	
	public void setLinkedHeadline(String linked_headline) {
		this.linked_headline = linked_headline;
	}
	
	public int getAnalyser_id() {
		return analyser_id;
	}
	
	public void setAnalyser_id(int analyser_id) {
		this.analyser_id = analyser_id;
	}
	
	public String getProposedChange() {
		return proposed_change;
	}
	
	public void setProposedChange(String proposed_change) {
		this.proposed_change = proposed_change;
	}
	
	public String getImpactedVersion() {
		return impacted_version;
	}
	
	public void setImpactedVersion(String impacted_version) {
		this.impacted_version = impacted_version;
	}
	
	public String getAnalysisDate() {
		return analysis_date;
	}
	
	public void setAnalysisDate(String analysis_date) {
		this.analysis_date = analysis_date;
	}
	
	public int getRealiser_id() {
		return realiser_id;
	}
	
	public void setRealiser_id(int realiser_id) {
		this.realiser_id = realiser_id;
	}
	
	public String getRealisedItems() {
		return realised_items;
	}
	
	public void setRealisedItems(String realised_items) {
		this.realised_items = realised_items;
	}
	
	public String getRealisedVersion() {
		return realised_version;
	}
	
	public void setRealisedVersion(String realised_version) {
		this.realised_version = realised_version;
	}
	
	public String getRealisationDate() {
		return realisation_date;
	}
	
	public void setRealisationDate(String realisation_date) {
		this.realisation_date = realisation_date;
	}
	
	public int getValidator_id() {
		return validator_id;
	}
	
	public void setValidator_id(int validator_id) {
		this.validator_id = validator_id;
	}
	
	public String getValidatorComments() {
		return validator_comments;
	}
	
	public void setValidatorComments(String validator_comments) {
		this.validator_comments = validator_comments;
	}
	
	public String getValidatedVersion() {
		return validated_version;
	}
	
	public void setValidatedVersion(String validated_version) {
		this.validated_version = validated_version;
	}
	
	public String getValidationDate() {
		return validation_date;
	}
	
	public void setValidatioDate(String validation_date) {
		this.validation_date = validation_date;
	}
	
	public String getClosureDate() {
		return closure_date;
	}
	
	public void setClosureDate(String closure_date) {
		this.closure_date = closure_date;
	}
		
}

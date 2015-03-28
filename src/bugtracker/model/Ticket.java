package bugtracker.model;

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
	
	public String getSubmission_version() {
		return submission_version;
	}
	
	public void setSubmission_version(String submission_version) {
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
	
	public String getScheduled_version() {
		return scheduled_version;
	}
	
	public void setScheduled_version(String scheduled_version) {
		this.scheduled_version = scheduled_version;
	}
	
	public int getSubmitter_user_id() {
		return submitter_user_id;
	}
	
	public void setSubmitter_user_id(int submitter_user_id) {
		this.submitter_user_id = submitter_user_id;
	}
	
	public String getSubmission_date() {
		return submission_date;
	}
	
	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}
	
	public String getDetection_phase() {
		return detection_phase;
	}
	
	public void setDetection_phase(String detection_phase) {
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
	
	public int getEstimated_wl() {
		return estimated_wl;
	}
	
	public void setEstimated_wl(int estimated_wl) {
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
	
	public String getLinked_ticket() {
		return linked_ticket;
	}
	
	public void setLinked_ticket(String linked_ticket) {
		this.linked_ticket = linked_ticket;
	}
	
	public String getLinked_headline() {
		return linked_headline;
	}
	
	public void setLinked_headline(String linked_headline) {
		this.linked_headline = linked_headline;
	}
	
	public int getAnalyser_id() {
		return analyser_id;
	}
	
	public void setAnalyser_id(int analyser_id) {
		this.analyser_id = analyser_id;
	}
	
	public String getProposed_change() {
		return proposed_change;
	}
	
	public void setProposed_change(String proposed_change) {
		this.proposed_change = proposed_change;
	}
	
	public String getImpacted_version() {
		return impacted_version;
	}
	
	public void setImpacted_version(String impacted_version) {
		this.impacted_version = impacted_version;
	}
	
	public String getAnalysis_date() {
		return analysis_date;
	}
	
	public void setAnalysis_date(String analysis_date) {
		this.analysis_date = analysis_date;
	}
	
	public int getRealiser_id() {
		return realiser_id;
	}
	
	public void setRealiser_id(int realiser_id) {
		this.realiser_id = realiser_id;
	}
	
	public String getRealised_items() {
		return realised_items;
	}
	
	public void setRealised_items(String realised_items) {
		this.realised_items = realised_items;
	}
	
	public String getRealised_version() {
		return realised_version;
	}
	
	public void setRealised_version(String realised_version) {
		this.realised_version = realised_version;
	}
	
	public String getRealisation_date() {
		return realisation_date;
	}
	
	public void setRealisation_date(String realisation_date) {
		this.realisation_date = realisation_date;
	}
	
	public int getValidator_id() {
		return validator_id;
	}
	
	public void setValidator_id(int validator_id) {
		this.validator_id = validator_id;
	}
	
	public String getValidator_comments() {
		return validator_comments;
	}
	
	public void setValidator_comments(String validator_comments) {
		this.validator_comments = validator_comments;
	}
	
	public String getValidated_version() {
		return validated_version;
	}
	
	public void setValidated_version(String validated_version) {
		this.validated_version = validated_version;
	}
	
	public String getValidation_date() {
		return validation_date;
	}
	
	public void setValidation_date(String validation_date) {
		this.validation_date = validation_date;
	}
	
	public String getClosure_date() {
		return closure_date;
	}
	
	public void setClosure_date(String closure_date) {
		this.closure_date = closure_date;
	}
		
}

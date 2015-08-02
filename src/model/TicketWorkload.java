/**
 * 
 */
package model;

/**
 * @author dumber
 *
 */
public class TicketWorkload {
	private int ticket_workload_id;
	private int tw_ticket_id;
	private int estimated_analysis;
	private int estimated_realisation;
	private int estimated_validation;
	private int estimated_sum;
	private int analysis_workload;
	private int realisation_workload;
	private int validation_workload;
	private int workload_sum;
	
	/**
	 * @param ticket_workload_id
	 * @param tw_ticket_id
	 * @param estimated_analysis
	 * @param estimated_realisation
	 * @param estimated_validation
	 * @param estimated_sum
	 * @param analysis_workload
	 * @param realisation_workload
	 * @param validation_workload
	 * @param workload_sum
	 */
	public TicketWorkload(int ticket_workload_id, int tw_ticket_id,
			int estimated_analysis, int estimated_realisation,
			int estimated_validation, int estimated_sum, int analysis_workload,
			int realisation_workload, int validation_workload, int workload_sum) {
		this.ticket_workload_id = ticket_workload_id;
		this.tw_ticket_id = tw_ticket_id;
		this.estimated_analysis = estimated_analysis;
		this.estimated_realisation = estimated_realisation;
		this.estimated_validation = estimated_validation;
		this.estimated_sum = estimated_sum;
		this.analysis_workload = analysis_workload;
		this.realisation_workload = realisation_workload;
		this.validation_workload = validation_workload;
		this.workload_sum = workload_sum;
	}
	
	/**
	 * @return the ticket_workload_id
	 */
	public int getTicketWorkload_id() {
		return ticket_workload_id;
	}
	
	/**
	 * @param ticket_workload_id the ticket_workload_id to set
	 */
	public void setTicketWorkload_id(int ticket_workload_id) {
		this.ticket_workload_id = ticket_workload_id;
	}
	
	/**
	 * @return the tw_ticket_id
	 */
	public int getTwTicket_id() {
		return tw_ticket_id;
	}
	
	/**
	 * @param tw_ticket_id the tw_ticket_id to set
	 */
	public void setTwTicket_id(int tw_ticket_id) {
		this.tw_ticket_id = tw_ticket_id;
	}
	
	/**
	 * @return the estimated_analysis
	 */
	public int getEstimatedAnalysis() {
		return estimated_analysis;
	}
	
	/**
	 * @param estimated_analysis the estimated_analysis to set
	 */
	public void setEstimatedAnalysis(int estimated_analysis) {
		this.estimated_analysis = estimated_analysis;
	}
	
	/**
	 * @return the estimated_realisation
	 */
	public int getEstimatedRealisation() {
		return estimated_realisation;
	}
	
	/**
	 * @param estimated_realisation the estimated_realisation to set
	 */
	public void setEstimatedRealisation(int estimated_realisation) {
		this.estimated_realisation = estimated_realisation;
	}
	
	/**
	 * @return the estimated_validation
	 */
	public int getEstimatedValidation() {
		return estimated_validation;
	}
	
	/**
	 * @param estimated_validation the estimated_validation to set
	 */
	public void setEstimatedValidation(int estimated_validation) {
		this.estimated_validation = estimated_validation;
	}
	
	/**
	 * @return the estimated_sum
	 */
	public int getEstimatedSum() {
		return estimated_sum;
	}
	
	/**
	 * @param estimated_sum the estimated_sum to set
	 */	
	public void setEstimatedSum(int estimated_sum) {
		this.estimated_sum = estimated_sum;
	}
	
	/**
	 * @return the analysis_workload
	 */
	public int getAnalysisWorkload() {
		return analysis_workload;
	}
	
	/**
	 * @param analysis_workload the analysis_workload to set
	 */
	public void setAnalysisWorkload(int analysis_workload) {
		this.analysis_workload = analysis_workload;
	}
	
	/**
	 * @return the realisation_workload
	 */
	public int getRealisationWorkload() {
		return realisation_workload;
	}
	
	/**
	 * @param realisation_workload the realisation_workload to set
	 */
	public void setRealisationWorkload(int realisation_workload) {
		this.realisation_workload = realisation_workload;
	}
	
	/**
	 * @return the validation_workload
	 */
	public int getValidationWorkload() {
		return validation_workload;
	}
	
	/**
	 * @param validation_workload the validation_workload to set
	 */
	public void setValidationWorkload(int validation_workload) {
		this.validation_workload = validation_workload;
	}
	
	/**
	 * @return the workload_sum
	 */
	public int getWorkloadSum() {
		return workload_sum;
	}
	
	/**
	 * @param workload_sum the workload_sum to set
	 */
	public void setWorkloadSum(int workload_sum) {
		this.workload_sum = workload_sum;
	}
	
}

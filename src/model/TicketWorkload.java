/**
 * 
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author dumber
 *
 */
public class TicketWorkload extends GenericTableElement {
	private IntegerProperty tw_ticket_id;
	private IntegerProperty estimated_analysis;
	private IntegerProperty estimated_realisation;
	private IntegerProperty estimated_validation;
	private IntegerProperty estimated_sum;
	private IntegerProperty analysis_workload;
	private IntegerProperty realisation_workload;
	private IntegerProperty validation_workload;
	private IntegerProperty workload_sum;
	
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
		super(ticket_workload_id);
		this.tw_ticket_id = new SimpleIntegerProperty(tw_ticket_id);
		this.estimated_analysis = new SimpleIntegerProperty(estimated_analysis);
		this.estimated_realisation = new SimpleIntegerProperty(estimated_realisation);
		this.estimated_validation = new SimpleIntegerProperty(estimated_validation);
		this.estimated_sum = new SimpleIntegerProperty(estimated_sum);
		this.analysis_workload = new SimpleIntegerProperty(analysis_workload);
		this.realisation_workload = new SimpleIntegerProperty(realisation_workload);
		this.validation_workload = new SimpleIntegerProperty(validation_workload);
		this.workload_sum = new SimpleIntegerProperty(workload_sum);
	}

	/**
	 * @param tw
	 */
	public TicketWorkload(TicketWorkload tw) {
		super(tw.getId());
		this.tw_ticket_id = tw.tw_ticket_id;
		this.estimated_analysis = tw.estimated_analysis;
		this.estimated_realisation = tw.estimated_realisation;
		this.estimated_validation = tw.estimated_validation;
		this.estimated_sum = tw.estimated_sum;
		this.analysis_workload = tw.analysis_workload;
		this.realisation_workload = tw.realisation_workload;
		this.validation_workload = tw.validation_workload;
		this.workload_sum = tw.workload_sum;
	}
	
	/**
	 * @return the tw_ticket_id
	 */
	public int getTwTicket_id() {
		return tw_ticket_id.get();
	}
	
	/**
	 * @param tw_ticket_id the tw_ticket_id to set
	 */
	public void setTwTicket_id(int tw_ticket_id) {
		this.tw_ticket_id.set(tw_ticket_id);
	}
	
	/**
	 * @return the tw_ticket_id
	 */
	public IntegerProperty twTicketIdProperty() {
		return tw_ticket_id;
	}
	
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return tw_ticket_id.get()	+ ", " + estimated_analysis.get() + ", " + estimated_realisation.get() + ", " + estimated_validation.get()
				+ ", " + estimated_sum.get() + ", " + analysis_workload.get() + ", " + realisation_workload.get() + ", "
				+ validation_workload.get() + ", " + workload_sum.get();
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		return "`tw_ticket_id`=" + tw_ticket_id.get()	+ ", `est_analysis`=" + estimated_analysis.get()
				+ ", `est_realisation`=" + estimated_realisation.get() + ", `est_validation`=" 
				+ estimated_validation.get() + ", `est_sum`=" + estimated_sum.get() + ", `analysis_wl`="
				+ analysis_workload.get() + ", `realisation_wl`=" + realisation_workload.get() + ", `validation_wl`="
				+ validation_workload.get() + ", `workload_sum`=" + workload_sum.get();
	}
	
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketWorkload [id=" + id.get() + ", tw_ticket_id=" + tw_ticket_id.get()
				+ ", estimated_analysis=" + estimated_analysis.get()
				+ ", estimated_realisation=" + estimated_realisation.get()
				+ ", estimated_validation=" + estimated_validation.get()
				+ ", estimated_sum=" + estimated_sum.get() + ", analysis_workload="
				+ analysis_workload.get() + ", realisation_workload="
				+ realisation_workload.get() + ", validation_workload="
				+ validation_workload.get() + ", workload_sum=" + workload_sum.get() + "]";
	}
	
}

/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author dumber
 *
 */
public class TicketAnalysis {
	private int ticket_analysis_id;
	private int ta_ticket_id;
	private String proposed_change;
	private int impacted_version_id;
	private Timestamp analysis_date; // yyyy-mm-dd hh:mm:ss.fffffffff
	private int analyser_user_id;
	
	/**
	 * @param ticket_analysis_id
	 * @param ta_ticket_id
	 * @param proposed_change
	 * @param impacted_version_id
	 * @param analysis_date
	 * @param analyser_user_id
	 */
	public TicketAnalysis(int ticket_analysis_id, int ta_ticket_id,
			String proposed_change, int impacted_version_id,
			Timestamp analysis_date, int analyser_user_id) {
		this.ticket_analysis_id = ticket_analysis_id;
		this.ta_ticket_id = ta_ticket_id;
		this.proposed_change = proposed_change;
		this.impacted_version_id = impacted_version_id;
		this.analysis_date = analysis_date;
		this.analyser_user_id = analyser_user_id;
	}

	/**
	 * @return the ticket_analysis_id
	 */
	public int getTicketAnalysis_id() {
		return ticket_analysis_id;
	}

	/**
	 * @param ticket_analysis_id the ticket_analysis_id to set
	 */
	public void setTicketAnalysis_id(int ticket_analysis_id) {
		this.ticket_analysis_id = ticket_analysis_id;
	}

	/**
	 * @return the ta_ticket_id
	 */
	public int getTaTicket_id() {
		return ta_ticket_id;
	}

	/**
	 * @param ta_ticket_id the ta_ticket_id to set
	 */
	public void setTaTicket_id(int ta_ticket_id) {
		this.ta_ticket_id = ta_ticket_id;
	}

	/**
	 * @return the proposed_change
	 */
	public String getProposedChange() {
		return proposed_change;
	}

	/**
	 * @param proposed_change the proposed_change to set
	 */
	public void setProposedChange(String proposed_change) {
		this.proposed_change = proposed_change;
	}

	/**
	 * @return the impacted_version_id
	 */
	public int getImpactedVersion_id() {
		return impacted_version_id;
	}

	/**
	 * @param impacted_version_id the impacted_version_id to set
	 */
	public void setImpactedVersion_id(int impacted_version_id) {
		this.impacted_version_id = impacted_version_id;
	}

	/**
	 * @return the analysis_date
	 */
	public Timestamp getAnalysisDate() {
		return analysis_date;
	}

	/**
	 * @param analysis_date the analysis_date to set
	 */
	public void setAnalysisDate(Timestamp analysis_date) {
		this.analysis_date = analysis_date;
	}

	/**
	 * @return the analyser_user_id
	 */
	public int getAnalyserUser_id() {
		return analyser_user_id;
	}

	/**
	 * @param analyser_user_id the analyser_user_id to set
	 */
	public void setAnalyserUser_id(int analyser_user_id) {
		this.analyser_user_id = analyser_user_id;
	}
	
}
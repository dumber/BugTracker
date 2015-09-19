/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author dumber
 *
 */
public class TicketAnalysis extends GenericTableElement {
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
		super(ticket_analysis_id);
		this.ta_ticket_id = ta_ticket_id;
		this.proposed_change = proposed_change;
		this.impacted_version_id = impacted_version_id;
		this.analysis_date = analysis_date;
		this.analyser_user_id = analyser_user_id;
	}

	/**
	 * @param ta
	 */
	public TicketAnalysis(TicketAnalysis ta) {
		super(ta.id);
		this.ta_ticket_id = ta.ta_ticket_id;
		this.proposed_change = ta.proposed_change;
		this.impacted_version_id = ta.impacted_version_id;
		this.analysis_date = ta.analysis_date;
		this.analyser_user_id = ta.analyser_user_id;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  ta_ticket_id + ", \'" + proposed_change	+ "\', " + impacted_version_id
				+ ", \'" + analysis_date + "\', " + analyser_user_id;
	}
	
	public String debug() {
		return "TicketAnalysis [id=" + id + "ta_ticket_id=" + ta_ticket_id
				+ ", proposed_change=" + proposed_change
				+ ", impacted_version_id=" + impacted_version_id
				+ ", analysis_date=" + analysis_date + ", analyser_user_id="
				+ analyser_user_id + "]";
	}
	
}

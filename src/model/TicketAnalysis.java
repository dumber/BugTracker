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
public class TicketAnalysis extends GenericTableElement {
	private IntegerProperty ta_ticket_id;
	private StringProperty proposed_change;
	private IntegerProperty impacted_version_id;
	private ObjectProperty<Timestamp> analysis_date; // yyyy-mm-dd hh:mm:ss.fffffffff
	private IntegerProperty analyser_user_id;
	
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
		this.ta_ticket_id = new SimpleIntegerProperty(ta_ticket_id);
		this.proposed_change = new SimpleStringProperty(proposed_change);
		this.impacted_version_id = new SimpleIntegerProperty(impacted_version_id);
		this.analysis_date = new SimpleObjectProperty<Timestamp>(analysis_date);
		this.analyser_user_id = new SimpleIntegerProperty(analyser_user_id);
	}

	/**
	 * @param ta
	 */
	public TicketAnalysis(TicketAnalysis ta) {
		super(ta.getId());
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
		return ta_ticket_id.get();
	}

	/**
	 * @param ta_ticket_id the ta_ticket_id to set
	 */
	public void setTaTicket_id(int ta_ticket_id) {
		this.ta_ticket_id.set(ta_ticket_id);
	}

	
	/**
	 * @return the ta_ticket_id
	 */
	public IntegerProperty taTicketIdProperty() {
		return ta_ticket_id;
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
	 * @return the impacted_version_id
	 */
	public int getImpactedVersion_id() {
		return impacted_version_id.get();
	}

	/**
	 * @param impacted_version_id the impacted_version_id to set
	 */
	public void setImpactedVersion_id(int impacted_version_id) {
		this.impacted_version_id.set(impacted_version_id);
	}
	
	/**
	 * @return the imapcted_version_id
	 */
	public IntegerProperty impactedVersionIdProperty() {
		return impacted_version_id;
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
	 * @return the analyser_user_id
	 */
	public int getAnalyserUser_id() {
		return analyser_user_id.get();
	}

	/**
	 * @param analyser_user_id the analyser_user_id to set
	 */
	public void setAnalyserUser_id(int analyser_user_id) {
		this.analyser_user_id.set(analyser_user_id);
	}
	
	/**
	 * @return the analyser_user_id
	 */
	public IntegerProperty analyserUserIdProperty() {
		return analyser_user_id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (analysis_date != null) {
			return  ta_ticket_id.get() + ", \'" + proposed_change.get()	+ "\', " + impacted_version_id.get()
				+ ", \'" + analysis_date.get() + "\', " + analyser_user_id.get();
		} else {
			return  ta_ticket_id.get() + ", \'" + proposed_change.get()	+ "\', " + impacted_version_id.get()
					+ ", NULL , " + analyser_user_id.get();
		}
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		if (analysis_date != null) {
			return "`ta_ticket_id`=" + ta_ticket_id.get()	+ ", `proposed_change`=\'" + proposed_change.get()
					+ "\', `impacted_ver_id`=" + impacted_version_id.get() + ", `analysis_date`=\'" 
					+ analysis_date.get() + "\', `analyser_user_id`="	+ analyser_user_id.get();
		} else {
			return "`ta_ticket_id`=" + ta_ticket_id.get()	+ ", `proposed_change`=\'" + proposed_change.get()
					+ "\', `impacted_ver_id`=" + impacted_version_id.get() + ", `analysis_date`= NULL" 
					+ ", `analyser_user_id`="	+ analyser_user_id.get();
		}
	}
	
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketAnalysis [id=" + id + ", ta_ticket_id=" + ta_ticket_id.get()
				+ ", proposed_change=" + proposed_change.get()
				+ ", impacted_version_id=" + impacted_version_id.get()
				+ ", analysis_date=" + analysis_date.get() + ", analyser_user_id="
				+ analyser_user_id.get() + "]";
	}
	
}

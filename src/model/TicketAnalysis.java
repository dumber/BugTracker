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
	private StringProperty impacted_version;
	private ObjectProperty<Timestamp> analysis_date; // yyyy-mm-dd hh:mm:ss.fffffffff
	private StringProperty analyst_user;
	
	private IntegerProperty project_id;
	
	/**
	 * @param ticket_analysis_id
	 * @param ta_ticket_id
	 * @param proposed_change
	 * @param impacted_version
	 * @param analysis_date
	 * @param analyst_user
	 */
	public TicketAnalysis(int ticket_analysis_id, int ta_ticket_id,
			String proposed_change, String impacted_version,
			Timestamp analysis_date, String analyser_user, int project_id) {
		super(ticket_analysis_id);
		this.ta_ticket_id = new SimpleIntegerProperty(ta_ticket_id);
		this.proposed_change = new SimpleStringProperty(proposed_change);
		this.impacted_version = new SimpleStringProperty(impacted_version);
		this.analysis_date = new SimpleObjectProperty<Timestamp>(analysis_date);
		this.analyst_user = new SimpleStringProperty(analyser_user);
		
		this.project_id = new SimpleIntegerProperty(project_id);
	}

	/**
	 * @param ta
	 */
	public TicketAnalysis(TicketAnalysis ta) {
		super(ta.getId());
		this.ta_ticket_id = ta.ta_ticket_id;
		this.proposed_change = ta.proposed_change;
		this.impacted_version = ta.impacted_version;
		this.analysis_date = ta.analysis_date;
		this.analyst_user = ta.analyst_user;
		
		this.project_id = ta.project_id;
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
	public String getAnalyst() {
		return analyst_user.get();
	}

	/**
	 * @param analyst the analyst to set
	 */
	public void setAnalyst(String analyst) {
		this.analyst_user.set(analyst);
	}

	/**
	 * @return the analyst
	 */
	public StringProperty analystProperty() {
		return analyst_user;
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
		if (analysis_date.get() != null) {
			return  ta_ticket_id.get() + ", \'" + proposed_change.get()	+ "\', " + impacted_version.get()
				+ ", \'" + analysis_date.get() + "\', \'" + analyst_user.get() + "\', " + project_id.get() + "\'";
		} else {
			return  ta_ticket_id.get() + ", \'" + proposed_change.get()	+ "\', " + impacted_version.get()
					+ ", NULL ,\' " + analyst_user.get() + "\', " + project_id.get();
		}
	}
	
	/**
	 * @return 
	 */
	public String toInsertString() {
		if (analysis_date.get() != null) {
			return  ta_ticket_id.get() + ", \'" + proposed_change.get()	+ "\', "
					+ "(select `id` from `project_versions` where "
					+ "`project_versions`.`version` = \'" + impacted_version.get()
					+ "\' and `project_versions`.`project_id` = " + project_id.get()
					+ "), \'" + analysis_date.get() + "\', (select `id` from "
					+ "`users` where `users`.`username` = \'" + analyst_user.get()
					+ "\'), " + project_id.get();
		} else {
			return  ta_ticket_id.get() + ", \'" + proposed_change.get()	+ "\', "
					+ "(select `id` from `project_versions` where "
					+ "`project_versions`.`version` = \'"  + impacted_version.get() 
					+ "\' and `project_versions`.`project_id` = " + project_id.get()
					+ "), NULL , ( select `id` from `users` where "
					+ "`users`.`username` = \'" + analyst_user.get() 
					+ "\'), " + project_id.get();
		}
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {
		if (analysis_date.get() != null) {
			return "`ta_ticket_id`=" + ta_ticket_id.get()	+ ", `proposed_change`=\'" + proposed_change.get()
					+ "\', `impacted_ver_id`=(select `id` from `project_versions` where "
					+ "`project_versions`.`version` = \'" + impacted_version.get() 
					+ "\' and `project_versions`.`project_id` = " + project_id.get() 
					+ "), `analysis_date`=\'" + analysis_date.get() 
					+ "\', `analyser_user_id`= ( select `id` from `users` where "
					+ "`users`.`username` = \'" + analyst_user.get() 
					+ "\'), `project_id`=" + project_id.get();
		} else {
			return "`ta_ticket_id`=" + ta_ticket_id.get()	+ ", `proposed_change`=\'" + proposed_change.get()
					+ "\', `impacted_ver_id`=(select `id` from `project_versions` where "
					+ "`project_versions`.`version` = \'" + impacted_version.get() 
					+ "\' and `project_versions`.`project_id` = " + project_id.get() 
					+ "), `analysis_date`= NULL, `analyser_user_id`= ( select `id` from `users`"
					+ " where `users`.`username` = \'" + analyst_user.get() 
					+ "\'), `project_id`=" + project_id.get();
		}
	}
	
	/**
	 * @return 
	 */
	public String debug() {
		return "TicketAnalysis [id=" + id + ", ta_ticket_id=" + ta_ticket_id.get()
				+ ", proposed_change=" + proposed_change.get()
				+ ", impacted_version=" + impacted_version.get()
				+ ", analysis_date=" + analysis_date.get() + ", analyst="
				+ analyst_user.get() + ", project_id=" + project_id.get() + "]";
	} 
	
}

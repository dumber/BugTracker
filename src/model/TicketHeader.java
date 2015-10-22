package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class TicketHeader extends GenericTableElement {
	private StringProperty unique_ticket_name;
	private StringProperty project_name;
	private StringProperty headline;
	private StringProperty description;
	private StringProperty severity;
	private StringProperty priority;
	private StringProperty status;
	
	/**
	 * @param t_id				the ticket id
	 * @param u_t_id			the unique ticket id
	 * @param t_project_id		the project id of the ticket
	 * @param headline			the headline of the ticket
	 * @param description		the description of the ticket
	 * @param severity		the severity of the ticket
	 * @param priority		the priority of the ticket
	 * @param status		the status of the ticket
	 */
	public TicketHeader(int t_id, String u_t_id, String project,
			String headline, String description, String severity,
			String priority, String status) {
		super(t_id);
		this.unique_ticket_name = new SimpleStringProperty(u_t_id);
		this.project_name = new SimpleStringProperty(project);
		this.headline = new SimpleStringProperty(headline);
		this.description = new SimpleStringProperty(description);
		this.severity = new SimpleStringProperty(severity);
		this.priority = new SimpleStringProperty(priority);
		this.status = new SimpleStringProperty(status);
	}
	
	/**
	 * @param t					the ticket to copy
	 */	
	public TicketHeader(TicketHeader t) {
		super(t.getId());
		this.unique_ticket_name = t.unique_ticket_name;
		this.project_name = t.project_name;
		this.headline = t.headline;
		this.description = t.description;
		this.severity = t.severity;
		this.priority = t.priority;
		this.status = t.status;
	}

	/**
	 * @return the unique_ticket_name
	 */
	public String getUniqueTicke_id() {
		return unique_ticket_name.get();
	}

	/**
	 * @param u_t_id the ticket_name to set
	 */
	public void setUniqueTicket_id(String u_t_id) {
		this.unique_ticket_name.set(u_t_id);
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
	
//	/**
//	 * @param u_t_id
//	 * @param t_project_id
//	 * @param headline
//	 * @param description
//	 * @param severity
//	 * @param priority
//	 * @param t_state_id
//	 * @param linked_ticket_id
//	 */
//	public void modifyTicketHeader(String u_t_id, int p_id, String hl, 
//			String desc, int s_id, int pri_id, int st_id, int lt_id) {
//		this.unique_ticket_name.set(u_t_id);
//		this.project_name.set(p_id);
//		this.headline.set(hl);
//		this.description.set(desc);
//		this.severity.set(s_id);
//		this.priority.set(pri_id);
//		this.status.set(st_id);
//	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  "\'" + unique_ticket_name.get() + "\', " + project_name.get() + ", \'" + headline.get() + "\', \'" + description.get() + "\', "
				+ severity.get() + ", " + priority.get() + ", " + status.get();
	}
	
	/** 
	 * @return
	 */
	public String toInsertString() {
		return  "\'" + unique_ticket_name.get() + "\', (select `id` from `projects` "
				+ "where `projects`.`project_name`=\'" + project_name.get() + "\'), \'" 
				+ headline.get() + "\', \'" + description.get() + "\', "
				+ "(select `id` from `severities` where `severities`.`severity`=\'" 
				+ severity.get() + "\'), (select `id` from `priorities` where "
				+ "`priorities`.`priority`=\'" + priority.get() + "\'), "
				+ "(select `id` from `statuses` where `statuses`.`status`=\'" + status.get() + "\')";
	}
	
	/**
	 * @return 
	 */
	public String toUpdateString() {	
		return "`unique_ticket_name`=\'" + unique_ticket_name.get() + "\', "
				+ "`project_id`=(select `id` from `projects` where "
				+ "`projects`.`project_name`=\'" + project_name.get() 
				+ "\'), `headline`=\'" + headline.get() + "\', "
				+ "`description`=\'" + description.get() + "\', "
				+ "`severity_id`=(select `id` from `severities` where "
				+ "`severities`.`severity`=\'"
				+ severity.get() + "\'), `priority_id`=(select `id` from "
				+ "`priorities` where `priorities`.`priority`=\'" 
				+ priority.get() + "\'), `status_id`=(select `id` from "
				+ "`statuses` where `statuses`.`status`=\'" + status.get() + "\')";
	}
	
	/**
	 * @return 
	 */
	public String debug() {	
		return "TicketHeader [id=" + id.get() + ", unique_ticket_name=" + unique_ticket_name.get()
				+ ", t_project_id=" + project_name.get() + ", headline=" + headline.get()
				+ ", description=" + description.get() + ", severity="
				+ severity.get() + ", priority=" + priority.get()
				+ ", status=" + status.get() + "]";
	}
	
}

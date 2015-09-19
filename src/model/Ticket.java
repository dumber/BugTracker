/**
 * 
 */
package model;

/**
 * @author dumber
 *
 */
public class Ticket {
	private TicketHeader header;
	private TicketSubmission ticket_submission;
	private TicketAnalysis ticket_analysis;
	private TicketRealisation ticket_realisation;
	private TicketValidation ticket_validation;
	private TicketWorkload ticket_workload;
	private TicketHistory ticket_history;
	/**
	 * 
	 */
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param header
	 * @param ticket_submission
	 * @param ticket_analysis
	 * @param ticket_realisation
	 * @param ticket_validation
	 * @param ticket_workload
	 * @param ticket_history
	 */
	public Ticket(TicketHeader header, TicketSubmission ticket_submission,
			TicketAnalysis ticket_analysis,
			TicketRealisation ticket_realisation,
			TicketValidation ticket_validation, TicketWorkload ticket_workload,
			TicketHistory ticket_history) {
		this.header = header;
		this.ticket_submission = ticket_submission;
		this.ticket_analysis = ticket_analysis;
		this.ticket_realisation = ticket_realisation;
		this.ticket_validation = ticket_validation;
		this.ticket_workload = ticket_workload;
		this.ticket_history = ticket_history;
	}

	/**
	 * @return the header
	 */
	protected TicketHeader getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	protected void setHeader(TicketHeader header) {
		this.header = header;
	}

	/**
	 * @return the ticket_submission
	 */
	protected TicketSubmission getTicketSubmission() {
		return ticket_submission;
	}

	/**
	 * @param ticket_submission the ticket_submission to set
	 */
	protected void setTicketSubmission(TicketSubmission ticket_submission) {
		this.ticket_submission = ticket_submission;
	}

	/**
	 * @return the ticket_analysis
	 */
	protected TicketAnalysis getTicketAnalysis() {
		return ticket_analysis;
	}

	/**
	 * @param ticket_analysis the ticket_analysis to set
	 */
	protected void setTicketAnalysis(TicketAnalysis ticket_analysis) {
		this.ticket_analysis = ticket_analysis;
	}

	/**
	 * @return the ticket_realisation
	 */
	protected TicketRealisation getTicketRealisation() {
		return ticket_realisation;
	}

	/**
	 * @param ticket_realisation the ticket_realisation to set
	 */
	protected void setTicketRealisation(TicketRealisation ticket_realisation) {
		this.ticket_realisation = ticket_realisation;
	}

	/**
	 * @return the ticket_validation
	 */
	protected TicketValidation getTicketValidation() {
		return ticket_validation;
	}

	/**
	 * @param ticket_validation the ticket_validation to set
	 */
	protected void setTicketValidation(TicketValidation ticket_validation) {
		this.ticket_validation = ticket_validation;
	}

	/**
	 * @return the ticket_workload
	 */
	protected TicketWorkload getTicketWorkload() {
		return ticket_workload;
	}

	/**
	 * @param ticket_workload the ticket_workload to set
	 */
	protected void setTicketWorkload(TicketWorkload ticket_workload) {
		this.ticket_workload = ticket_workload;
	}

	/**
	 * @return the ticket_history
	 */
	protected TicketHistory getTicketHistory() {
		return ticket_history;
	}

	/**
	 * @param ticket_history the ticket_history to set
	 */
	protected void setTicketHistory(TicketHistory ticket_history) {
		this.ticket_history = ticket_history;
	}
	
}

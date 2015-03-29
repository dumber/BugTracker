/**
 * 
 */
package view;

import model.Ticket;

/**
 * @author dumber
 *
 */
public class TicketView {
	public void printTicketDetails(Ticket t) {
		System.out.println("id: " + t.getT_id());
		System.out.println("ticket id: " + t.getTicket_id());
		System.out.println("project id: " + t.getProject_id());
		System.out.println("submission version: " + t.getSubmissionVersion());
		System.out.println("headline: " + t.getHeadline());
		System.out.println("description: " + t.getDescription());
		System.out.println("sheduled version: " + t.getScheduledVersion());
		System.out.println("submitter user id: " + t.getSubmissionDate());
		System.out.println("detection phase: " + t.getDetectionPhase());
		System.out.println("severity: " + t.getSeverity());
		System.out.println("priority: " + t.getPriority());
		System.out.println("estimated workload: " + t.getEstimatedWorkload());
		System.out.println("workload: " + t.getWorkload());
		System.out.println("state: " + t.getState());
		System.out.println("linked ticket: " + t.getLinkedTicket());
		System.out.println("linked_headline: " + t.getLinkedHeadline());
		System.out.println("analyser user id: " + t.getAnalyser_id());
	}
}

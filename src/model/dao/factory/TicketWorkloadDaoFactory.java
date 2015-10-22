/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TicketWorkload;
import model.dao.TicketWorkloadDao;

/**
 * @author dumber
 *
 */
public class TicketWorkloadDaoFactory extends GenericDaoFactory implements
		TicketWorkloadDao {

	/**
	 * 
	 */
	public TicketWorkloadDaoFactory() {
		super("`ticket_workloads`");
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketWorkloadDao#getAllTableElements()
	 */
	@Override
	public List<TicketWorkload> getAllTableElements() throws SQLException {
		List<TicketWorkload> ticket_workloads = new ArrayList<TicketWorkload>();
		dataSource.setSelectQueryString("`ticket_workloads`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketWorkload tw = new TicketWorkload(rs.getInt("id"), rs.getInt("tw_ticket_id"), rs.getInt("est_analysis"), 
					rs.getInt("est_realisation"), rs.getInt("est_validation"), rs.getInt("est_sum"), rs.getInt("analysis_wl"),
					rs.getInt("realisation_wl"), rs.getInt("validation_wl"), rs.getInt("workload_sum"));
			ticket_workloads.add(tw);
		}
		rs.close();
		return ticket_workloads;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketWorkloadDao#findElementById(int)
	 */
	@Override
	public TicketWorkload findElementById(int id) throws SQLException {
		TicketWorkload tw = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`ticket_workloads` WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			tw = new TicketWorkload(rs.getInt("id"), rs.getInt("tw_ticket_id"), rs.getInt("est_analysis"), 
					rs.getInt("est_realisation"), rs.getInt("est_validation"), rs.getInt("est_sum"), rs.getInt("analysis_wl"),
					rs.getInt("realisation_wl"), rs.getInt("validation_wl"), rs.getInt("workload_sum"));
		}
		rs.close();
		return tw;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TicketWorkloadDao#addElementToTable(model.TicketWorkload)
	 */
	@Override
	public void addElementToTable(TicketWorkload ticket_wl) throws SQLException {
		if (ticket_wl != null) {
			dataSource.setInsertQueryString("`ticket_workloads` (`tw_ticket_id`, `est_analysis`, `est_realisation`,"
					+ "`est_validation`, `est_sum`, `analysis_wl`, `realisation_wl`, `validation_wl`, `workload_sum`) VALUES (" 
					+ ticket_wl.toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_workload into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketWorkloadDao#updateElementInTalbe(int, model.TicketWorkload)
	 */
	@Override
	public void updateElementInTalbe(int id, TicketWorkload ticket_wl) throws SQLException {
		if (ticket_wl != null) {
			dataSource.setUpdateQueryString("`ticket_workloads` SET " + ticket_wl.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_workload \n");
		}
	}

}

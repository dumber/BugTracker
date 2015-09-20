/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.TicketWorkload;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class TicketWorkloadDaoFactory extends GenericDaoFactory implements
		GenericDaoIFC {

	/**
	 * 
	 */
	public TicketWorkloadDaoFactory() {
		super();
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<TicketWorkload> ticket_workloads = new ArrayList<TicketWorkload>();
		dataSource.setSelectQueryString("`ticket_workloads`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketWorkload tw = new TicketWorkload(rs.getInt("tw_id"), rs.getInt("tw_ticket_id"), rs.getInt("est_analysis"), 
					rs.getInt("est_realisation"), rs.getInt("est_validation"), rs.getInt("est_sum"), rs.getInt("analysis_wl"),
					rs.getInt("realisation_wl"), rs.getInt("validation_wl"), rs.getInt("workload_sum"));
			ticket_workloads.add(tw);
		}
		rs.close();
		return ticket_workloads;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int tw_id, Class<T> type) throws SQLException {
		TicketWorkload tw = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`ticket_workloads` WHERE tw_id = ?" );
		dataSource.executeSelectByIdQuery(tw_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			tw = new TicketWorkload(rs.getInt("tw_id"), rs.getInt("tw_ticket_id"), rs.getInt("est_analysis"), 
					rs.getInt("est_realisation"), rs.getInt("est_validation"), rs.getInt("est_sum"), rs.getInt("analysis_wl"),
					rs.getInt("realisation_wl"), rs.getInt("validation_wl"), rs.getInt("workload_sum"));
		}
		rs.close();
		return type.cast(tw);
	}

	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public TicketWorkload findTicketWorkloadById(int id) throws SQLException {
		return findElementById(id, TicketWorkload.class);
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T ticket_wl) throws SQLException {
		if (((TicketWorkload)ticket_wl) != null) {
			dataSource.setInsertQueryString("`ticket_workloads` (`tw_id`,`tw_ticket_id`, `est_analysis`, `est_realisation`,"
					+ "`est_validation`, `est_sum`, `analysis_wl`, `realisation_wl`, `validation_wl`, `workload_sum`) VALUES (" 
					+ ((TicketWorkload)ticket_wl).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_workload into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int tw_id, T ticket_wl) throws SQLException {
		if (((TicketWorkload)ticket_wl) != null) {
			dataSource.setUpdateQueryString("`ticket_workloads` SET " + ((TicketWorkload)ticket_wl).toUpdateString() 
					+ " WHERE tw_id = " + tw_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_workload \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int tw_id) throws SQLException {
		dataSource.setDeleteQueryString("`ticket_workloads` WHERE tw_id = " + tw_id + ";");
		dataSource.executeDeleteQuery();
	}

}

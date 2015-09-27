/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.TicketAnalysis;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class TicketAnalysisDaoFactory extends GenericDaoFactory implements GenericDaoIFC {

	/**
	 * 
	 */
	public TicketAnalysisDaoFactory() {
		super("`ticket_analyses`");
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<TicketAnalysis> analyses = new ArrayList<TicketAnalysis>();
		dataSource.setSelectQueryString("`ticket_analyses`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketAnalysis ta = new TicketAnalysis(rs.getInt("id"), rs.getInt("ta_ticket_id"),
						rs.getString("proposed_change"), rs.getInt("impacted_ver_id"),
						rs.getTimestamp("analysis_date"), rs.getInt("analyser_user_id"));
			analyses.add(ta);
		}
		rs.close();
		return analyses;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int id, Class<T> type) throws SQLException {
		TicketAnalysis ta = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.ticket_analyses WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			ta = new TicketAnalysis(rs.getInt("id"), rs.getInt("ta_ticket_id"), 
					rs.getString("proposed_change"), rs.getInt("impacted_ver_id"), 
					rs.getTimestamp("analysis_date"), rs.getInt("analyser_user_id"));
		}
		rs.close();
		return type.cast(ta);
	}

	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public TicketAnalysis findTicketAnalysisById(int id) throws SQLException {
		return findElementById(id, TicketAnalysis.class);
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T ta) throws SQLException {
		if (((TicketAnalysis)ta) != null) {
			dataSource.setInsertQueryString("`ticket_analyses` (`ta_ticket_id`, `proposed_change`, `impacted_ver_id`,"
					+ " `analysis_date`, `analyser_user_id`) VALUES (" + ((TicketAnalysis)ta).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_analysis into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int id, T ta) throws SQLException {
		if (((TicketAnalysis)ta) != null) {
			dataSource.setUpdateQueryString("`ticket_analyses` SET " + ((TicketAnalysis)ta).toUpdateString() 
					+ " WHERE `id` =" + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_analysis \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int id) throws SQLException {
		dataSource.setDeleteQueryString("`ticket_analyses` WHERE `id` = " + id +";");
		dataSource.executeDeleteQuery();
	}

}

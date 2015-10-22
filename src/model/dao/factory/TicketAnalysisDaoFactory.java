/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TicketAnalysis;
import model.dao.TicketAnalysisDao;

/**
 * @author dumber
 *
 */
public class TicketAnalysisDaoFactory extends GenericDaoFactory implements TicketAnalysisDao {

	/**
	 * 
	 */
	public TicketAnalysisDaoFactory() {
		super("`ticket_analyses`");
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketAnalysisDao#getAllTableElements()
	 */
	@Override
	public List<TicketAnalysis> getAllTableElements() throws SQLException {
		List<TicketAnalysis> analyses = new ArrayList<TicketAnalysis>();
		dataSource.setSelectQueryString("`ticket_analyses_view`;");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketAnalysis ta = new TicketAnalysis(rs.getInt("id"), rs.getInt("ta_ticket_id"), 
					rs.getString("proposed_change"), rs.getString("impacted_version"), 
					rs.getTimestamp("analysis_date"), rs.getString("analyst"),
					rs.getInt("project_id"));
			analyses.add(ta);
		}
		rs.close();
		return analyses;
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketAnalysisDao#findElementById(int)
	 */
	@Override
	public TicketAnalysis findElementById(int id) throws SQLException {
		TicketAnalysis ta = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`ticket_analyses_view` WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			ta = new TicketAnalysis(rs.getInt("id"), rs.getInt("ta_ticket_id"), 
					rs.getString("proposed_change"), rs.getString("impacted_version"), 
					rs.getTimestamp("analysis_date"), rs.getString("analyst"),
					rs.getInt("project_id"));
		}
		rs.close();
		return ta;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TicketAnalysisDao#addElementToTable(model.TicketAnalysis)
	 */
	@Override
	public void addElementToTable(TicketAnalysis ta) throws SQLException {
		if (ta != null) {
			dataSource.setInsertQueryString("`ticket_analyses` (`ta_ticket_id`,"
					+ " `proposed_change`, `impacted_ver_id`, `analysis_date`, "
					+ "`analyser_user_id`, `project_id`) VALUES (" 
					+ ta.toInsertString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt ticket_analysis into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.TicketAnalysisDao#updateElementInTalbe(int, model.TicketAnalysis)
	 */
	@Override
	public  void updateElementInTalbe(int id, TicketAnalysis ta) throws SQLException {
		if (ta != null) {
			dataSource.setUpdateQueryString("`ticket_analyses` SET " + ta.toUpdateString() 
					+ " WHERE `id` =" + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_analysis \n");
		}
	}
	
}

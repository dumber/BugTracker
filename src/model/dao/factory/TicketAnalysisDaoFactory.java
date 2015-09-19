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
		super();
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<TicketAnalysis> ana = new ArrayList<TicketAnalysis>();
		dataSource.setSelectQueryString("`ticket_analyses`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			TicketAnalysis ta = new TicketAnalysis(rs.getInt("ta_id"), rs.getInt("ta_ticket_id"),
						rs.getString("proposed_change"), rs.getInt("impacted_ver_id"),
						rs.getTimestamp("analysis_date"), rs.getInt("analyser_user_id"));
			ana.add(ta);
		}
		rs.close();
		return null;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int ta_id, Class<T> type) throws SQLException {
		TicketAnalysis ta = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.ticket_analyses WHERE ta_id = ?" );
		dataSource.executeSelectByIdQuery(ta_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			ta = new TicketAnalysis(rs.getInt("ta_id"), rs.getInt("ta_ticket_id"), 
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
			dataSource.setInsertQueryString("`ticket_analyses` (`ta_ticket_id`, `proposed_change`, `impacted_version`, `analysis_date`, `analyser_user_id`) VALUES (" 
											+ ((TicketAnalysis)ta).getTaTicket_id() + ", \'" + ((TicketAnalysis)ta).getProposedChange() + "\', " 
											+ ((TicketAnalysis)ta).getImpactedVersion_id() + ", \'" + ((TicketAnalysis)ta).getAnalysisDate() + "\', "
											+ ((TicketAnalysis)ta).getAnalyserUser_id() + ");");
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
			dataSource.setUpdateQueryString("`ticket_analyses` SET `ta_tikcet_id`=" + ((TicketAnalysis)ta).getTaTicket_id() 
											+ ", `proposed_change`=\'" + ((TicketAnalysis)ta).getProposedChange()
											+ "\', `impacted_version`=" + ((TicketAnalysis)ta).getImpactedVersion_id() 
											+ ", `analysis_date`=\'" + ((TicketAnalysis)ta).getAnalysisDate()
											+ "\', `analyser_user_id`=" + ((TicketAnalysis)ta).getAnalyserUser_id());
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt ticket_analysis \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int ta_id) throws SQLException {
		dataSource.setDeleteQueryString("`ticket_analyses` WHERE ta_id = " + ta_id +";");
		dataSource.executeDeleteQuery();
	}

}

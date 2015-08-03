/**
 * 
 */
package model.dao.factory;

import helper.MySqlDataSourceSingleton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Severity;
import model.dao.SeverityDao;

/**
 * @author dumber
 *
 */
public class SeverityDaoFactory implements SeverityDao {
	MySqlDataSourceSingleton db = MySqlDataSourceSingleton.getInstance();
	List<Severity> severities;
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public SeverityDaoFactory() throws SQLException {
		severities = new ArrayList<Severity>();
		db.setSelectQueryString("`severities`");
		db.executeSelectQuery();
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			Severity sev = new Severity(rs.getInt("s_id"),rs.getString("severity"));
			severities.add(sev);
		}
		rs.close();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#getAllSeverities()
	 */
	@Override
	public List<Severity> getAllSeverities() {
		return severities;
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#findSeverity(int)
	 */
	@Override
	public Severity findSeverity(int s_id) {
		return severities.get(s_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#addSeverity(model.Severity)
	 */
	@Override
	public void addSeverity(Severity severity) throws SQLException {
		severities.add(severity);
		db.setInsertQueryString("`severities` (`severity`) VALUES (" + severity.getSeverity() + ");");
		db.executeInsertQuery();
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#updateSeverity(model.Severity)
	 */
	@Override
	public void updateSeverity(int s_id, String severity) throws SQLException {
		findSeverity(s_id).setSeverity(severity);
		db.setUpdateQueryString("`severities` SET `severity` = " + severity + " WHERE `s_id` = " + s_id + ";");
		db.executeUpdateQuery();
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#deleteSeverity(model.Severity)
	 */
	@Override
	public void deleteSeverity(int s_id) throws SQLException {
		severities.remove(s_id);
		db.setDeleteQueryString("`severities` WHERE s_id = " + s_id + ";");
		db.executeDeleteQuery();
	}

}

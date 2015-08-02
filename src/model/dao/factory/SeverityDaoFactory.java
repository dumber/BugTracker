/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.MySqlDataSourceSingleton;
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
		db.setSelect_command("`severities`");
		db.executeSelectCommand();
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
		db.setInsert_command("`severities` (`severity`) VALUES (" + severity.getSeverity() + ");");
		db.executeInsertCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#updateSeverity(model.Severity)
	 */
	@Override
	public void updateSeverity(int s_id, String severity) throws SQLException {
		findSeverity(s_id).setSeverity(severity);
		db.setUpdate_command("`severities` SET `severity` = " + severity + " WHERE `s_id` = " + s_id + ";");
		db.executeUpdateCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#deleteSeverity(model.Severity)
	 */
	@Override
	public void deleteSeverity(int s_id) throws SQLException {
		severities.remove(s_id);
		db.setDelete_command("`severities` WHERE s_id = " + s_id + ";");
		db.executeDeleteCommand();
	}

}

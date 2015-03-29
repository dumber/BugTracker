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
	
	private static final String SQL_QUERY = "select * from severities";
	
	public SeverityDaoFactory() throws SQLException {
		severities = new ArrayList<Severity>();
		db.setResultSet(db.getStmt().executeQuery(SQL_QUERY));
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			Severity sev = new Severity(rs.getInt("s_id"),rs.getString("severity"));
			severities.add(sev);
		}
	}
	
	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#getAllSeverities()
	 */
	@Override
	public List<Severity> getAllSeverities() {
		return severities;
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#getSeverity(int)
	 */
	@Override
	public Severity getSeverity(int s_id) {
		return severities.get(s_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#findSeverity(int)
	 */
	@Override
	public String findSeverity(int s_id) {
		return severities.get(s_id).getSeverity();
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#addSeverity(model.Severity)
	 */
	@Override
	public void addSeverity(Severity severity) {
		severities.add(severity);
		// TODO create the SQL insert command
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#updateSeverity(model.Severity)
	 */
	@Override
	public void updateSeverity(Severity severity) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#deleteSeverity(model.Severity)
	 */
	@Override
	public void deleteSeverity(int s_id) {
		severities.remove(s_id);
		// TODO create the SQL delete command
	}

}

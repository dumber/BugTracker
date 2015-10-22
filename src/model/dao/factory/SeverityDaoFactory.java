/**
 * 
 */
package model.dao.factory;

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
public class SeverityDaoFactory extends GenericDaoFactory implements SeverityDao {
	
	/**
	 * 
	 */
	public SeverityDaoFactory(){
		super("`severities`");
	}
	
	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#getAllTableElements()
	 */
	@Override
	public List<Severity> getAllTableElements() throws SQLException  {
		List<Severity> severities = new ArrayList<Severity>();
		dataSource.setSelectQueryString("`severities`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			Severity sev = new Severity(rs.getInt("id"),rs.getString("severity"));
			severities.add(sev);
		}
		rs.close();
		return severities;
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#findElementById(int)
	 */
	@Override
	public Severity findElementById(int id) throws SQLException {
		Severity s = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`severities` WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			s = new Severity(rs.getInt("id"), rs.getString("severity"));
		}
		rs.close();
		return s;
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#addElementToTable(model.Severity)
	 */
	@Override
	public void addElementToTable(Severity severity) throws SQLException {
		if (severity != null) {
			dataSource.setInsertQueryString("`severities` (`severity`) VALUES (" + severity.toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt severity into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.SeverityDao#updateElementInTalbe(int, model.Severity)
	 */
	@Override
	public void updateElementInTalbe(int id, Severity severity) throws SQLException {
		if (severity != null) {
			dataSource.setUpdateQueryString("`severities` SET " + severity.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt severity \n");
		}
	}

}

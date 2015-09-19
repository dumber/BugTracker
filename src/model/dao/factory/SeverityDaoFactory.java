/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GenericTableElement;
import model.Severity;
import model.dao.GenericDaoIFC;

/**
 * @author dumber
 *
 */
public class SeverityDaoFactory extends GenericDaoFactory implements GenericDaoIFC {
	
	/**
	 * 
	 */
	public SeverityDaoFactory(){
		super();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<Severity> getAllTableElements() throws SQLException  {
		List<Severity> severities = new ArrayList<Severity>();
		dataSource.setSelectQueryString("`severities`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			Severity sev = new Severity(rs.getInt("s_id"),rs.getString("severity"));
			severities.add(sev);
		}
		rs.close();
		return severities;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int s_id, Class<T> type) throws SQLException {
		Severity s = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`severities` WHERE s_id = ?" );
		dataSource.executeSelectByIdQuery(s_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			s = new Severity(rs.getInt("s_id"), rs.getString("severity"));
		}
		rs.close();
		return type.cast(s);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Severity findSeverityById(int id) throws SQLException {
		return findElementById(id, Severity.class);
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T severity) throws SQLException {
		if (((Severity)severity) != null) {
			dataSource.setInsertQueryString("`severities` (`severity`) VALUES (\'" + ((Severity)severity).getSeverity() + "\');");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt severity into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int s_id, T severity) throws SQLException {
		if (((Severity)severity) != null) {
			dataSource.setUpdateQueryString("`severities` SET `severity` = \'" + ((Severity)severity).getSeverity() + "\' WHERE `s_id` = " + s_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt severity \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int s_id) throws SQLException {
		dataSource.setDeleteQueryString("`severities` WHERE s_id = " + s_id + ";");
		dataSource.executeDeleteQuery();
	}

}

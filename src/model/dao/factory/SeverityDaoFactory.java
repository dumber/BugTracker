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
		super("`severities`");
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
			Severity sev = new Severity(rs.getInt("id"),rs.getString("severity"));
			severities.add(sev);
		}
		rs.close();
		return severities;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int id, Class<T> type) throws SQLException {
		Severity s = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.`severities` WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			s = new Severity(rs.getInt("id"), rs.getString("severity"));
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
			dataSource.setInsertQueryString("`severities` (`severity`) VALUES (" + ((Severity)severity).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt severity into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int id, T severity) throws SQLException {
		if (((Severity)severity) != null) {
			dataSource.setUpdateQueryString("`severities` SET " + ((Severity)severity).toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt severity \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int id) throws SQLException {
		dataSource.setDeleteQueryString("`severities` WHERE `id` = " + id + ";");
		dataSource.executeDeleteQuery();
	}

}

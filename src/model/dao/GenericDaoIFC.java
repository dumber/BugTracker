/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.GenericTableElement;

/**
 * @author dumber
 *
 */
public interface GenericDaoIFC {
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException;
	public <T extends GenericTableElement> T findElementById(int id, Class<T> type) throws SQLException;
	public <T extends GenericTableElement> void addElementToTable(T elem) throws SQLException;
	public <T extends GenericTableElement> void updateElementInTalbe(int id, T elem) throws SQLException;
	public void deleteElementFromTable(int id) throws SQLException;
}

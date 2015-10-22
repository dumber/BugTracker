/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.Action;

/**
 * @author dumber
 *
 */
public interface ActionDao extends GenericDaoIFC {
	public List<Action> getAllTableElements() throws SQLException;
	public Action findElementById(int id) throws SQLException;
	public void addElementToTable(Action elem) throws SQLException;
	public void updateElementInTalbe(int id, Action elem) throws SQLException;
}

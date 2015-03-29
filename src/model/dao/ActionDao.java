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
public interface ActionDao {
	public List<Action> getAllActions();
	public Action findAction(int a_id);
	public void addAction(Action action) throws SQLException;
	public void updateAction(int a_id, String action) throws SQLException;
	public void deleteAction(int a_id) throws SQLException;
}

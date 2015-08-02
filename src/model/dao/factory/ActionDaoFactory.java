/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.MySqlDataSourceSingleton;
import model.Action;
import model.dao.ActionDao;

/**
 * @author dumber
 *
 */
public class ActionDaoFactory implements ActionDao {
	MySqlDataSourceSingleton db = MySqlDataSourceSingleton.getInstance();
	List<Action> actions;
		
	/**
	 * @throws SQLException 
	 * 
	 */
	public ActionDaoFactory() throws SQLException {
		actions = new ArrayList<Action>();
		db.setSelect_command("`actions`");
		db.executeSelectCommand();
		ResultSet rs = db.getResultSet();
		while (rs.next()) {
			Action dp = new Action(rs.getInt("a_id"), rs.getString("action"));
			actions.add(dp);
		}
		rs.close();
	}

	/* (non-Javadoc)
	 * @see model.dao.ActionDao#getAllActions()
	 */
	@Override
	public List<Action> getAllActions() {
		return actions;
	}

	/* (non-Javadoc)
	 * @see model.dao.ActionDao#findAction(int)
	 */
	@Override
	public Action findAction(int a_id) {
		return actions.get(a_id);
	}

	/* (non-Javadoc)
	 * @see model.dao.ActionDao#addAction(model.Action)
	 */
	@Override
	public void addAction(Action action) throws SQLException {
		actions.add(action);
		db.setInsert_command("`actions` (`action`) VALUES (" + action.getAction() + ");");
		db.executeInsertCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.ActionDao#updateAction(model.Action)
	 */
	@Override
	public void updateAction(int a_id, String action) throws SQLException{
		findAction(a_id).setAction(action);
		db.setUpdate_command("`actions` SET `action` = " + action + " WHERE `a_id` = " + a_id + ";");
		db.executeUpdateCommand();
	}

	/* (non-Javadoc)
	 * @see model.dao.ActionDao#deleteAction(int)
	 */
	@Override
	public void deleteAction(int a_id) throws SQLException {
		actions.remove(a_id);
		db.setDelete_command("`actions` WHERE a_id = " + a_id + ";");
		db.executeDeleteCommand();
	}

}

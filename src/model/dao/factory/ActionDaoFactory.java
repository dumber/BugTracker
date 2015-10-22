/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Action;
import model.dao.ActionDao;

/**
 * @author dumber
 *
 */
public class ActionDaoFactory extends GenericDaoFactory implements ActionDao {
		
	/**
	 *
	 */
	public ActionDaoFactory() {
		super("actions");
	}

	/* (non-Javadoc)
	 * @see model.dao.ActionDao#getAllTableElements()
	 */
	@Override
	public List<Action> getAllTableElements() throws SQLException {
		List<Action> actions = new ArrayList<Action>();
		dataSource.setSelectQueryString("`actions`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			Action a = new Action(rs.getInt("id"), rs.getString("action"));
			actions.add(a);
		}
		rs.close();
		return actions;
	}

	/* (non-Javadoc)
	 * @see model.dao.ActionDao#findElementById(int)
	 */
	@Override
	public Action findElementById(int id) throws SQLException {
		Action a = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.actions WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			a = new Action(rs.getInt("id"), rs.getString("action"));
		}
		rs.close();
		return a;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.ActionDao#addElementToTable(model.Action)
	 */
	@Override
	public void addElementToTable(Action action) throws SQLException {
		if (action != null) {
			dataSource.setInsertQueryString("`actions` (`action`) VALUES (" + action.toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt action into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.ActionDao#updateElementInTalbe(int, model.Action)
	 */
	@Override
	public void updateElementInTalbe(int id, Action action) throws SQLException{
		if (action.getAction() != null) {
			dataSource.setUpdateQueryString("`actions` SET " + action.toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt action \n");
		}
	}

}

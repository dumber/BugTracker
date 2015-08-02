/**
 * 
 */
package model.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Action;
import model.GenericTableElement;
import model.dao.GenericDaoIFC;;

/**
 * @author dumber
 *
 */
public class ActionDaoFactory extends GenericDaoFactory implements GenericDaoIFC {
//	List<GenericTableElement> actions;
//	List<Action> actions;
	
		
	/**
	 * @throws SQLException 
	 * 
	 */
	public ActionDaoFactory() throws SQLException {
		super();
//		actions = new ArrayList<Action>();
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#getAllTableElements()
	 */
	@Override
	public List<? extends GenericTableElement> getAllTableElements() throws SQLException {
		List<Action> actions = new ArrayList<Action>();
		dataSource.setSelectQueryString("`actions`");
		dataSource.executeSelectQuery();
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			Action a = new Action(rs.getInt("a_id"), rs.getString("action"));
			actions.add(a);
		}
		rs.close();
		return actions;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int a_id, Class<T> type) throws SQLException {
		Action a = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.actions WHERE a_id = ?" );
		dataSource.executeSelectByIdQuery(a_id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			a = new Action(rs.getInt("a_id"), rs.getString("action"));
		}
		rs.close();
		return type.cast(a);
	}

	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Action findActionById(int id) throws SQLException {
		return findElementById(id, Action.class);
	}
	
	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#addElementToTable(T action)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T action) throws SQLException {
//		actions.add((Action)action);
		dataSource.setInsertQueryString("`actions` (`action`) VALUES (" + ((Action)action).getAction() + ");");
		dataSource.executeInsertQuery();
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(model.Action)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int a_id, T action) throws SQLException{
		Action a = findActionById(a_id);
		if (a != null) {
			a.setAction(((Action)action).getAction());
			dataSource.setUpdateQueryString("`actions` SET `action` = \'" + a.getAction() + "\' WHERE `a_id` = " + a_id + ";");
			dataSource.executeUpdateQuery();
		} else {
			// TODO throw some exceptions
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int a_id) throws SQLException {
//		actions.remove(a_id);
		dataSource.setDeleteQueryString("`actions` WHERE a_id = " + a_id + ";");
		dataSource.executeDeleteQuery();
	}

}

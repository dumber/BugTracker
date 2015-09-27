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
		
	/**
	 * 
	 */
	public ActionDaoFactory() {
		super("actions");
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
			Action a = new Action(rs.getInt("id"), rs.getString("action"));
			actions.add(a);
		}
		rs.close();
		return actions;
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#findElementById(int, java.lang.Class)
	 */
	@Override
	public <T extends GenericTableElement> T findElementById(int id, Class<T> type) throws SQLException {
		Action a = null;
		dataSource.setCustomQueryString(" * FROM `bugtrack`.actions WHERE id = ?" );
		dataSource.executeSelectByIdQuery(id);
		ResultSet rs = dataSource.getResultSet();
		while (rs.next()) {
			a = new Action(rs.getInt("id"), rs.getString("action"));
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
	 * @see model.dao.GenericDaoIFC#addElementToTable(model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void addElementToTable(T action) throws SQLException {
		if (((Action)action) != null) {
			dataSource.setInsertQueryString("`actions` (`action`) VALUES (" + ((Action)action).toString() + ");");
			dataSource.executeInsertQuery();
		} else {
			throw new RuntimeException("trying to insert corrupt action into database \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#updateElementInTalbe(int, model.GenericTableElement)
	 */
	@Override
	public <T extends GenericTableElement> void updateElementInTalbe(int id, T action) throws SQLException{
		if (((Action)action).getAction() != null) {
			dataSource.setUpdateQueryString("`actions` SET " + ((Action)action).toUpdateString() 
					+ " WHERE `id` = " + id + ";");
			dataSource.executeUpdateQuery();
		} else {
			throw new RuntimeException("corrupt action \n");
		}
	}

	/* (non-Javadoc)
	 * @see model.dao.GenericDaoIFC#deleteElementFromTable(int)
	 */
	@Override
	public void deleteElementFromTable(int id) throws SQLException {
		dataSource.setDeleteQueryString("`actions` WHERE `id` = " + id +";");
		dataSource.executeDeleteQuery();
	}

}

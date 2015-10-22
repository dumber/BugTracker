/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.UserType;

/**
 * @author dumber
 *
 */
public interface UserTypeDao extends GenericDaoIFC {
	public List<UserType> getAllTableElements() throws SQLException;
	public UserType findElementById(int id) throws SQLException;
	public void addElementToTable(UserType elem) throws SQLException;
	public void updateElementInTalbe(int id, UserType elem) throws SQLException;
}

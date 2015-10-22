/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.ProjectUser;

/**
 * @author dumber
 *
 */
public interface ProjectUserDao extends GenericDaoIFC {
	public List<ProjectUser> getAllTableElements() throws SQLException;
	public ProjectUser findElementById(int id) throws SQLException;
	public void addElementToTable(ProjectUser elem) throws SQLException;
	public void updateElementInTalbe(int id, ProjectUser elem) throws SQLException;
}

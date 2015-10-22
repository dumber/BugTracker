/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.Project;

/**
 * @author dumber
 *
 */
public interface ProjectDao extends GenericDaoIFC {
	public List<Project> getAllTableElements() throws SQLException;
	public Project findElementById(int id) throws SQLException;
	public void addElementToTable(Project elem) throws SQLException;
	public void updateElementInTalbe(int id, Project elem) throws SQLException;
}

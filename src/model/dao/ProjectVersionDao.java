/**
 * 
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.ProjectVersion;

/**
 * @author dumber
 *
 */
public interface ProjectVersionDao extends GenericDaoIFC {
	public List<ProjectVersion> getAllTableElements() throws SQLException;
	public ProjectVersion findElementById(int id) throws SQLException;
	public void addElementToTable(ProjectVersion elem) throws SQLException;
	public void updateElementInTalbe(int id, ProjectVersion elem) throws SQLException;
}

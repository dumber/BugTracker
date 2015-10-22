/**
 * 
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author dumber
 *
 */
public class ProjectUser extends GenericTableElement {
	private StringProperty project_name;
	private StringProperty username;
	
	/**
	 * @param pu_id
	 * @param project_name
	 * @param username
	 */
	public ProjectUser(int pu_id, String project, String user) {
		super(pu_id);
		this.project_name = new SimpleStringProperty(project);
		this.username = new SimpleStringProperty(user);
	}

	/**
	 * @param pu
	 */
	public ProjectUser(ProjectUser pu) {
		super(pu.getId());
		this.project_name = pu.project_name;
		this.username = pu.username;
	}

	/**
	 * @return the project_name
	 */
	public String getProject() {
		return project_name.get();
	}

	/**
	 * @param project_name the project_name to set
	 */
	public void setProject(String project) {
		this.project_name.set(project);
	}

	/**
	 * @return the project_name
	 */
	public StringProperty projectProperty() {
		return project_name;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username.get();
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String user) {
		this.username.set(user);
	}

	/**
	 * @return the username
	 */
	public StringProperty usernameProperty() {
		return username;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return project_name.get() + ", " + username.get();
	}
	
	/**
	 * @return
	 */
	public String toInsertString() {
		return "(select `id` from `projects` where `projects`.`project_name`=\'" + project_name.get() + "\'), (select `id` from `users` where `users`.`username` = \'" + username.get() + "\')";
	}

	/**
	 * @return 
	 */
	public String toUpdateString() {	
		return "`project_id`=(select `id` from `projects` where `projects`.`project_name`=\'" + project_name.get() + "\'), `user_id`=(select `id` from `users` where `users`.`username` = \'" + username.get() + "\')";

	}
	
	/**
	 * @return 
	 */
	public String debug() {	
		return "ProjectUser [id=" + id.get() + ", project_name=" + project_name.get() + ", username="
				+ username.get() + "]";

	}
	
	
}

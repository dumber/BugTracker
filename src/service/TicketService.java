/**
 * 
 */
package service;

import java.sql.SQLException;





import model.Action;
import model.dao.ActionDao;
import model.dao.factory.ActionDaoFactory;

/**
 * @author dumber
 *
 */
public class TicketService {
	private final ActionDao ac_dao;
	/**
	 * 
	 */
	public TicketService() {
		this.ac_dao = new ActionDaoFactory();
	}
	
	public Action getAction(int id) {
		try {
			return ac_dao.findElementById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("couldn't find action. something is wrong");
		
		}
	}
}

/**
 * 
 */
package view;

import java.sql.SQLException;

import controller.UserInterfaceControl;
import service.TicketService;
import model.Action;
import model.dao.ActionDao;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import application.BugTrackerApp;

/**
 * @author dumber
 *
 */
public class TicketOverviewConroller {
    @FXML
    private TextArea textarea;
    private TicketService tc;
    
//    public Action getth() {
//    	try {
//			return adf.findElementById(1);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	return new Action(1,"picsaba");
//    }
//    
    @FXML
    private Label Label;

    // Reference to the main application.
    private UserInterfaceControl mainApp;
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
	public TicketOverviewConroller() {
//		adf = new ActionDaoFactory();
		tc = new TicketService();
	}
	
	@FXML
	public void initialize() throws SQLException {	   
//		textarea.setText("a");
	}
	
	public void setMainApp(UserInterfaceControl app) {
		this.mainApp = app;
//		textarea.setText(tc.getAction(1).getAction());
	}
}

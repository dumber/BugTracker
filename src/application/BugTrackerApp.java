/**
 * 
 */
package application;
	
import helper.MySqlDataSourceSingleton;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;








import controller.UserInterfaceControl;
import test.FactoryTest;
import view.RootLayoutController;
import view.TicketOverviewConroller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.Action;
import model.DetectionPhase;
import model.TicketHeader;
import model.dao.factory.ActionDaoFactory;
import model.dao.factory.DetectionPhaseDaoFactory;
import model.dao.factory.PriorityDaoFactory;
import model.dao.secure.PasswordHash;

/**
 * @author dumber
 *
 */
public class BugTrackerApp extends Application {
	private UserInterfaceControl gui;
	
	@Override
	public void start(Stage primaryStage) {
		gui = new UserInterfaceControl(primaryStage);
        gui.initRootLayout();
        gui.showWelcomeTab();
	}

  
	public static void main(String[] args) {
		MySqlDataSourceSingleton my = MySqlDataSourceSingleton.getInstance();
		try {
			my.setupConnection("dumber", "Test1234");		
			
//			DatabaseMetaData meta = my.getConn().getMetaData();
//			String[] types = {"TABLE"};
//			ResultSet rs_t = meta.getTables(null, null, "%", types);
//			table_colums_n_types = new ArrayList<Map<String, List<Map<String,String>>>>();
//			while (rs_t.next()) {
//				String table = rs_t.getString("TABLE_NAME");
				FactoryTest test = new FactoryTest("users");
				test.runSelectTest(2);
//				test.runInsertTest();
//				test.printMaxTest();
//				test.runUpdateTest();
//				test.runDeleteTest();
				test.runSelectAllTest();
//			}
//			ActionDaoFactory adf = new ActionDaoFactory();
//			System.out.println("mivan?");
			//+adf.findActionById(1).debug());
//			System.out.println(adf.findActionById(1).debug());
//			DetectionPhase a = new DetectionPhase(adf.findDetectionPhaseById(1));
//			System.out.println("Success: " );
//			System.out.println(a.toString());
//			a.setPhaseName("Submit");
//			adf.updateElementInTalbe(1, a);
//			System.out.println("Modified:");
//			System.out.println(a.debug());
//			a.setPhaseName("Specification");
//			adf.updateElementInTalbe(1, a);
//			System.out.println("Modified:");
//			System.out.println(a.debug());
//			ArrayList<DetectionPhase> alist = (ArrayList<DetectionPhase>)adf.getAllTableElements();
//			System.out.println(alist.get(0).getId() + ", " + alist.get(0).getAction());
//			Action a = new Action(1,"lophas");
//			adf.updateElementInTalbe(1, a);
//			adf.addElementToTable(a);
//			System.out.println(adf.findActionById(14).toString());
//			alist = (ArrayList<Action>)adf.getAllTableElements();
//			adf.deleteElementFromTable(14);
//			for(DetectionPhase i : alist) {
//				System.out.println(i.debug());
//			}
//			my.MySqlDataSourceCloseConections();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/* catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}*/		
//		launch(args);
	}
}

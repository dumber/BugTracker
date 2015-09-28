/**
 * 
 */
package application;
	
import helper.MySqlDataSourceSingleton;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

import test.FactoryTest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.Action;
import model.DetectionPhase;
import model.dao.factory.ActionDaoFactory;
import model.dao.factory.DetectionPhaseDaoFactory;
import model.dao.factory.PriorityDaoFactory;

/**
 * @author dumber
 *
 */
public class BugTrackerApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BugTracker");
        
        initRootLayout();
        showTicketOverview();
	}
	
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BugTrackerApp.class.getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the ticket overview inside the root layout.
     */
    public void showTicketOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BugTrackerApp.class.getResource("../view/TicketOverview.fxml"));
            TabPane ticketOverview = (TabPane) loader.load();
            Tab tab = new Tab();
//            tab.setText("Welcome");
            tab.setContent(ticketOverview);
            TabPane tp = new TabPane();
            tp.getTabs().add(tab);
            // Set person overview into the center of root layout.
            rootLayout.setCenter(tp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    

    
	public static void main(String[] args) {
		MySqlDataSourceSingleton my = MySqlDataSourceSingleton.getInstance();
		try {
			my.setupConnection("dumber", "asdfQq22");		
//			my.getDatabaseMetaData();
//			my.executeQueryDemo();
			FactoryTest test = new FactoryTest();
			test.runSelectTest();
//			test.runInsertTest();
			test.printMaxTest();
//			test.runUpdateTest();
			test.runDeleteTest();
//			DatabaseMetaData meta = my.getConn().getMetaData();
//			String[] types = {"TABLE"};
//			ResultSet rs_t = meta.getTables(null, null, "%", types);
//			table_colums_n_types = new ArrayList<Map<String, List<Map<String,String>>>>();
//			while (rs_t.next()) {
//				String table = rs_t.getString("TABLE_NAME");
				test.runSelectAllTest("actions");
//			}
//			DetectionPhaseDaoFactory adf = new DetectionPhaseDaoFactory();
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
			my.MySqlDataSourceCloseConections();
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
		}		
//		launch(args);
	}
}

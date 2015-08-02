/**
 * 
 */
package application;
	
import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

import database.MySqlDataSourceSingleton;
import model.dao.factory.ActionDaoFactory;

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
     * Shows the person overview inside the root layout.
     */
    public void showTicketOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BugTrackerApp.class.getResource("../view/TicketOverview.fxml"));
            TabPane ticketOverview = (TabPane) loader.load();
            Tab tab = new Tab();
            tab.setText("Welcome");
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
//			my.executeQueryDemo();
			ActionDaoFactory adf = new ActionDaoFactory();
			System.out.println("Success: " );
			System.out.println(adf.findAction(1).getAction_id() + ", " + adf.findAction(1).getAction());
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

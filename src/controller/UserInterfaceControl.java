/**
 * 
 */
package controller;

import java.io.IOException;

import view.LoginDialogController;
import view.RootLayoutController;
import view.TicketOverviewConroller;
import application.BugTrackerApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author dumber
 *
 */
public class UserInterfaceControl {
	private Stage primaryStage;
	private BorderPane rootLayout;
	private TabPane tp;
	
	private static boolean logged_in = false;
	
	/**
	 * 
	 */
	public UserInterfaceControl(Stage primary) {
		this.primaryStage = primary;
		this.primaryStage.setTitle("BugTracker");
	}
	
	public static boolean isUserLoggedIn() {
		return logged_in;
	}
	
	public Stage getStage() {
		return primaryStage;
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
            tp = new TabPane();
            // Show the scene containing the root layout.
            rootLayout.setCenter(tp);
            

            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            RootLayoutController rlc = loader.getController();
            rlc.setMainApp(this);
            
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the ticket overview inside the root layout.
     */
    public void showTicketOverview(String str) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BugTrackerApp.class.getResource("../view/TicketOverview.fxml"));
            TabPane ticketOverview = (TabPane) loader.load();
            Tab tab = new Tab(str);
//            tab.setText("Welcome");
            tab.setContent(ticketOverview);            
            tp.getTabs().add(tab);
            tp.getSelectionModel().select(tab);
            
            TicketOverviewConroller ctrl = loader.getController();
            ctrl.setMainApp(this);
            // Set person overview into the center of root layout.
            rootLayout.setCenter(tp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void showWelcomeTab() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BugTrackerApp.class.getResource("../view/WelcomeTab.fxml"));
            AnchorPane welcome_tab = (AnchorPane) loader.load();
            Tab tab = new Tab("Welcome");

            tab.setContent(welcome_tab);
            tp.getTabs().add(tab);
            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(tp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean showLoginDialog() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BugTrackerApp.class.getResource("../view/LoginDialog.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Please log in: ");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(pane);
	        dialogStage.setScene(scene);

	        LoginDialogController login_ctrl = loader.getController();
	        login_ctrl.setDialogStage(dialogStage);
	        
	        dialogStage.showAndWait();

	        logged_in = login_ctrl.isOkClicked();
	        return logged_in;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return logged_in;
		}
    }
}

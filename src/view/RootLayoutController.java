/**
 * 
 */
package view;

import java.sql.SQLException;

import controller.UserInterfaceControl;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * @author dumber
 *
 */
public class RootLayoutController {
	@FXML
	private Button loginButton;
	@FXML
	private Button searchButton;
	@FXML
	private TextField searchField;
	
	private UserInterfaceControl mainApp;
	/**
	 * 
	 */
//	public RootLayoutController() {
//		// TODO Auto-generated constructor stub
//	}

	@FXML
	public void initialize() {	   
//		searchField.setText("a");
	}
	
	public void setMainApp(UserInterfaceControl app) {
		this.mainApp = app;
//		textarea.setText(tc.getAction(1).getAction());
	}
	
	 @FXML
	 private void handleLoginButtonAction(ActionEvent event) {
	     // Button was clicked, do something...	     
	     boolean ok = mainApp.showLoginDialog();
	     if (ok) {
	    	 searchField.setText("login Button pressed");
	    	 Platform.runLater(new Runnable() {
			     @Override
			     public void run() {
			    	 searchField.requestFocus();
			     }
			});
	     } else {
	    	 searchField.setText("khmmm");
	    	 Platform.runLater(new Runnable() {
			     @Override
			     public void run() {
			    	 loginButton.requestFocus();
			     }
			});
	     }
	 }
	 
	 @FXML
	 private void handleSearchButtonAction(ActionEvent event) {
		 if (UserInterfaceControl.isUserLoggedIn()) {
			 mainApp.showTicketOverview(searchField.getText());
		 } else {
		    	Alert alert = new Alert(AlertType.ERROR);
		    	alert.initOwner(mainApp.getStage());
		    	alert.setTitle("Error");
		    	alert.setHeaderText("Must be logged in to search!");
		    	alert.showAndWait();
		 }
	 }
	 
	 @FXML
	 private void handleEnter(KeyEvent event) {
		 if (this.loginButton.isFocused() && event.getCode() == KeyCode.ENTER) {
			 boolean ok = mainApp.showLoginDialog();
		     if (ok) {
		    	 searchField.setText("enter on login Button pressed");
		    	 Platform.runLater(new Runnable() {
				     @Override
				     public void run() {
				    	 searchField.requestFocus();
				     }
				 });
		     } else {
		    	 searchField.setText("wut?");
		    	 Platform.runLater(new Runnable() {
				     @Override
				     public void run() {
				    	 loginButton.requestFocus();
				     }
				});
		     }
		 } else if (searchButton.isFocused() && event.getCode() == KeyCode.ENTER) {
			 if (UserInterfaceControl.isUserLoggedIn()) {
				 mainApp.showTicketOverview(searchField.getText());
			 } else {
			    	Alert alert = new Alert(AlertType.ERROR);
			    	alert.initOwner(mainApp.getStage());
			    	alert.setTitle("Error");
			    	alert.setHeaderText("Must be logged in to search!");
			    	alert.showAndWait();
			 }
		 }		 
	 }
}

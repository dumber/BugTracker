/**
 * 
 */
package view;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import controller.UserInterfaceControl;
import model.User;
import model.dao.secure.PasswordHash;
import service.LoginService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * @author dumber
 *
 */
public class LoginDialogController {
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelButton;
	
	private Stage dialogStage;
	private LoginService service;
	private User db_user;
	private boolean okClicked;
	
	private UserInterfaceControl mainApp;
	/**
	 * 
	 */
	public LoginDialogController() {
	}
	
	@FXML
	public void initialize() {	   
		service = new LoginService();
		Platform.runLater(new Runnable() {
		     @Override
		     public void run() {
		         usernameField.requestFocus();
		     }
		});
	}
	
    /**
     * Sets the stage of this dialog.
     * 
     * @param stage
     */
	public void setDialogStage(Stage stage) {
		this.dialogStage = stage;
		
	}
	
    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
	public void setMainApp(UserInterfaceControl app) {
		this.mainApp = app;
//		textarea.setText(tc.getAction(1).getAction());
	}
	
	 @FXML
	 private void handleOk() {
		 if (!usernameField.getText().equals("") && !this.cancelButton.isFocused()) {
		     String usr = usernameField.getText();
		     try {
		    	new PasswordHash(passwordField.getText());
				db_user = service.getUserByName(usr);
				if (db_user == null) {
			    	Alert alert = new Alert(AlertType.ERROR);
			    	alert.initOwner(dialogStage);
			    	alert.setTitle("Error");
			    	alert.setHeaderText("Login failed: No such user!");
			    	alert.showAndWait();					
				} else {
					if (db_user.getUsername().equals(usr) && 
				    		 PasswordHash.checkPassword(db_user)) {
					     okClicked = true;
					     dialogStage.close();
				     } else {
				    	// Show the error message.
				    	Alert alert = new Alert(AlertType.ERROR);
				    	alert.initOwner(dialogStage);
				    	alert.setTitle("Error");
				    	alert.setHeaderText("Login failed: Incorrect password!");
				    	alert.showAndWait();
				     }
				}
		     } catch (SQLException e) {

				e.printStackTrace();
		     } catch (NoSuchAlgorithmException e) {
			    Alert alert = new Alert(AlertType.ERROR);
			    alert.initOwner(dialogStage);
			    alert.setTitle("Error");
			    alert.setHeaderText("we should not see this: no such algorithm!");
			    alert.showAndWait();
				e.printStackTrace();
			}		     
		     	 
		 } else {
		    	// Show the error message.
		    	Alert alert = new Alert(AlertType.ERROR);
		    	alert.initOwner(dialogStage);
		    	alert.setTitle("Error");
		    	alert.setHeaderText("Login failed: Username field cannot be empty!");
		    	alert.showAndWait(); 
		 }
	 }
	 
	 /**
	 * Called when the user clicks cancel.
	 */
	 @FXML
	 private void handleCancel() {
		 dialogStage.close();
	 }
	 
	 @FXML
	 private void handleEnter(KeyEvent event) {
		 if (this.cancelButton.isFocused() && event.getCode() == KeyCode.ENTER) {
			 okButton.setDefaultButton(false);
			 handleCancel();
		 } 
	 }
}

package restauto.manager.menu.levelc.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialogs;

import restauto.manager.database.tools.MySQLDatabase;
import restauto.manager.menu.levelc.model.Employee;
import restauto.manager.menu.levelc.model.Levelc;
import restauto.manager.menu.levelc.model.LocationGoogle;

@SuppressWarnings("deprecation")
public class EmployeeEditDialogController {

    @FXML
    private TextField idField;
    @FXML
    private TextField userField;
    @FXML
    private TextField passField;
    @FXML
    private TextField fnameField;
    @FXML
    private TextField lnameField;


    private Stage dialogStage;
    private Employee employee;
    private boolean okClicked = false;
    File pictureFile;
    String pictureNameString;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.dialogStage.getIcons().add(new Image("file:resources/images/1412737629_food-grey.png"));
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param Menu Item
     */
    public void setLocation(Employee employee) {
        this.employee = employee;

        idField.setText(employee.getItemID());
        userField.setText(employee.getUsername());
        passField.setText(employee.getPassword());
        fnameField.setText(employee.getFname());
        lnameField.setText(employee.getLname());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     * @throws SQLException 
     * @throws FileNotFoundException 
     */
    @FXML
    private void handleOk() throws FileNotFoundException, SQLException{
        //if (isInputValid()) {
            employee.setItemID(idField.getText());
            employee.setUsername(userField.getText());
            employee.setPassword(passField.getText());
            employee.setFname(fnameField.getText());
            employee.setLname(lnameField.getText());
            
            
        
            
            okClicked = true;
            dialogStage.close();
        
            //MySQLDatabase database=new MySQLDatabase();
            //database.insertImage(pictureNameString, pictureFile, location.getItemID());
        }
    

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
/*
    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     *
    private boolean isInputValid() {
        String errorMessage = "";

        if (idField.getText() == null || idField.getText().length() == 0) {
            errorMessage += "No valid ID!\n"; 
        }
        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "No valid street!\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Dialogs.create()
                .title("Invalid Fields")
                .masthead("Please correct invalid fields")
                .message(errorMessage)
                .showError();
            return false;
        }
    } 
    */
    
    
} 
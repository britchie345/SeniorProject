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
import restauto.manager.menu.levelc.model.Levelc;
import restauto.manager.menu.levelc.model.LocationGoogle;

@SuppressWarnings("deprecation")
public class LocationEditDialogController {

    @FXML
    private TextField idField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField longitudeField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField latitudeField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField stateField;
    @FXML
    private TextField zipField;


    private Stage dialogStage;
    private LocationGoogle location;
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
    public void setLocation(LocationGoogle location) {
        this.location = location;

        idField.setText(location.getItemID());
        titleField.setText(location.getTitle());
        longitudeField.setText(location.getLongitude());
        latitudeField.setText(location.getLatitude());
        descriptionField.setText(location.getDescription());
        streetField.setText(location.getStreet());
        cityField.setText(location.getCity());
        stateField.setText(location.getState());
        zipField.setText(location.getZip());
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
            location.setItemID(idField.getText());
            location.setTitle(titleField.getText());
            location.setLongitude(longitudeField.getText());
            location.setLatitude(latitudeField.getText());
            location.setDescription(descriptionField.getText());
            location.setStreet(streetField.getText());
            location.setCity(cityField.getText());
            location.setState(stateField.getText());
            location.setZip(zipField.getText());
            
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
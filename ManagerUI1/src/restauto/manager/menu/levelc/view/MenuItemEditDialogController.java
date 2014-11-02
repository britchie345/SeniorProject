package restauto.manager.menu.levelc.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

//import org.controlsfx.dialog.Dialogs;

import restauto.manager.menu.levelc.model.Menu_Item;

@SuppressWarnings("deprecation")
public class MenuItemEditDialogController {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField caloriesField;
    @FXML
    private TextField onMenuField;
    @FXML
    private TextField spicyField;
    @FXML
    private TextField recomendedField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField menuDescField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField cookTimeField;


    private Stage dialogStage;
    private Menu_Item menuItem;
    private boolean okClicked = false;

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
     * @param person
     */
    public void setMenuItem(Menu_Item menuItem) {
    	
        this.menuItem = menuItem;

        idField.setText         (menuItem.getItemID());
        nameField.setText       (menuItem.getName());
        caloriesField.setText   (menuItem.getCalories());
        onMenuField.setText     (menuItem.getOnMenu());
        spicyField.setText      (menuItem.getSpicy());
        recomendedField.setText (menuItem.getRecomended());
        priceField.setText      (menuItem.getPrice());
        menuDescField.setText   (menuItem.getMenuDesc());
        descriptionField.setText(menuItem.getDescription());
        cookTimeField.setText   (menuItem.getCookTime());
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
     */
    @FXML
    private void handleOk() {
    	
        //if (isInputValid()) {
    	menuItem.setItemID(idField.getText());         
        menuItem.setName(nameField.getText());       
        menuItem.setCalories(caloriesField.getText());   
        menuItem.setOnMenu(onMenuField.getText());     
        menuItem.setSpicy(spicyField.getText());      
        menuItem.setRecomended(recomendedField.getText()); 
        menuItem.setPrice(priceField.getText());      
        menuItem.setMenuDesc(menuDescField.getText());   
        menuItem.setDescription(descriptionField.getText());
        menuItem.setCookTime(cookTimeField.getText());  

            okClicked = true;
            dialogStage.close();
        //}
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

//    /**
//     * Validates the user input in the text fields.
//     * 
//     * @return true if the input is valid
//     */
//    private boolean isInputValid() {
//        String errorMessage = "";
//
//        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
//            errorMessage += "No valid first name!\n"; 
//        }
//        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
//            errorMessage += "No valid last name!\n"; 
//        }
//        if (streetField.getText() == null || streetField.getText().length() == 0) {
//            errorMessage += "No valid street!\n"; 
//        }
//
//        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
//            errorMessage += "No valid postal code!\n"; 
//        } else {
//            // try to parse the postal code into an int.
//            try {
//                Integer.parseInt(postalCodeField.getText());
//            } catch (NumberFormatException e) {
//                errorMessage += "No valid postal code (must be an integer)!\n"; 
//            }
//        }
//
//        if (cityField.getText() == null || cityField.getText().length() == 0) {
//            errorMessage += "No valid city!\n"; 
//        }
//
//        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
//            errorMessage += "No valid birthday!\n";
//        }
//
//        if (errorMessage.length() == 0) {
//            return true;
//        } else {
//            // Show the error message.
//            Dialogs.create()
//                .title("Invalid Fields")
//                .masthead("Please correct invalid fields")
//                .message(errorMessage)
//                .showError();
//            return false;
//        }
//    }
}
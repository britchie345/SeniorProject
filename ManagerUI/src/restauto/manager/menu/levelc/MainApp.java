package restauto.manager.menu.levelc;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import restauto.manager.menu.levelc.model.Levelc;
import restauto.manager.menu.levelc.view.LevelaOverviewController;
import restauto.manager.menu.levelc.view.LevelbOverviewController;
import restauto.manager.menu.levelc.view.LevelcEditDialogController;
import restauto.manager.menu.levelc.view.LevelcOverviewController;
import restauto.manager.menu.levelc.view.ManagerLoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     * The data as an observable list of Levelcs.
     */
    private ObservableList<Levelc> levelcData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        levelcData.add(new Levelc("344", "Burger"));
        levelcData.add(new Levelc("345", "Filet Mignonet"));
        levelcData.add(new Levelc("346", "Strip Steak"));
        levelcData.add(new Levelc("347", "Prime Rib"));
        levelcData.add(new Levelc("348", "Beef Tips"));
        levelcData.add(new Levelc("349", "Steak Sandwich"));
        levelcData.add(new Levelc("350", "Turkey Burger"));
        levelcData.add(new Levelc("351", "Turkey Legs"));
        levelcData.add(new Levelc("352", "Ham"));
    }

    /**
     * Returns the data as an observable list of Levelcs. 
     * @return
     */
    public ObservableList<Levelc> getLevelcData() {
        return levelcData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Manager App");
        
        this.primaryStage.getIcons().add(new Image("file:resources/images/1412737629_food-grey.png"));

        initRootLayout();

        //showLevelcOverview();
        showManagerLoginOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
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
     * Shows the manager login overview inside the root layout.
     */
    public void showManagerLoginOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ManagerLogin.fxml"));
            AnchorPane managerLogin = (AnchorPane) loader.load();

            // Set manager login overview into the center of root layout.
            rootLayout.setCenter(managerLogin);

            // Give the controller access to the main app.
            ManagerLoginController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the levela overview inside the root layout.
     */
    public void showLevelaOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LevelaOverview.fxml"));
            AnchorPane levelaOverview = (AnchorPane) loader.load();

            // Set levela overview into the center of root layout.
            rootLayout.setCenter(levelaOverview);

            // Give the controller access to the main app.
            LevelaOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the levelb overview inside the root layout.
     */
    public void showLevelbOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LevelbOverview.fxml"));
            AnchorPane levelbOverview = (AnchorPane) loader.load();

            // Set levelb overview into the center of root layout.
            rootLayout.setCenter(levelbOverview);

            // Give the controller access to the main app.
            LevelbOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the levelc overview inside the root layout.
     */
    public void showLevelcOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LevelcOverview.fxml"));
            AnchorPane levelcOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(levelcOverview);

            // Give the controller access to the main app.
            LevelcOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     * 
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showPersonEditDialog(Levelc person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LevelcEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Levelc");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            LevelcEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
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
        launch(args);
    }
}

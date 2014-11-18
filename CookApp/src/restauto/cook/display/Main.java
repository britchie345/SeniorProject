package restauto.cook.display;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import restauto.cook.display.view.EmployeeLoginController;
import restauto.cook.display.view.HomePageController;
import restauto.cook.display.view.MainDisplayController;
import restauto.cook.display.view.RootLayoutController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    //Andrew used to keep track of which rootlayout buttons to show
    private static boolean fadeOut=true;
    private static boolean returnHome=true;
    private static boolean edit=false;

    /**
     * Constructor
     */
    public Main() {}
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Employee Display");
        
        //Add in an icon
        this.primaryStage.getIcons().add(new Image("file:resources/images/1412737629_food-grey.png"));

        initRootLayout();
        showEmployeeLoginOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);                        
            
            primaryStage.setScene(scene);
            primaryStage.show();
          //Andrew set root layout controller and change buttons
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            controller.fadeOut(fadeOut);
            controller.setReturnHome(returnHome);
            controller.hideEdit(edit);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the employee login overview inside the root layout.
     */
    public void showEmployeeLoginOverview() {
        try {
        	//Andrew handle setting buttons for this particular scene
        	fadeOut=true;
        	returnHome=true;
        	edit=false;
        	initRootLayout();
            // Load Manager Login overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/EmployeeLogin.fxml"));
            AnchorPane managerLogin = (AnchorPane) loader.load();

            // Set manager login overview into the center of root layout.
            rootLayout.setCenter(managerLogin);

            // Give the controller access to the main app.
            EmployeeLoginController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the HomePage overview inside the root layout.
     */
    public void showHomePageOverview() {
        try {
        	//Andrew handle setting buttons for this particular scene
        	fadeOut=false;
        	returnHome=true;
        	edit=false;
        	initRootLayout();
            // Load Home Page overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/HomePage.fxml"));
            AnchorPane homePageOverview = (AnchorPane) loader.load();

            // Set levela overview into the center of root layout.
            rootLayout.setCenter(homePageOverview);

            // Give the controller access to the main app.
            HomePageController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the Main Display overview inside the root layout.
     */
    public void showMainDisplay(String display) {
        try {
        	//Andrew handle setting buttons for this particular scene
        	fadeOut=false;
        	returnHome=false;
        	edit=true;
        	initRootLayout();
            // Load Main Display overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainDisplay2.fxml"));
            AnchorPane homePageOverview = (AnchorPane) loader.load();

            // Set Main Display overview into the center of root layout.
            rootLayout.setCenter(homePageOverview);

            // Give the controller access to the main app.
            MainDisplayController controller = loader.getController();
            controller.setMainApp(this, display);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Andrew used for updating mainDisplay without updating rootlayout
    public void showMainDisplay(String display, int[] arr) {
        try {
        	//Andrew handle setting buttons for this particular scene
        	fadeOut=false;
        	returnHome=false;
        	edit=true;
            // Load Main Display overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainDisplay2.fxml"));
            AnchorPane homePageOverview = (AnchorPane) loader.load();

            // Set Main Display overview into the center of root layout.
            rootLayout.setCenter(homePageOverview);

            // Give the controller access to the main app.
            MainDisplayController controller = loader.getController();
            controller.setMainApp(this, display);
            controller.setTable(arr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
  //Andrew display about menu dialog box when about button is clicked
    public void showAboutDialog() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/AboutDialogBox.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("About us");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

           

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            
        } catch (IOException e) {
            e.printStackTrace();            
        }
    }
    
    // Simple printing solution to help typing
    static void print(String string) {
    	System.out.println("\n\n" + string + "\n\n");
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

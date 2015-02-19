package restauto.manager.menu.levelc.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import restauto.manager.menu.levelc.MainApp;


public class PieChartReportController {

    @FXML
    private Button chartButtonA;
    @FXML
    private Button chartButtonB;
    @FXML
    private Button chartButtonC;
    @FXML
    private Button chartButtonD;
    @FXML
    private Button backButton;
    @FXML
    private PieChart pieChartA;
    
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PieChartReportController() {
    	
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        
        pieChartA.setData(pieChartData);
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
    	
    	//Save reference to main app
        this.mainApp = mainApp;
    }
	
	/**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleBackward() {
				
		mainApp.showHomePageOverview();
	}
 
}
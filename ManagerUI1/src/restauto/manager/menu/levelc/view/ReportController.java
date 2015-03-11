package restauto.manager.menu.levelc.view;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import restauto.manager.database.tools.MySQLDatabase;
import restauto.manager.menu.levelc.MainApp;
import restauto.manager.menu.levelc.model.Type;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import javafx.event.EventHandler;


public class ReportController {

    @FXML
    private Button chartButtonA;
    @FXML
    private Button chartButtonB;
    @FXML
    private Button chartButtonC;
    @FXML
    private Button chartButtonD;
    @FXML
    private Button backButtonA;
    @FXML
    private Button backButtonB;
    @FXML
    private PieChart pieChartA;
    //@FXML
    //private BarChart barChartA;
    
    
    @FXML
    private DatePicker startDateA;
    private LocalDate localStartDateA;
    @FXML
    private DatePicker endDateA;
    private LocalDate localEndDateA;
    
    
    
    @FXML
    private BarChart<String, Integer> barChart;
    @FXML
    private CategoryAxis xAxis;
    private ObservableList<String> monthNames = FXCollections.observableArrayList();
    
	@FXML
    private TableView<Type> reportTypeTable;
    @FXML
    private TableColumn<Type, String> nameColumn;
//    @FXML
//    private TableColumn<Type, Boolean> includeData;
    @FXML
    private Button updateButtonA;
    @FXML
    private Button updateButtonB;
    
    private final String pattern = "yyyy-MM-dd";
    
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public ReportController() {
    	
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
//    	//reportTypeTable.getItems().get(0).setChecked(true);
//        final TableColumn<Type, Boolean> checkedCol = new TableColumn<Type, Boolean>("Check");
//        reportTypeTable.getColumns().addAll(checkedCol);
//        checkedCol.setCellValueFactory(new PropertyValueFactory<Type, Boolean>("checked"));
//        
    	 //reportTypeTable.getColumns().addAll(includeData);
//    	 includeData.setCellValueFactory(new PropertyValueFactory<Type, Boolean>("checked"));
//    	 includeData.setCellFactory(CheckBoxTableCell.forTableColumn(includeData));
//    	 includeData.setEditable(true);
//    	 reportTypeTable.setEditable(true);

    	
    	
    	
    	
    	
    	nameColumn.setCellValueFactory(
                cellData -> cellData.getValue().getNameProperty());
    	
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");
        
    	MySQLDatabase database = new MySQLDatabase();
    	
    	//New
    	
    	String typesIncluded = "";
    	
    	//New
    	
    	List<Map<String, String>> queryResult = database.getItemsBought(true, typesIncluded);
    	
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
        for(Map<String, String> index: queryResult) {
        	PieChart.Data data = new PieChart.Data(index.get("NAME"), Integer.parseInt(index.get("NUMBER_SOLD")));
        	pieChartData.add(data);
        }
        
        pieChartA.setData(pieChartData);
        pieChartA.setLabelLineLength(20);
        pieChartA.setLegendSide(Side.LEFT);
        
        for (Node node : pieChartA.lookupAll(".text.chart-pie-label"))
        	if (node instanceof Text)
        	  for (PieChart.Data data : pieChartData)
        		  if (data.getName().equals(((Text) node).getText()))
        			  ((Text) node).setText("  " + data.getName() + " (" + String.format("%,.0f", data.getPieValue()) + ")  ");
        
    
    
    
     //-----------------------------------------------
        
        
        
        // Get an array with the English month names.
        //////////String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        // Convert it to a list and add it to our ObservableList of months.
        /////////monthNames.addAll(Arrays.asList(months));

        //////////xAxis.setCategories(monthNames);
        //////////setPersonData();
        
        
        
        
        
        
        
        
//        String austria = "Austria";
//        String brazil = "Brazil";
//        String france = "France";
//        String italy = "Italy";
//        String usa = "USA";
//    
//        XYChart.Series series1 = new XYChart.Series();
//        series1.setName("2003");       
//        series1.getData().add(new XYChart.Data(austria, 25601.34));
//        series1.getData().add(new XYChart.Data(brazil, 20148.82));
//        series1.getData().add(new XYChart.Data(france, 10000));
//        series1.getData().add(new XYChart.Data(italy, 35407.15));
//        series1.getData().add(new XYChart.Data(usa, 12000));      
//        
//        XYChart.Series series2 = new XYChart.Series();
//        series2.setName("2004");
//        series2.getData().add(new XYChart.Data(austria, 57401.85));
//        series2.getData().add(new XYChart.Data(brazil, 41941.19));
//        series2.getData().add(new XYChart.Data(france, 45263.37));
//        series2.getData().add(new XYChart.Data(italy, 117320.16));
//        series2.getData().add(new XYChart.Data(usa, 14845.27));  
//        
//        XYChart.Series series3 = new XYChart.Series();
//        series3.setName("2005");
//        series3.getData().add(new XYChart.Data(austria, 45000.65));
//        series3.getData().add(new XYChart.Data(brazil, 44835.76));
//        series3.getData().add(new XYChart.Data(france, 18722.18));
//        series3.getData().add(new XYChart.Data(italy, 17557.31));
//        series3.getData().add(new XYChart.Data(usa, 92633.68));  
//        
//        barChartA.getData().addAll(series1, series2, series3);
        
        //-------------------------------------------
        
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = 
                DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };   
        
        startDateA.setConverter(converter);
        endDateA.setConverter(converter);
        
        startDateA.setPromptText(pattern.toLowerCase());
        endDateA.setPromptText(pattern.toLowerCase());

        startDateA.requestFocus();
        endDateA.requestFocus();
    
    
    }
    
    
    
    
    
    
    /**
     * Sets the persons to show the statistics for.
     * 
     * @param persons
     */
    public void setPersonData() {
    	
        int[] monthCounter = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        XYChart.Series<String, Integer> series = createMonthDataSeries(monthCounter);
        barChart.getData().add(series);
    }
    
    /**
     * Creates a XYChart.Data object for each month. All month data is then
     * returned as a series.
     * 
     * @param monthCounter Array with a number for each month. Must be of length 12!
     * @return
     */
    private XYChart.Series<String, Integer> createMonthDataSeries(int[] monthCounter) {
        XYChart.Series<String,Integer> series = new XYChart.Series<String,Integer>();

        for (int i = 0; i < monthCounter.length; i++) {
            XYChart.Data<String, Integer> monthData = new XYChart.Data<String,Integer>(monthNames.get(i), monthCounter[i]);
            series.getData().add(monthData);
        }

        return series;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
    	
    	//Save reference to main app
        this.mainApp = mainApp;
        
        // Add observable list data to the table
        reportTypeTable.setItems(mainApp.getTypeData());
    }
	
	/**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleBackward() {
				
		mainApp.showHomePageOverview();
	}
	
	/**
	 * Called when the user clicks the update button.
	 * 
	 * Displays chart data based on the selected types
	 */
	@FXML
	private void handleUpdateA() {
		
    	MySQLDatabase database = new MySQLDatabase();
    	
    	//New
    	
    	String typesIncluded = "";
    	boolean isFirst = true;
    	
        for (Type type : reportTypeTable.getItems()) {
        	
        	if(type.getChecked()) {
        		System.out.println(type.getName() + " is Checked");
            	//System.out.println(" " + type.getID());
            	
        		if(isFirst) {
        			
        			typesIncluded = type.getID();
        			isFirst = false;
        		}
        		else
        			typesIncluded += ", " + type.getID();
        			
        	}
        	

        }
        
        System.out.println("\n");
    	
    	//New
    	
    	List<Map<String, String>> queryResult = database.getItemsBought(false, typesIncluded);
    	
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
        for(Map<String, String> index: queryResult) {
        	PieChart.Data data = new PieChart.Data(index.get("NAME"), Integer.parseInt(index.get("NUMBER_SOLD")));
        	pieChartData.add(data);
        	
        	System.out.println(index.get("NAME"));
        }
        
        System.out.println("\n\n");
        
        pieChartA.setData(pieChartData);
        pieChartA.setLabelLineLength(20);
        pieChartA.setLegendSide(Side.LEFT);
        
        for (Node node : pieChartA.lookupAll(".text.chart-pie-label"))
        	if (node instanceof Text)
        	  for (PieChart.Data data : pieChartData)
        		  if (data.getName().equals(((Text) node).getText()))
        			  ((Text) node).setText("  " + data.getName() + " (" + String.format("%,.0f", data.getPieValue()) + ")  ");
        
	}
	
	@FXML
	private void handleUpdateB() {
		
		//System.out.println("\n\nStart Date: " + localStartDateA.toString() + "End Date: " + localEndDateA);
		
		
		MySQLDatabase database = new MySQLDatabase();
		double salesAmount = database.getSales(localStartDateA.toString(), localEndDateA.toString());
		
		System.out.println("\n\n" + salesAmount + "\n\n");
		
        XYChart.Series<String,Integer> series = new XYChart.Series<String,Integer>();
        XYChart.Data<String, Integer> totalSales = new XYChart.Data<String,Integer>("Total Sales", 1);
        series.getData().add(totalSales);
        barChart.getData().add(series);
	}
	
	@FXML
	private void handleStartDateA() {
		
		localStartDateA = startDateA.getValue();
	}
	
	@FXML
	private void handleEndDateA() {
		
		localEndDateA = endDateA.getValue();
	}
 
}
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

 /**
 * This class is a subclass of view that will draw out the greenery tour page. It also presents the plant 
 * information page when a plant is selected and includes a slider to show back and forth between times
 * 
 * @author Lisa Pathania & Tara Fishman
 *
 */

/* Additional info: 
* in plant class, the function getDescr will be used to determine how this class will be presented 
* the button will also have to set model's current plant model.setCurrenPlant() model.getCurrentPlant().getDesc
* model.getCurrentPlant().inGarden = True; <-- will add to garden tile pane 
* getImage -- take image and get name or correspondfing img you want to read in
*/


public class ViewPage2 extends View {
	
	Scene scene2;
	
	int buttonWidth = 100;
	int buttonHeight = 100;
	
	int plantImgW = 300;
	int plantImgH = 300;
	
	int gButtonX = 400;
	
	Garden g = new Garden();
	ArrayList<Plant> allPlants = g.allPlants;	
	ArrayList<Plant> cList = new ArrayList<>();
	ArrayList<Plant> tList = new ArrayList<>();

	
		
	/**
	 * Description: Sets up the another stage of the application with background
	 * image & title. Adds Scene2 scene to the stage and creates the plant nursery as well as the apllication fo creating new tabs
	 * that will hold plant information
	 *
	 *@param Stage  a platform container to hold scene2 
	 */
	public ViewPage2(Stage theStage) {
		
		Image back = new Image("file:images/bg2.png");
		ImageView bg = new ImageView(back);
		

		bg.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
		bg.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
		BackgroundImage myBG = new BackgroundImage(back, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		
		VBox vb = new VBox(20); // assembles the title, tabs, and button 
		HBox hb = new HBox(20); // home button and go to garden button
		
		HBox tBox = new HBox(20); // holds flow pane & combo boxes (drop down)
		
		FlowPane flow = new FlowPane(); // assembles the plant buttons
		
		flow.setTranslateX(30);
		flow.setTranslateY(20);
		
		flow.setVgap(20);
	    flow.setHgap(35);
	    flow.setPrefWrapLength(sceneWidth - 130);
	    flow.setPrefHeight(sceneHeight + 200);
	    
	    
	    TabPane tabPane = new TabPane();
	    Tab nTab = new Tab(); 
	    nTab.setText("Nursery Plant Selection");
	    
	    // creates tabs for all the plants linked with button
	    for (int i = 1; i < allPlants.size(); i++) {
	    	
	    	Button b1 = new Button();
	    	
	    	b1.setGraphic(new ImageView(new Image(allPlants.get(i).getImgName(), 
	    			buttonWidth, buttonHeight, false, false))); 
	    	
	    	flow.getChildren().addAll(b1);	    	
	    	
			Tab t = new Tab(); 
			b1.setOnAction(e -> tabPane.getTabs().addAll(t));
			setTabInfo(allPlants.get(i), t);
			
	    }
	    
	    tabPane.getTabs().add(nTab); // main tab with plant buttons
	    
	    tBox.getChildren().addAll(flow, getDropDown());
	    
		nTab.setContent(tBox);
		
		ScrollPane sc = new ScrollPane(vb);
		sc.setPrefViewportHeight(sceneHeight + 100);
		sc.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


		Label label2 = new Label("Greenery Tour");
		label2.setFont(new Font("Arial", 20));
		label2.setTranslateX(400);
	 	label2.setTranslateY(10);
	 		 	
	 	Button go = new Button("Go to Garden");
	 	
	 	hb.getChildren().addAll(label2, homeButton, go);
		vb.getChildren().addAll(hb, tabPane); 
		sc.setContent(vb);

		vb.setBackground(new Background(myBG));

		 homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1())); 
		 go.setOnAction(e -> theStage.setScene(new ViewPage4(theStage).getScene4()));
		 
		 scene2 = new Scene(sc, sceneWidth, sceneHeight);	
		
	   	theStage.setScene(scene2); 
	   	  theStage.show(); 		

		
	} 
	
	/**
	 * Description: Creates a new tab with plant info when specified plant button is clicked
	 * 
	 * @param	Plant Calls a plant's name, image, and description
	 * 		 	Tab  Holds the plant information
	 */
	public void setTabInfo(Plant p, Tab t) {
		VBox pInfo = new VBox(20);

		Text name = new Text(p.getName());
		name.setTranslateX(250);
		name.setTranslateY(20);

		name.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, fontSize));
		name.setFill(Color.WHITE); 
		name.setStrokeWidth(2); 
		name.setStroke(Color.BLUE);
		    
		t.setText(p.getName());
		
		ImageView planImg =  new ImageView(new Image(p.getImgName(), 
    			plantImgW, plantImgH, false, false));
		
		planImg.setTranslateX(plantImgW);

		Text desc = new Text(p.getDesc());
		
		Button g = new Button("Add to Garden");
		g.setTranslateX(gButtonX);
		g.setOnAction(e -> myPlants.add(p)); // adds to the user's plant arraylist
		
		pInfo.getChildren().addAll(name, planImg, g, desc);
		
		t.setContent(pInfo); // adds all plant info to tab
		
	}
	/**
	 * Description: Creates a VBox with contents of all filter options for plants
	 * 
	 * @return	VBox  Returns all the Combo boxes in a vertical format
	 */
	Boolean color;
	Boolean type;
	Boolean ht;
	Boolean fruit;
	Boolean water;
	Boolean month;


	public VBox getDropDown() {
		VBox v = new VBox(20);

		// a combo box = drop down to select a choice
		ComboBox<String> colorBox = new ComboBox<>();
		colorBox.getItems().addAll("white", "red", "pink", "orange", "yellow", "green", "blue", "purple", "none");
		colorBox.setValue("Color");
		colorBox.valueProperty().addListener(new ChangeListener<String>() {
           
			@Override 
            public void changed(ObservableValue ov, String t, String t1) {                
        		cList = g.Filter("color", (String) ov.getValue());
        		color = true;
        		for (Plant c: cList) {
            		System.out.println(c.getName());
                }            }    
        });
		
		ComboBox<String> typeBox = new ComboBox<>();
		typeBox.getItems().addAll("herb", "shrub", "tree");
		typeBox.setValue("Type");
		typeBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String t, String t1) {                
        		cList = g.Filter("type", (String) ov.getValue());
        		type = true;
        		
        		for (Plant c: cList) {
        		System.out.println(c.getName());
            }    
            }
        });
		
		ComboBox<String> htBox = new ComboBox<>();
		htBox.getItems().addAll("0-10", "10-20", "20-30", "30-40", "40+");
		htBox.setValue("Height");

		ComboBox<String> fruitBox = new ComboBox<>();
		fruitBox.getItems().addAll("Fruit", "No Fruit");
		fruitBox.setValue("Fruit");
		
		ComboBox<String> waterBox = new ComboBox<>();	
		waterBox.getItems().addAll("Low", "Medium", "High");
		waterBox.setValue("Water Usage");

		ComboBox<String> monthBox = new ComboBox<>();	
		monthBox.getItems().addAll("Jan", "Feb", "March",
				"April", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec");
		monthBox.setValue("Start Month");

		v.getChildren().addAll(colorBox, typeBox, htBox, fruitBox, waterBox, monthBox);
		
		
		return v;
		
	}
	
	 
	/**
	 * Description: basic getter for the scene in order to receive it when buttons are pressed on home screens 
	 * 
	 * @return scene2
	 */
	public Scene getScene2() {
		return scene2;
	}
	
	/**
	 * Description: This function takes in the current plant and creates a file and image that
	 * will be presented as a button
	 * 
	 * @param name based on the plant currently on
	 * @return String of data based on the plant
	 * @throws Exception
	 * 
	 */
	 public String createImage(String name) throws Exception {
		 String file = new String("plantImg/" + name + ".txt"); 
		 String data = ""; 
		 
		 data = new String(Files.readAllBytes(Paths.get(file))); 
		 return data;
	  }

	 

}

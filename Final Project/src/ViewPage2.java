import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
*/

public class ViewPage2 extends View {
	
	Scene scene2;
		
	int flowX = 30;
	int flowY = 20;
	int flowGapV = 20;
	int flowGapH = 35;
	int flowWrap = sceneWidth - 140;
	int flowPrefH = sceneHeight + 200;
	
	int scrollPrefH = sceneHeight + 100;
	int addButtonX = 400;
	
	int nameX = 250;
	int nameY = 20;
	
	int titleX = 220;
	
	int dboxSize = 35;
	int dPrefWidth = 100;
	
	Boolean color;
	Boolean type;
	Boolean ht;
	Boolean fruit;
	Boolean water;
	Boolean start;
		
	ArrayList<Plant> cList = new ArrayList<>();
 	Button garButton = new Button("Go to Garden");
 	Button addButton;
 	
	VBox vb = new VBox(boxSize); // assembles the title, tabs, and button 
	HBox hb = new HBox(); // holds home button and go to garden button
	HBox dropBox = new HBox(boxSize); // holds flow pane & combo boxes (drop down)
    
    TabPane tabPane = new TabPane();
    Tab mainTab = new Tab(); 
    
		
	/**
	 * Description: Sets up the another stage of the application with background
	 * image & title. Adds Scene2 scene to the stage and creates the plant nursery as well as the apllication fo creating new tabs
	 * that will hold plant information
	 *
	 *@param Stage  a platform container to hold scene2 
	 */
	public ViewPage2(Stage theStage) {
		
	    mainTab.setText("Nursery Plant Selection");
	    tabPane.getTabs().add(mainTab); // main tab with plant buttons
	    
	    dropBox.getChildren().addAll(setButtons(tabPane, allPlants), getDropDown());
		mainTab.setContent(dropBox);
		mainTab.setClosable(false);
		
		ScrollPane sc = new ScrollPane(vb);
		sc.setPrefViewportHeight(scrollPrefH);
		sc.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

		Text title = new Text("Greenery Tour");
		title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, fontSize));
		title.setFill(Color.WHITE); 
	    title.setStrokeWidth(strokeWidth); 
		title.setStroke(Color.BLUE);
		title.setTranslateX(titleX);
		    
	 	hb.getChildren().addAll(homeButton, title, garButton);
		vb.getChildren().addAll(hb, tabPane); 
		sc.setContent(vb);
		
		vb.setBackground(new Background(myBG));
		
		homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1())); 
		garButton.setTranslateX(addButtonX); 
		garButton.setOnAction(e -> theStage.setScene(new ViewPage4(theStage).getScene4()));
		
		scene2 = new Scene(sc, sceneWidth, sceneHeight);	
	   	theStage.setScene(scene2);
	   	theStage.show(); 		
		
	} 
	
	/**
	 * Description: Creates tabs for all the plants linked with button
	 * 
	 * @param	TabPane   Contains main tab and all tabs created for each plant 
	 * @return 	FlowPane  Organizes the layout of plant buttons on the main tab
	 * 
	 * 	 */
	public FlowPane setButtons(TabPane tabPane, ArrayList<Plant> alst) {
		
		FlowPane flow = new FlowPane(); 
		
		flow.setTranslateX(flowX);
		flow.setTranslateY(flowY);
		
		flow.setVgap(flowGapV);
	    flow.setHgap(flowGapH);
	    
	    flow.setPrefWrapLength(flowWrap);
	    flow.setPrefHeight(flowPrefH);
	    
		// if filter then use cList size
	    for (int i = 1; i < alst.size(); i++) {
	    	
	    	Button b1 = new Button();
			Plant p = allPlants.get(i);  
	    	
	    	b1.setGraphic(new ImageView(new Image(p.getImgName(), 
	    			buttonWidth, buttonHeight, false, false))); 
	    	
			b1.setTooltip(new Tooltip(p.greeneryHover()));

	    	
	    	flow.getChildren().addAll(b1);	    	
	    	
			Tab t = new Tab(); 
			b1.setOnAction(e -> tabPane.getTabs().addAll(t));
			
			setTabInfo(p, t);		
			addButton.setOnAction(e -> { 
				myPlants.add(p); // adds to the user's plant arraylist
			
			//	for (Plant k: myPlants) 
			//		System.out.print(k.getName() + ", ");
				 });
			}
		return flow;
	}
	
	
	/**
	 * Description: Creates a new tab with plant info when specified plant button is clicked
	 * 
	 * @param	Plant Calls a plant's name, image, and description
	 * 		 	Tab  Holds the plant information
	 */
	public void setTabInfo(Plant p, Tab t) {
		
		VBox pInfo = new VBox(boxSize);

		Text name = new Text(p.getName());
		name.setTranslateX(nameX);
		name.setTranslateY(nameY);

		name.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, fontSize));
		name.setFill(Color.WHITE); 
	    name.setStrokeWidth(strokeWidth); 
		name.setStroke(Color.BLUE);
		    
		t.setText(p.getName());
		
		ImageView planImg =  new ImageView(new Image(p.getImgName(), 
    			imgWidth, imgHeight, false, false));
		
		planImg.setTranslateX(imgWidth);

		Text desc = new Text(p.getDesc());
		
		addButton = new Button("Add to Garden");
		addButton.setTranslateX(addButtonX);

		pInfo.getChildren().addAll(name, planImg, addButton, desc);
		
		t.setContent(pInfo); // adds all plant info to tab
		
	}
	
	/**
	 * Description: Creates a VBox with contents of all filter options for plants; 
	 *  a combo box = drop down to select a choice

	 * 
	 * @return	VBox  Returns all the Combo boxes in a vertical format
	 */
	public VBox getDropDown() {
		VBox v = new VBox(dboxSize);
		v.setTranslateY(20);

		ComboBox<String> colorBox = new ComboBox<>();
		colorBox.getItems().addAll("white", "red", "pink", "orange", "yellow", "green", "blue", "purple", "none");
		colorBox.setValue("Color");
		colorBox.setPrefWidth(dPrefWidth);
		colorBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override 
            public void changed(ObservableValue ov, String t, String t1) {                
        		cList = g.Filter("color", (String) ov.getValue());
        		setButtons(tabPane, cList);
        		color = true;         
        	}    
        });
		
		ComboBox<String> typeBox = new ComboBox<>();
		typeBox.getItems().addAll("herb", "shrub", "tree");
		typeBox.setValue("Type");
		typeBox.setPrefWidth(dPrefWidth);
		typeBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String t, String t1) {                
        		cList = g.Filter("type", (String) ov.getValue());
        		type = true;       	  
          }
        });
		
		ComboBox<String> htBox = new ComboBox<>();
		htBox.getItems().addAll("0-10 ft", "10-20 ft", "20-30 ft", "30-40 ft", "40+ ft");
		htBox.setValue("Height");
		htBox.setPrefWidth(dPrefWidth);
		htBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String t, String t1) {                
        		cList = g.Filter("height", (String) ov.getValue());
        		ht = true;    
          }
        });

		ComboBox<String> fruitBox = new ComboBox<>();
		fruitBox.getItems().addAll("Fruit", "No Fruit");
		fruitBox.setValue("Fruit");
		fruitBox.setPrefWidth(dPrefWidth);
		fruitBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String t, String t1) {                
        		cList = g.Filter("hasFruit", (String) ov.getValue());
        		fruit = true;  
          }
        });
		
		ComboBox<String> waterBox = new ComboBox<>();	
		waterBox.getItems().addAll("Low", "Medium", "High");
		waterBox.setValue("Water");
		waterBox.setPrefWidth(dPrefWidth);
		waterBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String t, String t1) {                
        		cList = g.Filter("waterUse", (String) ov.getValue());
        		water = true;   
          }
        });

		ComboBox<String> monthBox = new ComboBox<>();	
		monthBox.getItems().addAll("January", "February", "March",
				"April", "May", "June", "July", "August", "September", "October", "November", "December");
		monthBox.setValue("Start");
		monthBox.setPrefWidth(dPrefWidth);
		monthBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String t, String t1) {                
        		cList = g.Filter("start", (String) ov.getValue());
        		start = true;    
          }
        });

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
	
}

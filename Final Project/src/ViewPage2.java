import java.util.ArrayList;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.stage.Stage;

 /**
 * This class is a subclass of view that will draw out the greenery tour page. It also presents the plant 
 * information page when a plant is selected and a "add to garden" button to add a specified plant to garden. 
 * 
 * @author Lisa Pathania & Tara Fishman
 *
 */

public class ViewPage2 extends View {
	
	Scene scene2;
		
	int flowX = 30;
	int flowY = 20;
	int flowGapV = 20;
	int flowGapH = 35;
	int flowWrap = sceneWidth - 150;
	int flowPrefH = sceneHeight + 200;
	
	int scrollPrefH = sceneHeight + 600;
	int addButtonX = 400;
	
	int nameX = 250;
	int nameY = 20;
	int titleX = 220;
	
	int dboxSize = 35;
	int dPrefWidth = 100;

 	Button garButton = new Button("Go to Garden");
	Button reset =  new Button("Reset");
	Text title = new Text("Greenery Tour");
	Image back = new Image("file:images/bg2.png", sceneWidth+1000, sceneHeight+1200, false, false);
	
	String alert = "Welcome to the Plant Nursery! Click on a plant you would like to"
		+ " view and go into the tab to add to garden! To filter plants based on different "
		+ "requirements, view the filters to the right. When ready, click go to garden.";
	
	String colorPick = "Color";
	String typePick = "Type";
	String htPick = "Height";
	String fruitPick = "Fruit";
	String waterPick = "Water";
	String monthPick = "Month";
	
	ViewPage4 vp4; 
	ArrayList<Plant> filteredPlants = g.allPlants;
	
	VBox vb = new VBox(boxSize); // assembles the title, tabs, and button 
	HBox hb = new HBox(); // holds home button and go to garden button
	HBox dropBox = new HBox(boxSize); // holds flow pane & combo boxes (drop down)

    TabPane tabPane = new TabPane();
    Tab mainTab = new Tab(); 
	ScrollPane sc = new ScrollPane(vb);
	

	/**
	 * Description: Sets up the another stage of the application with background
	 * image & title. Adds Scene2 scene to the stage and creates the plant nursery as well as the apllication fo creating new tabs
	 * that will hold plant information
	 *
	 *@param Stage  a platform container to hold scene2 
	 */
	public ViewPage2(Stage theStage) {
		
		vp4 = new ViewPage4(theStage);
		
		myBG = new BackgroundImage(back, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		setPlantNursery();
		
		Alert explain = new Alert(AlertType.INFORMATION);
		explain.setContentText(alert);
		explain.show();
		
		garButton.setTranslateX(addButtonX);
		
		homeButton.setOnAction(e -> control.goHomeButton(theStage, 1));
		garButton.setOnAction(e -> control.setGardButton(theStage, vp4)); 
							
	   	theStage.setScene(scene2);
	   	theStage.show(); 			
	} 
	
	/**
	 * Description: assembles all content for the Plant Nursery Page, it holds the main tab with all plant buttons (60)
	 * It also has the title, home button, go to garden button, scrollbar all on the main tab. It sets the
	 *  scene and background.
	 */
	public void setPlantNursery() {
		
	    mainTab.setText("Nursery Plant Selection");
	    tabPane.getTabs().add(mainTab); // main tab with plant buttons
		    
	    dropBox.getChildren().addAll(setButtons(tabPane, allPlants), getDropDown());
	    
		mainTab.setContent(dropBox);
		mainTab.setClosable(false);
		
		sc.setPrefViewportHeight(scrollPrefH);
		sc.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

		title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, fontSize));
		title.setFill(Color.WHITE); 
	    title.setStrokeWidth(strokeWidth); 
		title.setStroke(Color.BLUE);
		title.setTranslateX(titleX);
		    
	 	hb.getChildren().addAll(homeButton, title, garButton);
	 	vb.getChildren().addAll(hb, tabPane); 
		sc.setContent(vb);
		
		vb.setBackground(new Background(myBG));

		scene2 = new Scene(sc, sceneWidth, sceneHeight);
		scene2.setCursor(new ImageCursor(mouse));

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
	    
	    for (int i = 0; i < alst.size(); i++) {
	    	
	    	Button b1 = new Button();
			Plant p = alst.get(i);  
			
	    	b1.setGraphic(new ImageView(new Image(p.getImgName("original"), 
	    			buttonWidth, buttonHeight, false, false))); 
	    	
			b1.setTooltip(new Tooltip(p.greeneryHover()));
	    	
	    	flow.getChildren().addAll(b1);	    	
	    	
			Tab t = new Tab(); 
			b1.setOnAction(e -> tabPane.getTabs().addAll(t));
			
			setTabInfo(p, t);
				 
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
		
		ImageView planImg =  new ImageView(new Image(p.getImgName("original"), 
    			imgWidth, imgHeight, false, false));
		
		planImg.setTranslateX(imgWidth);

		Text desc = new Text(p.getDesc());
		
		Button addButton = new Button("Add to Garden");
		addButton.setTranslateX(addButtonX);			
		addButton.setOnAction(e -> control.setMyPlants(p));
				   	  
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
		colorBox.setValue(colorPick);
		colorBox.setPrefWidth(dPrefWidth);
		colorBox.setOnAction(e -> control.getFilter(this, colorBox, this.filteredPlants, colorPick,
				g, tabPane, dropBox, mainTab, getDropDown()));

		ComboBox<String> typeBox = new ComboBox<>();
		typeBox.getItems().addAll("herb", "shrub", "tree");
		typeBox.setValue(typePick);
		typeBox.setPrefWidth(dPrefWidth);		
		typeBox.setOnAction(e-> control.getFilter(this, typeBox, this.filteredPlants, typePick, g,
			tabPane, dropBox, mainTab, getDropDown()));
	
		ComboBox<String> htBox = new ComboBox<>();
		htBox.getItems().addAll("0-10 ft", "10-20 ft", "20-30 ft", "30-40 ft", "40+ ft");
		htBox.setValue(htPick);
		htBox.setPrefWidth(dPrefWidth);
		htBox.setOnAction(e-> control.getFilter(this, htBox, this.filteredPlants, htPick, g, 
			tabPane, dropBox, mainTab, getDropDown())); 

		ComboBox<String> fruitBox = new ComboBox<>();
		fruitBox.getItems().addAll("True", "False");
		fruitBox.setValue(fruitPick);
		fruitBox.setPrefWidth(dPrefWidth);
		fruitBox.setOnAction(e-> control.getFilter(this, fruitBox, this.filteredPlants, fruitPick, g,
				tabPane, dropBox, mainTab, getDropDown()));
		
		
		ComboBox<String> waterBox = new ComboBox<>();	
		waterBox.getItems().addAll("low", "medium", "high");
		waterBox.setValue(waterPick);
		waterBox.setPrefWidth(dPrefWidth);
		waterBox.setOnAction(e-> control.getFilter(this, waterBox, this.filteredPlants, waterPick, g,
				tabPane, dropBox, mainTab, getDropDown()));
		
		ComboBox<String> monthBox = new ComboBox<>();	
		monthBox.getItems().addAll("January", "February", "March",
				"April", "May", "June", "July", "August", "September", "October", "November", "December");
		monthBox.setValue(monthPick);
		monthBox.setPrefWidth(dPrefWidth);
		monthBox.setOnAction(e-> control.getFilter(this, monthBox, this.filteredPlants, monthPick, g,
				tabPane, dropBox, mainTab, getDropDown()));

		
		reset.setOnAction(e -> control.updateNursery(this, g.allPlants, g, tabPane, dropBox, mainTab, getDropDown(), true));

		v.getChildren().addAll(colorBox, typeBox, waterBox, fruitBox, htBox, monthBox, reset);	
		
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
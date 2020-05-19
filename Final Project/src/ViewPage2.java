import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.MouseEvent;
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
	Button addButton =  new Button("Add to Garden");
	Button reset =  new Button("Reset");
	Text title = new Text("Greenery Tour");
	Image back = new Image("file:images/bg2.png", sceneWidth+1000, sceneHeight+1200, false, false);
	
	ViewPage4 vp4; 
    Controller c = new Controller();
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
		explain.setContentText("Welcome to the Plant Nursery! Click on a plant you would like to"
				+ " view and go into the tab to add to garden! To filter plants based on different requirements, "
				+ "view the filters to the right. When ready, click go to garden.");
		explain.show();
		
		garButton.setTranslateX(addButtonX); 
		homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1())); 
		garButton.setOnAction( new EventHandler<ActionEvent>() { 
			   public void handle(ActionEvent event) { 
				 				    
					theStage.setScene(vp4.getScene4());
				    vp4.setMyPlants(c.getMyPlants());
				    } 
				});
		  
							
	   	theStage.setScene(scene2);
	   	theStage.show(); 			
	} 
	
	
	
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
	    
		// if filter then use cList size
	    for (int i = 0; i < alst.size(); i++) {
	    	
	    	Button b1 = new Button();
			Plant p = alst.get(i);  
			
	    	
	    	b1.setGraphic(new ImageView(new Image(p.getImgName(), 
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
		
		ImageView planImg =  new ImageView(new Image(p.getImgName(), 
    			imgWidth, imgHeight, false, false));
		
		planImg.setTranslateX(imgWidth);

		Text desc = new Text(p.getDesc());
		
		Button addButton =  new Button("Add to Garden");
		addButton.setTranslateX(addButtonX);
		
		addButton.setOnAction(new EventHandler<ActionEvent>() { 
			   public void handle(ActionEvent event) { 
				 c.setMyPlants(p);
				   } 
				});
		  
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

		colorBox.setOnAction((event) -> {
		   String colorPick = colorBox.getSelectionModel().getSelectedItem(); 
		   this.filteredPlants = g.Filter("color", colorPick, this.filteredPlants);
		   
		       dropBox.getChildren().clear();
		       dropBox.getChildren().addAll(setButtons(tabPane, this.filteredPlants), getDropDown());
		       
		       mainTab.setContent(dropBox);

		    for (Plant p: this.filteredPlants)
		    System.out.print(p.getName() + ", ");
		});

		ComboBox<String> typeBox = new ComboBox<>();
		typeBox.getItems().addAll("herb", "shrub", "tree");
		typeBox.setValue("Type");
		typeBox.setPrefWidth(dPrefWidth);
		typeBox.setOnAction((event) -> {

		String typePick = typeBox.getSelectionModel().getSelectedItem();
		
		this.filteredPlants = g.Filter("type", typePick, this.filteredPlants);
				       
		        dropBox.getChildren().clear();
		        dropBox.getChildren().addAll(setButtons(tabPane, this.filteredPlants), getDropDown());
		       
		        mainTab.setContent(dropBox);
		       
		        for (Plant p: this.filteredPlants)
		        System.out.print(p.getName() + ", ");
		       
		        });
	
	//	
		ComboBox<String> htBox = new ComboBox<>();
		htBox.getItems().addAll("0-10 ft", "10-20 ft", "20-30 ft", "30-40 ft", "40+ ft");
		htBox.setValue("Height");
		htBox.setPrefWidth(dPrefWidth);
		htBox.setOnAction((event) -> {

			String htPick = htBox.getSelectionModel().getSelectedItem();

			switch(htPick) {
			case("0-10"):
				this.filteredPlants = g.Filter("height", "0", this.filteredPlants);
			case("10-20"):
				this.filteredPlants = g.Filter("height", "10", this.filteredPlants);
			case("20-30"):
				this.filteredPlants = g.Filter("height", "20", this.filteredPlants);
			case("30-40"):
				this.filteredPlants = g.Filter("height", "30", this.filteredPlants);
			case("40+"):
				this.filteredPlants = g.Filter("height", "40", this.filteredPlants);
			}
			
			        dropBox.getChildren().clear();
			        dropBox.getChildren().addAll(setButtons(tabPane, this.filteredPlants), getDropDown());
			       
			        mainTab.setContent(dropBox);
			       
			        for (Plant p: this.filteredPlants)
			        System.out.print(p.getName() + ", ");
		        
        }); 

		ComboBox<String> fruitBox = new ComboBox<>();
		fruitBox.getItems().addAll("True", "False");
		fruitBox.setValue("Fruit");
		fruitBox.setPrefWidth(dPrefWidth);
		fruitBox.setOnAction((event) -> {

			String fruitPick = fruitBox.getSelectionModel().getSelectedItem();
			
			this.filteredPlants = g.Filter("hasFruit", fruitPick, this.filteredPlants);

			        dropBox.getChildren().clear();
			        dropBox.getChildren().addAll(setButtons(tabPane, this.filteredPlants), getDropDown());
			       
			        mainTab.setContent(dropBox);
			       
			      /*  for (Plant p: this.filteredPlants)
			        System.out.print(p.hasFruit == true);*/
			       
			        });  
		
		
		ComboBox<String> waterBox = new ComboBox<>();	
		waterBox.getItems().addAll("low", "medium", "high");
		waterBox.setValue("Water");
		waterBox.setPrefWidth(dPrefWidth);
		waterBox.setOnAction((event) -> {

			String waterPick = waterBox.getSelectionModel().getSelectedItem();
			
			this.filteredPlants = g.Filter("waterUse", waterPick, this.filteredPlants);

			        dropBox.getChildren().clear();
			        dropBox.getChildren().addAll(setButtons(tabPane, this.filteredPlants), getDropDown());
			       
			        mainTab.setContent(dropBox);
			       
			        for (Plant p: this.filteredPlants)
			        System.out.print(p.getName() + ", ");
			       
			        });
		
		ComboBox<String> monthBox = new ComboBox<>();	
		monthBox.getItems().addAll("January", "February", "March",
				"April", "May", "June", "July", "August", "September", "October", "November", "December");
		monthBox.setValue("Month");
		monthBox.setPrefWidth(dPrefWidth);
		monthBox.setOnAction((event) -> {

			String monthPick = monthBox.getSelectionModel().getSelectedItem();
			
			switch(monthPick) {
			case "January":
				this.filteredPlants = g.Filter("start", "1", this.filteredPlants);
				break;
			case "February":
				this.filteredPlants = g.Filter("start", "2", this.filteredPlants);
				break;
			case "March":
				this.filteredPlants = g.Filter("start", "3", this.filteredPlants);
				break;
			case "April":
				this.filteredPlants = g.Filter("start", "4", this.filteredPlants);
				break;
			case "May":
				this.filteredPlants = g.Filter("start", "5", this.filteredPlants);
				break;
			case "June":
				this.filteredPlants = g.Filter("start", "6", this.filteredPlants);
				break;
			case "July":
				this.filteredPlants = g.Filter("start", "7", this.filteredPlants);
				break;
			case "August":
				this.filteredPlants = g.Filter("start", "8", this.filteredPlants);
				break;
			case "September":
				this.filteredPlants = g.Filter("start", "9", this.filteredPlants);
				break;
			case "October":
				this.filteredPlants = g.Filter("start", "10", this.filteredPlants);
				break;
			case "November":
				this.filteredPlants = g.Filter("start", "11", this.filteredPlants);
				break;
			case "December":
				this.filteredPlants = g.Filter("start", "12", this.filteredPlants);
				break;
			}

			       
			        dropBox.getChildren().clear();
			        dropBox.getChildren().addAll(setButtons(tabPane, this.filteredPlants), getDropDown());
			       
			        mainTab.setContent(dropBox);
			       
			        for (Plant p: this.filteredPlants)
			        System.out.print(p.getName() + ", ");
			       
			        });
		

		reset.setOnAction((event) -> {
			
			this.filteredPlants = g.allPlants;

	        dropBox.getChildren().clear();
	        dropBox.getChildren().addAll(setButtons(tabPane, this.filteredPlants), getDropDown());
	       
	        mainTab.setContent(dropBox);
	        });
		

		v.getChildren().addAll(colorBox, typeBox,  waterBox, fruitBox, htBox, monthBox, reset);
		
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

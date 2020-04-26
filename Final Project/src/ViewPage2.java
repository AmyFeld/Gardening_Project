import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

// This class is a subclass of view that will draw out the greenery tour page

public class ViewPage2 extends View {
	Scene scene2;	
	int count = 0;

	
	public ViewPage2(Stage theStage) {
		
		Image back = new Image("file:bg2.png");
		ImageView bg = new ImageView(back);
		System.out.println(Screen.getPrimary().getVisualBounds().getWidth());
		bg.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
		bg.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
		BackgroundImage myBG= new BackgroundImage(back, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		
		VBox layout2 = new VBox(20); // assembles the title, tabs, and button vertically
		HBox layout3 = new HBox(20);
		
		FlowPane flow = new FlowPane();
		
		flow.setTranslateX(30);
		flow.setTranslateY(120);
		
		flow.setVgap(100);
	    flow.setHgap(100);
	    flow.setPrefWrapLength(200);
		
	    TabPane tabPane = new TabPane();
	    
	    Tab nTab = new Tab(); // main tab
	    nTab.setText("Nursery Plant Selection");

	    // creates tabs for all the plants linked with button
	    for (int i = 0; i < 15; i++) {
	    	Button b1 = new Button("Plant" + ++count); // modify for the correct name of plant
	    	flow.getChildren().addAll(b1);
	    	//flow.getChildren().add(add);
	    	
	    	
			Tab t = new Tab(); 
			t.setText("Plant" + count);
			//At.getTabPane().add
	        b1.setOnAction(e -> tabPane.getTabs().addAll(t));
	
	    }
	    
	    // Tab tab1 = tabPane.getTabs().get(0); // access the tabs individually and add info
	    // another method is to use a for loop for the arraylist of plant images, names, etc
	    // gives errors for now (out of bounds)
	    
    	//Button add = new Button("Add to Garden");

	    
	    tabPane.getTabs().add(nTab);
	    
		nTab.setContent(flow);
		//nTab.setContent(add);


		Label label2 = new Label("Greenery Tour");
		label2.setFont(new Font("Arial", 20));
		label2.setTranslateX(400);
	 	label2.setTranslateY(10);
	 	
	 	 Button homeButton = new Button("home");
	 	
	 	Button go = new Button("Go to Garden");
				
	 	layout3.getChildren().addAll(homeButton, go);
		 layout2.getChildren().addAll(label2, tabPane, layout3); 
		 layout2.setBackground(new Background(myBG));
		 

		 
		 homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1())); // go back to the original screen
		 go.setOnAction(e -> theStage.setScene(new ViewPage4(theStage).getScene4()));//System.out.println("Go Pressed"));//theStage.setScene(new ViewPage4(theStage).getScene4()));
		 scene2 = new Scene(layout2, 900, 600);	
		
	   	theStage.setScene(scene2); 
	   	  theStage.show(); 		

		
	} 
	
	public Scene getScene2() {
		return scene2;
	}
	

	/*
	Map<String, Plant> plantCollection = new HashMap<String, Plant>();	
	
	/*
	 * Input: takes in a name
	 * Output: none
	 * Function: the chosen plant is added to the collection
	 
	public void chosenPlant(String name) {		
		Plant plant = getPlant(name);
		plantCollection.put(name, plant);
		
	}
	
	/*
	 * Input: the color
	 * Output: string of color
	 * Function: sorts on the color of the plant 
	 
	public String selectColor(String color) {
		//iterate through icons of color and displays plants of color selected
	}
	
	/*
	 * Input: none
	 * Output: none
	 * Function: getter for the plant 
	 
	public Plant getPlant() {
		return p;
	}
	*/
	
	 

}

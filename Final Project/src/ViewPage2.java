import java.awt.Button;
import java.beans.EventHandler;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// This class is a subclass of view that will draw out the greenery tour page

public class ViewPage2 extends View {
	Scene scene2;	
	
	public ViewPage2(Stage theStage) {
		VBox layout2 = new VBox(20);
		Label label2 = new Label("Greenery Tour");
		layout2.getChildren().addAll(label2, homeButton); 
		
		homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1())); // go back to the original screen
		
		scene2 = new Scene(layout2, 600, 300);	
		
	   	theStage.setScene(scene2); 
	   	  theStage.show(); 		

		
	} 
	
	public Scene getScene2() {
		return scene2;
	}
	

	/*
	Map<String, Plant> plantCollection = new HashMap<String, Plant>();
	
	Button bColor  = new Button("Color");
	// bColor.setOnAction(SSButton);
	
	
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

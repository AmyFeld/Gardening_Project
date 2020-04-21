import java.awt.Button;
import java.beans.EventHandler;
import java.util.HashMap;
import java.util.Map;

// This class is a subclass of view that will draw out the greenery tour page

public class ViewPage2 {
	
	Plant p;

	
	public ViewPage2(Stage theStage, EventHandler<ActionEvent> SSButton) {
        theStage.setTitle("Rate My Garden");
	} 
	
	
	Map<String, Plant> plantCollection = new HashMap<String, Plant>();
	
	Button bColor  = new Button("Color");
	// bColor.setOnAction(SSButton);
	
	
	/*
	 * Input: takes in a name
	 * Output: none
	 * Function: the chosen plant is added to the collection
	 */
	public void chosenPlant(String name) {		
		Plant plant = getPlant(name);
		plantCollection.put(name, plant);
		
	}
	
	/*
	 * Input: the color
	 * Output: string of color
	 * Function: sorts on the color of the plant 
	 */
	public String selectColor(String color) {
		//iterate through icons of color and displays plants of color selected
	}
	
	/*
	 * Input: none
	 * Output: none
	 * Function: getter for the plant 
	 */
	public Plant getPlant() {
		return p;
	}

	
	
	 

}

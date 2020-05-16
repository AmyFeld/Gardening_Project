import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.Serializable;
import javafx.scene.Node;
/**
 * This class communicates with the controller to tell the view the current state of the Garden,
 *  the current plant and the triggering of garden
 * 
 * @author Tara Fishman
 *
 */

public class Model implements Serializable{
	
	Boolean startGardening = false;
	
	Garden currentGarden = new Garden();
	Plant currentPlant;
	
		double modelX;
	double modelY;
	
	/**
	 * Description: This is a setter for the Garden attribute in Model
	 * 
	 * @param Garden. used for setting the Model's current Garden
	 * @return. void
	 * @throws no exception
	 */
	public void setGarden(Garden g){
		currentGarden = g;
	}
	
	/**
	 * Description: This is a setter for the Plant attribute in Model
	 * 
	 * @param Plant. used for setting the Model's current Plant
	 * @return. void
	 * @throws no exception
	 */
	public void setPlant(Plant p){
		currentPlant = p;
	}
	
	/**
	 * Description: This is a getter for the Plant attribute in Model
	 * 
	 * @param none
	 * @return. Plant. the Model's currently selected plant
	 * @throws no exception
	 */
	public Plant getPlant(){
		return currentPlant;
	}
	
	/**
	 * Description: This is a getter for the Garden attribute in Model
	 * 
	 * @param none
	 * @return. Garden. The model's current Garden
	 * @throws no exception
	 */
	
	public Garden getGarden(){
		return currentGarden;
	}
	
	
	/**
	 * Description: rateGarden takes in the arraylist of used plants and returns all rating in an arraylist,
	 * including overall rating
	 * @param ArrayList<Plant> for the plants used on the drag and drop.
	 * @return. ArrayList<Integer> for all ratings made
	 * @throws no exception
	 */
	public ArrayList<Integer> rateGarden(ArrayList<Plant> temp) {
		ArrayList<Integer> ahhh = new ArrayList<Integer>();
		currentGarden.colorRating = currentGarden.calculateColorRating(temp);
		currentGarden.animalsFedRating = currentGarden.calculateAnimalsFedRating(temp);
		currentGarden.compatibilityRating = currentGarden.calculateCompatibilityRating(temp);
		currentGarden.contBloomRating = currentGarden.calculateContBloomRating(temp);
		currentGarden.transitionRating = currentGarden.calculateTransitionRating(temp);
		ahhh.add(currentGarden.colorRating);
		ahhh.add(currentGarden.contBloomRating);
		ahhh.add(currentGarden.animalsFedRating);
		ahhh.add(currentGarden.compatibilityRating);
		ahhh.add(currentGarden.transitionRating);
		int overall = currentGarden.colorRating + currentGarden.contBloomRating + currentGarden.animalsFedRating + currentGarden.compatibilityRating + currentGarden.transitionRating;
		overall /= 5;
		ahhh.add(overall);
		return ahhh;
	}
	
	/**
	 * Description: updateGarden takes the Model's current plant and appends it to the inGarden list of 
	 * the currentGarden in the Model
	 * @param void
	 * @return. void
	 * @throws no exception
	 */
	public void updateGarden() {
		currentGarden.inGarden.add(currentPlant);
	}
	/**
	 * Description: getPlantByName takes in a string from a view button and finds the corresponding plant in the currentGarden
	 * @param String. the button's name
	 * @return. Plant. the plant associated with that name
	 * @throws no exception
	 */
	public Plant getPlantByName(String s) {
		for (Plant p : this.currentGarden.allPlants) {
			if(p.name.equals(s)) {
				return p;
			}
		}
		return null;
	}
	/**
	 * Description: setStartGardeningis the setted for the isGardening boolean
	 * @param Boolean. the boolean to be set to isGardening
	 * @return. none
	 * @throws no exception
	 */
	public void setStartGardening(Boolean b){
	  startGardening = b;
	}
	/**
	 * Description: reset erases the previous garden/plant data from the model and resets the model's attributes back
	 * to the ones when the model was first initialized.
	 * @param none
	 * @return. none
	 * @throws no exception
	 */
	public void reset(){
		setStartGardening(false);
		currentPlant = null;
		currentGarden = new Garden(); // removeAll?
	}
	
	public String interpretFinalRating(int i) {
		String temp = "";
		String name = "rating/"+Integer.toString(i)+".txt";
			try {
				BufferedReader br = new BufferedReader(new FileReader(name));
				   String line = null;
				   while ((line = br.readLine()) != null) {
				       temp = temp+line+"\n";
				   }
				   
				}catch (Exception e) {
					System.err.format("Exception occurred trying to read '%s'.", name);
					e.printStackTrace();
					}
			return temp;
	}

		//Basic Getters and Setters for the Garden Drag and Drop

	// This is what I added :)
	
	public void setX(double x){
		modelX = x;
	}

	public void setY(double y){
		modelY =y;
	}

	public double getX(){
		return modelX;
	}

	public double getY(){
		return modelY;
	}

	public void setImage(Node n){
		n.setTranslateX(getX());
		n.setTranslateY(getY());
	}

}

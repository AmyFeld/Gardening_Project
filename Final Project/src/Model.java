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

public class Model implements Serializable {
	
	Boolean startGardening = false;
	
	Garden currentGarden = new Garden();
	ArrayList<Plant> allPlants = currentGarden.allPlants;
	Plant currentPlant;
	
	double modelX;
	double modelY;
	
	ArrayList<Plant> myPlants = new ArrayList<Plant>();
	ArrayList<Plant> gridPlants = new ArrayList<Plant>();
	ArrayList<Integer> rating = new ArrayList<Integer>();
	
	/**
	 * Description: This is a setter for the Plant attribute in Model
	 * 
	 * @param Plant. used for setting the Model's current Plant
	 * @return. void
	 * @throws no exception
	 */
	public void setPlant(Plant currentPlant){
		this.currentPlant = currentPlant;
	}
	
	/**
	 * Description: This is a setter for the Garden attribute in Model
	 * 
	 * @param Garden. used for setting the Model's current Garden
	 * @return. void
	 * @throws no exception
	 */
	public void setGarden(Garden currentGarden){
		this.currentGarden = currentGarden;
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
	 * Description: setStartGardeningis the setted for the isGardening boolean
	 * @param Boolean. the boolean to be set to isGardening
	 * @return. none
	 * @throws no exception
	 */
	public void setStartGardening(Boolean b){
	  startGardening = b;
	}
	/** Description: update adds plants to myPlants in model
	 * @param  Plant Takes in a specified plant
	*/
	public void update(Plant p) {
		myPlants.add(p);
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
	 * Basic getter for the arrayList of myPlants
	 * @return myPlants
	 */
	public ArrayList<Plant> getMyPlant() {
		return myPlants;
	}
	
	/**
	 * Description: sets the model rating value based on the current gridPlant array
	 * @return ArrayList<Integer> rating
	 */
	public ArrayList<Integer> setRating() {
		rating = rateGarden(gridPlants);
		System.out.println(rating);
		return rating;
	}
	
	/**
	 * Description: takes in a node and sets the x and y of that node based on the model's current X and Y values
	 * @param n
	 */
	public void setImage(Node n){
		n.setTranslateX(getX());
		n.setTranslateY(getY());
	}
	
	/**
	 * Description: reset erases the previous garden/plant data from the model and resets the model's attributes back
	 * to the ones when the model was first initialized.
	 * @param none
	 * @return. none
	 * @throws no exception
	 */
	public void reset() {
		setStartGardening(false);
		currentPlant = null;
		currentGarden = new Garden(); // removeAll?
	}
	
	/**
	 * Takes in the overall rating score and gives a string of information why the user got a specific rating
	 * @param i
	 * @return String temp
	 */
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

	
	/**
	 * Description: sets the modelX value to a given double
	 * @param x
	 */
	public void setX(double x){
		modelX = x;
	}

	/**
	 * Description: sets the modelY value to a given double
	 * @param y
	 */
	public void setY(double y){
		modelY = y;
	}

	/**
	 * Description: basic getter for current x value in model based on the controller
	 * @return double X value
	 */
	public double getX(){
		return modelX;
	}

	/**
	 * Description: basic getter for current y value in model based on the controller
	 * @return double Y value
	 */
	public double getY(){
		return modelY;
	}
	
	/**
	 * Description: rateGarden takes in the arraylist of used plants and returns all rating in an arraylist,
	 * including overall rating
	 * @param ArrayList<Plant> for the plants used on the drag and drop.
	 * @return. ArrayList<Integer> for all ratings made
	 * @throws no exception
	 */
	public ArrayList<Integer> rateGarden(ArrayList<Plant> temp) {
		ArrayList<Integer> rateList = new ArrayList<Integer>();
		currentGarden.colorRating = currentGarden.calculateColorRating(temp);
		currentGarden.animalsFedRating = currentGarden.calculateAnimalsFedRating(temp);
		currentGarden.compatibilityRating = currentGarden.calculateCompatibilityRating(temp);
		currentGarden.contBloomRating = currentGarden.calculateContBloomRating(temp);
		currentGarden.transitionRating = currentGarden.calculateTransitionRating(temp);
		rateList.add(currentGarden.colorRating);
		rateList.add(currentGarden.contBloomRating);
		rateList.add(currentGarden.animalsFedRating);
		rateList.add(currentGarden.compatibilityRating);
		rateList.add(currentGarden.transitionRating);
		double sum = 0;
		for(int i : rateList) {
			sum+=i;
		}
		rateList.add((int)Math.round(sum/5.0));
		return rateList;
	}

	/**
	 * Description: takes in a integer and sets the current plant to that integer
	 * then removes that plant from the gridPlants arrayList
	 * @param i
	 */
	public void removeImageView(int i) {
		setPlant(allPlants.get(i));
		System.out.println(currentPlant.name);
		gridPlants.remove(currentPlant);
	//	System.out.println(gridPlants.get(i).getName());
		//gridPlants.remove(i);
		printGrid();
	}
	
	/**
	 * Description: after getting what plant is currently being used adds the plant to the grid and sets the scale
	 * @param i
	 * @return int size
	 */
	public int addImageView(int i) {
		if(i<allPlants.size()) {
			setPlant(allPlants.get(i));
			gridPlants.add(currentPlant);
		}
		printGrid();
		return currentPlant.scaling();
	}
	
	/**
	 * Description: Prints all of the plants in grid -- used for testing they are in there
	 */
	public void printGrid() {
		for(int j=0; j< gridPlants.size(); j++) {
	 		System.out.print(gridPlants.get(j).getName()+ " "+ j);
	 	}
	}
	

}

// This class communicates with the controller to tell the view the current state of the Garden, the current plant and the triggering of garden
public class Model {
	
	Boolean startGardening;
	
	Garden currentGarden;
	Plant currentPlant;
	
	/*
	 * Input: the Garden 
	 * Output: none
	 * Function: sets the current garden
	 */
	public void setGarden(Garden g){
		currentGarden = g;
	}
	
	/*
	 * Input: the plant
	 * Output: none
	 * Function: sets the current plant
	 */
	public void setPlant(Plant p){
		currentPlant = p;
	}
	
	/*
	 * Input: none
	 * Output: currentPlant
	 * Function: returns the currentPlant as a getter
	 */
	public Plant getPlant(){
		return currentPlant;
	}
	
	/*
	 * Input: none
	 * Output: currentGarden
	 * Function: returns the currentGarden as a getter
	 */
	
	public Garden getGarden(){
		return currentGarden;
	}
	
	
	/*
	 * Input: the Garden class g
	 * Output: the overall rating as an int
	 * Function: sets the computer-generated rating and returns an int of the overall
	 */
	public int rateGarden(Garden g) {
		return 0;
	}
	
	/*
	 * Input: none
	 * Output: sets the rating
	 * Function: the rating is updated from rateGarden()
	 */
	public void updateGarden() {
		
	}
	

}

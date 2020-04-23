// This class is used for garden ratings and using this in the view to draw out the garden
public class Garden {
	
	ArrayList<Plant> allPlants = new ArrayList<>();
	
	Plant plantList[];
	int happinessRating;
	int contBloomRating;
	int animalsFedRating;
	int compatibilityRating;
	int transitionRating;
	
	public Garden(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader("plant.txt"));
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] plantInfo = line.split(",");
				this.allPlants.add(
				}
			reader.close();
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", "morse.txt");
			e.printStackTrace();
			}
		return 
	}
	
	/*
	 * Input: garden 
	 * Output: returns a calculated number out of 5 (1:low, 5:high)
	 * Function: calculation based on how good the garden is overall 
	 */
	public int calculateHappinessRating(Garden g){
		return 0;
	}
	
	/*
	 * Input: garden 
	 * Output: returns calculated number out of 5  (1:low, 5:high)
	 * Function: calculation based on garden on the number of blooms
	 */
	public int calculateContBloomRating(Garden g){
		return 0;
	}
	
	/*
	 * Input: garden 
	 * Output: calculated number out of 5  (1:low, 5:high)
	 * Function: calculation based on how many animals fed  
	 */
	public int calculateAnimalsFedRating(Garden g){
		return 0;
	}
	
	/*
	 * Input: garden 
	 * Output: returns a calculated number out of 5  (1:low, 5:high) 
	 * Function: calculation based on garden of how compatible the plants 
	 */	
	public int calculateCompatibilityRating(Garden g){
		return 0;
	}
	
	/*
	 * Input: garden 
	 * Output: returns a calculated number out of 5 (1:low, 5:high)
	 * Function: calculation based on how well the grass goes to forest (edge)
	 */
	public int calculateTransitionRating(Garden g) {
		return 0;
	}
	

}

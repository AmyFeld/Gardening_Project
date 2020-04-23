// This class is used for garden ratings and using this in the view to draw out the garden
public class Garden {
	
	ArrayList<Plant> allPlants = readAllPlants();
	
	Plant plantList[];
	int happinessRating;
	int contBloomRating;
	int animalsFedRating;
	int compatibilityRating;
	int transitionRating;
	
	public ArrayList<Plant> readAllPlants(){
		ArrayList<Plant> temp = new ArrayList<Plant>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("plant.txt"));
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] plantInfo = line.split(",");
				temp.add(plantInfo[0], plantInfo[1], Integer.parseInt(plantInfo[2]), Boolean.parseBoolean(plantInfo[3]), plantInfo[4], plantInfo[5], false);
				}
			reader.close();
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", "plant.txt");
			e.printStackTrace();
			}
		return temp;
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

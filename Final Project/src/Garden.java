import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

// This class is used for garden ratings and using this in the view to draw out the garden
public class Garden {
	
	ArrayList<Plant> allPlants = readAllPlants();
	
	Plant plantList[];
	int happinessRating;
	int contBloomRating;
	int animalsFedRating;
	int compatibilityRating;
	int transitionRating;
	
	
	/**
	 * Description: The readAllPlants is a function that will read in information from a text file to group
	 * together all possible plants into Plant objects for the Garden to store.
	 * @param None.
	 * @return. ArrayList<Plant> for storing all read in plants for the Garden object
	 * @throws IOException  Caused by file not foudn exception
	 */


	public ArrayList<Plant> readAllPlants(){
		ArrayList<Plant> temp = new ArrayList<Plant>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("plant.txt"));
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] plantInfo = line.split(",");
				temp.add(new Plant(plantInfo[0], plantInfo[1], Integer.parseInt(plantInfo[2]),
						Boolean.parseBoolean(plantInfo[3]), plantInfo[4], plantInfo[5], Integer.parseInt(plantInfo[6]), 
						Integer.parseInt(plantInfo[7])));

				}
			reader.close();
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", "plant.txt");
			e.printStackTrace();
			}
		return temp;
	}
	
	/**
	 * Description: calculateHappinessRating is a function that analyzes a garden and based on what plants are present,
	 * returns its rating from 1-5 stars.
	 * @param A garden to check it's contained plants
	 * @return int. whihc represents a number of stars from 1-5.
	 * @throws no exceptions
	 */
	public int calculateHappinessRating(Garden g){
		return 0;
	}
	
	/**
	 * Description: calculateContBloomRating is a function that analyzes a garden and based on what plants are present,
	 * returns its rating from 1-5 stars.
	 * @param A garden to check it's contained plants
	 * @return int. whihc represents a number of stars from 1-5.
	 * @throws no exceptions
	 */
	public int calculateContBloomRating(Garden g){
		return 0;
	}
	/**
	 * Description: calculateAnimalsFedRating is a function that analyzes a garden and based on what plants are present,
	 * returns its rating from 1-5 stars.
	 * @param A garden to check it's contained plants
	 * @return int. whihc represents a number of stars from 1-5.
	 * @throws no exceptions
	 */
	public int calculateAnimalsFedRating(Garden g){
		return 0;
	}
	
	/**
	 * Description: calculateCompatibilityRating is a function that analyzes a garden and based on what plants are present,
	 * returns its rating from 1-5 stars.
	 * @param A garden to check it's contained plants
	 * @return int. whihc represents a number of stars from 1-5.
	 * @throws no exceptions
	 */	
	public int calculateCompatibilityRating(Garden g){
		return 0;
	}
	
	/**
	 * Description: calculateTransitionRating is a function that analyzes a garden and based on what plants are present,
	 * returns its rating from 1-5 stars.
	 * @param A garden to check it's contained plants
	 * @return int. whihc represents a number of stars from 1-5.
	 * @throws no exceptions
	 */
	public int calculateTransitionRating(Garden g) {
		return 0;
	}
	

}

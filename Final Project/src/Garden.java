import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This class is used for garden ratings and using this in the view to draw out the garden
 * 
 * @author Tara Fishman
 *
 */public class Garden {
	
	ArrayList<Plant> allPlants = readAllPlants();
	ArrayList<Plant> inGarden = new ArrayList<Plant>();
	ArrayList<Plant> OnGardenPage = new ArrayList<Plant>();
	ArrayList<String> feedingPlants = getFeedingPlants();
	int colorRating;
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
	
	public ArrayList<String> getFeedingPlants(){
		ArrayList<String> temp = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("feedingPlants.txt"));
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				temp.add(line);
				}
			reader.close();
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", "plant.txt");
			e.printStackTrace();
			}
		return temp;
	}
	
	/**
	 * Description: calculateColorRating is a function that analyzes a garden and based on what plants are present,
	 * returns its rating from 1-5 stars.
	 * @param A garden to check it's contained plants
	 * @return int. whihc represents a number of stars from 1-5.
	 * @throws no exceptions
	 */
	public int calculateColorRating(ArrayList<Plant> usedPlants){
		int result = 0;
		String[] colors = {"red", "orange", "yellow", "green", "blue", "purple", "pink", "white"};
		for(Plant p : usedPlants) {
			
		}
		return result;
	}
	
	/**
	 * Description: calculateContBloomRating is a function that analyzes a garden and based on what plants are present,
	 * returns its rating from 1-5 stars.
	 * @param A garden to check it's contained plants
	 * @return int. whihc represents a number of stars from 1-5.
	 * @throws no exceptions
	 */
	public int calculateContBloomRating(ArrayList<Plant> usedPlants){
		int result = 0;
		for(Plant p : usedPlants) {
			
		}
		return result;
	}
	/**
	 * Description: calculateAnimalsFedRating is a function that analyzes a garden and based on what plants are present,
	 * returns its rating from 1-5 stars.
	 * @param A garden to check it's contained plants
	 * @return int. whihc represents a number of stars from 1-5.
	 * @throws no exceptions
	 */
	public int calculateAnimalsFedRating(ArrayList<Plant> usedPlants){
		int result = 0;
		for(Plant p : usedPlants) {
			
		}
		return result;
	}
	
	/**
	 * Description: calculateCompatibilityRating is a function that analyzes a garden and based on what plants are present,
	 * returns its rating from 1-5 stars.
	 * @param A garden to check it's contained plants
	 * @return int. whihc represents a number of stars from 1-5.
	 * @throws no exceptions
	 */	
	public int calculateCompatibilityRating(ArrayList<Plant> usedPlants){
		int result = 0;
		for(Plant p : usedPlants) {
			
		}
		return result;
	}
	
	/**
	 * Description: calculateTransitionRating is a function that analyzes a garden and based on what plants are present,
	 * returns its rating from 1-5 stars.
	 * @param A garden to check it's contained plants
	 * @return int. which represents a number of stars from 1-5.
	 * @throws no exceptions
	 */
	public int calculateTransitionRating(ArrayList<Plant> usedPlants) {
		int treesCount = 0, shrubsCount = 0, herbsCount = 0;
		for(Plant p : usedPlants) {
			if(p.type.equals("tree")) {
				treesCount++;
			}else if(p.type.equals("shrub")) {
				shrubsCount++;
			}else {
				herbsCount++;
			}
		}
		if(treesCount == shrubsCount && herbsCount == treesCount) {
			return 5;
		}else if(treesCount == 0 || shrubsCount == 0 || herbsCount == 0) {
			return 1;
		}else if((Math.abs(treesCount - shrubsCount) >= 7.0) || (Math.abs(treesCount - herbsCount) >= 7.0) || (Math.abs(herbsCount - shrubsCount) >= 7.0)){
			return 2;
		}else if((Math.abs(treesCount - shrubsCount) >= 4.0) || (Math.abs(treesCount - herbsCount) >= 4.0) || (Math.abs(herbsCount - shrubsCount) >= 4.0)){
			return 3;
		}else {
			return 4;
		}
	} 
	
	public ArrayList<Plant> Filter(String category, String type, ArrayList<Plant> currentList){
		ArrayList<Plant> temp = new ArrayList<Plant>();
		switch(category) {
		case "type":
			for(Plant p : currentList) {
				if(p.type.equals(type)) {
					temp.add(p);
				}
			}
			return temp;
		case "height":
			for(Plant p : currentList) {
				if(p.height >= Integer.parseInt(type) && p.height <= (Integer.parseInt(type)+60)) {
					temp.add(p);
				}
			}
			return temp;
		case "hasFruit":
			for(Plant p : currentList) {
				if(p.hasFruit == Boolean.parseBoolean(type)) {
					temp.add(p);
				}
			}
			return temp;
		case "waterUse":
			for(Plant p : currentList) {
				if(p.waterUse.equals(type)) {
					temp.add(p);
				}
			}
			return temp;
		case "color":
			for(Plant p : currentList) {
				if(p.color.equals(type.toLowerCase())) {
					temp.add(p);
				}
			}
			return temp;
		case "start":
			for(Plant p : currentList) {
				if(p.start <= Integer.parseInt(type) && p.end >= Integer.parseInt(type)) {
					temp.add(p);
				}
			}
			return temp;
		default:
			return this.allPlants;
		}
		
	}
	

}

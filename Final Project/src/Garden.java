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
		ArrayList<String> colorList = new ArrayList<String>();
		String[] colors = {"red", "orange", "yellow", "green", "blue", "purple", "pink", "white"};
		for(int i = 0; i < colors.length; i++) {
			colorList.add(colors[i]);
		}
		for(Plant p : usedPlants) {
			if(colorList.size() == 0) {
				return 5;
			}
			if(colorList.contains(p.color)) {
				colorList.remove(p.color);
			}
		}
		if(colorList.size() <= 2) {
			return 4;
		}else if(colorList.size() <= 4) {
			return 3;
		}else if(colorList.size() <= 6) {
			return 2;
		}else {
			return 1;
		}
		
	}
	
	/**
	 * Description: calculateContBloomRating is a function that analyzes a garden and based on what plants are present,
	 * returns its rating from 1-5 stars.
	 * @param A garden to check it's contained plants
	 * @return int. whihc represents a number of stars from 1-5.
	 * @throws no exceptions
	 */
	public int calculateContBloomRating(ArrayList<Plant> usedPlants){
		ArrayList<Integer> months = new ArrayList<Integer>();
		for(int i = 1; i < 13; i++) {
			months.add(i);
		}
		for(Plant p : usedPlants) {
			for(int i = p.start; i <= p.end; i++) {
				if(months.size() == 0) {
					return 5;
				}else if(months.contains(i)) {
					months.remove(i);
				}
			}
		}
		if(months.size() <= 2) {
			return 4;
		}else if(months.size() <= 4) {
			return 3;
		}else if(months.size() <= 6) {
			return 2;
		}else {
			return 1;
		}
		
	}
	/**
	 * Description: calculateAnimalsFedRating is a function that analyzes a garden and based on what plants are present,
	 * returns its rating from 1-5 stars.
	 * @param A garden to check it's contained plants
	 * @return int. whihc represents a number of stars from 1-5.
	 * @throws no exceptions
	 */
	public int calculateAnimalsFedRating(ArrayList<Plant> usedPlants){
		ArrayList<String> feedingPlants = getFeedingPlants();
		for(Plant p : usedPlants) {
			if(feedingPlants.size() == 0) {
				return 5;
			}
			if(feedingPlants.contains(p.name)) {
				feedingPlants.remove(p.name);
			}
		}
		if(feedingPlants.size() <= 3) {
			return 4;
		}else if(feedingPlants.size() <= 5) {
			return 3;
		}else if(feedingPlants.size() <= 8) {
			return 2;
		}else {
			return 1;
		}
	}
	
	/**
	 * Description: calculateCompatibilityRating is a function that analyzes a garden and based on what plants are present,
	 * returns its rating from 1-5 stars.
	 * @param A garden to check it's contained plants
	 * @return int. whihc represents a number of stars from 1-5.
	 * @throws no exceptions
	 */	
	public int calculateCompatibilityRating(ArrayList<Plant> usedPlants){
		int lowCount = 0, mediumCount = 0, highCount = 0;
		for(Plant p : usedPlants) {
			if(p.waterUse.equals("low")) {
				lowCount++;
			}else if(p.waterUse.equals("medium")) {
				mediumCount++;
			}else {
				highCount++;
			}
		}
		int highLowDif = Math.abs(highCount - lowCount);
		int medHighDif = Math.abs(highCount - mediumCount);
		int medLowDif = Math.abs(lowCount - mediumCount);
		if(highCount == usedPlants.size() || mediumCount == usedPlants.size() || lowCount == usedPlants.size()) {
			return 5;
		}else if(highLowDif <= 4 || medHighDif <= 4 || medLowDif <= 4){
			return 2; 
		}else if(highLowDif <= 8 || medHighDif <= 8 || medLowDif <= 8){
			return 3;
		}else if(highLowDif <= 15 || medHighDif <= 15 || medLowDif <= 15){
			return 4;
		}else{
			return 1; 
		}
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

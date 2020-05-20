import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class is used for garden ratings and using this in the view to draw out the garden
 * 
 * @author Tara Fishman
 *
 */

public class Garden implements Serializable{
	
	ArrayList<Plant> allPlants = readAllPlants();
	ArrayList<Plant> inGarden = new ArrayList<Plant>();
	int colorRating;
	int contBloomRating;
	int animalsFedRating;
	int compatibilityRating;
	int transitionRating;
	
	// scaling: 
	int rateBest = 5;
	int rateGood = 4;
	int rateAvg = 3;
	int rateBad = 2;
	int rateWorst = 1;
	int defaultSize = 0;
	
	int feedPlantGood = 3;
	int feedPlantAvg = 5;
	int feedPlantBad = 8;
	
	int colorGood = 2;
	int colorAvg = 4;
	int colorBad = 6;
	
	int monthSize = 13;
	int startMonth = 1;
	int monthGood = 3;
	int monthAvg = 4;
	int monthBad = 6;
	
	int compatAvg = 8;
	int compatBad = 4;
	
	double transBad = 4.0;
	double transAvg = 7.0;
	
	int inches = 12;
	int inchMax = 120;


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
						Boolean.valueOf(plantInfo[3]), plantInfo[4], plantInfo[5], Integer.parseInt(plantInfo[6]), 
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
	 * 
	 * @return
	 */
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
	 * @return int. which represents a number of stars from 1-5.
	 * @throws no exceptions
	 */
	public int calculateColorRating(ArrayList<Plant> usedPlants){
		ArrayList<String> colorList = new ArrayList<String>();
		String[] colors = {"red", "orange", "yellow", "green", "blue", "purple", "pink", "white"};
		for(String c: colors) {
			colorList.add(c);
		}
		for(Plant p : usedPlants) {
			if(colorList.size() == defaultSize) {
				return rateBest;
			}
			if(colorList.contains(p.color)) {
				colorList.remove(p.color);
			}
		}
		if(colorList.size() <= colorGood) {
			return rateGood;
		}else if(colorList.size() <= colorAvg) {
			return rateAvg;
		}else if(colorList.size() <= colorBad) {
			return rateBad;
		}else {
			return rateWorst;
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
		ArrayList<String> months = new ArrayList<String>();
		for(int i = startMonth; i < monthSize; i++) {
			months.add(String.valueOf(i));
		}
		for(Plant p : usedPlants) {
			for(int i = p.start; i <= p.end+1; i++) {
				if(months.size() == defaultSize) {
					return rateBest;
					}
				if(months.contains(String.valueOf(i))) {
					months.remove(String.valueOf(i));
				}
				}
			}
		if(months.size() <= monthGood) {
			return rateGood;
		}else if(months.size() <= monthAvg) {
			return rateAvg;
		}else if(months.size() <= monthBad) {
			return rateBad;
		}else 
			return rateWorst;
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
			if(feedingPlants.size() == defaultSize) {
				return rateBest;
			}
			if(feedingPlants.contains(p.name)) {
				feedingPlants.remove(p.name);
			}
		}
		if(feedingPlants.size() <= feedPlantGood) {
			return rateGood;
		}else if(feedingPlants.size() <= feedPlantAvg) {
			return rateAvg;
		}else if(feedingPlants.size() <= feedPlantBad) {
			return rateBad;
		}else {
			return rateWorst;
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
		int lowCount = defaultSize, mediumCount = defaultSize, highCount = defaultSize;
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
			return rateBest;
		}else if(lowCount == highCount || highCount == mediumCount || mediumCount == lowCount) {
			return rateWorst;
		}else if(highLowDif <= compatBad || medHighDif <= compatBad|| medLowDif <= compatBad){
			return rateBad; 
		}else if(highLowDif <= compatAvg || medHighDif <= compatAvg || medLowDif <= compatAvg){
			return rateAvg;
		}else{
			return rateGood;
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
		int treesCount = defaultSize, shrubsCount = defaultSize, herbsCount = defaultSize;
		for(Plant p : usedPlants) {
			if(p.type.equals("tree")) {
				treesCount++;
			}else if(p.type.equals("shrub")) {
				shrubsCount++;
			}else {
				herbsCount++;
			}
		}
		if (treesCount == shrubsCount && herbsCount == treesCount) {
			return rateBest;
		}else if(treesCount == defaultSize || shrubsCount == defaultSize || herbsCount == defaultSize) {
			return rateWorst;
		}else if((Math.abs(treesCount - shrubsCount) >= transBad) || (Math.abs(treesCount - herbsCount) >= transBad) 
				|| (Math.abs(herbsCount - shrubsCount) >= transBad)){
			return rateBad;
		}else if((Math.abs(treesCount - shrubsCount) >= transAvg) || (Math.abs(treesCount - herbsCount) >= transAvg) 
				|| (Math.abs(herbsCount - shrubsCount) >= transAvg)){
			return rateAvg;
		}else {
			return rateGood;
		}
	} 
	
	/**
	 * Description: takes in strings and an array list to create a temporary arraylist that prints a version 
	 * with only those qualities 
	 * @param category
	 * @param type
	 * @param currentList
	 * @return ArrayList<Plant>
	 */
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
			if(type.equals("40")) {
				for(Plant p : currentList) {
					if(p.height >= (inches * Integer.parseInt(type))) {
						temp.add(p);
					}
				}
				return temp;
			}else {
				for(Plant p : currentList) {
					if(p.height >= (inches * Integer.parseInt(type)) && 
							p.height <= ((inches * Integer.parseInt(type)) + inchMax)) {
						temp.add(p);
					}
				}
				return temp;
			}
		case "hasFruit":
			if(type.equals("True")) {
				for(Plant p : currentList) {
					if(p.hasFruit) {
						temp.add(p);
					}
				}
						return temp;
				}else{
					for(Plant p : currentList) {
						if(!p.hasFruit) {
							temp.add(p);
						}
					}
							return temp;

				}
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

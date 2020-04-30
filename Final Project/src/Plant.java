import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;

// This class is meant to handle the types of plants and handle plant sorting/filtering

public class Plant {

	String name;
	String type;
	int height;
	boolean hasFruit;
	String waterUse;
	String color;
	int start;
	int end;
	
	public Plant(String name, String type, int height, boolean hadFruit, String waterUse, String color, int start, int end){
		this.name = name;
		this.type = type;
		this.height = height;
		this.hasFruit = hasFruit;
		this.waterUse = waterUse;
		this.color = color;
		this.start = start;
		this.end = end;
	}
	/*
	 * Description: getName takes in a Plant and returns its name
	 * @param none
	 * @return. String which represents the name stored in a plant
	 * @throws nothing
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Description: sortByType takes in nothing and returns nothing but is meant to be used on an array of plants
	 * to sort it in order of type tree, shrub, herb
	 * @param none
	 * @return. nothing
	 * @throws nothing
	 */
	public void sortByType() {	
	
	}
	
	/*
	 * Description: sortByFruition takes in nothing and returns nothing but is meant to be used on an array of plants
	 * to sort it in order of hasFruit is true to hasFruit is false
	 * @param none
	 * @return. nothing
	 * @throws nothing
	 */
	public void sortByFruition() {
	
	}
	
	/*
	 * Description: sortByWaterUse takes in nothing and returns nothing but is meant to be used on an array of plants
	 * to sort it in order of low wateruse, medium wateruse and high wateruse
	 * @param none
	 * @return. nothing
	 * @throws nothing
	 */
	public void sortByWaterUse() {
		
	}
	
	/*
	 * Description: sortByColor takes in nothing and returns nothing but is meant to be used on an array of plants
	 * to sort it in order of the rainbow
	 * @param none
	 * @return. nothing
	 * @throws nothing
	 */
	public void sortByColor() {
		
	}
	
	/*
	 * Input: a plant collection and String 
	 * Output: none
	 * Function: filters based on the string 
	 */
	public void filter(Collection<Plant> pList, String filterOption) {
		
	}
	
	/*
	 * Description: getImgName uses a plant's name to return the name of the img file that has the plant
	 * @param none
	 * @return. String that represents the name of the apporpriate img file
	 * @throws nothing
	 */
	
	public String getImgName() {
		String temp = this.name.replace(" ", "_");
		temp = "file:plantImg/" + temp + ".jpg";
		return temp; 
	}
	/*
	 * Description: getDesc uses a plant's name to return the contents of the appropriate description file
	 * @param none
	 * @return. String that is teh contents of the appropriate txt file
	 * @throws filenotfound Exception
	 */
	public String getDesc() {
		String s = "";
		String name = this.name.replace(" ", "_");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("file:plantDesc/" + name+".txt"));
			   String line = null;
			   while ((line = br.readLine()) != null) {
			       s = s+line+"\n";
			   }
			   
			}catch (Exception e) {
				System.err.format("Exception occurred trying to read '%s'.", "plant.txt");
				e.printStackTrace();
				}
		return s;
	}
	
}

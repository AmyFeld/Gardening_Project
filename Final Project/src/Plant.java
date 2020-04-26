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
	boolean inGarden = false;
	
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
	 * Input: none
	 * Output: none
	 * Function: sorts based on the type of plant 
	 */
	public void sortByType() {	
	
	}
	
	/*
	 * Input: none
	 * Output: none
	 * Function: sorts based on the type of fruit 
	 */
	public void sortByFruition() {
	
	}
	
	/*
	 * Input: none
	 * Output: none
	 * Function: sorts based on how the plant needs water (high, medium, low)
	 */
	public void sortByWaterUse() {
		
	}
	
	/*
	 * Input: none
	 * Output: none
	 * Function: sorts based on how the plant's color (red, green, etc)
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
	 * Input: a String 
	 * Output: an altered String
	 * Function: gets the name of the corresponding image file based on plant name
	 */
	
	public String getImgName(String s) {
		String temp = s.replace(" ", "_");
		temp = temp + ".jpg";
		return temp; 
	}
	
	public String getDesc(Plant p) {
		String s = "";
		String name = p.name.replace(" ", "_");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(name+".txt"));
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

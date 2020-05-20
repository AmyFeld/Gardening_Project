import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.Collection;

/**
 * This class is meant to handle the types of plants and handle plant sorting/filtering
 * 
 * @author Tara Fishman 
 *
 */
public class Plant implements Serializable{

	String name;
	String type;
	int height;
	Boolean hasFruit;
	String waterUse;
	String color;
	int start;
	int end;
	
	int shrubSize = 100;
	int herbSize = 50; 
	int treeSize= 150; 
	int genSize = 75;
	
	/**
	 * Description: Sets the plants information
	 * @param name
	 * @param type
	 * @param height
	 * @param hadFruit
	 * @param waterUse
	 * @param color
	 * @param start
	 * @param end
	 */
	public Plant(String name, String type, int height, Boolean hasFruit, String waterUse, String color, int start, int end){
		this.name = name;
		this.type = type;
		this.height = height;
		this.hasFruit = hasFruit;
		this.waterUse = waterUse;
		this.color = color;
		this.start = start;
		this.end = end;
	}
	
	/**
	 * Generic plant constuctor- sets nothing
	 */
	public Plant() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Description: getName takes in a Plant and returns its name
	 * @param none
	 * @return. String which represents the name stored in a plant
	 * @throws nothing
	 */
	public String getName() {
		return name;
	}
	/**
	 * Description: getImgName uses a plant's name to return the name of the img file that has the plant
	 * @param none
	 * @return. String that represents the name of the apporpriate img file
	 * @throws nothing
	 */
	
	public String getImgName(String whichOne) {
		String temp = this.name.replace(" ", "_");
		switch(whichOne) {
		case "original":
			temp = "file:plantImg/" + temp + ".jpg";
			break;
		case "spring":
			temp = "file:seasonImages/springPlants/" + temp + ".jpg";
			break;
		case "fall":
			temp = "file:seasonImages/fallPlants/" + temp + ".jpg";
			break;
		case "winter":
			temp = "file:seasonImages/winterPlants/" + temp + ".jpg";
			break;
		}
		return temp; 
	}
	
	
	/**
	 * Description: getDesc uses a plant's name to return the contents of the appropriate description file
	 * @param none
	 * @return. String that is teh contents of the appropriate txt file
	 * @throws filenotfound Exception
	 */
	public String getDesc() {
		String s = "";
		String name = this.name.replace(" ", "_");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("plantDesc/" + name+".txt"));
			   String line = null;
			   while ((line = br.readLine()) != null) {
			       s = s+line+"\n";
			   }
			   
			}catch (Exception e) {
				System.err.format("Exception occurred trying to read '%s'.", name+".txt");
				e.printStackTrace();
				}
		return s;
	}
	
	/**
	 * Description: creates a string based on the current plant to be used for hovering
	 * @return String s
	 */
	public String greeneryHover() {
		String s = "";
		String name = this.name.replace(" ", "_");
		System.out.println(name);
		try {
			BufferedReader br = new BufferedReader(new FileReader("plantDesc/" + name+".txt"));
			   String line = null;
			   while ((line = br.readLine()) != null) {
				   if(line.contains("Synopsis")) {
					   break;
				   }
			       s = s+line+"\n";
			   }
			   
			}catch (Exception e) {
				System.err.format("Exception occurred trying to read '%s'.", name+".txt");
				e.printStackTrace();
				}
		return s;
	}
	
	/**
	 * Description: Based on the type of plant, the imgHeight will be determined - used for creating imageView in garden
	 * @return integer size
	 */
	public int scaling() {
		switch(this.type) {
		case("herb"):
			return herbSize;
		case("shrub"):
			return shrubSize;
		case("tree"):
			return treeSize;
		}
		return genSize;
	}
}

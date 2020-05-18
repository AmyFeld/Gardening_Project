package src;

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
	

	public Plant(String name, String type, int height, Boolean hadFruit, String waterUse, String color, int start, int end){
		this.name = name;
		this.type = type;
		this.height = height;
		this.hasFruit = hasFruit;
		this.waterUse = waterUse;
		this.color = color;
		this.start = start;
		this.end = end;
	}
	public Plant() {
		// TODO Auto-generated constructor stub
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
		case "spring":
			temp = "file:seasonImages/springPlants/" + temp + ".jpg";
		case "fall":
			temp = "file:seasonImages/fallPlants/" + temp + ".jpg";
		case "winter":
			temp = "file:seasonImages/winterPlants/" + temp + ".jpg";
		}
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
	
	public String gardenHover() {
		return this.name;
	}
	
	public int scaling() {
		switch(this.type) {
		case("herb"):
			return 50;
		case("shrub"):
			return 100;
		case("tree"):
			return 150;
		}
		return 100;
	}
}

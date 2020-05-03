import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * This class is an abstract class used as a framework for all other views.
 * 
 * @author Lisa Pathania & Amy Feldman
 *
 */
public class View extends Application {
  	
	// value of the height and width of screen
		int canvasWidth = 900;
		int canvasHeight = 600;
		int sceneWidth = 900;
		int sceneHeight = 600;
		
		int fontSize = 40;

		int labelX = 300;
		int labelY = 15;
	
		Button prevButton;
		Button nextButton;
		
	    Image home = new Image("file:images/home.png", 20, 20, false, false);
	    Button homeButton = new Button("Home", new ImageView(home));
		Scene scene1;
		 
		 /**
			 * Sets up the first stage of the application with background
			 * image & title. Adds ViewPage1 scene to the stage
			 *
			 *@param Stage  a platform container to hold scene1 
			 *
			 */
	@Override
	public void start(Stage theStage) {
		Image back = new Image("file:images/bg.png");
		ImageView bg = new ImageView(back);
		
		Group root = new Group();
		root.getChildren().add(bg);

		theStage.setTitle("Create a Garden");
		
		theStage.setScene(new ViewPage1(theStage).getScene1()); 
		theStage.show(); 		
	}
	
	public static void main(String args[]){   
	      launch(args);     
	   } 
	
	
	/** 
	 * Reads in a textfile and returns the content into string format
	 *   
	 * @param String  Filename of the textfile 
	 * 		    int   Name of the folder the textfile is found
	 * @return String  Returns the content of textfile into String
	 *  
	 */
	public String uploadText(String name, int page) throws Exception {
		
		String file = new String("textFiles/Page" + page + "/" + name + ".txt"); 
		String data = ""; 
		
		data = new String(Files.readAllBytes(Paths.get(file))); 
		return data;	  
	}
	
	
    
	/**
	 * Takes in the information that was used to update and fixes the page and what should be seen
	 * 
	 */
	public void update() {} 

	/*
	 * Input: What Page Currently on? or None
	 * Output: None
	 * Function: takes in the information that was used to update and fixes the page and what should be seen
	 */
}
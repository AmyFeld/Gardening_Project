import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * This class is an abstract class used as a framework for all other views.
 * 
 * @author Lisa Pathania & Amy Feldman
 *
 */
public class View extends Application {

	int sceneWidth = 900;
	int sceneHeight = 600;
	
	int fontSize = 40;
	int boxSize = 20;
	int strokeWidth = 2;
			
	int labelX = 300;
	int labelY = 15;
		
	int buttonWidth = 100;
	int buttonHeight = 100;
		
	int imgWidth = 300;
	int imgHeight = 300;
	
	int plaWidth = 100;
	int plaHeight = 100;
	
	int home = 1; 
	int strokeWid = 2;
	int sizingGen = 2;
	int sizingPla = 3;		    

	int opac = 0;
	double vol = 0.05;
	int i = 0;
	    
	double x = 0;
	double y = 0;
	
	TextField userlabel;
	Button prevButton;
	Button nextButton;
	Button homeButton = new Button("Home");
		
	Image back = new Image("file:images/bg2.png",sceneWidth, sceneHeight, false, false);
	Image mouse = new Image("file:images/leaf.png");
	ImageView ivg;
	BackgroundImage myBG;
	ImageView imageView;
	ImageView imgVL;
	Circle circ;
	Rectangle rect;

	Plant imName;
	Plant currPla;
	View currView;
	Controller control;
	Scene scene1;
	Garden g = new Garden();

	TilePane tile;	 
	AnchorPane anchor;
	VBox tileBox;
	
	ArrayList<Plant> allPlants = g.allPlants;		
	ArrayList<ImageView> ivArr = new ArrayList<ImageView>();
	ArrayList<Plant> gridPlants = new ArrayList<Plant>();
	ArrayList<Integer> ratings = new ArrayList<Integer>();
		    
	
	/**
	 * Sets the generalities of the abstract view	 
	 */
	public View() {
		
		control = new Controller(this);
		
		g = control.model.getGarden();
		allPlants = g.allPlants;
		
		Image back = new Image("file:images/bg2.png");
		ImageView bg = new ImageView(back);
		
		imageView = new ImageView();

		bg.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
		bg.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
		myBG = new BackgroundImage(back, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);		
	}
	
	/** 
	 * Description: Starts the entire application.
	 * 
	 */
	public static void main(String args[]){  			
	      launch(args);     
	}
	
		 
	/**
	 * Sets up the first stage of the application with background, image, title, and music.
	 * Adds ViewPage1 scene to the stage
	 *
	 *@param Stage  a platform container to hold scene1 
	 *
	 */
	@Override
	public void start(Stage theStage) throws Exception {
		
		File file = new File("harp.mp3");
		Media media = new Media((file).toURI().toString());
		AudioClip mediaplayer = new AudioClip(media.getSource());
		
		mediaplayer.setVolume(vol);
		mediaplayer.play();
		System.out.println("music starts");
		
		theStage.setTitle("Create a Garden");
		theStage.setScene(new ViewPage1(theStage).getScene1()); 
		theStage.show(); 		
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

	 */
	public void update() {		
		ratings = control.model.rateGarden(gridPlants);
		// System.out.println(ratings.get(1));
		} 
	
	/**
	 * Basic getter setting the current imageView
	 * @param iv
	 */
	public void setImageView(ImageView iv) {
		imageView = iv;
	}
	 
	/**
	 * add a plant to the garden and gives ability to move it; scaled based on type
	 * @param scale
	 */
	public void moveImageView(int scale) {
				 
		circ = new Circle(scale/2);
		circ.setStroke(Color.BISQUE);
		circ.setFill(new ImagePattern(imageView.getImage()));
		 		
		circ.setTranslateX(sceneWidth/sizingPla);
		circ.setTranslateY(sceneHeight/sizingPla);		 
		 
		circ.setOnMouseDragged(control.getHandlerForDrag());
		circ.setOnMouseReleased(control.getHandlerForRelease());

	 	imageView.setOnMouseClicked(control.getHandlerForClick());	 
	 	
		anchor.getChildren().add(circ);
		 
	   } 
	
	 public void removeImageView() {
		 circ.setOpacity(opac);
	 }
	

	 /**
	  * Moves a generic image within the garden
	  */
	 public void moveGenImage() {
		rect = new Rectangle(plaWidth/sizingGen, plaWidth/sizingGen);
		rect.setStroke(Color.BISQUE);
		rect.setFill(new ImagePattern(imageView.getImage()));
		rect.setOnMouseDragged(control.getHandlerForDrag());
		rect.setOnMouseReleased(control.getHandlerForRelease());
		anchor.getChildren().add(rect);
	 }
	
	/**
	 * Sets the variable i in order to see where it is in the array
	 * @param imgview
	 * @return boolean
	 */
	 public boolean setI(ImageView imgview) {
		 if(ivArr.contains(imgview)) {
			 i = ivArr.indexOf(imgview);
			 return true;
		 }
		 return false;
	}	
	
	 /**
	  * Description: gets the plant based on all of the plants in database
	  * @return Plant
	  */
	 public Plant getImageName() {
		 imName = allPlants.get(i);
		 return imName;
	 }

	 
}

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
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
	// added things
	TextField userlabel;
  	 
	// value of the height and width of screen
	//int canvasWidth = 1380;
	//int canvasHeight = 940;
	int sceneWidth = 900;
	int sceneHeight = 600;
	
	int fontSize = 40;
	int boxSize = 20;
			
	int labelX = 300;
	int labelY = 15;
		
	int buttonWidth = 100;
	int buttonHeight = 100;
		
	int imgWidth = 300;
	int imgHeight = 300;
	    
	int strokeWidth = 2;
	Scene theScene;

	GraphicsContext gc;

	Image background;
	Image[] img;		
		
		//variables to determine the location of image
	double x = 0;
	double y = 0;
	Button prevButton;
	Button nextButton;
		
	Image back = new Image("file:images/bg2.png",sceneWidth, sceneHeight, false, false);
	Image mouse = new Image("file:images/leaf.png");

		
	BackgroundImage myBG;// = new BackgroundImage(back, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

	// Image home = new Image("icons/home.png", 50, 50, false, false);
	Button homeButton = new Button("Home");//, new ImageView(home));

	View currView;
	//ViewPage1 vp1;
	Controller control;
		
	Scene scene1;
	
		 
	//grid shindig
	//GridPane grid
	TilePane tile;
	 
	AnchorPane anchor;
	//		private BorderPane border; 
	//private TilePane tile;
			
	VBox tileBox;
	Garden g = new Garden();
	ArrayList<Plant> allPlants = g.allPlants;		
	//ArrayList<Plant> myPlants = new ArrayList<Plant>();
	ArrayList<Plant> gridPlants = new ArrayList<Plant>();
			
	Plant currPla;
			
	int plaWidth = 100;
	int plaHeight = 100;

	ImageView imageView;
	ImageView imgVL;
	int i=0;
	//new magic numbers
	int home=0; 
	int strokeWid = 2;
	int sizingGen = 2;
	int sizingPla =3;
		    
	ImageView ivg;
	int opac = 0;
	
	double vol = 0.05;
		 
	//ImageView[] ivArr;
	ArrayList<ImageView> ivArr = new ArrayList<ImageView>();
	//Scene scene2;
	   //VP5
	ArrayList<Integer> ratings = new ArrayList<Integer>();
		    
	/**
	 * sets the generalities of the abstract view	 
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
	 * Sets up the first stage of the application with background
	 * image & title. Adds ViewPage1 scene to the stage
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
	
	
		System.out.println("music");
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
	public void update() {
		
		//ratings = control.model.rateGarden(gridPlants);
		System.out.println(ratings.get(1));
		
	//	control = new Controller();
	} 
	
	/**
	 * Basic getter setting the current imageView
	 * @param iv
	 */
	public void setImageView(ImageView iv) {
		imageView = iv;
	}
	 
	Circle circ;
	/**
	 * add a plant to the garden and gives ability to move it; scaled based on type
	 * @param scale
	 */
	public void moveImageView(int scale) {
				 
		circ = new Circle(scale/2);
		circ.setStroke(Color.BISQUE);
		//Image im = new Image(allPlants.get(i).getImgName());
		circ.setFill(new ImagePattern(imageView.getImage()));
		 		
		circ.setTranslateX(sceneWidth/sizingPla);
		circ.setTranslateY(sceneHeight/sizingPla);		 
		 
		circ.setOnMouseDragged(control.getHandlerForDrag());
		circ.setOnMouseReleased(control.getHandlerForRelease());

	 	//circ.addEventHandler(KeyEvent.KEY_PRESSED, control.getHandlerForRemove());
	 	imageView.setOnMouseClicked(control.getHandlerForClick());
		
	  	System.out.println("Hi");
	 
	 //	newImageView();
	 	
		anchor.getChildren().add(circ);
		 
	   } 
	
	 public void removeImageView() {
		 
		 //grid.getChildren().remove(circ);
		// grid.getChildren().get(i).setOpacity(0);
		 circ.setOpacity(opac);
		// grid.getChildren().remove(i);
		// if()
	 }
	
	 Rectangle rect;
	 /**
	  * Moves a generic image within the garden
	  */
	 public void moveGenImage() {
		rect = new Rectangle(plaWidth/sizingGen, plaWidth/sizingGen);
		rect.setStroke(Color.BISQUE);
			//Image im = new Image(allPlants.get(i).getImgName());
		rect.setFill(new ImagePattern(imageView.getImage()));
		// ImageView imv = (ivArr.get(i));
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
	 
	
	
	 Plant imName;
	 /**
	  * Description: gets the plant based on all of the plants in database
	  * @return Plant
	  */
	 public Plant getImageName() {
		 
		 imName = allPlants.get(i);
		 
		// imName = imageView.getId();
		 System.out.println("HiIIIII" + imName.name);
		 return imName;
	 }

	 
}

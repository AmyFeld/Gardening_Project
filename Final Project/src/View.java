import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * This class is an abstract class used as a framework for all other views.
 * 
 * @author Lisa Pathania & Amy Feldman
 *
 */
public class View extends Application {
	
  	 
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
	 
	AnchorPane grid;
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
	int l=0;
		    
	ImageView ivg;
		 
	//ImageView[] ivArr;
	ArrayList<ImageView> ivArr = new ArrayList<ImageView>();
	//Scene scene2;
	   //VP5
	ArrayList<Integer> ratings = new ArrayList<Integer>();
		    
		 
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
	
	/*public void updateMyPlants(Plant p) {
		myPlants.add(p);
		myPlants.set(i, p);
		i++;
	}

	public ArrayList<Plant> getMyPlants() {
		return myPlants;
	}*/
	public void setImageView(ImageView iv) {
		imageView = iv;
	}
	 
	Circle circ;
	public void moveImageView(int scale) {
				 
		circ = new Circle(scale/2);
		circ.setStroke(Color.BISQUE);
		//Image im = new Image(allPlants.get(i).getImgName());
		circ.setFill(new ImagePattern(imageView.getImage()));
		 		
		circ.setTranslateX(sceneWidth/3);
		circ.setTranslateY(sceneHeight/3);		 
		 
		circ.setOnMouseDragged(control.getHandlerForDrag());
		circ.setOnMouseReleased(control.getHandlerForRelease());

	 	//circ.addEventHandler(KeyEvent.KEY_PRESSED, control.getHandlerForRemove());
	 	imageView.setOnMouseClicked(control.getHandlerForClick());
		
	  	System.out.println("Hi");
	 
	 //	newImageView();
	 	
		grid.getChildren().add(circ);
		 
	   } 
	
	 public void removeImageView() {
		 
		 //grid.getChildren().remove(circ);
		// grid.getChildren().get(i).setOpacity(0);
		 circ.setOpacity(0);
		// grid.getChildren().remove(i);
		// if()
	 }
	
	 Rectangle rect;
	 public void moveGenImage() {
		rect = new Rectangle(plaWidth/2, plaWidth/2);
		rect.setStroke(Color.BISQUE);
			//Image im = new Image(allPlants.get(i).getImgName());
		rect.setFill(new ImagePattern(imageView.getImage()));
		// ImageView imv = (ivArr.get(i));
		rect.setOnMouseDragged(control.getHandlerForDrag());
		rect.setOnMouseReleased(control.getHandlerForRelease());
		grid.getChildren().add(rect);
	 }
	
	 public void newImageView() {
		ImageView iv = new ImageView(imageView.getImage());
	  	  	
	 	iv.setPreserveRatio(true);
	 	iv.setFitHeight(100);
	  	
	 	//Tooltip.install(iv, new Tooltip(control.model.allPlants.get(i).greeneryHover()));
	  	
	 	iv.setOnMousePressed(control.getHandlerForClick());
	    	
	 	System.out.println(ivArr.add(iv));
		tileBox.getChildren().remove(i);
	 	tileBox.getChildren().add(i, iv);
	 		
	 	System.out.println("BLEH" + iv);
	 }
	 
	public void getRatings() {
		 
		 //return control.getRating();
	 }
	
	 public boolean setI(ImageView imgview) {
		
		 if(ivArr.contains(imgview)) {
			 i = ivArr.indexOf(imgview);
		 	return true;
		 }
			return false;
	}
	 
	
	
	 Plant imName;
	 public Plant getImageName() {
		 
		 imName = allPlants.get(i);
		 
		// imName = imageView.getId();
		 System.out.println("HiIIIII" + imName.name);
		 return imName;
	 }

	 
}

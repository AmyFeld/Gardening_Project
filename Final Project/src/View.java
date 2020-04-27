import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// This class is an abstract class used as a framework for all other views

public class View extends Application {
  	
	// value of the height and width of screen
		int canvasWidth = 1380;
		int canvasHeight = 940;
		
	// value of the size of the image
		static final int imgWidthOrig = 100;
		static final int imgHeightOrig = 100;

		int imgWidth = 300;
		int imgHeight = 300;
	    
	    Scene theScene;

	    GraphicsContext gc;

	    Image background;
	    Image[] img;		
		
		//variables to determine the location of image
		double x = 0;
		double y = 0;
		Button prevButton;
		Button nextButton;
		
	   // Image home = new Image("icons/home.png", 50, 50, false, false);
	    Button homeButton = new Button("home");//, new ImageView(home));

		View currView;
		//ViewPage1 vp1;
		
		
		 Scene scene1;
		//Scene scene2;
		 
		 
	@Override
	public void start(Stage theStage) throws Exception {
		Image back = new Image("file:bg.png");
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
	
	
	public void setViewPage(View view) {
		currView = view;
		
	}
	
	public void getScene(Scene scene) {
		scene1 = scene;
	}
	

	public void addMouseListener(Controller controller) {
		// TODO Auto-generated method stub
		
	}

	public void setOnAction(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Input: What Page Currently on? or None
	 * Output: None
	 * Function: takes in the information that was used to update and fixes the page and what should be seen
	 */
	public void update() {
		
	}
	
	/*
	 * Input: None
	 * Output: None
	 * Function: imports that images based on the page that the user is on and the images needed
	 */
	public void importImages() {
		
	}
	
	
    //Read image from file and return
    private Image createImage(String image_file) {
        Image img = new Image(image_file);
        return img;   	
    } 
    
	public Scene getScene() {
		return theScene;
	}
	
	//getter methods to get the frame dimensions and image dimensions
	public int getWidth() {
		return canvasWidth;
	}
	
	public int getHeight() {
		return canvasHeight;
	}
	
	public int getImageWidth() {
		return imgWidth;
	}
	
	public int getImageHeight() {
		return imgHeight;
	}
	
}
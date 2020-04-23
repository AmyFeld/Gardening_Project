
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
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
	    Stage theStage;

	    GraphicsContext gc;

	    Image background;
	    Image[] img;		
		
		//variables to determine the location of image
		double x = 0;
		double y = 0;
		Text t = new Text(); // as a title for each page
		Button prevButton;
		Button nextButton;
		Button homeButton;
		View ViewPage1;
		View ViewPage2;
		View ViewPage3;
		View ViewPage4;
		View ViewPage5;
		View ViewPage6;
		View ViewPage7;
		View currView;


	
	/*public View(Stage theStage) {
		
		theStage.setTitle("Create a Garden");
		Group root = new Group();
		
		theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
      		
		}*/
	

	@Override
	public void start(Stage theStage) throws Exception {
		this.theStage = theStage;
		
	      Group group = new Group();  
	      Scene scene = new Scene(group ,600, 300); 
	      
	      scene.setFill(Color.LIGHTGREEN); 
	      //group.addChildren(t);
		  Text t = new Text("hihob"); // as a title for each page
		  
		  
		  // home button if fired
		  homeButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					
					System.out.println("Home button is clicked");
					 setViewPage(ViewPage1);
			 
				}
			});
		  
		  // back button if fired
		  prevButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					System.out.println("Back button is clicked");
					// setViewPage(get);
			 
				}
			});
		  
		  
		  // next button if fired
		  nextButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					System.out.println("Next button is clicked");

				}
			});
		  
	      theStage.setTitle("Build Your Garden"); 
	   	  theStage.setScene(scene); 
	   	  theStage.show(); 		
	}
	
	public void setViewPage(View view) {
		currView = view;
		
	}
	
	
	 public static void main(String args[]){          
	      launch(args);     
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

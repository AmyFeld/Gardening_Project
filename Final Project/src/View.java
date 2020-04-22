
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

// This class is an abstract class used as a framework for all other views

public class View {
  	
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

	
	public View(Stage theStage) {
		
		theStage.setTitle("Create a Garden");
		Group root = new Group();
		
		theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
      		
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

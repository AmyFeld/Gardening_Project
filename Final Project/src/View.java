import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class View {
  
  	//[] Image img;
	
	// value of the height and width of screen
		int canvasWidth = 1380;
		int canvasHeight = 940;
		// value of the size of the image
		static final int imgWidthOrig = 100;
		static final int imgHeightOrig = 100;

		int imgWidth = 300;
		int imgHeight = 300;
	    
	    GraphicsContext gc;

	    Image background;
		// array of wide png images
	    Image[] animationSequence;

		
		
		//variables to determine the location of image
		double x = 0;
		double y = 0;
		
		//double xMouse;
		//double yMouse;
		
	
	
	
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
	public void importImages(){
		
	}
	
	
	

}

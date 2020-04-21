import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;

// This class presents the plant information page when a plant is selected and includes a slider to show back and forth between times
public class ViewPage3 extends View{
	String title;
	

	
	public ViewPage3(Stage theStage, EventHandler<ActionEvent> SSButton) {
        theStage.setTitle("Plant Information");
    
      slider = new JSlider();
      // have to finish uploading information about this
    

       
        
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);


        gc = canvas.getGraphicsContext2D();

		
		//importImages();
		
	
	}
  
  /*
   * Input: None
   * Output: None
   * Function: Changes what happens when the slider is changed 
   */
  public void SliderChange(){
    
  }
  
  
    
    //Helpful Tools: https://www.dummies.com/programming/java/how-to-use-sliders-in-java/
}

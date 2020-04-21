import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;

// This class presents the Rate My Garden page and takes in the ratings to present each topic using different icons
public class ViewPage5 extends View{
	String title;
	

	
	public ViewPage5(Stage theStage, EventHandler<ActionEvent> SSButton) {
        theStage.setTitle("Rate My Garden");

       
        
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);


        gc = canvas.getGraphicsContext2D();

		
		//importImages();
		
	
	}

  /*
   * Input: int 
   * Output: None
   * Function: presents happiness using some form of icon
   */
  public void presentHappiness(int happy){

  }
  
  /*
   * Input: int 
   * Output: None
   * Function: presents cont bloom rating using some form of icon
   */
  public void presentContBloom(int bloom){
    
  }
  
    /*
   * Input: int 
   * Output: None
   * Function: presents animals fed rating  using some form of icon
   */
  
  public void presentAnimalsFedRating(int animal){
  
  }
  
    /*
   * Input: int 
   * Output: None
   * Function: presents compatibility rating using some form of icon
   */
  public void presentCompatibilityRating(int compat){
    
  }
  
    /*
   * Input: int 
   * Output: None
   * Function: presents transition rating using some form of icon
   */
  
  public void presentTransition Rating(int transit){
    
  }

  
  /*
   * Input: None 
   * Output: None
   * Function: Starts up view Page
   */
  public void start(){
  
  }


}

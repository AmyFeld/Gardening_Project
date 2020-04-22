import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;


// This class is used to present the Tips to Start tab and include the information and buttons that will present the information
public class ViewPage9 extends View {
	String title;
	

	
	public ViewPage9(Stage theStage, EventHandler<ActionEvent> SSButton) {
        theStage.setTitle("Tips to Start");

        Button unhappy = new Button("Unhappy?");
        unhappy.setOnAction(SSButton);
        
        Button bestPlace = new Button("Best Place to Start");
        bestPlace.setOnAction(SSButton);
        
        Button start = new Button("Start with");
        start.setOnAction(SSButton);
        
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);
        root.getChildren().add(unhappy);
        root.getChildren().add(bestPlace);
        root.getChildren().add(start);

        gc = canvas.getGraphicsContext2D();

	
		//importImages();
		
	
	}
	
	/*
	 * Input: None
	 * Output: None
	 * Function: Will read in a .txt file and upload it onto the canvas
	 */
	public void uploadText() {
		// generic of what it should be 
		// later add a part that "when unhappy button = clicked"
		 File file = new File("\SLIDE9.txt"); 
    		Scanner sc = new Scanner(file); 
  
    		while (sc.hasNextLine()) 
      			System.out.println(sc.nextLine()); 
		
	}

}

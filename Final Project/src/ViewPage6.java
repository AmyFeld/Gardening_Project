 import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;


// This class is used to present the About Arden tab and include the information and buttons that will present the information

public class ViewPage6 extends View{
	String title;
	

	
	public ViewPage6(Stage theStage, EventHandler<ActionEvent> SSButton) {
        theStage.setTitle("AboutArden");

        Button missionStatement = new Button("Mission Statement");
        missionStatement.setOnAction(SSButton);
        
        Button purpose = new Button("Purpose");
        purpose.setOnAction(SSButton);
        
        Button history = new Button("History");
        history.setOnAction(SSButton);
        
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);
        root.getChildren().add(missionStatement);
        root.getChildren().add(purpose);
        root.getChildren().add(history);

        gc = canvas.getGraphicsContext2D();

		
		//importImages();
		
	
	}

	/*
	 * Input: None
	 * Output: None
	 * Function: Will read in a .txt file and upload it onto the canvas
	 */
public void uploadText() {
		
	}
}

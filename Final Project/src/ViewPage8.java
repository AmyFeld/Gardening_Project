import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;

// This class is used to present the Benefits of a Garden tab and include the information and buttons that will present the information

public class ViewPage8 extends View{
	String title;
	

	
	public ViewPage8(Stage theStage, EventHandler<ActionEvent> SSButton) {
        theStage.setTitle("Benefits of a Garden");

        Button animals = new Button("Animals");
        animals.setOnAction(SSButton);
        
        Button edge = new Button("Stopping an Edge");
        edge.setOnAction(SSButton);
        
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);
        root.getChildren().add(animals);
        root.getChildren().add(edge);
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

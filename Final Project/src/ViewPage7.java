import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewPage7 extends View {
	String title;
	

	
	public ViewPage7(Stage theStage, EventHandler<ActionEvent> SSButton) {
        theStage.setTitle("Resources");

        Button buy = new Button("Where to buy");
        buy.setOnAction(SSButton);

        Button faq = new Button("Frequently Asked Questions");
        faq.setOnAction(SSButton);
        
     
        
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);
        root.getChildren().add(buy);
        root.getChildren().add(faq);
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

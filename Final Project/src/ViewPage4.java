import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewPage4 extends View{
	String title;
	

	
	public ViewPage4(Stage theStage, EventHandler<ActionEvent> SSButton) {
        theStage.setTitle("My Garden");

       
        
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);


        gc = canvas.getGraphicsContext2D();

		
		//importImages();
		
	
	}
}

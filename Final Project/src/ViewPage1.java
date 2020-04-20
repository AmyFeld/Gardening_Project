 import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewPage1 extends View{
	String title;
	

	
	public ViewPage1(Stage theStage, EventHandler<ActionEvent> SSButton) {
        theStage.setTitle("AboutArden");

        Button page2  = new Button("Start Gardening");
        page2.setOnAction(SSButton);
        
        Button page6 = new Button("About Arden");
        page6.setOnAction(SSButton);
        
        Button page7 = new Button("Resources");
        page7.setOnAction(SSButton);
     
        Button page8 = new Button("Benefits of a Garden");
        page8.setOnAction(SSButton);
        
        Button page9 = new Button("Tips to Start");
        page9.setOnAction(SSButton);
        
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);
        
        root.getChildren().add(page2);
        
   
        root.getChildren().add(page6);
        root.getChildren().add(page7);
        root.getChildren().add(page8);
        root.getChildren().add(page9);
        
        gc = canvas.getGraphicsContext2D();

		
		//importImages();
		
	
	}
}

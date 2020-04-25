import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// This class is used to present the Benefits of a Garden tab and include the information and buttons that will present the information

public class ViewPage8 extends View{
	Scene scene1;

	public ViewPage8(Stage theStage) {
				
		  // home button if fired
		VBox layout1 = new VBox(20);     
	    Label label1 = new Label("Benefits of a Garden");
	  	Button home = new Button("Home");
	  	Button animal = new Button("Animals");
	  	Button stop = new Button("Stopping an Edge");
	  	
	  	
	  	layout1.getChildren().addAll(label1, home,animal,stop);
		
	  	scene1 = new Scene(layout1, 600, 300); // the button and label
		 //   scene1.setFill(Color.LIGHTGREEN);
	  		  	
	    home.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));	 
	  	
	   	 theStage.setScene(scene1); 
	   	 theStage.show(); 	

	}	
	
	public Scene getScene8() {
		return scene1;
	}

	 public static void main(String args[]){          
	      launch(args);     
	   }
	
	
	/*String title;
	

	
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
		
	
	}*/
	
	/*
	 * Input: None
	 * Output: None
	 * Function: Will read in a .txt file and upload it onto the canvas
	 */
	
public void uploadText() {
		
	}

}

 import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// This class is a subclass of view that will draw out the home page with proper buttons

public class ViewPage1 extends View {
	
	Scene scene1;

	public ViewPage1(Stage theStage) {
				
		  // home button if fired
		VBox layout1 = new VBox(20);     
	    Label label1 = new Label("Create Your Own Garden");
	  	Button button1 = new Button("Start Planting");
	  	Button page6 = new Button("About Arden");
	  	Button page7 = new Button("Resources");
	  	Button page8 = new Button("Benefits of a Garden");
	  	Button page9 = new Button("Tips to Start");
	  	layout1.getChildren().addAll(label1, button1, page6, page7, page8, page9);
		
	  	scene1 = new Scene(layout1, 600, 300); // the button and label
		 //   scene1.setFill(Color.LIGHTGREEN);
	  		  	
	  	button1.setOnAction(e -> theStage.setScene(new ViewPage2(theStage).getScene2()));	 
	  	page6.setOnAction(e-> theStage.setScene(new ViewPage6(theStage).getScene6()));
	  	page7.setOnAction(e-> theStage.setScene(new ViewPage7(theStage).getScene7()));
	  	page8.setOnAction(e-> theStage.setScene(new ViewPage8(theStage).getScene8()));
	  	page9.setOnAction(e-> theStage.setScene(new ViewPage9(theStage).getScene9()));
	  	
	   	 theStage.setScene(scene1); 
	   	 theStage.show(); 	

	}	
	
	public Scene getScene1() {
		return scene1;
	}

	 public static void main(String args[]){          
	      launch(args);     
	   }
	

	
	/*public ViewPage1(Stage theStage, EventHandler<ActionEvent> SSButton) {
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
		
	
	} */
}

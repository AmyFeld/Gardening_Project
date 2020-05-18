import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class is a subclass of view that will draw out the home page with proper buttons
 * 
 * @author Amy Feldman & Lisa Pathania
 *
 */
public class ViewPage1 extends View {
	
	Scene scene1;
	
	/**
	 * Description: Sets up the first stage of the application with background
	 * image & title. Adds Scene1 scene to the stage and creates buttons that will go to future pages
	 *
	 *@param Stage  a platform container to hold scene1 
	 */

	public ViewPage1(Stage theStage) {
				
		  // home button if fired
		
		VBox layout2 = new VBox(boxSize);
		
		back = new Image("file:images/bg.png", sceneWidth, sceneHeight, false, false);
		myBG  = new BackgroundImage(back, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		
		HBox layout1 = new HBox(boxSize); 
		Text label1 = new Text("Create Your Own Garden");
		label1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, fontSize));
	     	label1.setFill(Color.WHITE); 
	     	label1.setStrokeWidth(2); 
	     	label1.setStroke(Color.BLUE);    
	   // Label label1 = new Label("Create Your Own Garden");
	    
	  	Button button1 = new Button("Start Planting");
	  	//.setAlignment(Pos.CENTER);
	  	Button page6 = new Button("About Arden");
	  	Button page7 = new Button("Resources");
	  	Button page8 = new Button("Benefits of a Garden");
	  	Button page9 = new Button("Tips to Start");
	  	layout2.getChildren().addAll(label1, button1);
	  	layout1.getChildren().addAll(page6, page7, page8, page9);
	  	layout1.setAlignment(Pos.BOTTOM_CENTER);
		layout2.setAlignment(Pos.CENTER);
		

	  	layout2.setBackground(new Background(myBG));
	  	
	 	Group root = new Group();
		//root.getChildren().addAll(layout1, layout2);
		layout2.getChildren().add(layout1);
		
	  	scene1 = new Scene(layout2,sceneWidth, sceneHeight); // the button and label
		 //   scene1.setFill(Color.LIGHTGREEN);
	  		  	
	  	button1.setOnAction(e -> theStage.setScene(new ViewPage2(theStage).getScene2()));	 
	  	page6.setOnAction(e-> theStage.setScene(new ViewPage6(theStage).getScene6()));
	  	page7.setOnAction(e-> theStage.setScene(new ViewPage7(theStage).getScene7()));
	  	page8.setOnAction(e-> theStage.setScene(new ViewPage8(theStage).getScene8()));
	  	page9.setOnAction(e-> theStage.setScene(new ViewPage9(theStage).getScene9()));
	  	
	  	
	   	 theStage.setScene(scene1); 
	   	 theStage.show(); 	

	}	
	
	/**
	 * Description: basic getter for the scene in order to receive it when buttons are pressed on home screens 
	 * 
	 * 
	 * @return scene1
	 */
	public Scene getScene1() {
		return scene1;
	}

}
	

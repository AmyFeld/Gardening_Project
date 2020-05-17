import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * This class is a subclass of view that will draw out the greenery tour page. It also presents the
 * Rate My Garden page and takes in the ratings to present each topic using different icons.
 * 
 * @author Amy Feldman & Lisa Pathania
 *
 */

//This class is a subclass of view that will draw out the greenery tour page
//This class presents the Rate My Garden page and takes in the ratings to present each topic using different icons

public class ViewPage5 extends View {
	
	
	int colorStars;
	int bloomStars; 
	int animalStars; 
	int compatStars; 
	int transitStars; 
	int overallStars; // have to add to model
	int cs1 = 0;
	int cs2 = 1;
	int cs3 = 2;
	int cs4 = 3;
	int cs5 = 4;
	int cs6 = 5;
	
	int STARH = 75;
	int STARW = 75;
	
	VBox layout2 = new VBox();
	
	int hboxInt = 20;
	Scene scene5;
	
	/**
	 * For the user to get results of their garden rating this class will consume numbers to show based on stars and also be able to share further
	 * 
	 * @param Stage  Holds the image of the garden and plants
	 * @return none  Creates an application displaying the graphics 
	 *
	 */
	public ViewPage5(Stage theStage) {
			
				
  		theStage.setTitle("Rate My Garden");

  		HBox layout1 = new HBox(hboxInt);     
	        Label label1 = new Label("Rate My Garden");
	  	//Button home = new Button("Home");
	  	Button save = new Button("Save to");
	  	//Button faq = new Button("Frequently Asked Questions");
	  	Label buttonPressed = new Label("");
		//Button back2g = new Button("Back to Garden");	  	
	  	layout1.getChildren().addAll(label1, homeButton, save, buttonPressed);
		
	  	//Group root = new Group();
	  	//root.getChildren().addAll(layout1);
	  			 //   scene1.setFill(Color.LIGHTGREEN);
	  		  	
	    homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));	 
	    
  
  		save.setOnAction(e -> { 
		    FileChooser fileChooser = new FileChooser();
	  		try {
	  			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Ser", ".ser"));
	  			File file = fileChooser.showSaveDialog(theStage);
	  			if(file != null) {
	  				FileOutputStream fileOut = new FileOutputStream(file);
					ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	  				objectOut.writeObject(control.model);
					objectOut.close();
					fileOut.close();
					save.setText("Saved");
	  			}

			} catch (Exception ex) {

				ex.printStackTrace();}
  		});
  		
	    
  		layout2.getChildren().add(layout1);
  		start(theStage);
  
  		layout2.setBackground(new Background(myBG));
	
		scene5 = new Scene(layout2, sceneWidth, sceneHeight); // the button and label
  		theStage.setScene(scene5); 
	   	theStage.show();
	
	}
	
	
	/**
	 * Description: basic getter for the scene in order to receive it when buttons are pressed on home screens 
	 * 
	 * 
	 * @return scene4
	 */
	public Scene getScene5() {
		return scene5;
	}

	/**
	 * Description: sets all of the ratings based on the model calculated ratings
	 * 
	 * 
	 * 
	 */
	public void setAllRatings() {
		System.out.println(ratings);
	    //ratings = getRatings();
	     //   System.out.println(ratings);
	      
		/*presentColor(ratings.get(cs1));
		presentContBloom(ratings.get(cs2));
		presentAnimalsFedRating(ratings.get(cs3));
		presentCompatibilityRating(ratings.get(cs4));
		presentTransitionRating(ratings.get(cs5));
		presentOverallRating(ratings.get(cs6));*/
	}
	
	/**
	 * Description: basic setter for taking in int from View that consumes from Model
	 * 
	 * @param int happy rating int calculated
	 * @return none
	 */
	
	public void presentColor(int color){
		colorStars = color;
	}

	/**
 	 * Description: basic setter for taking in int from View that consumes from Model
 	 * 
 	 * @param int bloom rating int calculated
 	 * @return none
 	 */
	public void presentContBloom(int bloom){
		bloomStars = bloom;
	}

	/**
 	 * Description: basic setter for taking in int from View that consumes from Model
 	 * 
 	 * @param int animal rating int calculated
 	 * @return none
 	 */

	public void presentAnimalsFedRating(int animal){
		animalStars = animal;
	}

	/**
 	 * Description: basic setter for taking in int from View that consumes from Model
 	 * 
 	 * @param int compatibility rating int calculated
 	 * @return none
 	 */
	 public void presentCompatibilityRating(int compat){
		compatStars = compat;
	 }

	/**
  	 * Description: basic setter for taking in int from View that consumes from Model
 	 * 
 	 * @param int transition rating int calculated
 	 * @return none
 	 */
	 public void presentTransitionRating(int transit){
	 	transitStars = transit;
	 }


	public void presentOverallRating(int overall) {
		overallStars = overall;
	}

	/**
 	 * Description: takes in the integer and presents each of the ratings and overall evaluation as 
 	 * a star added to a layout to be presented to the user
 	 * 
 	 * @param theStage 
 	 * @return none
 	 */
	 public void start(Stage theStage){
		setAllRatings();
	  	Image image = new Image("file:images/starD.png", STARH, STARW, true, true);
	  	//ImageView imageView = new ImageView(image);
	  	Label coll = new Label("Color Rating");
	  	Label blol = new Label("Continuous Bloom Rating");
	  	Label anil = new Label("Animal Rating");
	  	Label coml = new Label("Compatablity Rating");
	  	Label tral = new Label("Transitional Rating (from Edge)");
	  	Label overl = new Label("Overall Rating");
	  
		HBox col = new HBox();
	  	HBox blo = new HBox();
	  	HBox ani = new HBox();
	  	HBox com = new HBox();
	  	HBox tra = new HBox();
	  	HBox over = new HBox();
		  
		for(int i = 0; i<colorStars; i++) {
			System.out.print("*");
		  	ImageView imageViewC = new ImageView(image);
		  	col.getChildren().add(imageViewC);
		}
	  	System.out.println("");
	  
	  	for(int i = 0; i<bloomStars; i++) {
			System.out.print("*");
		  	ImageView imageViewB = new ImageView(image);
		  	blo.getChildren().add(imageViewB);
	  	}
	  	System.out.println("");
	  
		for(int i = 0; i<animalStars; i++) {
			System.out.print("*");
		  	ImageView imageViewA = new ImageView(image);
		  	ani.getChildren().add(imageViewA);
		 }
	  	System.out.println("");
	  
	  	for(int i = 0; i<compatStars; i++) {
			System.out.print("*");
		  	ImageView imageViewP = new ImageView(image);
		  	com.getChildren().add(imageViewP);
		 }
	  	System.out.println("");
	  
	  	for(int i = 0; i<transitStars; i++) {
			System.out.print("*");
		  	ImageView imageViewT = new ImageView(image);
		  	tra.getChildren().add(imageViewT);
 		}
	  
	  	for(int i = 0; i<overallStars; i++) {
			System.out.print("*");
		  	ImageView imageViewO = new ImageView(image);
		  	over.getChildren().add(imageViewO);
	  	}
	  	layout2.getChildren().addAll(coll,col,blol,blo,anil,ani,coml,com,tral,tra, overl, over);
	    
	}

}

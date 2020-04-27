import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.effect.Effect;
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
import javafx.stage.Screen;
import javafx.stage.Stage;

// This class is a subclass of view that will draw out the greenery tour page
//This class presents the Rate My Garden page and takes in the ratings to present each topic using different icons
public class ViewPage5 extends View{
	//String title;
	//private Text buttonPressed;
	
	int canvasWidth ;
	int canvasHeight ;
	
	
	//practice numbers for now
	
	int happyStars = 3;
	int bloomStars = 4; 
	int animalStars = 2; 
	int compatStars = 5; 
	int transitStars = 1; 
	
	 VBox layout2 = new VBox();
	

	Scene scene5;
	
	public ViewPage5(Stage theStage) {
		
		
		Image back = new Image("file:bg2.png", canvasWidth, canvasHeight, false, false);
		ImageView bg = new ImageView(back);
		//bg.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
		//bg.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
		BackgroundImage myBG= new BackgroundImage(back, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		
     theStage.setTitle("Rate My Garden");

     HBox layout1 = new HBox(20);     
	    Label label1 = new Label("Rate My Garden");
	  	//Button home = new Button("Home");
	  	Button save = new Button("Save to");
	  	//Button faq = new Button("Frequently Asked Questions");
	  	Label buttonPressed = new Label("");
	  	
	  	layout1.getChildren().addAll(label1, homeButton,save, buttonPressed);
		
	  	//Group root = new Group();
	  	//root.getChildren().addAll(layout1);
	  	
	  	scene5 = new Scene(layout2, 900, 600); // the button and label
		 //   scene1.setFill(Color.LIGHTGREEN);
	  		  	
	    homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));	 
	    
	    
	    
	    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
         public void handle(ActionEvent e) 
         { 
             buttonPressed.setText("Here you will able to save to computer to share :)"); 
         } 
     };
     
     save.setOnAction(event);
	    
	    /*save.setOnAction(e -> { 
	  		buttonPressed.setText("Here you will be able to save to email and share...");
	  		});
	    */
     layout2.getChildren().add(layout1);
     start(theStage);
     
     //root.getChildren().add(layout2);
     layout2.setBackground(new Background(myBG));
	//root.setEffect(new Effect(myBG));	
	  // 	 layout2.getChildren();
	   	 
     theStage.setScene(scene5); 
	   	 theStage.show(); 	
	   	 
	   	// start();
		
	   	 //layout2.getChildren();
	
	}

	public Scene getScene5() {
		return scene5;
	}

/*
* Input: int 
* Output: None
* Function: presents happiness using some form of icon
*/
public void presentHappiness(int happy){
	  happyStars = happy;
}

/*
* Input: int 
* Output: None
* Function: presents cont bloom rating using some form of icon
*/
public void presentContBloom(int bloom){
 bloomStars = bloom;
}

 /*
* Input: int 
* Output: None
* Function: presents animals fed rating  using some form of icon
*/

public void presentAnimalsFedRating(int animal){
	  animalStars = animal;
}

 /*
* Input: int 
* Output: None
* Function: presents compatibility rating using some form of icon
*/
public void presentCompatibilityRating(int compat){
 compatStars = compat;
}

 /*
* Input: int 
* Output: None
* Function: presents transition rating using some form of icon
*/

public void presentTransitionRating(int transit){
 transitStars = transit;
}


/*
* Input: None 
* Output: None
* Function: Starts up view Page
*/
public void start(Stage theStage){
	  Image image = new Image("file:starD.png", 50, 50, true, true);
	  //ImageView imageView = new ImageView(image);
	  Label hapl = new Label("Happiness Rating");
	  Label blol = new Label("Continuous Bloom Rating");
	  Label anil = new Label("Animal Rating");
	  Label coml = new Label("Compatablity Rating");
	  Label tral = new Label("Transitional Rating (from Edge)");
	  
	  HBox hap = new HBox();
	  HBox blo = new HBox();
	  HBox ani = new HBox();
	  HBox com = new HBox();
	  HBox tra = new HBox();
	  
	  for(int i = 0; i<happyStars; i++) {
		  System.out.print("*");
		  ImageView imageView = new ImageView(image);
		  hap.getChildren().add(imageView);
		 
	  }
	  System.out.println("");
	  
	  for(int i = 0; i<bloomStars; i++) {
		  System.out.print("*");
		  ImageView imageView = new ImageView(image);
		  blo.getChildren().add(imageView);
	  }
	  System.out.println("");
	  
	  for(int i = 0; i<animalStars; i++) {
		  System.out.print("*");
		  ImageView imageView = new ImageView(image);
		  ani.getChildren().add(imageView);
		 
	  }
	  System.out.println("");
	  
	  for(int i = 0; i<compatStars; i++) {
		  System.out.print("*");
		  ImageView imageView = new ImageView(image);
		  com.getChildren().add(imageView);
		 
	  }
	  System.out.println("");
	  
	  for(int i = 0; i<transitStars; i++) {
		  System.out.print("*");
		  ImageView imageView = new ImageView(image);
		  tra.getChildren().add(imageView);
		 
	  }
	 //System.out.println("Hi");
	  layout2.getChildren().addAll(hapl,hap,blol,blo,anil,ani,coml,com,tral,tra);
	  
	  
}


}

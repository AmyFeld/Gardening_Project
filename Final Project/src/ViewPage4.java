import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

/**
 * This class presents the garden and includes the drag and drop feature to add new items to the garden
 * 
 * @author Amy Feldman 
 *
 */

//This class presents the garden and includes the drag and drop feature to add new items to the garden

public class ViewPage4 extends View {
	Scene scene4;
	private GridPane grid;
	private BorderPane border;
	private TilePane tile;
	

	/**
	 * For the user to view the garden and drag & drop, creates the scene that would work
	 * This would add the buttons as well as and calls the other methods
	 * 
	 * @param Stage  Holds the image of the garden and plants
	 * @return none  Creates an application displaying the graphics 
	 *
	 */

	public ViewPage4(Stage theStage) {
				
		  // home button if fired
		HBox layout1 = new HBox(20);     
	    Label label1 = new Label("Edit Your Garden");
	    Button rate = new Button("Rate My Garden");
	  	
	    tile = new TilePane(Orientation.VERTICAL);
		grid = new GridPane();
		border = new BorderPane();
		
	  	layout1.getChildren().addAll(label1, homeButton, rate);
		
	  	//scene4 = new Scene(layout1, 900, 600); // the button and label
		 //   scene1.setFill(Color.LIGHTGREEN);
	  		  	
	    homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));	 
	    rate.setOnAction(e-> theStage.setScene(new ViewPage5(theStage).getScene5()));
	    
	    
	    
		start(theStage);
	    layout1.setAlignment(Pos.TOP_CENTER);
		border.setTop(layout1);;
		
		scene4 = new Scene(border, sceneWidth, sceneHeight); // the

		 //tile.setFill(Color.LIGHTGREEN); 
	  	//tile.setBackground(new Background(new BackgroundFill(Color.web("#" + FFFFFF), CornerRadii.EMPTY, Insets.EMPTY)));
		
		  
	   	 theStage.setScene(scene4); 
	   	 theStage.show(); 	

	}	
	
	/**
	 * For the user to view the garden and drag & drop
	 *	for now just creates and adds to the panes to create  ~mock~ garden
	 * 
	 * @param Stage  Holds the image of the garden and plants
	 * @return none  Creates an application displaying the graphics 
	 *
	 */
	public void start(Stage stage) {
		//Image back = new Image("file:lawn.png", 600, 600, false, false);
	//	ImageView flowBG = new ImageView(back);
		//BackgroundImage flowBG = new BackgroundImage(back, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		Image backup_house = new Image("file:backup_house.png", 100, 100, false, false);
		ImageView iv = new ImageView(backup_house);
		Image plant1 = new Image("file:plant1.png", 100, 100, false, false);
		ImageView iv2 = new ImageView(plant1);
		Image plant2 = new Image("file:plant2.png", 100, 100, false, false);
		ImageView iv3 = new ImageView(plant2);
		
		Rectangle r = new Rectangle(600, 600);
		r.setFill(Color.LIGHTGREEN);
		
	  tile.setTileAlignment(Pos.CENTER_LEFT);
      tile.setPrefRows(5);
      
      tile.getChildren().addAll(iv, iv2, iv3);
      
      //flow.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
      //flow.setStyle()
   //   grid.setBackground(new Background(flowBG));
      grid.setPrefHeight(600);
      grid.getChildren().add(r);
      //flow.setColumnHalignment(HPos.CENTER);
     //flow.setPrefWrapLength(3*canvasWidth/4);
      border.setLeft(tile);
      border.setCenter(grid);
      
     // border.getRight().setStyle("-fx-border-color: lightgreen;");
     
    //  flow.setStyle("-fx-border-color: POWDERBLUE;");
      
      
      
		
	}
	
	/**
	 * Description: basic getter for the scene in order to receive it when buttons are pressed on home screens 
	 * 
	 * 
	 * @return scene4
	 */
	public Scene getScene4() {
		return scene4;
	}

/*	 public static void main(String args[]){          
	      launch(args);     
	   }*/
}



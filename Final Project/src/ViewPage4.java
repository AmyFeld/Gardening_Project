import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
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
import javafx.scene.layout.VBox;

/**
 * This class presents the garden and includes the drag and drop feature to add new items to the garden
 * 
 * @author Amy Feldman 
 *
 */

//This class presents the garden and includes the drag and drop feature to add new items to the garden

public class ViewPage4 extends View {
	Scene scene4;
	private BorderPane border;
	
	
  
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
	  	Button back = new Button("Plant Nursery");
	    // set tile pane height/?
	    tile = new TilePane(Orientation.VERTICAL);
		grid = new GridPane();
		border = new BorderPane();
		
	  	layout1.getChildren().addAll(back, label1, homeButton, rate);
		
	  	//scene4 = new Scene(layout1, 900, 600); // the button and label
		 //   scene1.setFill(Color.LIGHTGREEN);
	  		  	
	    homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));	 
	    rate.setOnAction(e-> theStage.setScene(new ViewPage5(theStage).getScene5()));
	    back.setOnAction(e -> theStage.setScene(new ViewPage2(theStage).getScene2()));
	    
	    
		start(theStage);
	    layout1.setAlignment(Pos.TOP_CENTER);
		border.setTop(layout1);
		
			
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
	ImageView iv;
	//Generic Yard Images
		Image backup_house = new Image("file:images/backup_house.png", 100, 100, false, false);
		ImageView ivHouse = new ImageView(backup_house);
		Image pool = new Image("file:images/pool.png", 100, 100, false, false);
		ImageView ivPool = new ImageView(pool);
		Image fence = new Image("file:images/fence.png", 150, 50, false, false);
		ImageView ivFence = new ImageView(fence);
		Image road= new Image("file:images/road.png", 100, 100, false, false);
		ImageView ivRoad = new ImageView(road);
		Image driveWay= new Image("file:images/road.png", 100, 100, false, false);
		ImageView ivDriveWay = new ImageView(driveWay);
		
	
		//moving generic images
		ivHouse.setPreserveRatio(true);
	  	ivHouse.setFitHeight(100);
    	
    	ivHouse.setOnMouseDragged(control.getHandlerForDrag());
    	ivHouse.setOnMousePressed(control.getHandlerForClick());
    	ivHouse.setOnMouseReleased(control.getHandlerForRelease());
    	//Pool
    	ivPool.setPreserveRatio(true);
	  	ivPool.setFitHeight(100);
    	
    	ivPool.setOnMouseDragged(control.getHandlerForDrag());
    	ivPool.setOnMousePressed(control.getHandlerForClick());
    	ivPool.setOnMouseReleased(control.getHandlerForRelease());
    	//Fence
    	ivFence.setPreserveRatio(true);
	  	ivFence.setFitHeight(100);
    	
    	ivFence.setOnMouseDragged(control.getHandlerForDrag());
    	ivFence.setOnMousePressed(control.getHandlerForClick());
    	ivFence.setOnMouseReleased(control.getHandlerForRelease());
    	//Road
    	ivRoad.setPreserveRatio(true);
	  	ivRoad.setFitHeight(100);
    	
    	ivRoad.setOnMouseDragged(control.getHandlerForDrag());
    	ivRoad.setOnMousePressed(control.getHandlerForClick());
    	ivRoad.setOnMouseReleased(control.getHandlerForRelease());
    	//DriveWay
    	ivDriveWay.setPreserveRatio(true);
	  	ivDriveWay.setFitHeight(100);
    	
    	ivDriveWay.setOnMouseDragged(control.getHandlerForDrag());
    	ivDriveWay.setOnMousePressed(control.getHandlerForClick());
    	ivDriveWay.setOnMouseReleased(control.getHandlerForRelease());
    	
	//Pretend lawn for grid
		Rectangle r = new Rectangle(600, 600);
		r.setFill(Color.LIGHTGREEN);
		
		grid.setStyle("-fx-background-color: #05F861;");
		
	//Creating Basic Tile Params
	 // tile.setTileAlignment(Pos.CENTER_LEFT);
      //tile.setPrefRows(5);
      tile.setMaxWidth(plaWidth);
      tileBox = new VBox(20);
      
      //create scroll pane :)
      
     //setting the grid and tile to places 
      
       ScrollPane sc = new ScrollPane(tile);
      sc.setPrefViewportHeight(tileBox.getHeight());
      //sc.maxWidth(100);
     // sc.setFitToWidth(false);
      sc.setPrefWidth(plaWidth);
      sc.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
     // sc.autosize();
     
      	grid.setPrefHeight(600);
    	
      	border.setLeft(sc);
      	border.setCenter(grid);
        grid.setGridLinesVisible(true);
      
   //Setting up the image views and moving them 
  
      for(  i=0; i< myPlants.size(); i++) {
    	
    	  	iv = new ImageView(new Image(myPlants.get(i).getImgName(), plaWidth, plaHeight, false, false));
    		
    		//ivArr.insert(i, iv);
    	//  	ivArr.

    	  	iv.setPreserveRatio(true);
    	  	iv.setFitHeight(100);
        	
        	iv.setOnMouseDragged(control.getHandlerForDrag());
        	iv.setOnMousePressed(control.getHandlerForClick());
        	iv.setOnMouseReleased(control.getHandlerForRelease());
    	  	// FIX to be an array list
    	  //	ivArr.add(i, iv);
    	  	//ivArr.add(iv);
        	
        	System.out.println(ivArr.add(iv));
        	System.out.println(ivArr.indexOf(iv));
        	//addImage(control.getOriginX(), control.getOriginY(), 1, iv1);
        	System.out.println("ADDING IMAGE " + i);
        	//addImage(iv1.getTranslateX(), iv1.getTranslateY(), i, iv1);
        	//iv1.setTranslateX(control.getStartingX());
    		//iv1.setTranslateY(control.getStartingY());
    	  

        	tileBox.getChildren().add(iv);
    	   // tile.getChildren().add(iv1);
      } 
     
      tileBox.getChildren().addAll(ivHouse, ivPool, ivFence, ivRoad, ivDriveWay);

      System.out.println("Grid Children: "+ grid.getChildren());
      
     
      System.out.println(tileBox.getChildren());
     
     //tile.getChildren().addAll(imageView);
     //tile.getChildren().add(iv0);
       tile.getChildren().add(tileBox);
      sc.setContent(tile);
     
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

	
}



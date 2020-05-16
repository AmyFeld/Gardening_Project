import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
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
	
	//ArrayList<Plant> page4Plants = new ArrayList<Plant>();
  
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
		grid = new AnchorPane();
		border = new BorderPane();
		
	  	layout1.getChildren().addAll(back, label1, homeButton, rate);
	     
	  	Slider sl = new Slider();
	      sl.setOrientation(Orientation.VERTICAL);
	      sl.setMin(0);
	      sl.setMax(100);
	      sl.setMaxHeight(300);
	      sl.setValue(40);
	      sl.setShowTickLabels(true);
	      sl.setShowTickMarks(true);
	      sl.setMajorTickUnit(50);
	      sl.setMinorTickCount(0);
	      sl.setBlockIncrement(20);
		
	        Image trash = new Image("file:images/Trash.png", 100, 100, false, false);
	      ImageView imtrash = new ImageView(trash);
	     // Button label = new Button("Create new label");
	      TextField userlabel = new TextField("Create new label"); 
	      
	      //label.setOnAction(new EventHandler<ActionEvent>() {
	      EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
	      public void handle(ActionEvent e) {
	    		  //Label userlabel = new Label(new TextField().getText());
	    		
	    		  Label l = new Label();
	    		  l.setText(userlabel.getText());
	    		  grid.getChildren().add(l);
	    		  l.setOnMouseDragged(control.getHandlerForDrag());
	    		  l.setOnMouseReleased(control.getHandlerForRelease());
	    	  }
	      };
	      
	      userlabel.setOnAction(event);	
		 VBox right = new VBox(50);
	      right.getChildren().addAll(sl, userlabel, imtrash);
	  	//scene4 = new Scene(layout1, 900, 600); // the button and label
		 //   scene1.setFill(Color.LIGHTGREEN);
	  		  	
	    homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));	 
	    rate.setOnAction(e-> theStage.setScene(new ViewPage5(theStage).getScene5()));
	    back.setOnAction(e -> theStage.setScene(new ViewPage2(theStage).getScene2()));
	    
	    //How To    
	    Alert explain = new Alert(AlertType.INFORMATION);
	    explain.setContentText("To add to the garden: click on the plant or object you would like to add it will be added to the garden. Then you can drag to the specific location.");
	    explain.show();
		
		start(theStage);
	    layout1.setAlignment(Pos.TOP_CENTER);
	    border.setRight(right);
		border.setTop(layout1);
	//	page4Plants = myPlant;
			
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
	/*	Rectangle r = new Rectangle(600, 600);
		r.setFill(Color.LIGHTGREEN); */
    	BackgroundImage bg = new BackgroundImage(new Image("file:images/grid.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	grid.setBackground(new Background(bg));
		
	 //	grid.setStyle("-fx-background-color: #05F861;");
		
	//Creating Basic Tile Params
	 // tile.setTileAlignment(Pos.CENTER_LEFT);
      //tile.setPrefRows(5);
      tile.setMaxWidth(plaWidth);
      tileBox = new VBox(20);
      
      //create scroll pane :)
      
     //setting the grid and tile to places 
      
       ScrollPane sc = new ScrollPane(tile);
      sc.setPrefViewportHeight(tileBox.getHeight());
      sc.setPrefWidth(plaWidth);
      sc.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
     // sc.autosize();
      
      	grid.setPrefHeight(600);
    	
      	border.setLeft(sc);
      	border.setCenter(grid);
    //    grid.setGridLinesVisible(true);
      
   //Setting up the image views and moving them 
    //    System.out.println(page4Plants.toString());
        
      //  myPlants = getMyPlants();
 //      System.out.println(control.model.getMyPlant().toString());
     //   control.model.myPlants.add(allPlants.get(7));
      for(  i=0; i< allPlants.size(); i++) {
    	  	
  	  	iv = new ImageView(new Image(allPlants.get(i).getImgName(), plaWidth, plaHeight, false, false));

    	/*  if ()
    	  	iv = new ImageView(new Image(allPlants.get(i).getImgName(), plaWidth, plaHeight, false, false));
      }
      else if () {
      }
      else {
    	  } */
    	  	iv.setPreserveRatio(true);
    	  	iv.setFitHeight(100);
    	  	
    	  	iv.setOnMousePressed(control.getHandlerForClick());
    	  	System.out.println("CLISKkahsdfkjhasf");
    	  	        	
        	System.out.println(ivArr.add(iv));
        	System.out.println("ADDING IMAGE " + i);
      

        	tileBox.getChildren().add(iv);
        	if(!grid.getChildren().isEmpty()) {
          	  for(int z = 0; z< grid.getChildren().size(); z++)
          	//  grid.getChildren().get(z).setOnMousePressed(control.getHandlerForClick());
            System.out.println("blah");	
            }
    	   // tile.getChildren().add(iv1);
      } 
    // ivArr.add(ivHouse);
    // ivArr.add(ivPool);
    // ivArr.add(ivFence);
    //ivArr.add(ivDriveWay);
     
    //  tileBox.getChildren().addAll(ivHouse, ivPool, ivFence, ivDriveWay);

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



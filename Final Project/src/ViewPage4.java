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
	
/*	 GridPane grid;
	
	//private TilePane tile;
	

	Garden g = new Garden();
	ArrayList<Plant> allPlants = g.allPlants;		
	ArrayList<Plant> myPlants = new ArrayList<Plant>();
	ArrayList<Plant> gridPlants = new ArrayList<Plant>();
	
	int plaWidth = 100;
	int plaHeight = 100;

    ImageView imageView;
    Image im1; 
    int i;
    int l;*/
   // ImageView iv1;
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
	//Pretend Images
		Image backup_house = new Image("file:backup_house.png", 100, 100, false, false);
		ImageView iv = new ImageView(backup_house);
		Image plant1 = new Image("file:plant1.png", 100, 100, false, false);
		ImageView iv2 = new ImageView(plant1);
		Image plant2 = new Image("file:plant2.png", 100, 100, false, false);
		ImageView iv3 = new ImageView(plant2);
	
	//Pretend lawn for grid
		Rectangle r = new Rectangle(600, 600);
		r.setFill(Color.LIGHTGREEN);
		
	//Creating Basic Tile Params
	 // tile.setTileAlignment(Pos.CENTER_LEFT);
      //tile.setPrefRows(5);
      tile.setMaxWidth(plaWidth);
      VBox tileBox = new VBox(20);
      
      //create scroll pane :)
      
     //setting the grid and tile to places 
      
      ScrollPane sc = new ScrollPane(tile);
      sc.setPrefViewportHeight(sceneHeight);
      sc.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
      
      
      	//sp.setContent(tile);
      	//flow.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
      	//flow.setStyle()
      	//   grid.setBackground(new Background(flowBG));
      	//  grid.setBackground(new Background(r));
      	grid.setPrefHeight(600);
      	//grid.getChildren().add(r);
      	//flow.setColumnHalignment(HPos.CENTER);
      	//flow.setPrefWrapLength(3*canvasWidth/4);
      	border.setLeft(sc);
      	border.setCenter(grid);
        grid.setGridLinesVisible(true);
 

        
   //Setting up the image views and moving them 
        //while(i<myPlants.length())
      for(  i=0; i< 18; i++) {
    	   im1 = new Image(allPlants.get(i).getImgName(), plaWidth, plaHeight, false, false);
    	  ImageView iv1  = new ImageView(im1);
    	  setImageView(iv1);
    	  	control.model.setX(iv.getTranslateX());
    	  	control.model.setY(iv.getTranslateY());
    	  
    		iv1.setPreserveRatio(true);
        	iv1.setFitHeight(100);
        	
        	iv1.setOnMouseDragged(control.getHandlerForDrag());
        	iv1.setOnMousePressed(control.getHandlerForClick());
        	iv1.setOnMouseReleased(control.getHandlerForRelease());
        	
        	System.out.println("ADDING IMAGE " + i);
        	//addImage(iv1.getTranslateX(), iv1.getTranslateY(), i, iv1);
        	//iv1.setTranslateX(control.getStartingX());
    		//iv1.setTranslateY(control.getStartingY());
    	  

    	  tileBox.getChildren().add(iv1);
    	   // tile.getChildren().add(iv1);
      } 
     
      System.out.println("Grid Children: "+ grid.getChildren());
      
     //tile.getChildren().addAll(imageView);
      tile.getChildren().add(tileBox);
      sc.setContent(tile);
     
      
      //EXTRA CODE THAT I THOUGHT MIGHT WORK 
      
      //Setting Tile Scroll
      /*tile.setOnScroll(new EventHandler<ScrollEvent>(){
    	  public void handle(ScrollEvent event) {
    		  tile.setTranslateX(tile.getTranslateX()+ event.getDeltaX());
    		  tile.setTranslateY(tile.getTranslateY() + event.getDeltaY());
    	  }});
      }*/
     
      //   	  iv1.set
	  //Working on the IV to select images to drag and drop
	  
	/*  iv1.setOnMouseClicked(new EventHandler<MouseEvent>() {
		  public void handle(MouseEvent event) {
			  
			/*  Dragboard db2 = iv1.startDragAndDrop(TransferMode.COPY);
			  System.out.println("hi :)");
			  iv1.setMouseTransparent(true);
	    		 System.out.println("mouse pressed");
	    		 event.setDragDetect(true);
	    		 ClipboardContent content = new ClipboardContent();
	    		 content.putAll(content);
	    		 db2.setContent(content);
	    		 
	    		 event.consume();
			  
		  }
	  });
	  l = i;
	  iv1.setOnMouseReleased(new EventHandler<MouseEvent>() {
	    	 public void handle(MouseEvent event) {
	    		 iv1.setMouseTransparent(false);
	    		 System.out.println("mouse released");
	    		 addImage(event.getX(), event.getY(), l, iv1);
	    	 }
	     });
	     
	     iv1.setOnMouseDragged(new EventHandler<MouseEvent>() {
	    	 public void handle(MouseEvent event) {
	    		 //Node n = (Node) event.getSource();
	    		 iv1.setTranslateX(iv1.getTranslateX() + event.getX());
	    		 iv1.setTranslateY(iv1.getTranslateY()+ event.getY());
	    		 event.setDragDetect(false);
	    		
	    		 System.out.println("mouse dragged");
	    	 }
	     });*/
	     
	   /*  iv1.setOnDragDetected(new EventHandler<MouseEvent>() {
	    	 public void handle(MouseEvent event) {
	    		 //iv1.startFullDrag();
	    		 Dragboard db2 = iv1.startDragAndDrop(TransferMode.COPY);
   			  System.out.println("hi :)");
   			  iv1.setMouseTransparent(true);
   	    		 System.out.println("mouse pressed");
   	    		 event.setDragDetect(true);
   	    		 ClipboardContent content = new ClipboardContent();
   	    		 content.putAll(content);
   	    		 db2.setContent(content);
   	    		 
   	    		 event.consume();
	    		 
	    		 System.out.println("drag detected");
	    	 }
	     });*/
	    // int l = i;
	   /*  iv1.setOnDragDetected((MouseEvent event)-> {
	    	 imageView = new ImageView(new Image(allPlants.get(l).getImgName(), plaWidth, plaHeight, false, false));
	    	 try {
	    			Thread.sleep(500);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    	    
	    		System.out.println("eventX:" + event.getX() + " > tile X:" + 7*tile.getWidth()/12); // debugging

	    	    
	    	   // if(event.getX() > 7 * tile.getWidth()/12) { //boundaries to whether is plant is dragged in flow pane
	    	    	    	
	    	    	grid.getChildren().add(imageView); 

	    	           Dragboard db = imageView.startDragAndDrop(TransferMode.COPY); 
	    	           ClipboardContent content = new ClipboardContent();
	    	           
	    	           // Store node ID in order to know what is dragged.
	    	           content.putString(imageView.getId());
	    	           db.setContent(content);
	    	           event.consume();
	    	   // }
	     //});
	     
	    
	     /*
	      * iv2.setOnDragDetected((MouseEvent event) -> {

ImageView iv1 = new ImageView(im1);

try {
	Thread.sleep(500);
} catch (InterruptedException e) {
	e.printStackTrace();
}

System.out.println("eventX:" + event.getX() + " > tile X:" + 7*tile.getWidth()/12); // debugging


if(event.getX() > 7 * tile.getWidth()/12) { //boundaries to whether is plant is dragged in flow pane
	    	
	flow.getChildren().add(iv1); 

       Dragboard db = iv1.startDragAndDrop(TransferMode.COPY); 
       ClipboardContent content = new ClipboardContent();
       
       // Store node ID in order to know what is dragged.
       content.putString(iv1.getId());
       db.setContent(content);
       event.consume();
}
  
});

	      */
	/*     grid.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
	    	 public void handle(MouseDragEvent event) {
	    		 System.out.println("mouse dragged: grid");
	    	 }
	     });
	     
	     grid.setOnDragOver(new EventHandler<DragEvent>() {
	    	 public void handle(DragEvent event) {
	    		event.acceptTransferModes(TransferMode.COPY);
	    		event.consume();
	    	 }
	     });
	     
	     grid.setOnMouseDragOver(new EventHandler<MouseDragEvent>() {
	    	 public void handle(MouseDragEvent event) {
	    		 
	    		 System.out.println("mouse drag over: grid");
	    	 }
	     });
	     
	     grid.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
	    	 public void handle(MouseDragEvent event) {
	    		 //int x = (int)event.getX();
	    		 //int y= (int)event.getY();
	    		// grid.add(iv2, x, y);
	    		// grid.add(child, columnIndex, rowIndex);
	    		 System.out.println("mouse drag release");
	    		 //grid.getChildren().add();
	    	 }
	    	 
	     });
	     */
      // });
      //tile.setHgap(20);
      //tile.getChildren().addAll(iv, iv2, iv3);
 
     // border.getRight().setStyle("-fx-border-color: lightgreen;");
     
    //  flow.setStyle("-fx-border-color: POWDERBLUE;");
	}
   
      

   	
	
	
	
	
	//hi
	//This is a function that will take 
	/* public void addImage(double x,double y, int i, ImageView iv) {//, MouseEvent e) {
			iv.setTranslateX(x);
			iv.setTranslateY(y);
	    	ImageView ivg = new ImageView();
	    
	    	//Image im2 = ;
	    	ivg.setImage((new Image(allPlants.get(i).getImgName(), plaWidth, plaHeight, false, false)));
	    	ivg.setPreserveRatio(true);
	    	ivg.setFitHeight(100);
	    	System.out.println("Hi:)");
	    	ivg.setOnMouseDragged(control.getHandlerForDrag());
	    	ivg.setOnMousePressed(control.getHandlerForClick());
	    	ivg.setOnMouseReleased(control.getHandlerForRelease());
	    	//ivg.setX(x);
	    	//ivg.setY(y);
	    	ivg.setTranslateX(x);
	    	ivg.setTranslateY(y);
	    	System.out.println(grid.getChildren());
	    	grid.getChildren().add(ivg);
	    	gridPlants.add(allPlants.get(i));
	    	System.out.println(grid.getChildren());
	    	for(int j=0; j< gridPlants.size(); j++) {
	    		System.out.print(gridPlants.get(j).getName());
	    	}
	    	//border.getChildren().add(ivg);
	    }
	 */
	

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



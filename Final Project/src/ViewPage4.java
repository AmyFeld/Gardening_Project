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


//This class presents the garden and includes the drag and drop feature to add new items to the garden

public class ViewPage4 extends View {
	Scene scene4;
	private GridPane grid;
	private BorderPane border;
	private TilePane tile;
	


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
	
	public Scene getScene4() {
		return scene4;
	}

	 public static void main(String args[]){          
	      launch(args);     
	   }
}



/*
public class ViewPage4 extends View{
//private ImgController1 imc1;
private ImageView iv2;
private FlowPane flow;
private BorderPane border;
private TilePane tile;
private final double WIDTH = 800;
private final double HEIGHT = 600;
Scene scene4;
/*
public void MyMovingImageView1(){
	
iv2 = new ImageView();
//imc1 = new ImgController1(this);
}
	/*
	 * Input: stage
	 * Output: None
	 * Function: Starts the view and sets the image and creates the basic outline and functioning of the canvas when the screen is initialized to have the panes
	 */
 
/*   @Override
  public void start(Stage stage) {
		//code from Lab8 to edit and change for our lab
  Image im1; //= new Image(getClass().getResourceAsStream("milkWeed.png"), 100, 100, true, true);
 
//  iv2.setImage(im1);
  iv2.setPreserveRatio(true);
  iv2.setFitHeight(100);
 // iv2.setOnMouseDragged(imc1.getHandlerForDrag());   
  	tile.setTileAlignment(Pos.CENTER_LEFT);
      tile.setPrefRows(5);
      tile.getChildren().add(iv2);
      
      flow.setColumnHalignment(HPos.CENTER);
      flow.setPrefWrapLength(3*WIDTH/4);
      border.setLeft(tile);
      border.setRight(flow);
      
      
      Scene scene1 = new Scene(border, WIDTH, HEIGHT);
 
      stage.setScene(scene1);
      

iv2.setOnDragDetected((MouseEvent event) -> {
	
  //ImageView iv1 = new ImageView(im1);
  
  try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  
	System.out.println("eventX:" + event.getX() + " > tile X:" + 7*tile.getWidth()/12); // debugging
  
  if(event.getX() > 7*tile.getWidth()/12) { //boundaries to whether is plant is dragged in flow pane
  	    	
  //	flow.getChildren().add(iv1); 
      //   Dragboard db = iv1.startDragAndDrop(TransferMode.COPY); 
         ClipboardContent content = new ClipboardContent();
         
         // Store node ID in order to know what is dragged.
       //  content.putString(iv1.getId());
         //db.setContent(content);
         event.consume();
  }
    
}); 
      stage.show();
  }
	
	/*
	 * Input: double value
	 * Output: None
	 * Function: sets the x value of the layout of image view
	 */
 
/*  public void setX(double x) {
  iv2.setTranslateX(iv2.getLayoutX() - WIDTH/2 + x);
  }
	
	/*
	 * Input: double value
	 * Output: None
	 * Function: sets the y value of the layout of image view
	 */
 
 /* public void setY(double y) {
  iv2.setTranslateY(iv2.getLayoutY() - HEIGHT/2 + y);
  }
  */
//}//}

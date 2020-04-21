import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


// This class presents the garden and includes the drag and drop feature to add new items to the garden
public class ViewPage4 {

private ImgController1 imc1;
private ImageView iv2;

private FlowPane flow;
private BorderPane border;
private TilePane tile;


private final double WIDTH = 800;
private final double HEIGHT = 600;


public MyMovingImageView1(){
	
tile = new TilePane(Orientation.VERTICAL);
flow = new FlowPane(Orientation.VERTICAL);
border = new BorderPane();

iv2 = new ImageView();
imc1 = new ImgController1(this);

}

	/*
	 * Input: stage
	 * Output: None
	 * Function: Starts the view and sets the image and creates the basic outline and functioning of the canvas when the screen is initialized to have the panes
	 */
   
    @Override
    public void start(Stage stage) {
		//code from Lab8 to edit and change for our lab
    Image im1; //= new Image(getClass().getResourceAsStream("milkWeed.png"), 100, 100, true, true);
   
    iv2.setImage(im1);
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
	
    ImageView iv1 = new ImageView(im1);
    
    try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    
	System.out.println("eventX:" + event.getX() + " > tile X:" + 7*tile.getWidth()/12); // debugging

    
    if(event.getX() > 7*tile.getWidth()/12) { //boundaries to whether is plant is dragged in flow pane
    	    	
    	flow.getChildren().add(iv1); 

           Dragboard db = iv1.startDragAndDrop(TransferMode.COPY); 
           ClipboardContent content = new ClipboardContent();
           
           // Store node ID in order to know what is dragged.
           content.putString(iv1.getId());
           db.setContent(content);
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
   
   public void setX(double x) {
    iv2.setTranslateX(iv2.getLayoutX() - WIDTH/2 + x);
    }
	
	/*
	 * Input: double value
	 * Output: None
	 * Function: sets the y value of the layout of image view
	 */
   
    public void setY(double y) {
    iv2.setTranslateY(iv2.getLayoutY() - HEIGHT/2 + y);
    }

    public static void main(String[] args) {
        launch();
    }
}

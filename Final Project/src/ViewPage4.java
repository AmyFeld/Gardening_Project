import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
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
import javafx.util.StringConverter;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
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
	ViewPage5 vp5;
	
	//ArrayList<ImageView> season = new ArrayList<ImageView>();
	String season = "spring";
	Slider sl = new Slider(0,3,0);
	Model m = new Model();
	ArrayList<Plant> myPlants = new ArrayList<Plant>();
	int second = 2;
	int fifth = 5;
	int anchorHeight = 600;
	int boxRight = 50;
	double n1 = 0.5; 
	double n2= 1.5;
	int min =0; 
	int max =2; 
	int tick = 1;
	   
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
		vp5 = new ViewPage5(theStage);		
		  // home button if fired
		HBox layout1 = new HBox(boxSize);     
		Label label1 = new Label("Edit Your Garden");
		Button rate = new Button("Rate My Garden");
	  	Button back = new Button("Plant Nursery");
	    // set tile pane height/?
	    tile = new TilePane(Orientation.VERTICAL);
		anchor = new AnchorPane();
		border = new BorderPane();
		
	  	layout1.getChildren().addAll(back, label1, homeButton, rate);
	     
	  	//Slider sl = new Slider(0,3,0);
	    sl.setOrientation(Orientation.VERTICAL);
	    sl.setMin(min);
	    sl.setMax(max);
	      //	sl.setMaxHeight(300);
	    sl.setValue(tick);
	    sl.setShowTickLabels(true);
	    sl.setShowTickMarks(true);
	    sl.setMajorTickUnit(tick);
	    sl.setMinorTickCount(min);
	    sl.setLabelFormatter(new StringConverter<Double>() {
	    	public String toString(Double n) {
	    		  if (n<n1) {
	    			  //System.out.println("Fall");
	    			 /// season = "fall";
	    			  return"Fall";
	    		  }
	    		  if(n<n2) {
	    			//  System.out.println("Spring");
	    			  //season = "spring";
	    			  return "Spring";
	    		  }
	    		 // System.out.println("Winterzxscccccccdfffffffffffffffffffc");
	    		  //season = "winter";
	    		  return "Winter";
	    		  
	    		  //return "bye";
	    	}

			@Override
			public Double fromString(String s) {
				switch (s) {
              		case "Fall":
                  		return 0d;
                	case "Spring":
                    	return 1d;
                	case "Winter":
                    	return 2d;
				}
				return x;
			}
							
	    });	      		      
			
	      //	System.out.println(season);
		
	    Image trash = new Image("file:images/Trash.png", plaHeight, plaWidth, false, false);
	    ImageView imtrash = new ImageView(trash);
	     // Button label = new Button("Create new label");
	    userlabel = new TextField("Create new label"); 
	      	      
	    Alert explain = new Alert(AlertType.INFORMATION);
		explain.setContentText("To add to the garden: click on the plant or object you would like to add it will be added to the garden. Then you can drag to the specific location. To Remove, drag the image to the trashcan. To add labels, type up what you want to add and drag to the location you would like.");
		Button tut = new Button(); 
		tut.setText("Tutorial");
		tut.setOnAction(e -> explain.show() );
		    
	    userlabel.setOnAction(e -> control.label(e));	
            VBox right = new VBox(boxRight);
	    right.getChildren().addAll(tut, sl, userlabel, imtrash);
	  
	  		  	
	    homeButton.setOnAction(e -> control.goHomeButton(theStage, home));	 
	    rate.setOnAction(e-> {
	    	m.updateGarden(); 
	    	theStage.setScene(vp5.getScene5());
		//control.goHomeButton(theStage, fifth);
	    	vp5.setAllRatings(ratings);
	    
	    });
	    back.setOnAction(e -> control.goHomeButton(theStage, second ));
	    
	    //How To    
	    	    
		ImageView iv;
		
	    start(theStage);
	    layout1.setAlignment(Pos.TOP_CENTER);
	    border.setRight(right);
	    border.setTop(layout1);
			
	    scene4 = new Scene(border, sceneWidth, sceneHeight); // the
		  
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
		ArrayList<ImageView> gen = makeGenImg();

    	BackgroundImage bg = new BackgroundImage(new Image("file:images/anchor.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    	anchor.setBackground(new Background(bg));
		
	 	anchor.setStyle("-fx-background-color: #05F861;");
			
	 	tile.setMaxWidth(plaWidth);
	 	tileBox = new VBox(boxSize);
     
      
	 	ScrollPane sc = new ScrollPane(tile);
	 	sc.setPrefViewportHeight(tileBox.getHeight());
	 	sc.setPrefWidth(plaWidth);
	 	sc.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	 	// sc.autosize();
      
      	anchor.setPrefHeight(anchorHeight);
    	
      	border.setLeft(sc);
      	border.setCenter(anchor);
      	makeIm();
    	sl.valueProperty().addListener(
      		new ChangeListener<Number>() {
      			 public String toString(Double n) {
      		   		  if (n<n1) {
      		   			  return"fall";
      		   		  }
      		   		  if(n<n2) {
      		   			  return "spring";
      		   		  }
      		   		 // System.out.println("Winterzxscccccccdfffffffffffffffffffc");
      		   		 
      		   		  return "winter";
      		   	}
      				 
				public void changed(ObservableValue<? extends Number> arg0, Number oldVal, Number newVal) {
					season = toString(newVal.doubleValue());
					//for(int j = 0; j<allPlants.size(); j++)
						//tileBox.getChildren().remove(j);
					//ivArr.clear();
					tileBox.getChildren().removeAll(ivArr);
					makeIm();
				    

				} 
		});
    	     
    	//System.out.println("anchor Children: "+ anchor.getChildren());

    	tileBox.getChildren().addAll(gen);
     
    	//System.out.println(tileBox.getChildren());
    
    	sc.setContent(tileBox);
	}
	
	/**
	 * Description: Makes the image view for the plants based off the seasons
	 */
	public void makeIm() {
		
		ImageView iv;
		
		for( i=0; i< myPlants.size(); i++) {
	    	 
		  	Image im = new Image(myPlants.get(i).getImgName(season), plaWidth, plaHeight, false, false);
	  		iv = new ImageView(im);

	      	iv.setPreserveRatio(true);
	      	iv.setFitHeight(plaHeight);
	    	iv.setOnMouseClicked(e -> control.click(e));//control.getHandlerForClick());  
		    	
	    	ivArr.add(i, iv);
	   
		} 	
		tileBox.getChildren().addAll(ivArr);
	}

	/**
	 * Description: creates all of the generic images to be added to the garden
	 * @return genIm / ArrayList<ImageView>
	 */
	public ArrayList<ImageView> makeGenImg() {
		//Generic Yard Images
		Image backup_house = new Image("file:images/backup_house.png", plaHeight, plaWidth, false, false);
		ImageView ivHouse = new ImageView(backup_house);
		Image pool = new Image("file:images/pool.png", plaHeight, plaWidth, false, false);
		ImageView ivPool = new ImageView(pool);
		Image fence = new Image("file:images/fence.png", plaHeight, plaWidth, false, false);
		ImageView ivFence = new ImageView(fence);
		Image driveWay= new Image("file:images/road.png", plaHeight, plaWidth,false, false);
		ImageView ivDriveWay = new ImageView(driveWay);
				
	
		//moving generic images
		//Generic Image
		ArrayList<ImageView> genIm = new ArrayList<>();
		genIm.add(ivHouse);
		genIm.add(ivPool);
		genIm.add(ivFence);
		genIm.add(ivDriveWay);
				
		for(int z = 0; z< genIm.size(); z++) {
			genIm.get(z).setPreserveRatio(true);
			genIm.get(z).setFitHeight(plaHeight);
		   	
			genIm.get(z).setOnMousePressed(control.getHandlerForClick2());
		}
		return genIm;
				
	}
	
	/**
	 * Description: takes in an array list to be presented
	 * @param alst
	 */
	public void setMyPlants(ArrayList<Plant> alst) {
		myPlants = alst;
		makeIm();
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


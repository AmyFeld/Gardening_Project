import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/**
 *  This class is meant to hold the main and communicate between the selected view and model
 * 
 * @author Amy Feldman
 *
 */

public class Controller extends Application {
	
	View view;
	Model model;
	double contX;
	double contY;
	Scene scene;

	/**
	 * Constructor for controller - sets the view to the parameter and creates a new model
	 * @param view
	 */
	public Controller(View view) {
		
		this.view = view;
		this.model = new Model();
	}

    /**
     * Begins running the GUI application of the entire program from updates
     * in model & view
     * 
     * @param Stage  a container holding the scene
     * 
     *
     */
    @Override
	public void start(Stage theStage) {	
    	 
    	theStage.show();
    }
   
    /**
     * main method for program, but the program runs from the view so just prints "Work" 
     * @param args
     */
	public static void main(String[] args) {
        System.out.println("WORK");
		launch(args);
    }

	/**
	 * changes the x and y position of the image in the model based on the mouseEvent
	 * @param event
	 */
	public void drag(MouseEvent event){
		Node n = (Node)event.getSource();
		n.setVisible(true);
		model.setX(event.getSceneX() - view.anchor.getLayoutX() - view.plaWidth/2); //view.imageView.getFitWidth()/2);
		model.setY(event.getSceneY() - view.anchor.getLayoutY() - view.plaHeight/2);//view.imageView.getFitHeight()/2);
		model.setImage(n);
		view.ratings = model.setRating();
		//System.out.println("DRAG");
	}

	/**
	 * Event handler for the images when dragged
	 * @return Event
	 */
	public EventHandler<MouseEvent> getHandlerForDrag(){
		return event -> drag((MouseEvent) event);
	}

	/**
	 * allows plants/images to be redragged after release and depending on the release location will remove it from the grid and view panes
	 * @param event
	 */
	public void release(MouseEvent event){
		Node n = (Node) event.getSource();
		
		view.imageView.setOnMouseDragged(getHandlerForDrag());
		System.out.println("RELEASE");
		if(n.getTranslateX() > 600) {
			view.circ = (Circle)n;
			System.out.println("REMOVE");
	
			view.setI(view.imageView);
			model.removeImageView(view.i);
			view.removeImageView();
		}
		view.ratings = model.setRating();
		System.out.println(view.ratings);
	}

	/**
	 * Event handler for the images when released 
	 * @return Event
	 */
	public EventHandler<MouseEvent> getHandlerForRelease(){
		return event -> release((MouseEvent) event);
	}
	
	/**
	 * adds the plant images in the garden on both the view and model aspect by calling functions in each
	 * @param event
	 */
	public void click(MouseEvent event){
		Node n = (Node)event.getSource();
		n.setMouseTransparent(true);
		
		view.imageView = (ImageView)n;
		view.setI(view.imageView);
		int plaSize = model.addImageView(view.i);
		
		view.moveImageView(plaSize);
		model.addImageView(view.i);
		model.setPlant(view.getImageName());
				
		view.ratings = model.setRating();
		System.out.println("click");
		
	}
	
	/**
	 * Event handler for the plant images click 
	 * @return Event
	 */
	public EventHandler<MouseEvent> getHandlerForClick(){
		return event -> click((MouseEvent) event);
	}
	
	/**
	 * adds the generic images to the view when clicked and calls functions in view
	 * @param e
	 */
	public void click2(MouseEvent e){
		Node n = (Node)e.getSource();
		n.setMouseTransparent(true);
			
		view.imageView = (ImageView)n;
		view.setI(view.imageView);
		//model.setPlant(p);
				
		view.moveGenImage();
	
		
		System.out.println("click");
		
	}
	
	/**
	 * Event handler for the generic images click 
	 * @return Event
	 */
	public EventHandler getHandlerForClick2(){
		
		return event -> click((MouseEvent) event);
	}

	/**
	 * basic setter for updating and setting the current plant in the model
	 * @param p
	 */
	public void setMyPlants(Plant p) {	
		model.update(p);
	}

	/**
	 * basic getter for recieving the lists of myPlants from the model
	 * @return ArrayList<Plant>
	 */
	public ArrayList<Plant> getMyPlants() {
		return model.myPlants;	
	}
	
	/**
	 * gives the labels the same ability to move within the garden, once a label is made
	 * @param e
	 */
	public void label(ActionEvent e) {
		 Label l = new Label();
		 l.setText(view.userlabel.getText());
		 view.anchor.getChildren().add(l);
		 l.setOnMouseDragged(getHandlerForDrag());
		 l.setOnMouseReleased(getHandlerForRelease());
	}

	/**
	 * Event handler that takes the event and stage and allows you to save a file wherever the user would like within their computer
	 * @param e
	 * @param theStage
	 */
	public void chooseFile(ActionEvent e, Stage theStage) {
		FileChooser fileChooser = new FileChooser();
  		try {
  			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Ser", ".ser"));
  			File file = fileChooser.showSaveDialog(theStage);
  			if(file != null) {
  				FileOutputStream fileOut = new FileOutputStream(file);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
  				objectOut.writeObject(model);
				objectOut.close();
				fileOut.close();
				
  			}

		} catch (Exception ex) {

			ex.printStackTrace();}
	}
	/**
 *   Description: The filter method that organizes which combobox and which filter is applied. It filters 
 *   the all plants (arraylist) given. 
 *   
 * @param vp2: ViewPage2 object since the method needs the objects in vp2
 * @param cbox: the specified combobox (viewpage2 has 6 comboboxes)
 * @param plst: the plant arraylist: all plants from the Garden class
 * @param area: the type of combobox, in the Garden class the Filter() helps sort through which types
 * @param g: garden specified in ViewPage2
 * @param tp: tabPane specified in ViewPage2
 * @param drop: the hbox assembling the plant buttons and comboboxes
 * @param t : the main tab featuring the Plant Nursery with all buttons
 * @param vb: the vbox assembling the comboxes on the main tab
 */
	public void getFilter(ViewPage2 vp2, ComboBox<String> cbox, ArrayList<Plant> plst, String area, 
			Garden g, TabPane tp, HBox drop, Tab t, VBox vb) {
		
		String pick = cbox.getSelectionModel().getSelectedItem(); 
		String val = area;
		String spec = "";
		
	switch(val) {
		case("Color"):
			spec = "color";
			break;
		case("Type"):
			spec = "type";
			break;
		case("Height"):
			spec = "height";
			break;
		case("Fruit"):
			spec = "hasFruit";
			break;
		case("Water"):
			spec = "waterUse";
			break;
		case("Month"):
			spec = "start";
			break;
		}
	
	if (spec.equals("height")) {
		switch(pick) {
		case("0-10"):
			pick = "0";
			break;
		case("10-20"):
			pick = "10";
			break;
		case("20-30"):
			pick = "20";			
			break;
		case("30-40"):
			pick = "30";
			break;
		case("40+"):
			pick = "40";
			break;
		}
		
	}
	
	if (spec.equals("start")) {
		switch(pick) {
		case "January":
			pick = "1";
			break;
		case "February":
			pick = "2";
			break;
		case "March":
			pick = "3";
			break;
		case "April":
			pick = "4";
			break;
		case "May":
			pick = "5";
			break;
		case "June":
			pick = "6";
			break;
		case "July":
			pick = "7";
			break;
		case "August":
			pick = "8";
			break;
		case "September":
			pick = "9";
			break;
		case "October":
			pick = "10";
			break;
		case "November":
			pick = "11";
			break;
		case "December":
			pick = "12";
			break;
		}
	}
	plst = g.Filter(spec, pick, plst);
	
	updateNursery(vp2, plst, g, tp, drop, t, vb, false);	
	} 
	
	/** 
	 * Description: Updates the visual Plant Nursery display with the given paramters in ViewPage2. The parameters 
	 * are needed to ensure no copies are created (only ViewPage2 objects). It displays the filtered or all plant buttons. 
	 * @param vp2  ViewPage2 object to access methods and objects
	 * @param plst a plant arraylist with applied filters
	 * @param g    a garden of viewpage2
	 * @param tp   a tabPane used in viewpage2
	 * @param drop a dropdown used in viewpage2
	 * @param t    the main tab used in viewpage2
	 * @param vb   the dropdown format of comboboxes in viewpage2
	 * @param reset a boolean to know whether to default to all 60 plants
	 */
	public void updateNursery(ViewPage2 vp2, ArrayList<Plant> plst, Garden g, 
			TabPane tp, HBox drop, Tab t, VBox vb, Boolean reset) {
		
		if (reset) {
			plst = g.allPlants;
		}
		
		drop.getChildren().clear();
		drop.getChildren().addAll(vp2.setButtons(tp, plst), vb);
		t.setContent(drop);
		
	}
	
	/**
	* Description: sets user selected plants for Viewpage4 from ViewPage2
	* @param Stage: the stage of viewpage2
	* @param Viewpage4: to allow access to myPlants arraylist from ViewPage2 to ViewPage4 
	*/
	
	public void setGardButton(Stage s, ViewPage4 vp4) {
		s.setScene(vp4.getScene4());
		vp4.setMyPlants(getMyPlants());		
	}
	
	/**
	 * Event handler for buttons to set the scene based on the certain page it is on and the page it is trying to get to
	 * @param s
	 * @param num
	 */
	public void goHomeButton(Stage s, int num) {

		switch (num) {
		case 1:
			scene = new ViewPage1(s).getScene1();
			break;
		case 2:	
			scene = new ViewPage2(s).getScene2();
			break;
		case 4:	
			scene = new ViewPage4(s).getScene4();
			break;
		case 5:
			scene = new ViewPage5(s).getScene5();
			break;
		case 6:
			scene = new ViewPage6(s).getScene6();
			break;
		case 7:
			scene = new ViewPage7(s).getScene7();
			break;
		case 8:
			scene = new ViewPage8(s).getScene8();
			break;
		case 9:
			scene = new ViewPage9(s).getScene9();
			break;				
		}

		s.setScene(scene);
	}
	
	/**
	 * Basic getter for recieving the rating given by the model
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getRating() {
		return model.setRating();
	}
	
	

}

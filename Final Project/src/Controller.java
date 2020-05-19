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

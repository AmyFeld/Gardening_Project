import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.Node;
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
	
	public Controller(View view) {
		
		this.view = view;
		this.model = new Model();
	}
	
	public Controller() {
		this.model = new Model();	
	}

    /**
     * Begins running the GUI application of the entire program from updates
     * in model & view
     * 
     * @param Stage  a container holding the scene
     * @throws Exception if an error occurred in Thread.sleep(100)
     *
     */
    @Override
	public void start(Stage theStage) {	      
    theStage.show();
    }
   
	public static void main(String[] args) {
        System.out.println("WORK");
		launch(args);
    }

// Mouse Events 
	public void drag(MouseEvent event){
		Node n = (Node)event.getSource();
		n.setVisible(true);
		//model.setX(model.getX() + event.getX());
		//model.setY(model.getY() + event.getY());
		model.setX(event.getSceneX() - view.anchor.getLayoutX() - view.plaWidth/2); //view.imageView.getFitWidth()/2);
		model.setY(event.getSceneY() - view.anchor.getLayoutY() - view.plaHeight/2);//view.imageView.getFitHeight()/2);
		model.setImage(n);
		view.ratings = model.setRating();
	}

	public EventHandler<MouseEvent> getHandlerForDrag(){
		return event -> drag((MouseEvent) event);
	}

	public void release(MouseEvent event){
		Node n = (Node) event.getSource();
		
		view.imageView.setOnMouseDragged(getHandlerForDrag());
		System.out.println("RELEASE");
		if(n.getTranslateX() > 600) {
			view.circ = (Circle)n;
			System.out.println("REMOVE");
		//	model.setPlant(view.getPlant());
		//	model.removePlant();
			//view.imageView = (ImageView)n;
			view.setI(view.imageView);
			model.removeImageView(view.i);
			view.removeImageView();
		}
		view.ratings = model.setRating();
		System.out.println(view.ratings);
	}

	public EventHandler<MouseEvent> getHandlerForRelease(){
		return event -> release((MouseEvent) event);
	}
	

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
	
	public void setMyPlants(Plant p) {	
		model.update(p);
	}
	
	public ArrayList<Plant> getMyPlants() {
		return model.myPlants;	
	}
	
	
	public EventHandler<MouseEvent> getHandlerForClick(){
		return event -> click((MouseEvent) event);
	}
	
	public void click2(MouseEvent e){
		Node n = (Node)e.getSource();
		n.setMouseTransparent(true);
			
		view.imageView = (ImageView)n;
		view.setI(view.imageView);
				
		view.moveGenImage();
		
		System.out.println("click");
		
	}
	
	public EventHandler getHandlerForClick2(){
		return event -> click((MouseEvent) event);
	}


	public double getStartingX(){
		return model.getX();
	}

	public double getStartingY(){
		return model.getY();
	}

	public double getOriginX(){
		return contX;
	}

	public double getOriginY(){
		return contY;
	}
	
	public ArrayList<Integer> getRating() {
		return model.setRating();
	}

}

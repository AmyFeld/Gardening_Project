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

	
	public Controller(View view) {
		
		this.view = view;
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
// Javadoc to follow once fully functioning
//
	public void drag(MouseEvent event){
		Node n = (Node)event.getSource();
		n.setVisible(true);
		model.setX(event.getSceneX() - view.anchor.getLayoutX() - view.plaWidth/2); //view.imageView.getFitWidth()/2);
		model.setY(event.getSceneY() - view.anchor.getLayoutY() - view.plaHeight/2);//view.imageView.getFitHeight()/2);
		model.setImage(n);
		view.ratings = model.setRating();
		//System.out.println("DRAG");
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
	
	public EventHandler<MouseEvent> getHandlerForClick(){
		return event -> click((MouseEvent) event);
	}
	
	public void click2(MouseEvent e){
		Node n = (Node)e.getSource();
		n.setMouseTransparent(true);
			
		view.imageView = (ImageView)n;
		view.setI(view.imageView);
		//model.setPlant(p);
				
		view.moveGenImage();
	
		
		System.out.println("click");
		
	}
	
	public EventHandler getHandlerForClick2(){
		
		return event -> click((MouseEvent) event);
	}

	public void setMyPlants(Plant p) {	
		model.update(p);
	}

	public ArrayList<Plant> getMyPlants() {
		return model.myPlants;	
	}
	
	public void label(ActionEvent e) {
		 Label l = new Label();
		 l.setText(view.userlabel.getText());
		 view.anchor.getChildren().add(l);
		 l.setOnMouseDragged(getHandlerForDrag());
		 l.setOnMouseReleased(getHandlerForRelease());
	}

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
	public ArrayList<Integer> getRating() {
		return model.setRating();
	}
	
	

}

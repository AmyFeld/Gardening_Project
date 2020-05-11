import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;

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
		
 /*	new EventHandler<ActionEvent>() {
 		@Override 
 		public void handle(ActionEvent event) {
            System.out.print("Hello World !!");
            view.setOnAction(event);
            }		 	     
    };
    */
    new AnimationTimer() {
    	
        public void handle(long currentNanoTime) { 
            try {
                Thread.sleep(100);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }.start();
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
		model.setX(model.getX() + event.getX());
		model.setY(model.getY() + event.getY());
		model.setImage(n);
		//System.out.println("DRAG");
	}

	public EventHandler<MouseEvent> getHandlerForDrag(){
		return event -> drag((MouseEvent) event);
	}

	public void release(MouseEvent event){
		Node n = (Node) event.getSource();
		if(n.getTranslateX()>= 0&& contX<1000){
			//System.out.println("First Part of If");
			view.addImage(model.getX(), model.getY());
		}
		else if(n.getTranslateX()<0&&contX>=1000){
			n.setVisible(false);
			//System.out.println("Second part of if");
		}
		System.out.println("RELEASE");
	}

	public EventHandler<MouseEvent> getHandlerForRelease(){
		return event -> release((MouseEvent) event);
	}
	

	public void click(MouseEvent event){
		Node n = (Node)event.getSource();
		n.setMouseTransparent(true);
		
		view.imageView = (ImageView)n;
		view.setI(view.imageView);
	
		model.setX(n.getTranslateX());
		model.setY(n.getTranslateY());
		contX = n.getTranslateX();
		contY = n.getTranslateY();
		
		System.out.println("click");
		
	}
	
	public EventHandler<MouseEvent> getHandlerForClick(){
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

}

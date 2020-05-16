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
		//model.update(view.currPla);
    	 //view.update();
		
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
		model.update(p);
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
		n.setVisible(true);
		//model.setX(model.getX() + event.getX());
		//model.setY(model.getY() + event.getY());
		model.setX(event.getSceneX() - view.grid.getLayoutX() - view.plaWidth/2); //view.imageView.getFitWidth()/2);
		model.setY(event.getSceneY() - view.grid.getLayoutY() - view.plaHeight/2);//view.imageView.getFitHeight()/2);
		model.setImage(n);
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
			System.out.println("REMOVE");
		//	model.setPlant(view.getPlant());
		//	model.removePlant();4
			//view.imageView = (ImageView)n;
			view.setI(view.imageView);
			model.removeImageView(view.i);
			view.removeImageView();
		}
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
		
		view.moveImageView();
		model.addImageView(view.i);
		model.setPlant(view.getImageName());
				
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
				
		
		//view.newImageView();
		
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

}

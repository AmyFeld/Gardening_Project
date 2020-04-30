import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *  This class is meant to hold the main and communicate between the selected view and model
 * 
 * @author Amy Feldman
 *
 */

public class Controller extends Application {
	
	View view;
	Model model;
	
	public Controller() {
		
	     this.view = new View();	
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
	
}

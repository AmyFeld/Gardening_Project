import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

// This class is meant to hold the main and communicate between the selected view and model

public class Controller extends Application implements MouseListener {
	View view;
	Model model;
	
	public Controller() {

		this.model = new Model();
		
		view.addMouseListener(this);
		addMouseListener(this);
	}
	
	/*
	 * Input: Stage
	 * Output: running program
	 * Function: takes in the updates from the model or view and presents to the screen/ user
	 */

    @Override
	public void start(Stage theStage) {
       // view = new View(theStage);
		
		  this.view = new View();
       		 this.model = new Model();
		try {
			this.view.start(theStage);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		//model = new Model(view.getWidth(), view.getHeight(), 
           //     view.getImageWidth(), view.getImageHeight());
		
 	new EventHandler<ActionEvent>() {
 		@Override 
 		public void handle(ActionEvent event) {
            System.out.print("Hello World !!");
            view.setOnAction(event);
            }		 	     
    };
    
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
    
    
	private void addMouseListener(Controller controller) {
		
	}
	
	/*
	 * Input: Mouse event
	 * Output: None
	 * Function: tells program what to do when mouse is pressed 
	 */
	
	@Override
	public void mousePressed(MouseEvent e) {
       		
    	}

	/*
	 * Input: Mouse event
	 * Output: None
	 * Function: tells program what to do when mouse is released 
	 */
	@Override
    	public void mouseReleased(MouseEvent e) {

    	}

	/*
	 * Input: Mouse event
	 * Output: None
	 * Function: tells program what to do when mouse is entered 
	 */
	@Override
    	public void mouseEntered(MouseEvent e) {

    	}

	/*
	 * Input: Mouse event
	 * Output: None
	 * Function: tells program what to do when mouse is exited 
	 */
	@Override
    	public void mouseExited(MouseEvent e) {
       
    	}

	/*
	 * Input: Mouse event
	 * Output: None
	 * Function: tells program what to do when mouse is clicked 
	 */
	@Override
    	public void mouseClicked(MouseEvent e) {
       
    	}
	
	public static void main(String[] args) {
        System.out.println("WORK");
		launch(args);
    }
	


}
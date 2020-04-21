import javafx.stage.Stage;

public class Controller implements MouseListener{
	View view;
	Model model;
	view.addMouseListener(this);
	addMouseListener(this);
	
	Controller(){
		this.view = new ViewPage1();
		this.model = new Model();
	}
	
	/*
	 * Input: Stage
	 * Output: running program
	 * Function: takes in the updates from the model or view and presents to the screen/ user
	 */
	
	@Override
	public void start(Stage theStage) {
		model.updateGarden();
		view.update();
		
		/*
	 	* Input: Action Event
	 	* Output: Change of screen
	 	* Function: takes in a button press, checks which button it is and changes the view to the appropriate page
	 	*/
		
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
			}
		}
		view.b.setOnAction(event);
		
	}
	
	/*
	 * Input: Mouse event
	 * Output: None
	 * Function: tells program what to do when mouse is pressed 
	 */
	public void mousePressed(MouseEvent e) {
       		
    	}

	/*
	 * Input: Mouse event
	 * Output: None
	 * Function: tells program what to do when mouse is released 
	 */
    	public void mouseReleased(MouseEvent e) {

    	}

	/*
	 * Input: Mouse event
	 * Output: None
	 * Function: tells program what to do when mouse is entered 
	 */
    	public void mouseEntered(MouseEvent e) {

    	}

	/*
	 * Input: Mouse event
	 * Output: None
	 * Function: tells program what to do when mouse is exited 
	 */
    	public void mouseExited(MouseEvent e) {
       
    	}

	/*
	 * Input: Mouse event
	 * Output: None
	 * Function: tells program what to do when mouse is clicked 
	 */
    	public void mouseClicked(MouseEvent e) {
       
    	}
	
	public static void main(String[] args) {
        launch(args);
    }
}

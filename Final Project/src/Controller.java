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
	
	@Override
	public void start(Stage theStage) {
		model.updateGarden();
		view.update();
		
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
			}
		}
		view.b.setOnAction(event);
		
	}
	
	public void mousePressed(MouseEvent e) {
       		
    	}

    	public void mouseReleased(MouseEvent e) {

    	}

    	public void mouseEntered(MouseEvent e) {

    	}

    	public void mouseExited(MouseEvent e) {
       
    	}

    	public void mouseClicked(MouseEvent e) {
       
    	}
	
	public static void main(String[] args) {
        launch(args);
    }
}

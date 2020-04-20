import javafx.stage.Stage;

public class Controller {
	View view;
	Model model;
	
	Controller(){
		this.view = new view1;
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
	
	public static void main(String[] args) {
        launch(args);
    }
}

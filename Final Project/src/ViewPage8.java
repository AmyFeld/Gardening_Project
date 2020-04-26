import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// This class is used to present the Benefits of a Garden tab and include the information and buttons that will present the information

public class ViewPage8 extends View {
	Scene scene8;

	public ViewPage8(Stage theStage) {
		
		VBox layout = new VBox(20);     
	    Label label = new Label("Benefits of a Garden");
	    Text animalText = new Text();
	    Text edgeText = new Text();
	    Text appearText = new Text();
	    
	    try {
			animalText.setText(uploadText("animals"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	    
	    try {
			edgeText.setText(uploadText("edge"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	    try {
			appearText.setText(uploadText("appear"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	    

	  	Button home = new Button("Home");
	    home.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));

	  	Tab animals = new Tab();
	  	animals.setText("Animals");
	  	animals.setContent(animalText);
	  	
	  	Tab edge = new Tab();
	  	edge.setText("Stopping An Edge");
	  	edge.setContent(edgeText);
	  	
		Tab appear = new Tab();
	  	appear.setText("Aesthetics and Appearances");
	  	appear.setContent(appearText);

		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(animals, edge, appear);
		
	  	layout.getChildren().addAll(label, tabPane, home); 
	  	scene8 = new Scene(layout, 900, 600); 
		  	
	   	 theStage.setScene(scene8); 
	   	 theStage.show(); 	

	}	
	
	public Scene getScene8() {
		return scene8;
	}

	 public static void main(String args[]){          
	      launch(args);     
	   }
	
	 
		/* Input: None
		 * Output: None
		 * Function: Will read in a .txt file and upload it onto the canvas
		 */
		 public String uploadText(String name) throws Exception {
			 String file = new String("textFiles/" + name + ".txt"); 
			 String data = ""; 
			 
			 data = new String(Files.readAllBytes(Paths.get(file))); 
			 return data;
		  }

}
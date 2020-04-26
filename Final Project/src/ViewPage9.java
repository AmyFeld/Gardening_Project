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


// This class is used to present the Tips to Start tab and include the information and buttons that will present the information
public class ViewPage9 extends View {
	
	Scene scene9;

	public ViewPage9(Stage theStage) {
			
	    // textFiles folder: .txt, .txt, .txt
		VBox layout = new VBox(20);     
	    Label label = new Label("Tips to Start");
	    Text unhappyText = new Text();
	    Text bestText = new Text();
	    Text startText = new Text();
	    
	    // textFiles folder: unhappy.txt, best.txt, start.txt

	    try {
			unhappyText.setText(uploadText("unhappy"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
 	    
	    try {
			bestText.setText(uploadText("best"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	    try {
			startText.setText(uploadText("start"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	    

	  	Button home = new Button("Home");
	    home.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));

	  	Tab unhappy = new Tab();
	  	unhappy.setText("Unhappy?");
	  	unhappy.setContent(unhappyText);
	  	
	  	Tab best = new Tab();
	  	best.setText("Best Places To Go");
	  	best.setContent(bestText);
	  	
		Tab start = new Tab();
	  	start.setText("Start With");
	  	start.setContent(startText);

		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(unhappy, best, start);
		
	  	layout.getChildren().addAll(label, tabPane, home); 
	  	scene9 = new Scene(layout, 900, 600); 
	  	
	   	 theStage.setScene(scene9); 
	   	 theStage.show(); 	

	}	
	
	public Scene getScene9() {
		return scene9;
	}
	 
		/* Input: None
		 * Output: None
		 * Function: Will read in a .txt file and upload it onto the canvas
		 */
		 public String uploadText(String name) throws Exception {
			 String file = new String("textFiles/Page9/" + name + ".txt"); 
			 String data = ""; 
			 
			 data = new String(Files.readAllBytes(Paths.get(file))); 
			 return data;	  
	}

}

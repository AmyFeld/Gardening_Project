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

// This class is used to present the Resources tab and include the information and buttons that will present the information

public class ViewPage7 extends View {
	Scene scene7;

	public ViewPage7(Stage theStage) {			
		
		VBox layout = new VBox(20);     
	    Label label = new Label("Resources");
	    Text whereText = new Text();
	    Text faqText = new Text();
	    
	    try {
			whereText.setText(uploadText("where"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	    
	    try {
			faqText.setText(uploadText("faq"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	    

	  	Button home = new Button("Home");
	    home.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));

	  	Tab where = new Tab();
	  	where.setText("Where to Buy");
	  	where.setContent(whereText);
	
	  	
	  	Tab faq = new Tab();
	  	faq.setText("FAQ");
	  	faq.setContent(faqText);

		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(where, faq);
		
	  	layout.getChildren().addAll(label, tabPane, home); 
	  	scene7 = new Scene(layout, 900, 600); 
	  	
	   	 theStage.setScene(scene7); 
	   	 theStage.show(); 	

	}	
	
	public Scene getScene7() {
		return scene7;
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
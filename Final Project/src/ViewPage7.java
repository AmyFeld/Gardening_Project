import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// This class is used to present the Resources tab and include the information and buttons that will present the information

public class ViewPage7 extends View {
	Scene scene7;

	public ViewPage7(Stage theStage) {		
		Image back = new Image("file:images/bg2.png",canvasWidth, canvasHeight, false, false);
		ImageView bg = new ImageView(back);
		BackgroundImage myBG = new BackgroundImage(back, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		
		VBox layout = new VBox(20);     
	    Text label1 = new Text("Resources");
		label1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, fontSize));
	    label1.setTranslateX(labelX);
	    label1.setTranslateY(labelY);
	    label1.setFill(Color.WHITE); 
	    label1.setStrokeWidth(2); 
	    label1.setStroke(Color.BLUE);
	    Text whereText = new Text();
	    Text faqText = new Text();
	    
	    // textFiles folder: where.txt and faq.txt

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
	    

	  	//Button home = new Button("Home");
	    homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));

	  	Tab where = new Tab();
	  	where.setText("Where to Buy");
	  	where.setContent(whereText);
	
	  	
	  	Tab faq = new Tab();
	  	faq.setText("FAQ");
	  	faq.setContent(faqText);

		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(where, faq);
		
	  	layout.getChildren().addAll(label1, tabPane, homeButton); 
	  	layout.setBackground(new Background(myBG));
	  	scene7 = new Scene(layout, sceneWidth, sceneHeight); 
	  	
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
		 String file = new String("textFiles/Page7/" + name + ".txt"); 
		 String data = ""; 
		 
		 data = new String(Files.readAllBytes(Paths.get(file))); 
		 return data;
	  }

}

import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.ImageCursor;
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

/**
 * This class is used to present the Resources tab and include
 *  the content and buttons that will present the information
 *  
 * @author Lisa Pathania
 *
 */

public class ViewPage7 extends View {
	Scene scene7;
	
	/**
	 * This will create different tabs that will display different information depending on the tab and also allow for a home button
	 * 
	 * @param Stage  Holds tabs that will read out information to the user
	 * @return none  Creates an application displaying the graphics and tabs of the information
	 *
	 */
	public ViewPage7(Stage theStage) {		
		VBox layout = new VBox(boxSize);     
	    	Text label1 = new Text("Resources");
		label1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, fontSize));
	    	label1.setTranslateX(labelX);
	    	label1.setTranslateY(labelY);
	    	label1.setFill(Color.WHITE); 
	    	label1.setStrokeWidth(strokeWid); 
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
	    
	    	homeButton.setOnAction(e -> control.goHomeButton(theStage, home));
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
	  	scene7.setCursor(new ImageCursor(mouse));

	   	theStage.setScene(scene7); 
	   	theStage.show(); 	

	}	
	
	/**
	 * Description: basic getter for the scene in order to receive it when buttons are pressed on screens 
	 * 
	 * 
	 * @return scene7
	 */
	public Scene getScene7() {
		return scene7;
	}

	 /**
		 * Description: takes in the text file to present to the user the basic information for that tab 
		 * 
		 * @param name a string of what the file is called
		 * @return none
		 * @throws Exception
		 */
	 public String uploadText(String name) throws Exception {
		 String file = new String("textFiles/Page7/" + name + ".txt"); 
		 String data = ""; 
		 data = new String(Files.readAllBytes(Paths.get(file))); 
		 return data;
	  }

}

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

/**
 * This class is used to present the Benefits of a Garden tab and include the 
 * content and buttons that will present the information
 * 
 * @author Lisa Pathania
 * 
 */
public class ViewPage8 extends View {
	Scene scene8;
	
	/**
	 * This will create different tabs that will display different information depending on the tab and also allow for a home button
	 * 
	 * @param Stage  Holds tabs that will read out information to the user
	 * @return none  Creates an application displaying the graphics and tabs of the information
	 *
	 */

	public ViewPage8(Stage theStage) {
		
	    VBox layout = new VBox(boxSize);     
	    Text label1 = new Text("Benefits of a Garden");
	    label1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, fontSize));
	    label1.setTranslateX(labelX);
	    label1.setTranslateY(labelY);
	    label1.setFill(Color.WHITE); 
	    label1.setStrokeWidth(2); 
	    label1.setStroke(Color.BLUE);
	    Text animalText = new Text();
	    Text edgeText = new Text();
	    Text appearText = new Text();
	    
	    // textFiles folder: animals.txt, edge.txt, appear.txt

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
	    

	  	//Button home = new Button("Home");
	    homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));

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
		
	    layout.getChildren().addAll(label1, tabPane, homeButton); 
	    layout.setBackground(new Background(myBG));
	    scene8 = new Scene(layout, sceneWidth, sceneHeight); 
		  	
	    theStage.setScene(scene8); 
	    theStage.show(); 	

	}	
	
	/**
	 * Description: basic getter for the scene in order to receive it when buttons are pressed on screens 
	 * 
	 * 
	 * @return scene8
	 */
	public Scene getScene8() {
		return scene8;
	}

	
	 
	 /**
		 * Description: takes in the text file to present to the user the basic information for that tab 
		 * 
		 * @param name a string of what the file is called
		 * @return none
		 * @throws Exception
		 */
	public String uploadText(String name) throws Exception {
		 String file = new String("textFiles/Page8/" + name + ".txt"); 
		 String data = ""; 
			 
		 data = new String(Files.readAllBytes(Paths.get(file))); 
		 return data;
	}

}

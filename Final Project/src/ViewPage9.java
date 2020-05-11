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
 * This class is used to present the Tips to Start tab and include the information and
 * buttons that will present the information
 * 
 * @author Lisa Pathania
 *
 */
 
public class ViewPage9 extends View {
	
	Scene scene9;
	//int fontSize = 40; 
	//int labelX = 300;
	//int labelY = 15;



	/**
	 * This will create different tabs that will display different information depending on the tab and also allow for a home button
	 * 
	 * @param Stage  Holds tabs that will read out information to the user
	 * @return none  Creates an application displaying the graphics and tabs of the information
	 *
	 */
	public ViewPage9(Stage theStage) {
		Image back = new Image("file:images/bg2.png", sceneWidth, sceneHeight, false, false);
		ImageView bg = new ImageView(back);
		BackgroundImage myBG = new BackgroundImage(back, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
			
		VBox layout = new VBox(20);     
	    Text label1 = new Text("Tips to Start");
		label1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, fontSize));
	    label1.setTranslateX(labelX);
	    label1.setTranslateY(labelY);
	    label1.setFill(Color.WHITE); 
	    label1.setStrokeWidth(2); 
	    label1.setStroke(Color.BLUE);
	    Text unhappyText = new Text();
	    Text bestText = new Text();
	    Text startText = new Text();
	    Text invasiveText = new Text();
	    
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
	    try {
	    	invasiveText.setText(uploadText("invasive"));
	 		} catch (Exception e2) {
	 			e2.printStackTrace();
	 		}
	 	    
	    homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));

	  	Tab unhappy = new Tab();
	  	unhappy.setText("Unhappy?");
	  	unhappy.setContent(unhappyText);
	  	
	  	Tab best = new Tab();
	  	best.setText("Best Places To Go");
	  	best.setContent(bestText);
	  	
		Tab start = new Tab();
	  	start.setText("Start With");
	  	start.setContent(startText);
	  	
		Tab invasive = new Tab();
	  	invasive.setText("Invasive Plants");
	  	invasive.setContent(invasiveText);

		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(unhappy, best, start, invasive);
		
	  	layout.getChildren().addAll(label1, tabPane, homeButton); 
	  	layout.setBackground(new Background(myBG));
	  	scene9 = new Scene(layout, sceneWidth, sceneHeight); 
	  	
	   	 theStage.setScene(scene9); 
	   	 theStage.show(); 	

	}	
	
	/**
	 * Description: basic getter for the scene in order to receive it when buttons are pressed on screens 
	 * 
	 * 
	 * @return scene9
	 */
	
	public Scene getScene9() {
		return scene9;
	}
	
	/**
	 * Description: takes in the text file to present to the user the basic information for that tab 
	 * 
	 * @param name a string of what the file is called
	 * @return none
	 * @throws Exception
	 */
		 public String uploadText(String name) throws Exception {
			 String file = new String("textFiles/Page9/" + name + ".txt"); 
			 String data = ""; 
			 
			 data = new String(Files.readAllBytes(Paths.get(file))); 
			 return data;	  
	}

}

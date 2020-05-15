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
 * This class is used to present the About Arden tab and include the 
 * content and buttons that will present the information.
 * 
 * @author Lisa Pathania
 *
 */
public class ViewPage6 extends View {
	
	Scene scene6;

	/**
	 * This will create different tabs that will display different information depending on the tab and also allow for a home button
	 * 
	 * @param Stage  Holds tabs that will read out information to the user
	 * @return none  Creates an application displaying the graphics and tabs of the information
	 *
	 */
	public ViewPage6(Stage theStage) {
		Image back = new Image("file:images/bg2.png",sceneWidth, sceneHeight, false, false);
		ImageView bg = new ImageView(back);
		BackgroundImage myBG = new BackgroundImage(back, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		
		VBox layout1 = new VBox(20);     
	    Text label1 = new Text("About Arden");
		label1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, fontSize));
	    label1.setTranslateX(labelX);
	    label1.setTranslateY(labelY);
	    label1.setFill(Color.WHITE); 
	    label1.setStrokeWidth(2); 
	    label1.setStroke(Color.BLUE);	  
	    Text msText = new Text();
	    msText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
	    Text purpText = new Text();
	    Text histText = new Text();
	    
	    // textFiles folder: ms.txt, purp.txt, hist.txt

	    try {
			msText.setText(uploadText("ms"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	    
	    try {
			purpText.setText(uploadText("purp"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	    
	    try {
			histText.setText(uploadText("hist"));
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	  	//Button home = new Button("Home");
	    homeButton.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));

	  	Tab ms = new Tab();
	  	ms.setText("Mission Statement");
	  	ms.setContent(msText);
	
	  	
	  	Tab purp = new Tab();
	  	purp.setText("Purpose");
	  	purp.setContent(purpText);

	  	
	  	Tab hist = new Tab();
	  	hist.setText("History");
	  	hist.setContent(histText);

	    
		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(ms, purp, hist);
		
	  	layout1.getChildren().addAll(label1, tabPane, homeButton); 
	  	layout1.setBackground(new Background(myBG));
	  	scene6 = new Scene(layout1, sceneWidth, sceneHeight); 

	  	
	   	 theStage.setScene(scene6); 
	   	 theStage.show(); 	

	}	
	

	/**
	 * Description: basic getter for the scene in order to receive it when buttons are pressed on screens 
	 * 
	 * 
	 * @return scene6
	 */
	
	public Scene getScene6() {
		return scene6;
	}

	/**
	 * Description: takes in the text file to present to the user the basic information for that tab 
	 * 
	 * @param name a string of what the file is called
	 * @return none
	 * @throws Exception
	 */
	 public String uploadText(String name) throws Exception {
		 String file = new String("textFiles/Page6/" + name + ".txt"); 
		 String data = ""; 
		 
		 data = new String(Files.readAllBytes(Paths.get(file))); 
		 return data;
	  }


}

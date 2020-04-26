 import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

// This class is used to present the About Arden tab and include the information and buttons that will present the information

public class ViewPage6 extends View {
	
	Scene scene6;


	public ViewPage6(Stage theStage) {
				
		VBox layout1 = new VBox(20);     
	    Label label1 = new Label("About Arden");
	    Text msText = new Text();
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

	  	Button home = new Button("Home");
	    home.setOnAction(e -> theStage.setScene(new ViewPage1(theStage).getScene1()));

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
		
	  	layout1.getChildren().addAll(label1, tabPane, home); 
	  	scene6 = new Scene(layout1, 900, 600); 

	  	
	   	 theStage.setScene(scene6); 
	   	 theStage.show(); 	

	}	
	
	public Scene getScene6() {
		return scene6;
	}

	/*
	 * Input: None
	 * Output: None
	 * Function: Reads in text file and upload it onto the canvas
	 */
	 public String uploadText(String name) throws Exception {
		 String file = new String("textFiles/" + name + ".txt"); 
		 String data = ""; 
		 
		 data = new String(Files.readAllBytes(Paths.get(file))); 
		 return data;
	  }


}

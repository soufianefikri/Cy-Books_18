package UpdateInfo;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.*;
import javafx.scene.image.*;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/UpdateInfo.fxml"));
			Scene scene = new Scene(root,800,600); 
			scene.getStylesheets().add(getClass().getResource("UpdateInfo.css").toExternalForm());
			stage.setTitle("Cy-Books_18 Update User Information");
			
			
			
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
	
		launch(args);
	}
	

	
}







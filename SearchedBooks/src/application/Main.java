package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/SearchedBooks.fxml"));
			Scene scene = new Scene(root); 
			scene.getStylesheets().add(getClass().getResource("SearchedBooks.css").toExternalForm());
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

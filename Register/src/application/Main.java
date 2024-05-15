package application;
	
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
			Parent root = FXMLLoader.load(getClass().getResource("/Register.fxml"));
			Scene scene = new Scene(root,800,600); 
			scene.getStylesheets().add(getClass().getResource("Register.css").toExternalForm());
			stage.setTitle("Cy-Books_18 Register Users");
			
			
			
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





/*@Override
public void start(Stage stage) throws Exception {
	try {
		/*Parent root = FXMLLoader.load(getClass().getResource("/Register.fxml"));
		Scene scene = new Scene(root,800,600); 
		scene.getStylesheets().add(getClass().getResource("Register.css").toExternalForm());
		stage.setTitle("Cy-Books_18 Register Users");
		/*Image image = new Image("new_user.png");
		ImageView imageView = new ImageView(image);
		
		Pane pane = (Pane) root;
		root.getChildren().add(imageView);
		stage.setScene(scene);
		stage.show();
	} catch(Exception e) {
		e.printStackTrace();
	}
}*/
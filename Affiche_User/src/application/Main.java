package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MenuUser menuUser = new MenuUser();
        menuUser.getUtilisateursFromDatabase();

        VBox vBox = menuUser.getvBox(); 

        //create a scene
        Scene scene = new Scene(vBox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CY BOOK : Liste des Utilisateurs");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

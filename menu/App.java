package menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // we create all the scene components
        MenuBase menu = new MenuBase();

        Scene scene = new Scene(menu, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("CY BOOKS");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
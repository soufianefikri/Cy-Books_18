package menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        //MenuBase menu = new MenuBase();
        //RegisterBase menu = new RegisterBase();
        LoginBase login = new LoginBase();


        Scene scene = new Scene(login, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("CY BOOKS");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
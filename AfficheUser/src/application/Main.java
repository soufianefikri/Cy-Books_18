package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class Main extends Application {

    private void getUtilisateursFromDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //for connect to your bdd
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj_jav", "root", "");
            //test the id you want
            PreparedStatement statement = connection.prepareStatement("select * from utilisateurs where id=1 ");
            ResultSet resultSet = statement.executeQuery();

            VBox root = new VBox();

            while (resultSet.next()) {
                String surname = resultSet.getString("nom");
                String name = resultSet.getString("prenom");
                String adress = resultSet.getString("adresse");
                String phone = resultSet.getString("numero_telephone");
                String email = resultSet.getString("adresse_mail");

                // displays user info
                Label labelName = new Label("Nom: " + surname);
                Label labelSurname = new Label("Prénom: " + name);
                Label labelAdress = new Label("Adresse: " + adress);
                Label labelPhone = new Label("Tel: " + phone);
                Label labelEmail = new Label("Mail: " + email);
                root.getChildren().add(labelName);
                root.getChildren().add(labelSurname);
                root.getChildren().add(labelAdress);
                root.getChildren().add(labelPhone);
                root.getChildren().add(labelEmail);
            }

            resultSet.close();
            statement.close();
            connection.close();

            Scene scene = new Scene(root, 400, 300);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("CY BOOK : Liste des Utilisateurs");
            stage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        getUtilisateursFromDatabase();
    }

    
    
    public static void main(String[] args) {
        launch(args);
    }
}
